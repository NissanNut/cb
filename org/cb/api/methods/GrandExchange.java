package org.cb.api.methods;

import java.awt.Color;
import java.awt.ColourBot;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.OCRFont;
import org.cb.connectors.GrandExchangeConnector;

/**
 * 
 * @author Troy
 *
 */
public class GrandExchange {
	private ColourMethods cm;
	private  GrandExchangeConnector gec = new GrandExchangeConnector();
	
	private  int slotWidth = 137;
	private  int slotHeight = 107;
	private  int bsSlotWidth = 48;
	private  int bsSlotHeight = 45;
	private  int progressWidth = 126;
	private  int progressHeight = 15;
	
	private  Rectangle[] slots = new Rectangle[]{new Rectangle(35,85,slotWidth,slotHeight),
		new Rectangle(190,85,slotWidth,slotHeight),
		new Rectangle(345,85,slotWidth,slotHeight),
		new Rectangle(35,204,slotWidth,slotHeight),
		new Rectangle(190,204,slotWidth,slotHeight),
		new Rectangle(345,204,slotWidth,slotHeight)};
	
	private  Rectangle[] buySlots = new Rectangle[]{new Rectangle(47,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(203,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(359,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(47,247,bsSlotWidth,bsSlotHeight),
		new Rectangle(203,247,bsSlotWidth,bsSlotHeight),
		new Rectangle(359,247,bsSlotWidth,bsSlotHeight)};
	
	private  Rectangle[] sellSlots = new Rectangle[]{new Rectangle(109,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(266,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(422,127,bsSlotWidth,bsSlotHeight),
		new Rectangle(109,247,bsSlotWidth,bsSlotHeight),
		new Rectangle(266,247,bsSlotWidth,bsSlotHeight),
		new Rectangle(422,247,bsSlotWidth,bsSlotHeight)};
	
	private  Rectangle[] progressBars = new Rectangle[]{new Rectangle(41,163,progressWidth,progressHeight),
		new Rectangle(204,163,progressWidth,progressHeight),
		new Rectangle(368,163,progressWidth,progressHeight),
		new Rectangle(41,284,progressWidth,progressHeight),
		new Rectangle(204,284,progressWidth,progressHeight),
		new Rectangle(368,284,progressWidth,progressHeight)};
	
	private  Rectangle[] collectBoxs = new Rectangle[]{new Rectangle(406,286,25,25),
		new Rectangle(455,286,25,25)};
	
	private  Rectangle buttonClose = new Rectangle(447,34,15,15);
	private  Rectangle buttonSearch = new Rectangle(107,96,35,35);
	private  Rectangle buttonBack = new Rectangle(37,291,23,11);
	private  Rectangle buttonQuantityMinus = new Rectangle(60,185,10,10);
	private  Rectangle buttonQuantityPlus = new Rectangle(240,185,10,10);
	private  Rectangle buttonQuantity1 = new Rectangle(56,210,30,20);
	private  Rectangle buttonQuantity10 = new Rectangle(97,210,30,20);
	private  Rectangle buttonQuantity100 = new Rectangle(139,210,30,20);
	private  Rectangle buttonQuantity1k = new Rectangle(180,210,30,20);
	private  Rectangle buttonQuantityCustom = new Rectangle(220,210,30,20);
	private  Rectangle buttonPriceMinus = new Rectangle(274,185,10,10);
	private  Rectangle buttonPricePlus = new Rectangle(448,185,10,10);
	private  Rectangle buttonPriceMinus5Percent = new Rectangle(274,210,30,20);
	private  Rectangle buttonPriceSetGE = new Rectangle(330,210,30,20);
	private  Rectangle buttonPriceCustom = new Rectangle(371,210,30,20);
	private  Rectangle buttonPricePlus5Percent = new Rectangle(427,210,30,20);
	private  Rectangle buttonConfirmOffer = new Rectangle(205,274,116,40);  
	private  Rectangle buttonFirstSearchResult = new Rectangle(68,344,100,10);
	private  Rectangle buttonAbortOffer = new Rectangle(358,280,10,10);
	
	private  Rectangle priceArea = new Rectangle(184,238,159,30);
    
	private  Color partiallySoldColour = new Color(198,139,1);
	private  Color soldColour = new Color(63,130,30);
	private  Color failedColour = new Color(138,0,16);
	
	public GrandExchange(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		slots = null;
		buySlots = null;
		sellSlots = null;
		progressBars = null;
		collectBoxs = null;
		buttonClose = null;
		buttonSearch = null;
		buttonBack = null;
		buttonQuantityMinus = null;
		buttonQuantityPlus = null;
		buttonQuantity1 = null;
		buttonQuantity10 = null;
		buttonQuantity100 = null;
		buttonQuantity1k = null;
		buttonQuantityCustom = null;
		buttonPriceMinus = null;
		buttonPricePlus = null;
		buttonPriceMinus5Percent = null;
		buttonPriceSetGE = null;
		buttonPriceCustom = null;
		buttonPricePlus5Percent = null;
		buttonConfirmOffer = null;
		buttonFirstSearchResult = null;
		buttonAbortOffer = null;
		priceArea = null;
		partiallySoldColour = null;
		soldColour = null;
		failedColour = null;
		gec = null;
	}
	
	/**
	 * Get a GE Item.
	 * 
	 * @param name
	 * @return GE_Item
	 * @throws InterruptedException
	 */
	public  GE_Item getItem(String name, boolean getChange) throws InterruptedException{
		return gec.getItem(name,getChange);	
	}
	
	/**
	 * Update your GE Item.
	 * 
	 * @param item
	 * @throws InterruptedException
	 */
	public  void updateItem(GE_Item item, boolean getChange) throws InterruptedException{
		item = gec.getItem(item.getName(), getChange);
	}
	
	/**
	 * Check if the GE is open.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean isOpen() throws InterruptedException{
		if(cm.checkColour(new Color(204,152,0), new Point(210,40))) return true;
		return false;
	}
	
	/**
	 * Check if the buy screen is open.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean isBuyScreenOpen() throws InterruptedException{
		return cm.checkColour(new Color(200,238,0), new Point(187,75));
	}
	
	/**
	 * Check if the sell screen is open.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public  boolean isSellScreenOpen() throws InterruptedException{
		return cm.checkColour(new Color(254,174,0), new Point(187,73));
	}
	
	/**
	 * Method to click randomly in the rectangle.
	 * 
	 * @param r
	 * @throws InterruptedException
	 */
	public  void clickRectangle(Rectangle r) throws InterruptedException{
		if(isOpen()){
			Point p = new Point((int)(r.getCenterX() - ((r.getWidth() / 2) -4)) + Constants.getRandom().nextInt((int)(r.getWidth() -4)), 
					(int)(r.getCenterY() - ((r.getHeight() / 2) -4)) + Constants.getRandom().nextInt((int)(r.getHeight() -4)));
			
			cm.theMouse.leftClick(p.x,p.y);
		}else{
			genericMessage();
		}	
	}
	
	/**
	 * Method to click randomly in the rectangle.
	 * 
	 * @param r
	 * @throws InterruptedException
	 */
	public  void clickRectangleNormal(Rectangle r) throws InterruptedException{
		if(isOpen()){
			Point p = new Point((int)(r.getCenterX() - ((r.getWidth() / 2) -2)) + Constants.getRandom().nextInt((int)(r.getWidth() -2)), 
					(int)(r.getCenterY() - ((r.getHeight() / 2) -2)) + Constants.getRandom().nextInt((int)(r.getHeight() -2)));
			
			cm.theMouse.leftClickNormal(p.x,p.y);
		}else{
			genericMessage();
		}	
	}
	
	/**
	 * Sends a generic message to the log.
	 * 
	 * @throws InterruptedException
	 */
	private  void genericMessage() throws InterruptedException{
		cm.log("The GE is not open, please open the GE before calling this method.");	
	}
	
	public  void close() throws InterruptedException{
		clickRectangle(buttonClose);
	}
	
	public  void clickSearch() throws InterruptedException{
		clickRectangle(buttonSearch);
	}
	
	public  void clickBack() throws InterruptedException{
		clickRectangle(buttonBack);
	}
	
	public  void clickQuantityMinus() throws InterruptedException{
		clickRectangle(buttonQuantityMinus);
	}
	
	public  void clickQuantityPlus() throws InterruptedException{
		clickRectangle(buttonQuantityPlus);
	}
	
	public  void clickQuantity1() throws InterruptedException{
		clickRectangle(buttonQuantity1);
	}
	
	public  void clickQuantity10() throws InterruptedException{
		clickRectangle(buttonQuantity10);
	}
	
	public  void clickQuantity100() throws InterruptedException{
		clickRectangle(buttonQuantity100);
	}
	
	public  void clickQuantity1k() throws InterruptedException{
		clickRectangle(buttonQuantity1k);
	}
	
	public  void clickQuantityCustom() throws InterruptedException{
		clickRectangle(buttonQuantityCustom);
	}
	
	public  void clickPriceMinus() throws InterruptedException{
		clickRectangle(buttonPriceMinus);
	}
	
	public  void clickPricePlus() throws InterruptedException{
		clickRectangle(buttonPricePlus);
	}
	
	public  void clickPriceMinus5Percent() throws InterruptedException{
		clickRectangle(buttonPriceMinus5Percent);
	}
	
	public  void clickPriceMinusSetGE() throws InterruptedException{
		clickRectangle(buttonPriceSetGE);
	}
	
	public  void clickPriceCustom() throws InterruptedException{
		clickRectangle(buttonPriceCustom);
	}
	
	public  void clickPricePlus5Percent() throws InterruptedException{
		clickRectangle(buttonPricePlus5Percent);
	}
	
	public  void clickConfirmOffer() throws InterruptedException{
		clickRectangle(buttonConfirmOffer);
	}
	
	public  void clickFirstSearchResult() throws InterruptedException{
		clickRectangle(buttonFirstSearchResult);
	}
	
	public  void clickAbortOffer() throws InterruptedException{
		clickRectangle(buttonAbortOffer);
	}
	
	public  void clickSlot(int slotID) throws InterruptedException{
		clickRectangle(slots[slotID -1]);
	}
	
	public  void clickBuySlot(int slotID) throws InterruptedException{
		clickRectangle(buySlots[slotID -1]);
	}
	
	public  void clickSellSlot(int slotID) throws InterruptedException{
		clickRectangle(sellSlots[slotID -1]);
	}
	
	/**
	 * Method to find and return a empty slot.
	 * 
	 * @return slot ID
	 * @throws InterruptedException
	 */
	public  int findEmptySlot() throws InterruptedException{
		if(cm.checkColour(new Color(204,153,0), new Point(86,90)) &&
				cm.checkColour(new Color(204,153,0), new Point(120,101))){
			return 1;
		}else if(cm.checkColour(new Color(204,153,0), new Point(241,90)) &&
				cm.checkColour(new Color(204,153,0), new Point(274,101))){
			return 2;
		}else if(cm.checkColour(new Color(204,153,0), new Point(397,90)) &&
				cm.checkColour(new Color(204,153,0), new Point(432,101))){
			return 3;
		}else if(cm.checkColour(new Color(204,153,0), new Point(86,211)) &&
				cm.checkColour(new Color(204,153,0), new Point(120,219))){
			return 4;
		}else if(cm.checkColour(new Color(204,153,0), new Point(241,211)) &&
				cm.checkColour(new Color(204,153,0), new Point(276,221))){
			return 5;
		}else if(cm.checkColour(new Color(204,153,0), new Point(397,211)) &&
				cm.checkColour(new Color(204,153,0), new Point(432,219))){
			return 6;
		}
		
		return -1;
	}
	
	/**
	 * Method to search and select a item in the GE.
	 * 
	 * @param item
	 * @throws InterruptedException
	 */
	public  boolean searchItem(String item) throws InterruptedException{
		String newItem = item.replace(" ", "");
		newItem = newItem.replace("'", "");
		newItem = newItem.replace("-", "");
		
		if(!cm.checkColour(new Color(143,127,100), new Point(490,460)))
			clickSearch();
		
		while(!cm.checkColour(new Color(143,127,100), new Point(490,460)))
			cm.sleep(200,400);
		
		cm.theKeyboard.sendKeys(item, false);
		cm.sleep(1000,2000);
		
		while(cm.checkColour(new Color(160,90,0), new Point(370,365)))
			cm.sleep(500,1000);
		
		cm.sleep(800,1500);
		for(int i = 0; i < 8; i++){
			Rectangle r = new Rectangle(66,(344 + i * 14),200,20);
			String s = cm.textReader.getText(r, OCRFont.GE_SMALL_TEXT, 30);
			
			if(s.contains(newItem)){
				for(int a = 0; a < 3; a++){
					cm.theMouse.leftClick(cm.getRandomPoint(new Rectangle((int)r.getX(),(int)r.getY(),200,14)));
					cm.sleep(1500,2000);
					
					if(!cm.textReader.getText(new Rectangle(52,135,150,16), OCRFont.GE_STAT_TEXT, 30).contains("N/A"))
						return true;
				}
				
				if(!cm.textReader.getText(new Rectangle(52,135,150,16), OCRFont.GE_STAT_TEXT, 30).contains("N/A"))
					return true;
				else
					return false;
			}/*else{
				System.out.println("Raw text: " + s + " | Your text: " + newItem);
			}*/
		}
		
		return false;
	}
	
	/**
	 * Set the quantity to buy or sell.
	 * 
	 * @param Quantity
	 * @throws InterruptedException
	 */
	public  void setQuantity(int Quantity) throws InterruptedException{
		if(Quantity > 10000){
			clickQuantityCustom();
			
			while(!cm.checkColour(new Color(0,0,0), new Point(327,403)))
				cm.sleep(100,200);
			
			cm.theKeyboard.sendKeys(String.valueOf(Quantity), true);
		}else{
			int thousands = Quantity/1000;
            int hundreds = (Quantity/100)%10;
            int tens = (Quantity/10)%10;
            int ones = Quantity%10;

            ArrayList<Integer> order = new ArrayList<Integer>();
            order.add(0);
            order.add(1);
            order.add(2);
            order.add(3);
            Collections.shuffle(order);
            
            for(int i = 0; i < order.size(); i++){
	            switch(order.get(i)){
	            case 0:
	            	for(int a = 0; a < thousands; a++){
	            		clickRectangleNormal(buttonQuantity1k);
	            		cm.sleep(50,100);
	            	}
	            	break;
	            case 1:
	            	for(int a = 0; a < hundreds; a++){
	            		clickRectangleNormal(buttonQuantity100);
	            		cm.sleep(50,100);
	            	}
	            	break;
	            case 2:
	            	for(int a = 0; a < tens; a++){
	            		clickRectangleNormal(buttonQuantity10);
	            		cm.sleep(50,100);
	            	}
	            	break;
	            case 3:
	            	for(int a = 0; a < ones; a++){
	            		clickRectangleNormal(buttonQuantity1);
	            		cm.sleep(50,100);
	            	}
	            	break;
	            }
	            
	            cm.sleep(80,200);
            }
		}
	}
	
	/**
	 * Check if a item has sold or brought.
	 * 
	 * @param slotID
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean hasSoldOrBrought(int slotID) throws InterruptedException{
		return cm.findColour(progressBars[slotID -1], soldColour, 10) != null;
	}
	
	/**
	 * Check if a item has sold or brought.
	 * 
	 * @param slotID
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean hasAnySoldOrBrought() throws InterruptedException{
		for(int i = 0; i < progressBars.length; i++){
			if(cm.findColour(progressBars[i], soldColour, 10) != null)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Check if a item is pending sale / buying.
	 * 
	 * @param slotID
	 * @return
	 * @throws InterruptedException
	 */
	public  boolean pendingSaleOrBuying(int slotID) throws InterruptedException{
		return cm.findColour(progressBars[slotID -1], partiallySoldColour, 10) != null;
	}
	
	/**
	 * Check if a item is pending sale / buying.
	 * 
	 * @param slotID
	 * @return
	 * @throws InterruptedException
	 */
	public  boolean hasAnyPendingSaleOrBuying() throws InterruptedException{
		for(int i = 0; i < progressBars.length; i++){
			if(cm.findColour(progressBars[i], partiallySoldColour, 10) != null)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Check if a slot has reached it's limit.
	 * 
	 * @param slotID
	 * @return boolean
	 * @throws InterruptedException
	 */
	public  boolean failedSaleOrBuying(int slotID) throws InterruptedException{
		return cm.findColour(progressBars[slotID -1], failedColour, 10) != null;
	}
	
	/**
	 * Check if a item is pending sale / buying.
	 * 
	 * @param slotID
	 * @return
	 * @throws InterruptedException
	 */
	public  boolean hasAnyFailedSaleOrBuying() throws InterruptedException{
		for(int i = 0; i < progressBars.length; i++){
			if(cm.findColour(progressBars[i], failedColour, 10) != null)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Collect the items from within the sale / buy screen.
	 * The window must already be open.
	 * 
	 * @throws InterruptedException
	 */
	public  void collectItems() throws InterruptedException{
		for(Rectangle r : collectBoxs){
			if(isBuyScreenOpen() || isSellScreenOpen())
				if(!cm.allSimilarColours(new Color(69,56,36), cm.getColours(r), 30)){
					cm.theMouse.leftClick(cm.getRandomPoint(r));
					cm.sleep(300,500);
				}
		}
	}
	
	/**
	 * Get the buy price, small orange text.
	 * 
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getBuyPriceSmallText() throws InterruptedException{
		if(isBuyScreenOpen() || isSellScreenOpen()){
			while(priceArea.contains(cm.theMouse.getMousePosition())){
				cm.theMouse.move(cm.getRandomPoint(new Rectangle(5,5,500,330)));
				cm.sleep(300,500);
			}
			
			try{
				String s = cm.textReader.getText(new Rectangle(200,284,180,16), OCRFont.GE_STAT_TEXT, 30).replace(",", "");
				
				if(!s.contains("No text found."))
					return Integer.parseInt(s);
				else
					return -1;
			}catch(NumberFormatException e){return -1;}
		}
		return -1;
	}
	
	/**
	 * Get the brought/sold text.
	 * 
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getBoughtSmallText() throws InterruptedException{
		if(isBuyScreenOpen() || isSellScreenOpen()){
			while(priceArea.contains(cm.theMouse.getMousePosition())){
				cm.theMouse.move(cm.getRandomPoint(new Rectangle(5,5,500,330)));
				cm.sleep(300,500);
			}
			
			try{
				String s = cm.textReader.getText(new Rectangle(200,270,180,16), OCRFont.GE_STAT_TEXT, 30).replace(",", "");
				
				if(!s.contains("No text found."))
					return Integer.parseInt(s);
				else
					return -1;
			}catch(NumberFormatException e){return -1;}
		}
		return -1;
	}
	
	/**
	 * Will read the quantity from buy/sell screen.
	 * 
	 * @param cm
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getQuantity() throws InterruptedException{
		if(isBuyScreenOpen() || isSellScreenOpen()){
			try{
				String s = cm.textReader.getText(new Rectangle(79,182,153,20), OCRFont.MENU_TEXT, 30).replace(",", "");
				s = s.replace(".", "");
				
				if(!s.contains("No text found."))
					return Integer.parseInt(s);
				else
					return -1;
			}catch(NumberFormatException e){return -1;}
		}
		return -1;
	}
	
	/**
	 * Will read the price from buy/sell screen.
	 * 
	 * @param cm
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getPrice() throws InterruptedException{
		if(isBuyScreenOpen() || isSellScreenOpen()){
			try{
				String s = cm.textReader.getText(new Rectangle(293,183,148,20), OCRFont.MENU_TEXT, 30).replace(",", "");
				s = s.replace("gp", "");
				s = s.replace(".", "");
				
				if(!s.contains("No text found."))
					return Integer.parseInt(s);
				else
					return -1;
			}catch(NumberFormatException e){return -1;}
		}
		return -1;
	}
	
	/**
	 * Get the amount of money you have by reading it
	 * from the item information screen.
	 * 
	 * @param cm
	 * @return int
	 * @throws InterruptedException
	 */
	public  int getGpFromItemInformation() throws InterruptedException{
		if(isBuyScreenOpen() || isSellScreenOpen()){
			try{
				String s = cm.textReader.getText(new Rectangle(550,449,185,17), OCRFont.GE_STAT_TEXT, 30);
				
				if(!s.contains("No text found.")){
					s = s.replace("Youhave","");
					s = s.replace("coins.", "");
					double modifier = ColourBot.getModifier(s);
					s = s.replaceAll("[^0-9.]+", "");
					return (int) (Integer.parseInt(s) * modifier);
				}else{
					return -1;
				}
			}catch(NumberFormatException e){return -1;}
		}
		return -1;
	}
}