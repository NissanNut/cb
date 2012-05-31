package org.cb.api.methods;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Troy
 *
 */
public class GE_Item {
	private int id;
	private String name;
	private double price;
	private String movement;
	private String thirtyDayChange;
	private String sixtyDayChange;
	private String ninetyDayChange;
	private BufferedImage image;
	private BufferedImage noteImage;
	
	public GE_Item(int id, String name, double price, String movement, String thirtyDayChange, String sixtyDayChange, String ninetyDayChange, BufferedImage image, BufferedImage noteImage){
		this.id = id;
		this.name = name;
		this.price = price;
		this.movement = movement;
		this.thirtyDayChange = thirtyDayChange;
		this.sixtyDayChange = sixtyDayChange;
		this.ninetyDayChange = ninetyDayChange;
		this.image = image;
		this.noteImage = noteImage;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getMovement() {
		return movement;
	}

	public String getThirtyDayChange() {
		return thirtyDayChange;
	}

	public String getSixtyDayChange() {
		return sixtyDayChange;
	}

	public String getNinetyDayChange() {
		return ninetyDayChange;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public BufferedImage getNoteImage() {
		return noteImage;
	}
	
}
