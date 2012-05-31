package org.cb.api.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 * @author Troy
 *
 */
public class ImageLoader {
	
	public static BufferedImage[] loadImages(int imageCount, String folderName, String fileType){
		BufferedImage[] font = new BufferedImage[imageCount];
		
		for(int i = 0; i < imageCount; i++)
			font[i] = loadImage(folderName + "/" + i + fileType);
		
		return font;
	}
	
	public static BufferedImage loadImage(String ref) {
		try {
			return ImageIO.read(new File(ref));
		}catch(Exception e) {/*e.printStackTrace();*/}
		return null;
	}

}