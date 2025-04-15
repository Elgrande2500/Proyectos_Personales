package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class Linea extends Figura{
	private static final int DEFAULT_WIDTH=1;
	private static final Color DEFAULT_BORDER_COLOR= Color.black;
	private static final Color DEFAULT_FILL_COLOR= Color.black;
	
	
	protected Linea(int x, int y) {
		
		super(x, y);
		this.fillColor= DEFAULT_FILL_COLOR;
		this.borderColor=DEFAULT_BORDER_COLOR;
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(borderColor);
		g2d.drawLine(this.x, this.y, this.x+100, this.y+(100/110));
		
	}
	
	public static Linea getDefaults (int x, int y) {
		
		return new Linea(x, y);
	}
	

}
