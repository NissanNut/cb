package org.cb.api.methods;

import java.awt.Point;
import java.util.ArrayList;

import org.cb.api.ColourMethods;

/**
 * 
 * @author Troy
 *
 */
public class Npc {
	private ColourMethods cm;
	
	public Npc(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cm = null;
	}
	
	/**
	 * Get's all the NPC's around you.
	 * 
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> getAllNpcs() throws InterruptedException{
		return cm.theMinimap.getAllNpcs();
	}
	
	/**
	 * Get closest NPC.
	 * 
	 * @param itemList
	 * @param distance
	 * @return Point
	 */
	public Point getClosestNpc() throws InterruptedException{
		return cm.getClosestPoint(cm.theMinimap.myPlayerPoint, getAllNpcs());
	}

}
