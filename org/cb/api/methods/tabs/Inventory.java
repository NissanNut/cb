package org.cb.api.methods.tabs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.OCRFont;
import org.cb.api.methods.GE_Item;

/**
 * 
 * @author Troy
 *
 */
public class Inventory {
	private ColourMethods cm;
	public  int invStartX = 563;
	public  int invStartY = 213;
	private  int invWidth = 190;
	private  int invHeight = 250;
	public  int slotWidth = 32;
	public  int slotHeight = 32;
	
	public  int itemFindTolerance = 50;
	
	private  Color invBeltColour = new Color(208,162,47);
	
	private  Color[] iCs = {new Color(49,43,33),
							new Color(60,52,42),
							new Color(63,53,44),
							new Color(64,56,45),
							new Color(65,57,46),
							new Color(66,58,48),
							new Color(71,63,51),
							new Color(69,63,50),
							new Color(71,61,51),
							new Color(73,67,57),
							new Color(71,64,52),
							new Color(72,64,52),
							new Color(74,68,58),
							new Color(67,59,49),
							new Color(61,55,43),
							new Color(61,53,43),
							new Color(66,58,49),
							new Color(64,54,45),
							new Color(65,57,45),
							new Color(67,59,48),
							new Color(72,64,51),
							new Color(72,63,51),
							new Color(62,56,44),
							new Color(64,56,46),
							new Color(70,64,51),
							new Color(66,59,49),
							new Color(72,62,52),
							new Color(71,63,52),
							new Color(73,67,58),
							new Color(60,52,43),
							new Color(71,61,52),
							new Color(63,53,45),
							new Color(69,64,51),
							new Color(65,56,45),
							new Color(64,57,46),
							new Color(67,58,48),
							new Color(71,62,52),
							new Color(64,54,44),
							new Color(61,53,42),
							new Color(72,62,51),
							new Color(72,62,51),
							new Color(62,56,43),
							new Color(70,64,50)};
	
	public  Vector<Color> inventoryColours = new Vector<Color>();
	
	public  Rectangle inventory = new Rectangle(invStartX, invStartY, invWidth, invHeight);
	public  Rectangle[] slots = new Rectangle[]{new Rectangle(invStartX, invStartY, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY, slotWidth, slotHeight),
		new Rectangle(invStartX, invStartY +36, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 36, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 36, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 36, slotWidth, slotHeight),
		new Rectangle(invStartX, invStartY + 72, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 72, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 72, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 72, slotWidth, slotHeight),
		new Rectangle(invStartX, invStartY + 108, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 108, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 108, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 108, slotWidth, slotHeight),
		new Rectangle(invStartX, invStartY + 144, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 144, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 144, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 144, slotWidth, slotHeight),
		new Rectangle(invStartX, invStartY + 180, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 180, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 180, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 180, slotWidth, slotHeight),
		new Rectangle(invStartX , invStartY + 216, slotWidth, slotHeight),
		new Rectangle(invStartX + 42, invStartY + 216, slotWidth, slotHeight),
		new Rectangle(invStartX + 84, invStartY + 216, slotWidth, slotHeight),
		new Rectangle(invStartX + 126, invStartY + 216, slotWidth, slotHeight)};
	

	public Inventory(ColourMethods cm){
		this.cm = cm;
		
		for(int i = 0; i < iCs.length; i++)
			inventoryColours.add(iCs[i]);
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		invBeltColour = null;
		iCs = null;
		inventoryColours = null;
		inventory = null;
		slots = null;
		cm = null;
	}
	
	/**
	 * Find the Inventory Tab.
	 * 
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point findInventoryTab() throws InterruptedException{
		try{
			Point tabY = cm.findColour(Constants.getTabArea(), invBeltColour, 0);
			int x = (int) ((tabY.x - 5) + Constants.getRandom().nextInt(11));
			int y = (int) ((tabY.x - 5) + Constants.getRandom().nextInt(11));

			if(tabY != null)
				return new Point(x,y);
		
		}catch(Exception e){cm.log("Failed to find the Inventory Tab, either you have not got the scapegoat " +
										"window visable or the colours have changed.");}
		return null;
	}
	
	/**
	 * This will compare the pixel colours of the inventory
	 * being normal as to when its selected. If the boarder 
	 * shows that it is selected then return true, else false.
	 */
	public boolean isSelected() throws InterruptedException{
		if(cm.checkColour(Constants.getScreenArea(), new Color(230,157,57), new Point(657,203),0))
			return true;

		return false;
	}

