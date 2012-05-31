package org.cb.api;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.cb.api.utils.ImageLoader;

/**
 * 
 * @author Troy
 *
 */
public class Constants {
	private static final Rectangle screenArea = new Rectangle(0,0,765,503);
	private static final Rectangle playArea = new Rectangle(3,3,512,335);
	private static final Rectangle minimapArea = new Rectangle(513,0,250,170);
	private static final Rectangle tabArea = new Rectangle(521,167,240,340);
	private static final Rectangle chatArea = new Rectangle(0,338,518,143);
	
	private static final Random random = new Random();

	private static final String[] runes = {"Air rune", "Water rune", "Earth rune", "Fire rune", 
			"Mind rune", "Body rune", "Chaos rune", "Death rune", 
			"Cosmic rune", "Law rune", "Nature rune", "Astral rune", 
			"Blood rune", "Soul rune", "Armadyl rune"};
	
	private static final BufferedImage[] spellImages = ImageLoader.loadImages(70, "Config/Images/Magic/Spells", ".gif");

	public static Rectangle getScreenArea() {
		return screenArea;
	}

	public static Rectangle getPlayArea() {
		return playArea;
	}

	public static Rectangle getMinimapArea() {
		return minimapArea;
	}

	public static Rectangle getTabArea() {
		return tabArea;
	}

	public static Rectangle getChatArea() {
		return chatArea;
	}

	public static Random getRandom() {
		return random;
	}

	public static String[] getRunes() {
		return runes;
	}

	public static BufferedImage[] getSpellImages() {
		return spellImages;
	}
	
}