package org.cb.api.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * @author Troy
 *
 */
public class Image {
	
	/**
	 * Make's a certain colour transparent.
	 * @param source
	 * @param color
	 * @return BufferedImage
	 */
	public static BufferedImage makeColorTransparent(BufferedImage source, Color color) {  
		BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);  
		Graphics2D g = image.createGraphics();  
		
		g.setComposite(AlphaComposite.Src);
		g.drawImage(image, null, 0, 0);
		g.dispose();
		
		int colorRGB = color.getRGB();
		for(int i = 0; i < image.getHeight(); i++) {  
			for(int j = 0; j < image.getWidth(); j++) {  
				if (image.getRGB(j, i) == colorRGB) {  
					image.setRGB(j, i, 0x8F1C1C);
				}  
			}  
		}  
		return image;  
	}
	
	/**
	 * Flips a given image horizontally.
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public static BufferedImage flipHorizontally(BufferedImage source) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.drawImage(source, 0, 0, w, h, w, 0, 0, h, null);  
		g.dispose();  
		return image;  
	}  

	/**
	 * Flips a given image vertically.
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public static BufferedImage flipVertically(BufferedImage source) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.drawImage(source, 0, 0, w, h, 0, h, w, 0, null);  
		g.dispose();  
		return image;  
	}  

	/**
	 * Rotates a given image to a given angle.
	 * @param source The source image.
	 * @param angle The angle to rotate by (in degrees).
	 * @return BufferedImage
	 */
	public static BufferedImage rotate(BufferedImage source, int angle) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.rotate(Math.toRadians(angle), w / 2, h / 2);  
		g.drawImage(source, null, 0, 0);  
		return image;  
	}  

	/**
	 * Resizes a given image to a given width and height.
	 * @param source The source image.
	 * @param width The new width.
	 * @param height The new height.
	 * @return BufferedImage
	 */
	public static BufferedImage resize(BufferedImage source, int width, int height) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(width, height, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
		g.drawImage(source, 0, 0, width, height, 0, 0, w, h, null);  
		g.dispose();  
		return image;  
	}  
	
	/**
	 * This will convert a image into a string.
	 * 
	 * @param image
	 * @return String
	 */
	public static String getImageString(BufferedImage image){
		String imageInString = null;
		
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			imageInString = new sun.misc.BASE64Encoder().encode(baos.toByteArray());
			baos.close();
			baos = null;
		}catch(IOException e){e.printStackTrace();}
		
		return imageInString;
	}
	
	/**
	 * This will convert a string into a image.
	 * 
	 * @param image
	 * @return BufferedImage
	 */
	public static BufferedImage getImageFromString(String image){
		BufferedImage imageFromString = null;
		
		try{
			byte[] byteArray = new sun.misc.BASE64Decoder().decodeBuffer(image);
			InputStream in = new ByteArrayInputStream(byteArray);
			imageFromString = ImageIO.read(in);
			in.close();
			byteArray = null;
			in = null;
		}catch(IOException e){e.printStackTrace();}
		
		return imageFromString;
	}
	
}
