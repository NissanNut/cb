package org.cb.api;

import java.awt.Color;
import java.awt.ColourBot;
import java.awt.Point;
import java.awt.RS_Client;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.cb.api.methods.Bank;
import org.cb.api.methods.Camera;
import org.cb.api.methods.GrandExchange;
import org.cb.api.methods.GroundItem;
import org.cb.api.methods.Menu;
import org.cb.api.methods.Minimap;
import org.cb.api.methods.Npc;
import org.cb.api.methods.Player;
import org.cb.api.methods.Players;
import org.cb.api.methods.TabContainer;
import org.cb.api.methods.Walker;
import org.cb.api.utils.Image;
import org.cb.api.utils.Points;
import org.cb.api.wrappers.OCR;
import org.cb.api.wrappers.TheKeyboard;
import org.cb.api.wrappers.TheMouse;


/**
 * 
 * @author Troy
 *
 */
public class ColourMethods {
	private RS_Client client;
	
	public TabContainer theTabs;
	public TheMouse theMouse;
	public TheKeyboard theKeyboard;
	public OCR textReader;
	public Menu theMenu;
	public Bank theBank;
	public Camera theCamera;
	public Minimap theMinimap;
	public GrandExchange theGrandExchange;
	public Player myPlayer;
	public Npc npc;
	public GroundItem groundItem;
	public Players players;
	public Walker walker;
	
	/**
	 * DO NOT CALL THIS.
	 * WILL CAUSE YOUR BOT TO CRASH.
	 * 
	 * @param client
	 */
	public void setClient(RS_Client client){
		this.client = client;
	}
	
	/**
	 * DO NOT CALL THIS.
	 */
	public void init(){
		theTabs = new TabContainer(this);
		textReader = new OCR(this);
		theMenu = new Menu(this);
		theBank = new Bank(this);
		theCamera = new Camera(this);
		theMinimap = new Minimap(this);
		theGrandExchange = new GrandExchange(this);
		myPlayer = new Player(this);
		npc = new Npc(this);
		groundItem = new GroundItem(this);
		players = new Players(this);
		walker = new Walker(this);
		theMouse = new TheMouse(client.theMouse);
		theKeyboard = new TheKeyboard(client.theKeyboard);
	}
	
	/**
	 * DO NOT CALL THIS.
	 */
	public void cleanUp(){
		theTabs.cleanUp();
		textReader.cleanUp();
		theMenu.cleanUp();
		theBank.cleanUp();
		theCamera.cleanUp();
		theMinimap.cleanUp();
		theGrandExchange.cleanUp();
		myPlayer.cleanUp();
		npc.cleanUp();
		groundItem.cleanUp();
		players.cleanUp();
		walker.cleanUp();
		
		theTabs = null;
		textReader = null;
		theMenu = null;
		theBank = null;
		theCamera = null;
		theMinimap = null;
		theGrandExchange = null;
		myPlayer = null;
		npc = null;
		groundItem = null;
		players = null;
		walker = null;
		theMouse = null;
		theKeyboard = null;
		client = null;
	}
	
	/**
	 * To stop your script.
	 */
	public void stopScript(){
		try{
			captureScreenWithPaint();
		}catch (InterruptedException e){e.printStackTrace();}

		client.stopScript();
	}
	
	/**
	 * Capture and save a screen shot.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean captureScreen() throws InterruptedException{
		return ColourBot.captureScreen(client);
	}
	
	/**
	 * Capture and save a screen shot with user paint.
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean captureScreenWithPaint() throws InterruptedException{
		return ColourBot.captureScreenWithPaint(client);
	}
	
	/**
	 * Sleep the thread for X amount of time.
	 * In MS.
	 * 
	 * @param sleepTime
	 */
	public void sleep(int sleepTime) throws InterruptedException{
		Thread.sleep(sleepTime);
	}
	
	/**
	 * Sleep with a random time
	 * 
	 * @param from
	 * @param to
	 * @throws InterruptedException
	 */
	public void sleep(int from, int to) throws InterruptedException{
		int sleepTime = Constants.getRandom().nextInt(to) + from;
		Thread.sleep(sleepTime);
	}
	
	/**
	 * Get a image of the screen.
	 * 
	 * @return BufferedImage
	 * @throws InterruptedException
	 */
	public BufferedImage getImage() throws InterruptedException{
		return ColourBot.getImage(client);
	}
	
