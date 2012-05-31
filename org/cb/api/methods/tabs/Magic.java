package org.cb.api.methods.tabs;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.cb.api.ColourMethods;
import org.cb.api.Constants;
import org.cb.api.enums.Spells;

/**
 * 
 * @author Troy
 * 
 *
 */
public class Magic {
	private ColourMethods cm;
	public Rectangle spellArea = new Rectangle(546,206,190,257);
	
	public Magic(ColourMethods cm){
		this.cm = cm;
	}
	
	/**
	 * Clean up.
	 */
	public void cleanUp(){
		spellArea = null;
		cm = null;
	}
	
	/**
	 * Check if the magic tab is selected.
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
	 * Click the magic tab.
	 * 
	 * @throws InterruptedException
	 */
	public void click() throws InterruptedException{
		Rectangle r = new Rectangle(734,171,28,33);
		int x = (int) ((r.getCenterX() - 5) + Constants.getRandom().nextInt(11));
		int y = (int) ((r.getCenterY() - 5) + Constants.getRandom().nextInt(11));

		cm.theMouse.leftClick(x,y);
		cm.sleep(100,150);
	}
	
	/**
	 * See if the spell is available.
	 * 
	 * @param spell
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean isSpellAvailable(Spells spell) throws InterruptedException{
		if(!isSelected())
			click();
		
		return cm.findImage(cm.getImage(spellArea), 
				Constants.getSpellImages()[spell.getImage()], 
				0, 
				0, 
				(int)spellArea.getWidth(), 
				(int)spellArea.getHeight(), 
				110); 
	}
	
	/**
	 * Click a spell.
	 * 
	 * @param spell
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean clickSpell(Spells spell) throws InterruptedException{
		if(!isSelected())
			click();
		
		Point p = cm.findImagePoint(cm.getImage(spellArea), 
				Constants.getSpellImages()[spell.getImage()], 
				0, 
				0, 
				(int)spellArea.getWidth(), 
				(int)spellArea.getHeight(), 
				110);
		
		if(p == null)
			return false;
			
		p = cm.getRandomPoint(new Rectangle((int)spellArea.getX() + p.x + 7, (int)spellArea.getY() + p.y + 7, 10, 10));
		
		cm.theMouse.leftClick(p);
		cm.sleep(200,250);
		return true;
	}

}