	/**
	 * This will use the find method to find the inventory
	 * tab and then click it.
	 */
	public void click() throws InterruptedException{
		Rectangle r = new Rectangle(644,171,28,33);
		int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));

		cm.theMouse.leftClick(x,y);
	}
	
	/**
	 * 
	 * @return int
	 * @throws InterruptedException
	 */
	public int countFreeSlots() throws InterruptedException{
		int count = 0;

		for(int i = 1; i < (slots.length + 1); i++){
			if(isSlotEmpty(i))
				count++;
		}
		return count;
	}
	
	/**
	 * Check if the inventory is full.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isFull() throws InterruptedException{
		if(countFreeSlots() < 1) return true;
		return false;
	}
	
	/**
	 * Check if the slot is free or not.
	 * 
	 * Please note: The inventory must be visible for this to work.
	 * 
	 * @param i
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean isSlotEmpty(int i) throws InterruptedException{
		Color c[] = cm.getColours(new Rectangle((int)slots[i -1].getCenterX() - 5, (int)slots[i -1].getCenterY() -5, 10,10));
		
		int count = 0;
		
		for(Color b : c){
			for(int x = 0; x < iCs.length; x++){
				if(cm.similarColours(iCs[x], b, 5)){
					count++;
					break;
				}
			}
		}
		
		if(count == (c.length - 1) || count > (c.length - 1)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Method to left click the selected slot.
	 * 
	 * @param slotID
	 * @throws InterruptedException
	 */
	public  void leftClick(int slotID) throws InterruptedException{
		int x = (int) ((slots[slotID -1].getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((slots[slotID -1].getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
		cm.theMouse.leftClick(x,y);
	}
	
	/**
	 * Method to right click the selected slot.
	 * 
	 * @param slotID
	 * @throws InterruptedException
	 */
	public  void rightClick(int slotID) throws InterruptedException{
		int x = (int) ((slots[slotID -1].getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((slots[slotID -1].getCenterY() - 5) + Constants.getRandom().nextInt(11));
			
		cm.theMouse.rightClick(x,y);
	}
	
	/**
	 * This will return the item stack count for a select 
	 * slot in the inventory.
	 * 
	 * @param slotID
	 * @return Integer
	 * @throws InterruptedException
	 */
	public  int getStackCount(int slotID) throws InterruptedException{
		int i = 1;
		
		try{
			i = Integer.parseInt(cm.textReader.getText(slots[slotID -1], OCRFont.STAT_TEXT, 30));
		}catch(NumberFormatException e){
			return -1;
		}
		
		return i;
	}
	
	/**
	 * Counts the amount of this item and returns the value.
	 * 
	 * @param item
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getItemCount(GE_Item item) throws InterruptedException{
		int count = 0;
		
		for(int i = 0; i < slots.length; i++){
			if(cm.findImage(cm.getImage(slots[i]), item.getImage(), 0, 0, slotWidth, slotHeight, 30))
				count++;
		}
		
		return count;
	}
	
	/**
	 * Find a item in the inventory and get the found slot back.
	 * 
	 * @param item
	 * @return slot ID
	 * @throws InterruptedException
	 */
	public  int findItem(GE_Item item) throws InterruptedException{
		for(int i = 0; i < slots.length; i++){
			if(cm.findImage(cm.getImage(slots[i]), item.getImage(), 0, 0, slotWidth, slotHeight, 30))
				return i +1;
		}
		
		return -1;
	}
	
	/**
	 * Find all matching slots and return the array.
	 * 
	 * @param item
	 * @return Array of slot ID's
	 * @throws InterruptedException
	 */
	public  ArrayList<Integer> findAllItems(GE_Item item) throws InterruptedException{
		ArrayList<Integer> slotArray = new ArrayList<Integer>();
		
		for(int i = 0; i < slots.length; i++){
			if(cm.findImage(cm.getImage(slots[i]), item.getImage(), 0, 0, slotWidth, slotHeight, 30))
				slotArray.add(i +1);
		}
		
		return slotArray;
	}
	
	/**
	 * Find a item in the inventory and get the found slot back.
	 * 
	 * @param item
	 * @return slot ID
	 * @throws InterruptedException
	 */
	public  int findItemNote(GE_Item item) throws InterruptedException{
		for(int i = 0; i < slots.length; i++){
			if(cm.findImage(cm.getImage(slots[i]), item.getNoteImage(), 0, 0, slotWidth, slotHeight, 30))
				return i +1;
		}
		
		return -1;
	}

	public  int getItemFindTolerance() {
		return itemFindTolerance;
	}

	public  void setItemFindTolerance(int itemFindTolerance) {
		this.itemFindTolerance = itemFindTolerance;
	}
}