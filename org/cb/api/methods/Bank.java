package org.cb.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.OCRFont;

/**
 * 
 * @author Troy
 *
 */
public class Bank {
	private ColourMethods cm;
	private static Color bankText = new Color(242,170,62);
	private static int firstX = 29;
	private static int firstY = 84;
	public static int slotWidth = 45;
	public static int slotHeight = 45;
	
	public static Rectangle buttonClose = new Rectangle(482,30,10,10);
	public static Rectangle buttonDepositAll = new Rectangle(353,296,30,20);
	public static Rectangle buttonDepositAllEquipment = new Rectangle(389,296,30,20);
	public static Rectangle buttonDepositAllBeast = new Rectangle(425,296,30,20);
	public static Rectangle buttonDepositAllMoney = new Rectangle(461,296,30,20);
	public static Rectangle buttonSwithToNote = new Rectangle(213,296,30,20);
	
	public Bank(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		bankText = null;
		buttonClose = null;
		buttonDepositAll = null;
		buttonDepositAllEquipment = null;
		buttonDepositAllBeast = null;
		buttonDepositAllMoney = null;
		buttonSwithToNote = null;
	}
	
	/**
	 * Will check if the bank is open.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isOpen() throws InterruptedException{
		if(cm.checkColour(bankText, new Point(198,33))) return true;
		return false;
	}
	
	public void clickRectangle(Rectangle r) throws InterruptedException{
		if(isOpen()){
			Point p = new Point((int)(r.getCenterX() - ((r.getWidth() / 2) -2)) + Constants.getRandom().nextInt((int)(r.getWidth() -4)), 
					(int)(r.getCenterY() - ((r.getHeight() / 2) -2)) + Constants.getRandom().nextInt((int)(r.getHeight() -4)));
			
			cm.theMouse.leftClick(p.x,p.y);
		}else{
			genericMessage();
		}	
	}
	
	/**
	 * Sends a generic message to the log.
	 * 
	 * @throws InterruptedException
	 */
	private void genericMessage() throws InterruptedException{
		cm.log("The bank is not open, please open the Bank before calling this method.");	
	}
	
	/**
	 * Close the bank.
	 * 
	 * @throws InterruptedException
	 */
	public void close() throws InterruptedException{
		clickRectangle(buttonClose);
	}
	
	/**
	 * Deposit all items.
	 * 
	 * @throws InterruptedException
	 */
	public void depositAll() throws InterruptedException{
		clickRectangle(buttonDepositAll);
	}
	
	/**
	 * Deposit all equipment.
	 * 
	 * @throws InterruptedException
	 */
	public void depositAllEquipment() throws InterruptedException{
		clickRectangle(buttonDepositAllEquipment);
	}
	
	/**
	 * Deposit all beast items.
	 * 
	 * @throws InterruptedException
	 */
	public void depositAllBeast() throws InterruptedException{
		clickRectangle(buttonDepositAllBeast);
	}
	
	/**
	 * Deposit all money.
	 * 
	 * @throws InterruptedException
	 */
	public void depositAllMoney() throws InterruptedException{
		clickRectangle(buttonDepositAllMoney);
	}
	
	/**
	 * Switch to withdraw notes.
	 * 
	 * @throws InterruptedException
	 */
	public void switchToNotes(boolean trueFalse) throws InterruptedException{
		clickRectangle(buttonSwithToNote);
	}
	
	/**
	 * Check if we are already set to withdraw notes.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isWithdrawNotes() throws InterruptedException{
		return cm.checkColour(Constants.getPlayArea(), new Color(121,118,88), new Point(224,305), 0);
	}
	
	/**
	 * Left click the selected slot.
	 * 
	 * @param selID
	 * @param row
	 * @throws InterruptedException
	 */
	public void leftClick(int selID, int row) throws InterruptedException{
		if(isOpen()){
			Rectangle r = getSlot(selID,row);
			int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
			int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
			cm.theMouse.leftClick(x,y);
		}else{
			genericMessage();
		}
	}
	
