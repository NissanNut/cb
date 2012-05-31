package org.cb.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;

/**
 * 
 * @author Troy
 *
 */
public class Camera {
	private ColourMethods cm;
	private double north = 543.2982606267021;
	private double east = 537.4923255266069;
	private double south = 542.6232578870905;
	private double west = 545.4438559558628;
	private double northEast = 539.3709298803561;
	private double southEast = 541.5773259655541;
	private double southWest = 545.5281844231332;
	private double northWest = 546.3304860613217;
	
	private static Color cLR = new Color(243,76,58);
	private static Color cMR = new Color(190,52,34);
	
	private Rectangle compas = new Rectangle(522,3,42,42);
	
	public Camera(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cLR = null;
		cMR = null;
		compas = null;
		cm = null;
	}
	
	/**
	 * Find the compass and give the cords it's at.
	 * 
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point findCompass() throws InterruptedException{
		try{
			return cm.findColourPattern(compas, new Color[]{cLR,cMR}, 6, 50, 20);	
		}catch(Exception e){cm.log("Failed to find the compass...");}
		
		return null;
	}
	
	/**
	 * Click the compass to face north.
	 * 
	 * @throws InterruptedException
	 */
	public void faceNorthClickCompass() throws InterruptedException{
		Point p = findCompass();
		
		if(p != null)
			cm.theMouse.leftClick(p.x,p.y);
		else
			cm.log("Camera: Failed to click the compass.");
	}
	
	/**
	 * Rotate the camera east from north.
	 * 
	 * @throws InterruptedException
	 */
	public void rotateEastFromNorth() throws InterruptedException{
		cm.theKeyboard.keyPress(KeyEvent.VK_LEFT);
		cm.sleep(1000);
		cm.theKeyboard.keyRelease(KeyEvent.VK_LEFT);
		cm.sleep(100);
	}
	
	/**
	 * Rotate the camera west from north.
	 * 
	 * @throws InterruptedException
	 */
	public void rotateWestFromNorth() throws InterruptedException{
		cm.theKeyboard.keyPress(KeyEvent.VK_RIGHT);
		cm.sleep(1000);
		cm.theKeyboard.keyRelease(KeyEvent.VK_RIGHT);
		cm.sleep(100);
	}
	
	/**
	 * Rotate the camera south from north.
	 * 
	 * @throws InterruptedException
	 */
	public void rotateSouthFromNorth() throws InterruptedException{
		int whichWay = Constants.getRandom().nextInt(2);
		
		switch(whichWay){
		case 0:
			cm.theKeyboard.keyPress(KeyEvent.VK_RIGHT);
			cm.sleep(2000);
			cm.theKeyboard.keyRelease(KeyEvent.VK_RIGHT);
			cm.sleep(100);
			break;
		case 1:
			cm.theKeyboard.keyPress(KeyEvent.VK_LEFT);
			cm.sleep(2000);
			cm.theKeyboard.keyRelease(KeyEvent.VK_LEFT);
			cm.sleep(100);
			break;
		}
	}
	
	/**
	 * Try and work out which direction we are
	 * facing and return that direction.
	 * 
	 * Will currently print the direction for
	 * debugging.
	 * 
	 * @throws InterruptedException
	 */
	public int checkDirection() throws InterruptedException{
		Point p = findCompass();
		
		if(p != null){
			double distance = p.distance(0,0);
			//cm.log("Distance: " + distance);
			
			if(distance - north <= 0.01 && distance - north >= 0){
				return 0;
			}else if(distance - east <= 0.01 && distance - east >= 0){
				return 1;
			}else if(distance - south <= 0.01 && distance - south >= 0){
				return 2;
			}else if(distance - west <= 0.01 && distance - west >= 0){
				return 3;
			}else if(distance - northEast <= 0.01 && distance - northEast >= 0){
				return 4;
			}else if(distance - southEast <= 0.01 && distance - southEast >= 0){
				return 5;
			}else if(distance - southWest <= 0.01 && distance - southWest >= 0){
				return 6;
			}else if(distance - northWest <= 0.01 && distance - northWest >= 0){
				return 7;
			}
		}
		
		return -1;
	}
	
	/**
	 * This is used internally, don't try and call.
	 * 
	 * @param direction
	 * @throws InterruptedException
	 */
	private void face(int direction) throws InterruptedException{
		int whichWay = Constants.getRandom().nextInt(2);
		
		switch(whichWay){
		case 0:
			while(checkDirection() != direction){
				cm.theKeyboard.keyPress(KeyEvent.VK_RIGHT);
				cm.sleep(10);
			}
			
			cm.theKeyboard.keyRelease(KeyEvent.VK_RIGHT);
			cm.sleep(100);
			break;
		case 1:
			while(checkDirection() != direction){
				cm.theKeyboard.keyPress(KeyEvent.VK_LEFT);
				cm.sleep(10);
			}
			
			cm.theKeyboard.keyRelease(KeyEvent.VK_LEFT);
			cm.sleep(100);
			break;
		}
	}
	
	/**
	 * Rotate the camera to face North
	 * 
	 * @throws InterruptedException
	 */
	public void faceNorth() throws InterruptedException{
		face(0);
	}
	
	/**
	 * Rotate the camera to face East
	 * 
	 * @throws InterruptedException
	 */
	public void faceEast() throws InterruptedException{
		face(1);
	}
	
	/**
	 * Rotate the camera to face South
	 * 
	 * @throws InterruptedException
	 */
	public void faceSouth() throws InterruptedException{
		face(2);
	}
	
	/**
	 * Rotate the camera to face West
	 * 
	 * @throws InterruptedException
	 */
	public void faceWest() throws InterruptedException{
		face(3);
	}
	
	/**
	 * Rotate the camera to face North East
	 * 
	 * @throws InterruptedException
	 */
	public void faceNorthEast() throws InterruptedException{
		face(4);
	}
	
	/**
	 * Rotate the camera to face South East
	 * 
	 * @throws InterruptedException
	 */
	public void faceSouthEast() throws InterruptedException{
		face(5);
	}
	
	/**
	 * Rotate the camera to face South West
	 * 
	 * @throws InterruptedException
	 */
	public void faceSouthWest() throws InterruptedException{
		face(6);
	}
	
	/**
	 * Rotate the camera to face North West
	 * 
	 * @throws InterruptedException
	 */
	public void faceNorthWest() throws InterruptedException{
		face(7);
	}
	
	/**
	 * This will set your cameras pitch to the top.
	 */
	public void pitchUp() throws InterruptedException{
		cm.theKeyboard.keyPress(KeyEvent.VK_UP);
		cm.sleep(1500);
		cm.theKeyboard.keyRelease(KeyEvent.VK_UP);
		cm.sleep(100);
	}
	
	/**
	 * This will set your cameras pitch to the bottom.
	 */
	public void pitchDown() throws InterruptedException{
		cm.theKeyboard.keyPress(KeyEvent.VK_DOWN);
		cm.sleep(1500);
		cm.theKeyboard.keyRelease(KeyEvent.VK_DOWN);
		cm.sleep(100);
	}
}