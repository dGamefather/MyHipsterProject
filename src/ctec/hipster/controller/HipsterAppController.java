package ctec.hipster.controller;

import ctec.hipster.model.Hipster;
import ctec.hipster.view.HipsterFrame;

/**
 * Selections with the drop-down menu.
 * 
 * @author Brennan Litster
 * @version 1.1 11/19/14
 */
public class HipsterAppController
{
	private HipsterFrame baseFrame;
	private Hipster selfHipster;
	private String[] myAlbums;
	
	public HipsterAppController()
	{
		
		selfHipster = new Hipster("Brennan", 17);
		buildAlbumArray();
		baseFrame = new HipsterFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public Hipster getSelfHipster()
	{
		return selfHipster;
	}
	
	private void buildAlbumArray()
	{
		myAlbums = new String[4];
		myAlbums[0] = "Zelda OoT";
		myAlbums[1] = "Zelda MM 3D";
		myAlbums[2] = "Zelda WW HD";
		myAlbums[3] = "Zelda TP";
		selfHipster.setHipsterAlbums(myAlbums);
	}
	
}
