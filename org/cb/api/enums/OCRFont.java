package org.cb.api.enums;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.cb.api.utils.ImageLoader;

/**
 * 
 * @author Troy
 *
 */
public enum OCRFont {
	TOP_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigTopTextChars", ".gif"),new Color[]{new Color(10,210,205),
													new Color(215,215,10),
													new Color(230,230,0),
													new Color(216,10,5),
													new Color(220,135,30),
													new Color(10,210,10),
													new Color(160,215,10),
													new Color(155,170,170),
													new Color(190,0,0),
													new Color(255,0,0),
													new Color(0,255,0),
													new Color(0,190,0),
													new Color(255,255,0),
													new Color(190,190,0),
													new Color(205,190,155),
													new Color(25,240,240),
													new Color(235,206,118)}),
													
	MENU_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigMenuTextChars", ".gif"),new Color[]{new Color(198,184,149),
													new Color(230,230,0),
													new Color(163,152,124),
													new Color(212,129,31),
													new Color(150,175,180),
													new Color(190,0,0),
													new Color(255,0,0),
													new Color(0,255,0),
													new Color(0,190,0),
													new Color(255,255,0),
													new Color(190,190,0),
													new Color(150,75,0),
													new Color(160,180,180),
													new Color(255,150,30),
													new Color(211,184,95),
													new Color(255,168,97)}),
														
	SMALL_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigSmallTextChars", ".gif"),new Color[]{new Color(255,255,0),
													new Color(0,0,0),
													new Color(0,0,255),
													new Color(0,255,255)}),
	
	STAT_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigStatTextChars", ".gif"),new Color[]{new Color(255,255,0),
													new Color(0,255,0),
													new Color(230,230,0),
													new Color(255,140,0),
													new Color(255,150,30),
													new Color(255,0,0),
													new Color(252,252,100)}),
	
	GE_STAT_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigStatTextChars", ".gif"),new Color[]{new Color(200,150,0),
													new Color(153,153,0),
													new Color(255,153,0)}),
	
	GE_SMALL_TEXT(ImageLoader.loadImages(83, "Config/Fonts/fsigSmallTextChars", ".gif"),new Color[]{new Color(160,90,0)});
	
	BufferedImage fontChars[] = new BufferedImage[83];
	Color textColours[] = new Color[]{};
			
	private OCRFont(BufferedImage[] fontChars, Color[] textColours){
		this.fontChars = fontChars;
		this.textColours = textColours;
	}

	public BufferedImage[] getFontChars() {
		return fontChars;
	}

	public Color[] getTextColours() {
		return textColours;
	}
}