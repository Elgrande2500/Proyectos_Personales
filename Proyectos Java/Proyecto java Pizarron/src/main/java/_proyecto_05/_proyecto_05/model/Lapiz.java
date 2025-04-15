package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Lapiz extends Figura{
	private static final int DEFAULT_WIDTH=1;
	private static final Color DEFAULT_BORDER_COLOR= Color.black;
	private static final Color DEFAULT_FILL_COLOR= Color.black;
	private List <Point> points;
	
	
	
	
	

	protected Lapiz(int x, int y) {
		super(x, y);
		this.fillColor= DEFAULT_FILL_COLOR;
		this.borderColor=DEFAULT_BORDER_COLOR;
		points=new ArrayList<Point>();
		points.add(new Point(x,y));
		this.stroke=DEFAULT_WIDTH;
	}

	public void paint(Graphics g) {
		if (points.size()>2);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(borderColor);
		Point a= points.get(0);
		for (int i=1;i<=points.size()-1;i++) {
			Point b=points.get(i);
			g2d.drawLine((int)a.getX(),(int)a.getY() , (int) b.getX(),(int) b.getY());
			a=b;
		}
	
	}
	
	public void addPoint(int x, int y) {
		points.add(new Point (x,y));
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public static Lapiz getDefaults (int x, int y) {
		
		return new Lapiz(x, y);
	}
}
