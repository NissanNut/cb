package org.cb.api.methods;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.cb.api.ColourMethods;

/**
 * 
 * @author Troy
 *
 */
public class Player {
	private ColourMethods cm;
	private static Rectangle myPlayerArea = new Rectangle(244,126,26,60);
	
	private static Color greenHP1 = new Color(97,186,0);
	private static Color greenHP2 = new Color(167,219,0);
	private static Color redHP1 = new Color(164,0,7);
	private static Color redHP2 = new Color(234,32,7);
	
	public Player(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		myPlayerArea = null;
		greenHP1 = null;
		greenHP2 = null;
		redHP1 = null;
		redHP2 = null;
		cm = null;
	}
	
	/**
	 * Check if the player is in combat
	 * based on the hp bar being above your player.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean inCombat() throws InterruptedException{
		if(cm.findColourPattern(myPlayerArea, new Color[]{greenHP1,greenHP2}, 5, 100, 20) != null || 
				cm.findColourPattern(myPlayerArea, new Color[]{redHP1,redHP2}, 5, 100, 20) != null) return true;
		return false;
	}
	
	/**
	 * Check if the player is animating.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isAnimating() throws InterruptedException{
		BufferedImage src;
		BufferedImage compare;
		
		src = cm.getImage(myPlayerArea);
		cm.sleep(150);
		compare = cm.getImage(myPlayerArea);
		
		if(cm.findImage(src, compare, 0, 0, (int)myPlayerArea.getWidth(), (int)myPlayerArea.getHeight(), 185)){
			cm.sleep(150);
			compare = cm.getImage(myPlayerArea);
			if(cm.findImage(src, compare, 0, 0, (int)myPlayerArea.getWidth(), (int)myPlayerArea.getHeight(), 185))
				return false;
			else
				return true;
		}else{
			return true;
		}
	}
	
	/**
	 * Return if your player is walking.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isWalking() throws InterruptedException{
		return cm.theMinimap.isWalking();
	}

}
