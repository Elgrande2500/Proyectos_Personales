package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangulo extends Figura{
	private static final int DEFAULT_WIDTH=150;
	private static final int DEFAULT_HEIGHT=100;
	private static final Color DEFAULT_BORDER_COLOR= new Color (0,0,0);
	private static final Color DEFAULT_FILL_COLOR= Color.blue;
	
	private int width;
	private int heigth;
	
	protected Rectangulo(int x, int y) {
		super(x, y);
		this.fillColor= DEFAULT_FILL_COLOR;
		this.borderColor=DEFAULT_BORDER_COLOR;
		this.heigth=DEFAULT_HEIGHT;
		this.width=DEFAULT_WIDTH;
	}

	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawRect(this.x, this.y, this.width, this.heigth);
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x+1, this.y+1, this.width-1, this.heigth-1);
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

	public static Rectangulo getDefaults (int x, int y) {
		
		return new Rectangulo(x, y);
	}
	
}
