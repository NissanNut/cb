package org.cb.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * @author Troy
 *
 */
public class WalkPath {
	private ArrayList<Point> path;
	private int pathToleranceX;
	private int pathToleranceY;
	private Color stickToThisColour;
	private int colourTolerance;
	
	/**
	 * Create a new walk path to be used by the walker.
	 * You can leave stickToThisColour as null and the walker will
	 * only use the point list to work from.
	 * 
	 * @param path
	 * @param pathToleranceX
	 * @param pathToleranceY
	 * @param stickToThisColour
	 * @param colourTolerance
	 */
	public WalkPath(ArrayList<Point> path, int pathToleranceX, int pathToleranceY, Color stickToThisColour, int colourTolerance){
		this.path = path;
		this.pathToleranceX = pathToleranceX;
		this.pathToleranceY = pathToleranceY;
		this.stickToThisColour = stickToThisColour;
		this.colourTolerance = colourTolerance;
	}

	public ArrayList<Point> getPath() {
		return path;
	}

	public void setPath(ArrayList<Point> path) {
		this.path = path;
	}

	public int getPathToleranceX() {
		return pathToleranceX;
	}

	public void setPathToleranceX(int pathToleranceX) {
		this.pathToleranceX = pathToleranceX;
	}

	public int getPathToleranceY() {
		return pathToleranceY;
	}

	public void setPathToleranceY(int pathToleranceY) {
		this.pathToleranceY = pathToleranceY;
	}

	public Color getStickToThisColour() {
		return stickToThisColour;
	}

	public void setStickToThisColour(Color stickToThisColour) {
		this.stickToThisColour = stickToThisColour;
	}

	public int getColourTolerance() {
		return colourTolerance;
	}

	public void setColourTolerance(int colourTolerance) {
		this.colourTolerance = colourTolerance;
	}

}
