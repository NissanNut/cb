package org.cb.api.methods.tabs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.Prayers;

/**
 * 
 * @author Troy
 *
 */
public class Prayer {
	private ColourMethods cm;
	public static Color ACTIVATED = new Color(171, 154, 108);
	public static Color QUICKPRAYER_ACTIVATED = new Color(155, 186, 150);
	public static Rectangle QUICKPRAYER_BOUNDS = new Rectangle(705, 53, 34, 33);
	
	public Prayer(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		ACTIVATED = null;
		QUICKPRAYER_ACTIVATED = null;
		QUICKPRAYER_BOUNDS = null;
		cm = null;
	}
	
	/**
	 * Check if the prayer tab is selected.
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
	 * Click the prayer tab.
	 * 
	 * @throws InterruptedException
	 */
	public void click() throws InterruptedException{
		Rectangle r = new Rectangle(704,171,28,33);
		int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));

		cm.theMouse.leftClick(x,y);
	}
	
	public boolean isQuickPrayerEnabled() throws InterruptedException{
		Color[] colors = cm.getColours(QUICKPRAYER_BOUNDS);
		Vector<Color> colorVec = new Vector<Color>();
		
		for(Color c : colors)
			colorVec.add(c);
		
		if(colorVec.contains(QUICKPRAYER_ACTIVATED))
			return true;
		else
			return false;
	}
	
	public void enableQuickPrayer() throws InterruptedException{
		Point p = new Point((int)(QUICKPRAYER_BOUNDS.getCenterX() - (QUICKPRAYER_BOUNDS.width /2)) + 
				Constants.getRandom().nextInt(QUICKPRAYER_BOUNDS.width), (int)(QUICKPRAYER_BOUNDS.getCenterY() - (QUICKPRAYER_BOUNDS.height /2)) + 
				Constants.getRandom().nextInt(QUICKPRAYER_BOUNDS.height));
		cm.theMouse.leftClick(p);
	}

	/**
	 * Check if the prayer is selected.
	 * 
	 * @param prayer
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isPrayerSelected(Prayers prayer) throws InterruptedException{
		Color[] colors = cm.getColours(prayer.getBounds());
		Vector<Color> colorVec = new Vector<Color>();
		
		for(Color c : colors)
			colorVec.add(c);
		
		if(colorVec.contains(ACTIVATED))
			return true;
		else
			return false;
	}
	
	/**
	 * Select the prayer.
	 * 
	 * @param prayer
	 * @throws InterruptedException
	 */
	public void select(Prayers prayer) throws InterruptedException{
		if(!isSelected())
			click();
		
		Point p = new Point((int)(prayer.getBounds().getCenterX() - (prayer.getBounds().width /2)) + Constants.getRandom().nextInt(prayer.getBounds().width), 
				(int)(prayer.getBounds().getCenterY() - (prayer.getBounds().height /2)) + Constants.getRandom().nextInt(prayer.getBounds().height));
		cm.theMouse.leftClick(p);
	}
}
