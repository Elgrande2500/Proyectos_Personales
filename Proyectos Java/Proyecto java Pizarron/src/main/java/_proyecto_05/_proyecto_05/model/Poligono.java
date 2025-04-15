package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Poligono extends Figura{
	private static final Color DEFAULT_BORDER_COLOR= Color.black;
	private static final Color DEFAULT_FILL_COLOR= Color.black;
	private static final int SIDE=100;
	int[]x= {100,150,170,190,110};
	int[]y= {120,280, 280,250,150};
	
	protected Poligono(int x, int y) {
		super(x, y);
		this.borderColor=DEFAULT_BORDER_COLOR;
		this.fillColor=DEFAULT_FILL_COLOR;
	
		
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawPolyline(this.x, this.y, 5);		
		g2d.setColor(this.fillColor);
		}
	
	
	public static Poligono getDefaults (int x, int y, int a) {
		return new Poligono(x, y);
	}
	
	

}
