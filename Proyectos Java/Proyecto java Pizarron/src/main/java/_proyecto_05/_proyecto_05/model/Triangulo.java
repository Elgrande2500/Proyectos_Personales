package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangulo extends Figura{
	private static final int DEFAULT_WIDTH=100;
	private static final int DEFAULT_HEIGHT=100;
	private static final Color DEFAULT_BORDER_COLOR= Color.black;
	private static final Color DEFAULT_FILL_COLOR= Color.black;
	
	private int width;
	private int heigth;
	
	
	protected Triangulo(int x, int y) {
		super(x, y);	
		this.fillColor= DEFAULT_FILL_COLOR;
		this.borderColor=DEFAULT_BORDER_COLOR;
		this.heigth=DEFAULT_HEIGHT;
		this.width=DEFAULT_WIDTH;
	}
	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		if (width!=0&&heigth!=0) {
		g2d.drawLine(this.x, this.y, this.x+(width/2), this.y+heigth);
		g2d.setColor(this.borderColor);
		g2d.drawLine(this.x+(width/2), this.y+heigth,this.x-(width/2), this.y+heigth);
		g2d.setColor(this.fillColor);
		g2d.drawLine(this.x, this.y, this.x-(width/2), this.y+heigth);
		}
	}
public static Triangulo getDefaults (int x, int y) {
		
		return new Triangulo(x, y);
}
	
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	
	
	
}
