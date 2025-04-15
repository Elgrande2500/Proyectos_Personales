package _proyecto_05._proyecto_05.model;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class Texto extends Figura{
	private static final Color TEXT_COLOR= Color.RED;
	private static String DEFAULT_TEXT ="Hola profe pongame 10 :)";
	private String text;
	
	
	
	protected Texto(int x, int y) {
		super(x, y);
		fillColor=TEXT_COLOR;
		text=DEFAULT_TEXT;
	}
		
		
		
		
		public void paint(Graphics g) {
			Graphics2D g2d= (Graphics2D) g;
			g2d.setColor(fillColor);
			g2d.drawString(text, this.x, this.y);
			
		}

		public static Texto getDefaults (int x, int y) {
			return new Texto(x, y);
		}
		



		public String getText() {
			return text;
		}




		public void setText(String text) {
			this.text = text;
		}
		
		
		
	}


