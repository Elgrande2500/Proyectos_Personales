package _proyecto_05._proyecto_05.model;

import java.awt.Color;
import java.awt.Graphics;




public abstract class Figura {
	protected int x;
	protected int y;
	protected int stroke;
	protected Color borderColor;
	protected Color fillColor;
	
	protected Figura(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getStroke() {
		return stroke;
	}
	public void setStroke(int stroke) {
		this.stroke = stroke;
	}
	public Color getBorder() {
		return borderColor;
	}
	public void setBorder(Color border) {
		this.borderColor = border;
	}
	public Color getFill() {
		return fillColor;
	}
	public void setFill(Color fill) {
		this.fillColor = fill;
	}
	
	public void paint(Graphics g) {
		
	}

	
	
	
	
	
	
	
	
	
}
