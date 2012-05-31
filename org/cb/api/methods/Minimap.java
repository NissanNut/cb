package org.cb.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.OCRFont;
import org.cb.api.utils.ImageLoader;

/**
 * 
 * @author Troy
 *
 */
public class Minimap {
	private ColourMethods cm;
	public Rectangle minimapRectangle = new Rectangle(550,8,155,155);
	public Point myPlayerPoint = new Point(628,86);
	
	private BufferedImage npcImage = ImageLoader.loadImage("Config/Images/Minimap/npc.gif");
	private BufferedImage itemImage = ImageLoader.loadImage("Config/Images/Minimap/item.gif");
	private BufferedImage playerImage = ImageLoader.loadImage("Config/Images/Minimap/player.gif");
	private BufferedImage flagImage = ImageLoader.loadImage("Config/Images/Minimap/flag.gif");
	
	public Minimap(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		minimapRectangle = null;
		myPlayerPoint = null;
		npcImage = null;
		itemImage = null;
		playerImage = null;
		flagImage = null;
		cm = null;
	}
	
	public BufferedImage getMinimap() throws InterruptedException{
		return cm.getImage(minimapRectangle);
	}
	
	/**
	 * Check if run mode is enabled.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isRunModeOn() throws InterruptedException{
		return cm.checkColour(Constants.getScreenArea(), new Color(141,97,55), new Point(727,110),0);
	}
	
	/**
	 * Set the run mode on or off with true/false.
	 * 
	 * @param result
	 * @throws InterruptedException
	 */
	public void setRunMode(boolean result) throws InterruptedException{
		if(result && isRunModeOn()){
			//Do nothing
		}else if(result && !isRunModeOn()){
			clickRun();
		}else if(!result && isRunModeOn()){
			clickRun();
		}else if(!result && !isRunModeOn()){
			//Do nothing
		}
	}
	
	/**
	 * Click Run
	 * 
	 * @throws InterruptedException
	 */
	public void clickRun() throws InterruptedException{
		int x = 711;
		int y = 96;
		Rectangle deposit = new Rectangle(x,y,20,20);
		Point p = new Point((int)(deposit.getCenterX() - 8) + Constants.getRandom().nextInt(17), (int)(deposit.getCenterY() - 8) + Constants.getRandom().nextInt(17));
		
		cm.theMouse.leftClick(p.x, p.y);
	}
	
	/**
	 * Return the HP read from the minimap.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int getHP() throws InterruptedException{	
		int i = -1;
		
		try{
			i = Integer.parseInt(cm.textReader.getText(new Rectangle(715,25,40,30), OCRFont.STAT_TEXT, 30));
		}catch(Exception e){
			return -1;
		}
		
		return i;
	}
	
	/**
	 * Return the Prayer read from the minimap.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int getPrayerPoints() throws InterruptedException{	
		int i = -1;
		
		try{
			i = Integer.parseInt(cm.textReader.getText(new Rectangle(735,60,40,30), OCRFont.STAT_TEXT, 30));
		}catch(Exception e){
			return -1;
		}
		
		return i;
	}
	
	/**
	 * Return the Run read from the minimap.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int getRunPoints() throws InterruptedException{	
		int i = -1;
		
		try{
			i = Integer.parseInt(cm.textReader.getText(new Rectangle(735,100,40,30), OCRFont.STAT_TEXT, 30));
		}catch(Exception e){
			return -1;
		}
		
		return i;
	}
	
	/**
	 * Will return all the yellow dot's on the minimap.
	 * AKA npcs.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllNpcs() throws InterruptedException{
		return cm.findImageArray(minimapRectangle, npcImage, 0, 0, (int)minimapRectangle.getWidth(), (int)minimapRectangle.getHeight(), 20);
	}
	
	/**
	 * Will return all the white dot's on the minimap.
	 * AKA players.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllPlayers() throws InterruptedException{
		return cm.findImageArray(minimapRectangle, playerImage, 0, 0, (int)minimapRectangle.getWidth(), (int)minimapRectangle.getHeight(), 20);
	}
	
	/**
	 * Will return all the red dot's on the minimap.
	 * AKA Items.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllItems() throws InterruptedException{
		return cm.findImageArray(minimapRectangle, itemImage, 0, 0, (int)minimapRectangle.getWidth(), (int)minimapRectangle.getHeight(), 20);
	}
	
	/**
	 * Will return a boolean of your player walking.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isWalking() throws InterruptedException{
		return cm.findImage(cm.getImage(minimapRectangle), flagImage, 0, 0, (int)minimapRectangle.getWidth(), (int)minimapRectangle.getHeight(), 40);
	}
}
