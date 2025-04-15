package _proyecto_05._proyecto_05.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagen extends Figura {
	private static final int DEFAULT_WIDTH=150;
	private static final int DEFAULT_HEIGHT=100;
	private int width;
	private int heigth;

	
	protected Imagen(int x, int y) {
		super(x, y);
		this.width=DEFAULT_WIDTH;
		this.heigth=DEFAULT_HEIGHT;
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d= (Graphics2D) g;
		File file =new File("/Users/alumno/Desktop/Tareas/dados.png");
		Image image;
		try {
			image = ImageIO.read(file);
			g2d.drawImage(image,width,heigth,this.x, this.y,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	public static Imagen getDefaults (int x, int y) {
		
		return new Imagen(x, y);
	}
	
	
}
