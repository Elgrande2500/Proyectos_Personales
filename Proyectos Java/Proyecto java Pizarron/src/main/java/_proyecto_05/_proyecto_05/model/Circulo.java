package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circulo extends Figura{
	private static final int DEFAULT_RADIUS=60;
	private static final Color DEFAULT_BORDER_COLOR= new Color (0,0,0);
	private static final Color DEFAULT_FILL_COLOR= Color.GREEN;
	
	
	
private int radius;



	protected Circulo(int x, int y) {
		super(x, y);
		this.fillColor= DEFAULT_FILL_COLOR;
		this.borderColor=DEFAULT_BORDER_COLOR;
		this.radius=DEFAULT_RADIUS;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawOval(this.x, this.y, this.radius, this.radius);
		g2d.setColor(this.fillColor);
		g2d.fillOval(this.x+1, this.y+1, this.radius-2, this.radius-2);
	}
	
	
	
public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

public static Circulo getDefaults (int x, int y) {
	return new Circulo(x,y);
}
	

}
