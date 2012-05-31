package org.cb.api.wrappers;

import org.cb.input.Keyboard;

/**
 * 
 * @author Troy
 *
 */
public class TheKeyboard {
	private Keyboard k;
	
	public TheKeyboard(Keyboard k){
		this.k = k;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		k = null;
	}
	
	public void sendKeys(String string, boolean pressEnter) throws InterruptedException{
		k.sendKeys(string, pressEnter);
	}
	
	public void sendChar(char c) throws InterruptedException{
		k.sendChar(c);
	}
	
	public void sendEnter() throws InterruptedException{
		k.sendEnter();
	}
	
	public void keyPress(int keyCode) throws InterruptedException{
		k.keyPress(keyCode);
	}
	
	public void keyRelease(int keyCode) throws InterruptedException{
		k.keyRelease(keyCode);
	}
}
