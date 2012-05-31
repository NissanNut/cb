package org.cb.api;

import java.awt.Graphics;


/**
 * 
 * @author Troy
 *
 */
public abstract class Script extends ColourMethods{
	
	/**
	 * Optional on paint method.
	 * 
	 * @param g
	 */
	public void onRepaint(Graphics g){}
	
	/**
	 * Optional on start method.
	 * 
	 * @throws InterruptedException
	 */
	public void onStart() throws InterruptedException{}
	
	/**
	 * Your script's main loop.
	 * The script will sleep for the returned amount of time in milliseconds.
	 * 
	 * @return long
	 * @throws InterruptedException
	 */
	public abstract long loop() throws InterruptedException;
	
	/**
	 * Optional on end method.
	 * 
	 * @throws InterruptedException
	 */
	public void onEnd() throws InterruptedException{}
	
}
