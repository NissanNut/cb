package org.cb.api.methods;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;

/**
 * 
 * @author Troy
 *
 */
public class Walker {
	private ColourMethods cm;
	
	public Walker(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cm = null;
	}
	
	/**
	 * This method will use your WalkPath to walk
	 * with the minimap to your desired location.
	 * 
	 * @param wp
	 * @throws InterruptedException
	 */
	public void walk(WalkPath wp) throws InterruptedException{
		for(Point p : wp.getPath()){
			int x = p.x - wp.getPathToleranceX() + Constants.getRandom().nextInt((wp.getPathToleranceX() * 2));
			int y = p.y - wp.getPathToleranceY() + Constants.getRandom().nextInt((wp.getPathToleranceY() * 2));
			
			if(wp.getStickToThisColour() != null){
				Point a = cm.getClosestPoint(p, cm.findColourArray(cm.theMinimap.minimapRectangle, wp.getStickToThisColour(), wp.getColourTolerance()));
				if(a != null && a.distance(p) <= 5)
					cm.theMouse.leftClick(a);
				else
					cm.theMouse.leftClick(new Point(x,y));
			}else{
				cm.theMouse.leftClick(new Point(x,y));
			}
			
			while(!cm.theMinimap.isWalking())
				cm.sleep(200,300);
			
			cm.sleep(500,800);
			
			while(cm.theMinimap.isWalking())
				cm.sleep(200,300);
		}
	}
	
	/**
	 * This method will walk your WalkPath backwards.
	 * 
	 * @throws InterruptedException
	 */
	public void walkReverse(WalkPath wp) throws InterruptedException{
		ArrayList<Point> path = wp.getPath();
		Collections.reverse(path);
		wp.setPath(path);
		
		walk(wp);
	}

}