	/**
	 * Get a image of the screen in the selected rectangle defined.
	 * 
	 * @param r
	 * @return BufferedImage
	 * @throws InterruptedException
	 */
	public BufferedImage getImage(Rectangle r) throws InterruptedException{
		return ColourBot.getImage(client,r);
	}
	
	/**
	 * Get a colour at the selected point.
	 * 
	 * @param p
	 * @return Color
	 * @throws InterruptedException
	 */
	public Color getColour(Point p) throws InterruptedException{
		return ColourBot.getColour(client,p);
	}
	
	/**
	 * Get a colour at the x,y cords.
	 * 
	 * @param x
	 * @param y
	 * @return Color
	 * @throws InterruptedException
	 */
	public Color getColour(int x, int y) throws InterruptedException{
		return ColourBot.getColour(client,new Point(x,y));
	}
	
	/**
	 * Get a colour from the selected image
	 * at the selected point.
	 * 
	 * @param i
	 * @param p
	 * @return Color
	 * @throws InterruptedException
	 */
	public Color getColour(BufferedImage i, Point p) throws InterruptedException{
		return ColourBot.getColour(i, p);
	}
	
	/**
	 * Get a colour from the selected image
	 * at the selected x,y cords.
	 * 
	 * @param i
	 * @param x
	 * @param y
	 * @return Color
	 * @throws InterruptedException
	 */
	public Color getColour(BufferedImage i, int x, int y) throws InterruptedException{
		return ColourBot.getColour(i, new Point(x,y));
	}
	
	/**
	 * Check the colour at a specific point.
	 * (Doesn't appear to be working atm...)
	 * 
	 * @param r
	 * @param c
	 * @param p
	 * @param tolerance
	 * @return boolean
	 */
	public boolean checkColour(Rectangle r, Color c, Point p, int tolerance) throws InterruptedException{
		return ColourBot.checkColour(client,r, c, p, tolerance);
	}
	
	/**
	 * Check the colour at a point.
	 * 
	 * @param c
	 * @param p
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean checkColour(Color c, Point p) throws InterruptedException{
		return ColourBot.checkColour(client,c,p);
	}
	
	/**
	 * Method to find the pixel colour
	 * 
	 * @param c
	 * @return Point
	 */
	public Point findColour(Rectangle r, Color c, int tolerance) throws InterruptedException{
		return ColourBot.findColour(client,r, c, tolerance);
	}
	
	/**
	 * Find all the matching points for this colour.
	 * 
	 * @param r
	 * @param c
	 * @param tolerance
	 * @return
	 * @throws InterruptedException
	 */
	public ArrayList<Point> findColourArray(Rectangle r, Color c, int tolerance) throws InterruptedException{
		return ColourBot.findColourArray(client,r, c, tolerance);
	}
	
	/**
	 * Find all the matching points for this colour.
	 * 
	 * @param r
	 * @param c
	 * @param tolerance
	 * @return
	 * @throws InterruptedException
	 */
	public ArrayList<Point> findColourArray(BufferedImage i, Color c, int tolerance) throws InterruptedException{
		return ColourBot.findColourArray(i, c, tolerance);
	}
	
	/**
	 * Method to get all the colours within a set area.
	 * 
	 * @param r
	 * @return Color
	 * @throws InterruptedException
	 */
	public Color[] getColours(Rectangle r) throws InterruptedException{
		return ColourBot.getColours(client,r);
	}
	
	/**
	 * Check if two colours are similar with
	 * a selectable tolerance.
	 * 
	 * @param a
	 * @param b
	 * @param tolerance
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean similarColours(Color a, Color b, int tolerance) throws InterruptedException{
		return ColourBot.similarColours(a, b, tolerance);
	}
	
	/**
	 * Check if all colours are similar to the matching colour.
	 * 
	 * @param a
	 * @param b
	 * @param tolerance
	 * @return boolean
	 */
	public boolean allSimilarColours(Color a, Color[] b, int tolerance) {
		return ColourBot.allSimilarColours(a, b, tolerance);
	}
	
	/**
	 * Check if a colour is similar to any of the colours in a array.
	 * 
	 * @param a
	 * @param b
	 * @param tolerance
	 * @return
	 */
	public boolean anySimilarColours(Color a, Color[] b, int tolerance) {
		return ColourBot.anySimilarColours(a, b, tolerance);
	}
	
