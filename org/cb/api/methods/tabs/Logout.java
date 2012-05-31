package org.cb.api.methods.tabs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;

/**
 * 
 * @author Troy
 *
 */
public class Logout {
	private ColourMethods cm;
	private Rectangle exitToLobby = new Rectangle(570,350,145,25);
	private Rectangle exitToLogin = new Rectangle(570,395,145,25);
	
	public Logout(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		exitToLobby = null;
		exitToLogin = null;
		cm = null;
	}
	
	/**
	 * Check if the logout tab is selected.
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
	 * Click the logout tab.
	 * 
	 * @throws InterruptedException
	 */
	public void click() throws InterruptedException{
		Rectangle r = new Rectangle(746,0,17,17);
		int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));

		cm.theMouse.leftClick(x,y);
	}
	
	/**
	 * Clicks exit to lobby.
	 * 
	 * @throws InterruptedException
	 */
	public void exitToLobby() throws InterruptedException{
		if(!isSelected())
			click();
		
		int x = (int) ((exitToLobby.getCenterX() - 64) + Constants.getRandom().nextInt(130));
		int y = (int) ((exitToLobby.getCenterY() - 10) + Constants.getRandom().nextInt(20));
		
		cm.theMouse.leftClick(x,y);
	}
	
	/**
	 * Clicks exit to login.
	 * 
	 * @throws InterruptedException
	 */
	public void exitToLogin() throws InterruptedException{
		if(!isSelected())
			click();
		
		int x = (int) ((exitToLogin.getCenterX() - 64) + Constants.getRandom().nextInt(130));
		int y = (int) ((exitToLogin.getCenterY() - 10) + Constants.getRandom().nextInt(20));
		
		cm.theMouse.leftClick(x,y);
	}
}