	/**
	 * Right click the selected slot.
	 * 
	 * @param selID
	 * @param row
	 * @throws InterruptedException
	 */
	public void rightClick(int selID, int row) throws InterruptedException{
		if(isOpen()){
			Rectangle r = getSlot(selID,row);
			int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
			int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
			cm.theMouse.rightClick(x,y);
		}else{
			genericMessage();
		}
	}
	
	/**
	 * Left click the selected slot.
	 * 
	 * @param r
	 * @throws InterruptedException
	 */
	public void leftClickSlot(Rectangle r) throws InterruptedException{
		if(isOpen()){
			int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
			int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
			cm.theMouse.leftClick(x,y);
		}else{
			genericMessage();
		}
	}
	
	/**
	 * Right click the selected slot.
	 * 
	 * @param r
	 * @throws InterruptedException
	 */
	public void rightClickSlot(Rectangle r) throws InterruptedException{
		if(isOpen()){
			int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
			int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
			cm.theMouse.rightClick(x,y);
		}else{
			genericMessage();
		}
	}
	
	/**
	 * Will search the bank for the specified item name.
	 * 
	 * @param itemName
	 * @throws InterruptedException
	 */
	public void search(String itemName) throws InterruptedException{
		if(isOpen()){
			int x = 65;
			int y = 297;
			Rectangle deposit = new Rectangle(x,y,33,23);
			Point p = new Point((int)(deposit.getCenterX() - 5) + Constants.getRandom().nextInt(11), (int)(deposit.getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
			cm.theMouse.leftClick(p.x,p.y);
			
			while(!cm.checkColour(new Rectangle(0,0,765,503), new Color(0,0,0), new Point(404,402), 0))
				cm.sleep(400,500);
			
			cm.theKeyboard.sendKeys(itemName, true);
		}else{
			genericMessage();
		}
	}
	
	/**
	 * This will calculate the rectangle of the selected slot.
	 * Might further this in the future by remove the need to
	 * enter the selected row.
	 * 
	 * @param selID
	 * @param row
	 * @return Rectangle
	 * @throws InterruptedException
	 */
	public static Rectangle getSlot(int selID, int row) throws InterruptedException{
		int x = (firstX + (selID * slotWidth) - slotWidth);
		int y = (firstY + (row * slotHeight) - slotHeight);
		Rectangle r = new Rectangle(x,y,slotWidth,slotHeight);
		
		return r;
	}
	
	/**
	 * This will return the item stack count for a select 
	 * slot in the bank.
	 * 
	 * @param slot
	 * @return Integer
	 * @throws InterruptedException
	 */
	public int getStackCount(Rectangle slot) throws InterruptedException{
		int i = 1;
		
		try{
			i = Integer.parseInt(cm.textReader.getText(slot, OCRFont.STAT_TEXT, 30));
		}catch(Exception e){
			return -1;
		}
		
		return i;
	}
	
	/**
	 * Find a item in the bank and get the found slot back.
	 * 
	 * @param item
	 * @return slot
	 * @throws InterruptedException
	 */
	public static Rectangle findItem(ColourMethods cm, GE_Item item) throws InterruptedException{
		for(int a = 0; a < 5; a++){
			for(int b = 0; b < 10; b++){
				if(cm.findImage(cm.getImage(getSlot(a,b)), item.getImage(), 0, 0, 40, 40, 30))
					return getSlot(a,b);
			}
		}
		
		return null;
	}
	
	/**
	 * Find all matching slots and return the array.
	 * 
	 * @param item
	 * @return Array of slot ID's
	 * @throws InterruptedException
	 */
	public static ArrayList<Rectangle> findAllItems(ColourMethods cm, GE_Item item) throws InterruptedException{
		ArrayList<Rectangle> slotArray = new ArrayList<Rectangle>();
		
		for(int a = 0; a < 5; a++){
			for(int b = 0; b < 10; b++){
				if(cm.findImage(cm.getImage(getSlot(a,b)), item.getImage(), 0, 0, 40, 40, 30))
					slotArray.add(getSlot(a,b));
			}
		}
		
		return slotArray;
	}
}