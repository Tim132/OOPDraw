/* 
 * Filename: OOPDraw2.java 
 * Written By: Sunit Katkar 
 * E-Mail:sunitkatkar@hotmail.com 
 * Home-Page : http://www.vidyut.com/sunit 
 * Java Page : www.vidyut.com/sunit/JavaPage.html 
 ****************************************************************** 
 * Description: 
 * A very simple vector drawing example. I have used the OO concept 
 * of Polymorphism to declare on abstract Shape class and then derived  
 * line, rectangle and oval shape classes. The shapes are stored in a 
 * Vector so that they remain on screen as new shapes are drawn. 
 * An offscreen image technique is used to avoid flicker. 
 **************************************************************** 
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved. 
 * 
 * Permission to use, copy, modify, and distribute this software 
 * for NON-COMMERCIAL or COMMERCIAL purposes and without fee 
 * is hereby granted. 
 * 
 * Whew ! That was too much legalese..even to have copied and pasted 
 * from some other place... PLEASE DO NOT BLAME ME in any way 
 * if your system crashes because of this code, or if anything else 
 * bad happens. In short "DO WHAT YOU WANT BUT DONT BLAME ME !" 
 *****************************************************************/
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Filename: OOPDraw2.java<br/>
 * Written By: Sunit Katkar<br/>
 * E-Mail:sunitkatkar@hotmail.com<br/>
 * Home-Page : [url]http://www.vidyut.com/sunit[/url]<br/>
 * Java Page : [url]www.vidyut.com/sunit/JavaPage.html[/url]
 * <p/>
 *******************************************************************************<p/>
 * Description: A very simple vector drawing example. I have used the OO concept
 * of Polymorphism to declare on abstract Shape class and then derived line,
 * rectangle and oval shape classes. The shapes are stored in a Vector so that
 * they remain on screen as new shapes are drawn. An offscreen image technique
 * is used to avoid flicker.
 * <p/>
 *******************************************************************************<p/>
 * Copyright (c) 1997 Sunit Katkar All Rights Reserved.
 * <p/>
 * 
 * Permission to use, copy, modify, and distribute this software for
 * NON-COMMERCIAL or COMMERCIAL purposes and without fee is hereby granted.
 * <p/>
 * 
 * Whew ! That was too much legalese..even to have copied and pasted from some
 * other place... PLEASE DO NOT BLAME ME in any way if your system crashes
 * because of this code, or if anything else bad happens. In short
 * "DO WHAT YOU WANT BUT DONT BLAME ME !"
 * <p/>
 *******************************************************************************<p/>
 * This code was modified by BugSlayer to change it from an applet into a
 * desktop application. Also, refactored the code a little bit to comply to
 * naming conventioned, infomration hiding and several other basic OO
 * principles.
 * <p/>
 ******************************************************************************/
