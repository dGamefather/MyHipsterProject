package ctec.hipster.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import ctec.hipster.controller.HipsterAppController;

public class HipsterPanel extends JPanel
{
	private HipsterAppController baseController;
	private JComboBox albumBox;
	private JLabel albumLabel;
	private JLabel hipsterImage;
	private SpringLayout baseLayout;
	
	public HipsterPanel(HipsterAppController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		albumLabel = new JLabel("Album info here!");
		hipsterImage = new JLabel("selfy", new ImageIcon(this.getClass().getResource("/ctec/hipster/view/images/selfy.jpg")), JLabel.CENTER);
		albumBox = new JComboBox();
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		albumBox.setModel(new DefaultComboBoxModel(baseController.getSelfHipster().getHipsterAlbums()));
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.black);
		this.setLayout(baseLayout);
		this.add(albumLabel);
		this.add(hipsterImage);
		this.add(albumBox);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, albumLabel, -92, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, albumLabel, -1, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, hipsterImage, -68, SpringLayout.NORTH, albumLabel);
		baseLayout.putConstraint(SpringLayout.WEST, hipsterImage, 31, SpringLayout.EAST, albumBox);
		baseLayout.putConstraint(SpringLayout.SOUTH, albumBox, -89, SpringLayout.SOUTH, this);
		hipsterImage.setForeground(Color.WHITE);
		albumLabel.setForeground(Color.WHITE);
		baseLayout.putConstraint(SpringLayout.WEST, albumBox, 35, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		albumBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent selected)
			{
				if (albumBox.getSelectedIndex() == 0)
				{
					albumLabel.setText("You are truly a hipster");
				}
				else if (albumBox.getSelectedIndex() <= 2)
				{
					albumLabel.setText("You may have some hipster quality");
				}
				else
				{
					albumLabel.setText("NOT A HIPSTER");
				}
			}
		});
	}
	
}
