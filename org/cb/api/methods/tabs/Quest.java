package org.cb.api.methods.tabs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;

/**
 * 
 * @author Troy
 *
 */
public class Quest {
	private ColourMethods cm;
	
	public Quest(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cm = null;
	}
	
	/**
	 * Check if the quest tab is selected.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isSelected() throws InterruptedException{
		if(cm.checkColour(Constants.getScreenArea(), new Color(230,157,57), new Point(747,203),0))
			return true;

		return false;
	}
	
	/**
	 * Click the quest tab.
	 * 
	 * @throws InterruptedException
	 */
	public void click() throws InterruptedException{
		Rectangle r = new Rectangle(614,171,28,33);
		int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));

		cm.theMouse.leftClick(x,y);
	}

}