public class OOPDraw2 extends JFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 4695753453561082104L;

	private AbstractShape s;

	private Point startpos, endpos; // Declare the start and end positions

	private Button btnLine, btnOval, btnRect, btnClear;

	//ArrayList for storing the shapes
	private ArrayList<AbstractShape> vt = new ArrayList<AbstractShape>();

	private int i = 0; // Vector index to keep count of elements(i.e.shapes)

	private int nheight1, nwidth1;
	
	private String currentShape;

	public static void main(String[] args) {
		OOPDraw2 frame = new OOPDraw2();
		frame.setVisible(true);
	}

	public OOPDraw2() {
		// Do nothing in constructor off applet
		initGUI();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Where the mouse went down is the start
		// position of the shape to be drawn
		int x = arg0.getX();
		int y = arg0.getY();
		startpos = new Point(x, y);
		if (currentShape == "line") {
			s = new MyLine(); // Create the shape - Line
		}
		if (currentShape == "oval") {
			s = new MyOval(); // Create the shape - Oval
		}
		if (currentShape == "rect") {
			s = new MyRect(); // Create the shape - Rectangle
		}	
		s.setStart(startpos);// Set the start position where mouse went down
		vt.add(s); // and add the shape (line) to the vector vt
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Fianlly the mouse is up indicating shape drawing is over.
		// So set these mouseUp coordinates to set the end position.
		// Then update the Vector count.
		int x = arg0.getX();
		int y = arg0.getY();
		endpos = new Point(x, y);
		if (currentShape == "line") {
			s = (AbstractShape) vt.get(i);
			s.setEnd(endpos);
			// increment the index of Vector as
			// cLine object is now added at current index i
		}
		else {
			// All this jugglery because we do not want to draw oval
			// outside the applet area. Also we should be able to draw
			// the oval even if our starting point is at bottom right
			// and end point is at top left of the applet. Note that
			// top-left to top right is the positive x axis and top left
			// to left bottom is the positive y axis.
			Point drawto = new Point(Math.max(x, startpos.x), Math.max(y, startpos.y));
			Point newstart = new Point(Math.min(x, startpos.x), Math.min(y, startpos.y));
			nwidth1 = Math.abs((drawto.x - newstart.x));
			nheight1 = Math.abs((drawto.y - newstart.y));
			s = (AbstractShape) vt.get(i);
			s.setWidth(nwidth1);
			s.setHeight(nheight1);
			s.setStart(newstart);
			// increment the index of Vector as
			// cOval object is now added at current index i
		}
		i++;
		repaint();
	}

	/*
	 * Mouse Drag i.e. Left mouse button is down and mouse is being moved
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// Now the mouse is being dragged without releasing,
		// which means that the user may stop his mouse over a
		// point but not release it. So that point is the
		// current endpoint
		int x = arg0.getX();
		int y = arg0.getY();
		endpos = new Point(x, y);
		if (currentShape == "line") {
			s = (MyLine) vt.get(i); // refer to that shape stored in vector
			s.setEnd(endpos); // and set its end point.
		}
		else {
			// Here we see where the shape drawing started (mouse went down) and
			// now where the mouse is (mouse drag). And we draw from this new
			// point to the point from which the mouse went down. This avoids
			// the Oval/Rectangle from going out of the screen, or some really
			// weird things from happening.
			// Try to take simple Line drawing type of approach and draw from
			// bottom
			// right to top left and see what happens :)
			Point drawto = new Point(Math.max(x, startpos.x), Math.max(y, startpos.y));
			Point newstart = new Point(Math.min(x, startpos.x), Math.min(y, startpos.y));
			nwidth1 = Math.abs((drawto.x - newstart.x));
			nheight1 = Math.abs((drawto.y - newstart.y));
			s = (AbstractShape) vt.get(i);
			s.setWidth(nwidth1);
			s.setHeight(nheight1);
			s.setStart(newstart);
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// Nothing TO DO in this method
	}

	/*
	 * Paint method overridden for custom rendering of the screen
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// To get a shadow effect
		g.setColor(Color.black);
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(new Color(255, 255, 154));
		g.fillRect(1, 1, getSize().width - 3, getSize().height - 3);
		for (int i = 0; i < vt.size(); i++) {
			// Add the shapes to the vector
			AbstractShape sh = (AbstractShape) vt.get(i);
			sh.Draw((Graphics2D) g);
		}
	}

	/*
	 * method initializes GUI components
	 */
	private void initGUI() {
		setSize(800, 600);
		setTitle("POSE 2.0 hairy drawing tool");
		setLayout(new FlowLayout());
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		// Create and Add the buttons
		btnLine = new Button("Line");
		btnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentShape = "line";
			}
		});
		btnOval = new Button("Oval");
		btnOval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentShape = "oval";
			}
		});
		btnRect = new Button("Rectangle");
		btnRect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentShape = "rect";
			}
		});
		btnClear = new Button("Clear");
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Clear the entire drawing screen
				// First remove all elements
				vt.clear();
				// then make vector index zero
				i = 0;
				// finally, call repaint()
				repaint();
			}
		});
		add(btnLine);
		add(btnOval);
		add(btnRect);
		add(btnClear);
	}

} // ALL ends :)