	/**
	 * Find the point at which the selected colour
	 * is located within the screen.
	 * 
	 * @param col
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point findColour(Color col, int x1, int y1, int x2, int y2) throws InterruptedException{
		return ColourBot.findColour(client, col, x1, y1, x2, y2);
	}
		
    /**
     * Should work with any number of Colors > 2.
     * 
     * This method was created by Joel I think
     * from RSCA. Based on Fsig's method.
     *
     * @param r
     * @param colors
     * @param distance
     * @param maxColors
     * @param tolerance
     * @return Point
     * @throws InterruptedException
     */
    public Point findColourPattern(Rectangle r, Color[] colors, int distance, int maxColors, int tolerance) throws InterruptedException {
        return ColourBot.findColourPattern(client, r, colors, distance, maxColors, tolerance);
    }
    
    /**
     * 
     * @param r
     * @param colors
     * @param distance
     * @param maxColors
     * @param tolerance
     * @return ArrayList<Point>
     * @throws InterruptedException
     */
    public ArrayList<Point> findColourPatternArray(Rectangle r, Color[] colors, int distance, int maxColors, int tolerance) throws InterruptedException {
        return ColourBot.findColourPatternArray(client, r, colors, distance, maxColors, tolerance);
    }
	
	/**
	 * Find a colour in the set area with the option to start from
	 * wherever in the image you like.
	 * 
	 * This is a modification of the method Devil and myself originally
	 * came up with.
	 * 
	 * @param r
	 * @param I
	 * @param c
	 * @param x2
	 * @param y2
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point findColourInPattern(Rectangle r, BufferedImage I, Color c, int x2, int y2, int tolerance) throws InterruptedException{
		return ColourBot.findColourInPattern(r, I, c, x2, y2, tolerance);
	}
	
	/**
	 * Converts the image to 16bit colours.
	 * 
	 * @param I
	 * @return BufferedImage
	 */
	public BufferedImage convertTo16Bit(BufferedImage I) throws InterruptedException{
		return ColourBot.convertTo16Bit(I);
	}
	
	/**
	 * Get the most left point from the array.
	 * 
	 * @param arr
	 * @return Point
	 */
	public Point getMostLeftPoint(ArrayList<Point> arr) throws InterruptedException{
		return Points.getMostLeftPoint(arr);
	}
	
	/**
	 * Get the most left point from the array.
	 * 
	 * @param arr
	 * @return Point
	 */
	public Point getHighestPoint(ArrayList<Point> arr) throws InterruptedException{
		return Points.getHighestPoint(arr);
	}
	
	/**
	 * Get the most left point from the array.
	 * 
	 * @param arr
	 * @return Point
	 */
	public Point getLowestPoint(ArrayList<Point> arr) throws InterruptedException{
		return Points.getLowestPoint(arr);
	}
	
	/**
	 * Get the most left point from the array.
	 * 
	 * @param arr
	 * @return Point
	 */
	public Point getMostRightPoint(ArrayList<Point> arr) throws InterruptedException{
		return Points.getMostRightPoint(arr);
	}
	
	/**
	 * Get the closest point.
	 * 
	 * @param src
	 * @param points
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point getClosestPoint(Point src, ArrayList<Point> points) throws InterruptedException{
		return ColourBot.getClosestPoint(src, points);
	}
	
/*************************************************
* Image methods have been imported to here now.
*************************************************/
	
	/**
	 * Find a image within another image.
	 * 
	 * @param orig
	 * @param compare
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param tolerance
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean findImage(BufferedImage orig, BufferedImage compare, int x1, int y1, int x2, int y2, int tolerance) throws InterruptedException {
		return ColourBot.findImage(orig, compare, x1, y1, x2, y2, tolerance);
	}
	
	/**
	 * Find the point where the image fits.
	 * 
	 * @param orig
	 * @param compare
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param tolerance
	 * @return Point
	 * @throws InterruptedException
	 */
	public Point findImagePoint(BufferedImage orig, BufferedImage compare, int x1, int y1, int x2, int y2, int tolerance) throws InterruptedException {
		return ColourBot.findImagePoint(orig, compare, x1, y1, x2, y2, tolerance);
	}
	
