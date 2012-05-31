package org.cb.api.methods;

import java.awt.Point;
import java.util.ArrayList;

import org.cb.api.ColourMethods;

/**
 * 
 * @author Troy
 *
 */
public class Players {
	private ColourMethods cm;
	
	public Players(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cm = null;
	}
	
	/**
	 * Get's all the Players around you.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllPlayers() throws InterruptedException{
		return cm.theMinimap.getAllPlayers();
	}
	
	/**
	 * Get closest Player.
	 * 
	 * @param itemList
	 * @param distance
	 * @return Point
	 */
	public Point getClosestPlayer() throws InterruptedException{
		return cm.getClosestPoint(cm.theMinimap.myPlayerPoint, getAllPlayers());
	}
}
