package org.cb.api.methods;

import java.awt.Point;
import java.util.ArrayList;

import org.cb.api.ColourMethods;

/**
 * 
 * @author Troy
 *
 */
public class GroundItem {
	private ColourMethods cm;
	
	public GroundItem(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		
	}
	
	/**
	 * Get's all the ground Items around you.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllItems() throws InterruptedException{
		return cm.theMinimap.getAllItems();
	}
	
	/**
	 * Get closest ground Item.
	 * 
	 * @param itemList
	 * @param distance
	 * @return Point
	 */
	public Point getClosestItem() throws InterruptedException{
		return cm.getClosestPoint(cm.theMinimap.myPlayerPoint, getAllItems());
	}
}
