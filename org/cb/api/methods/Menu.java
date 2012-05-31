package org.cb.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.OCRFont;
import org.cb.api.utils.Points;

/**
 * 
 * @author Troy
 *
 */
public class Menu {
	private ColourMethods cm;
	
	public Menu(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		cm = null;
	}
	
	/**
	 * Check if the menu is open.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isOpen(ColourMethods cm) throws InterruptedException{
		int x = cm.theMouse.getMousePosition().x;
		int y = cm.theMouse.getMousePosition().y;
		int width = 300;
		int height = 200;
		
		Rectangle r = new Rectangle(x,y,width,height);
		
		if(cm.findColourPattern(r, new Color[]{new Color(33,49,56),new Color(10,29,37)}, 4, 310, 10) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the point where the selected ID
	 * should be located, with a random tolerance.
	 * 
	 * @param selID
	 * @return Point
	 */
	private Point getSlot(ColourMethods cm,int selID) throws InterruptedException{
		int x = cm.theMouse.getMousePosition().x;
		int y = cm.theMouse.getMousePosition().y;
		
		y += (selID * 17) + 6 + Constants.getRandom().nextInt(5);
		x += -30 + Constants.getRandom().nextInt(60);
		
		return new Point(x,y);
	}
	
	/**
	 * Select the option within the menu.
	 * 
	 * @param selID
	 * @throws InterruptedException
	 */
	public void selectOption(int selID) throws InterruptedException{
		cm.theMouse.setMouseMoving(true);
		Point p = getSlot(cm,selID);
		cm.theMouse.leftClick(p.x,p.y);
	}
	
	/**
	 * Select a option within the menu by the name
	 * of the option.
	 * 
	 * @param optionText
	 * @throws InterruptedException
	 */
	public void selectOption(String optionText) throws InterruptedException{
		int x = cm.theMouse.getMousePosition().x -150;
		int y = cm.theMouse.getMousePosition().y;
		int y2 = 0;
		
		try{
			for(int i = 1; i < 11; i++){
				y2 = y + ((i * 16) + 4);
				Rectangle r = new Rectangle(x,y2,300,17);
				
				if(cm.textReader.getText(r, OCRFont.MENU_TEXT, 30).contains(optionText.trim())){
					cm.theMouse.setMouseMoving(true);
					Point p = cm.getRandomPoint(new Rectangle(r.x + 100, r.y, 100, 17));
					cm.theMouse.leftClick(p.x,p.y);
				}
			}
		}catch(Exception e){}
	}
	
	/**
	 * Testing getting the menu options.
	 * Supports up to 10 options.
	 * 
	 * @throws InterruptedException
	 */
	public void echoOptions() throws InterruptedException{
		int x = cm.theMouse.getMousePosition().x -150;
		int y = cm.theMouse.getMousePosition().y;
		int y2 = 0;
		
		try{
			for(int i = 1; i < 11; i++){
				y2 = 0;
				y2 = y + ((i * 16) + 4);
				Rectangle r = new Rectangle(x,y2,300,17);
				
				cm.log("OPTION TEXT: " + cm.textReader.getText(r, OCRFont.MENU_TEXT, 30));
			}
		}catch(Exception e){}
	}
	
	/**
	 * Returns the point where the selected ID
	 * should be located, with a random tolerance.
	 * 
	 * @param selID
	 * @return Point
	 */
	private Point getSlotNew(int selID) throws InterruptedException{
		Rectangle bounds = getMenuBounds(cm.getImage());
		int x = (int)bounds.getX();
		int y = (int)bounds.getY();
		
		y += (selID * 17) + 6 + Constants.getRandom().nextInt(5);
		x += 20 + Constants.getRandom().nextInt((int)(bounds.getWidth()-40));
		
		return new Point(x,y);
	}
	
	/**
	 * Select the option within the menu.
	 * 
	 * @param selID
	 * @throws InterruptedException
	 */
	public void selectOptionNew(int selID) throws InterruptedException{
		cm.theMouse.setMouseMoving(true);
		Point p = getSlotNew(selID);
		cm.theMouse.leftClick(p.x,p.y);
	}
	
	/**
	 * Select a option within the menu by the name
	 * of the option.
	 * 
	 * @param optionText
	 * @throws InterruptedException
	 */
	public void selectOptionNew(String optionText) throws InterruptedException{
		Rectangle bounds = getMenuBounds(cm.getImage());
		int x = (int)bounds.getX();
		int y = (int)bounds.getY();
		int y2 = 0;
		
		try{
			for(int i = 1; i < 11; i++){
				y2 = y + ((i * 16) + 4);
				Rectangle r = new Rectangle(x,y2,(int)bounds.getWidth(),17);
				
				if(cm.textReader.getText(r, OCRFont.MENU_TEXT, 30).contains(optionText.trim())){
					cm.theMouse.setMouseMoving(true);
					Point p = cm.getRandomPoint(new Rectangle(r.x + 20, r.y, (int)bounds.getWidth()-40, 17));
					cm.theMouse.leftClick(p.x,p.y);
				}
			}
		}catch(Exception e){}
	}
	
	/**
	 * Testing getting the menu options.
	 * Supports up to 10 options.
	 * 
	 * @throws InterruptedException
	 */
	public void echoOptionsNew() throws InterruptedException{
		Rectangle bounds = getMenuBounds(cm.getImage());
		
		int x = (int)bounds.getX();
		int y = (int)bounds.getY();
		
		int y2 = 0;
		
		try{
			for(int i = 1; i < 20; i++){
				y2 = 0;
				y2 = y + ((i * 16) + 4);
				Rectangle r = new Rectangle(x,y2,(int)bounds.getWidth(),17);
				
				String s = cm.textReader.getText(r, OCRFont.MENU_TEXT, 30);
				
				if(s != "")
					cm.log("OPTION TEXT: " + s);
				else
					break;
			}
		}catch(Exception e){}
	}
	
	/**
	 * Trim a image to find the menu's bounds.
	 * 
	 * @param source
	 * @param ignoreColours
	 * @return BufferedImage
	 * @throws InterruptedException
	 */
	public Rectangle getMenuBounds(BufferedImage source) throws InterruptedException{
		for(int a = 0; a < source.getWidth(); a++){
			for(int b = 0; b < source.getHeight(); b++){
				if(!cm.similarColours(new Color(source.getRGB(a, b)), new Color(254,254,254), 0))
					source.setRGB(a, b, new Color(0,0,0).getRGB());
				else
					source.setRGB(a, b, new Color(255,255,255).getRGB());
			}
		}
		
		ArrayList<Point> points = cm.findColourArray(source,new Color(255,255,255),0);
		
		if(points == null)
			return null;
		
		Point pleft = Points.getMostLeftPoint(points);
		Point pright = Points.getMostRightPoint(points);
		Point ptop = Points.getHighestPoint(points);
		Point pbottom = Points.getLowestPoint(points);
		
		int width = (pright.x - pleft.x) +1;
		int height = (pbottom.y - ptop.y);
		
		Rectangle r = new Rectangle(pleft.x, ptop.y, width, height);
		
		return r;
	}
}