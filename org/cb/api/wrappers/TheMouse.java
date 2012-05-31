package org.cb.api.wrappers;

import java.awt.Point;

import org.cb.input.Mouse;


/**
 * 
 * @author Troy
 *
 */
public class TheMouse {
	private Mouse m;
	
	public TheMouse(Mouse m){
		this.m = m;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		m = null;
	}
	
	public void move(Point destination) throws InterruptedException{
		m.mouseMove(destination);
	}
	
	public void moveNormal(Point destination) throws InterruptedException{
		m.mouseMoveNormal(destination);
	}
	
	public void leftClick(Point destination) throws InterruptedException{
		m.leftClick(destination.x, destination.y);
	}
	
	public void leftClickNormal(Point destination) throws InterruptedException{
		m.leftClickNormal(destination.x, destination.y);
	}
	
	public void middleClick(Point destination) throws InterruptedException{
		m.middleClick(destination.x, destination.y);
	}
	
	public void rightClick(Point destination) throws InterruptedException{
		m.rightClick(destination.x, destination.y);
	}
	
	public void move(int x, int y) throws InterruptedException{
		m.mouseMove(new Point(x,y));
	}
	
	public void moveNormal(int x, int y) throws InterruptedException{
		m.mouseMoveNormal(new Point(x,y));
	}
	
	public void leftClick(int x, int y) throws InterruptedException{
		m.leftClick(x, y);
	}
	
	public void leftClickNormal(int x, int y) throws InterruptedException{
		m.leftClickNormal(x, y);
	}
	
	public void middleClick(int x, int y) throws InterruptedException{
		m.middleClick(x, y);
	}
	
	public void rightClick(int x, int y) throws InterruptedException{
		m.rightClick(x, y);
	}
	
	public double getMouseSpeed() throws InterruptedException{
		return m.getMouseSpeed();
	}
	
	public void setMouseSpeed(double speed) throws InterruptedException{
		m.setMouseSpeed(speed);
	}
	
	public Point getMousePosition() throws InterruptedException{
		return m.getMousePosition();
	}
	
	public void setMousePosition(Point position) throws InterruptedException{
		m.setMousePosition(position);
	}
	
	public boolean isMouseMoving(){
		return m.isMouseMoving();
	}
	
	public void setMouseMoving(boolean moving){
		m.setMouseMoving(moving);
	}
	
	public void scrollWheel(int scrollamount) throws InterruptedException{
		m.scrollWheel(scrollamount);
	}
}