	/**
	 * Return all possible point's the image fits.
	 * 
	 * @param orig
	 * @param compare
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param tolerance
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> findImageArray(BufferedImage orig, BufferedImage compare, int x1, int y1, int x2, int y2, int tolerance) throws InterruptedException {
		return ColourBot.findImageArray(orig, compare, x1, y1, x2, y2, tolerance);
	}
	
	/**
	 * Return all possible point's the image fits.
	 * 
	 * @param r
	 * @param compare
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param tolerance
	 * @return ArrayList<Point>
	 * @throws InterruptedException
	 */
	public ArrayList<Point> findImageArray(Rectangle r, BufferedImage compare, int x1, int y1, int x2, int y2, int tolerance) throws InterruptedException {
		return ColourBot.findImageArray(client, r, compare, x1, y1, x2, y2, tolerance);
	}
	
	/**
	 * Returns random number
	 */
	
	public int random(int low, int high) {
		return ColourBot.random(low, high);
	}
	
	/**
	 * Logs the selected message to the client's log.
	 * 
	 * @param msg
	 */
	public void log(String msg) throws InterruptedException{
		ColourBot.log(client,msg);
	}
	
	
	/**
	 * Make a certain colour transparent within the image.
	 * 
	 * @param source
	 * @param color
	 * @return BufferedImage
	 */
	public BufferedImage makeColorTransparent(BufferedImage source, Color color){  
		return Image.makeColorTransparent(source, color);
	}
	
	/**
	 * Flip the image horizontally.
	 * 
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public BufferedImage flipHorizontally(BufferedImage source){  
		return Image.flipHorizontally(source);
	}
	
	/**
	 * Flip the image vertically.
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public BufferedImage flipVertically(BufferedImage source){  
		return Image.flipVertically(source);
	}
	
	/**
	 * Rotates the image to a given angle.
	 * 
	 * @param source The source image.
	 * @param angle The angle to rotate by (in degrees).
	 * @return BufferedImage
	 */
	public BufferedImage rotate(BufferedImage source, int angle){ 
		return Image.rotate(source, angle);
	}
	
	/**
	 * Resizes the image to a given width and height.
	 * 
	 * @param source The source image.
	 * @param width The new width.
	 * @param height The new height.
	 * @return BufferedImage
	 */
	public BufferedImage resize(BufferedImage source, int width, int height){  
		return Image.resize(source, width, height);
	}

	
/*****************************************************************************************
 * Script Utils
 *****************************************************************************************/
	
	/**
	 * Format value in K,M,B and return the string value.
	 * 
	 * @param value
	 * @return String
	 */
    public String formatValue(double value){
    	return ColourBot.formatValue(value);
    }

    /**
     * Format gold per hour and return the string value of GP per hour.
     * 
     * @param value
     * @param timeRan
     * @return String
     */
    public String formatPerHour(double value, long timeRan){
    	return ColourBot.formatPerHour(value, timeRan);
    }
    
    /**
     * Method to get a random point within the rectangle.
     * 
     * @param r
     * @return Point
     * @throws InterruptedException
     */
    public Point getRandomPoint(Rectangle r) throws InterruptedException{
    	return ColourBot.getRandomPoint(r);
    }
    
    /**
     * Check if the state of mouse block.
     * 
     * @return boolean
     */
	public boolean isAllowMouse(){
		return ColourBot.isAllowMouse(client);
	}
	
	/**
	 * Enable / disable the mouse block.
	 * 
	 * @param allowMouse
	 */
	public void setAllowMouse(boolean allowMouse){
		ColourBot.setAllowMouse(client,allowMouse);
	}
	
	/**
	 * Start all randoms.
	 * 
	 * @throws InterruptedException
	 */
	public void startAllRandoms() throws InterruptedException{
		ColourBot.startAllRandoms(client);
	}
	
	/**
	 * Start a random.
	 * 
	 * @param name
	 * @throws InterruptedException
	 */
	public void startRandom(String name) throws InterruptedException{
		ColourBot.startRandom(client,name);
	}
	
	/**
	 * Stop all randoms.
	 * 
	 * @throws InterruptedException
	 */
	public void stopAllRandoms() throws InterruptedException{
		ColourBot.startAllRandoms(client);
	}
	
	/**
	 * Stop a random.
	 * 
	 * @param name
	 * @throws InterruptedException
	 */
	public void stopRandom(String name) throws InterruptedException{
		ColourBot.startRandom(client,name);
	}

}
