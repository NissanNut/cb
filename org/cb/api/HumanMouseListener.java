package org.cb.api;

import java.awt.event.MouseEvent;

/**
 * 
 * @author Troy
 *
 */
public interface MouseListener {
	public void mouseClicked(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseDragged(MouseEvent e);
}