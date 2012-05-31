package org.cb.api.utils;

import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * @author Troy
 *
 */
public class Points {
	
	public static Point getMostLeftPoint(ArrayList<Point> arr){
	    int x = -1;
	    Point a = null;
	    int j = arr.size(); 
	    
	    for(int i = 0; i < j; i++){ 
	    	Point p = arr.get(i);
	    	if ((x == -1) || (p.x < x)) {
	    		x = p.x;
	    		a = p;
	    	}
	    }
	    return a;
	}

	public static Point getMostRightPoint(ArrayList<Point> arr){
	    int x = -1;
	    Point a = null;
	    int j = arr.size(); 
	    
	    for(int i = 0; i < j; i++){ 
	    	Point p = arr.get(i);
	    	if ((x == -1) || (p.x > x)) {
	    		x = p.x;
	    		a = p;
	    	}
	    }
	    return a;
	}

	public static Point getHighestPoint(ArrayList<Point> arr){
	    int y = -1;
	    Point a = null;
	    int j = arr.size(); 
	    
	    for(int i = 0; i < j; i++){ 
	    	Point p = arr.get(i);
	    	if ((y == -1) || (p.y < y)) {
	    		y = p.y;
	    		a = p;
	    	}
	    }
	    return a;
	}

	public static Point getLowestPoint(ArrayList<Point> arr){
	    int y = -1;
	    Point a = null;
	    int j = arr.size(); 
	    
	    for(int i = 0; i < j; i++){ 
	    	Point p = arr.get(i);
	    	if ((y == -1) || (p.y > y)) {
	    		y = p.y;
	    		a = p;
	    	}
	    }
	    return a;
	}

}