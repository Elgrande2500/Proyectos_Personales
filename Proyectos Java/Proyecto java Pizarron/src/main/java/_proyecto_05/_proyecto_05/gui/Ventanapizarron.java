package _proyecto_05._proyecto_05.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import _proyecto_05._proyecto_05.exception.DrawingException;
import _proyecto_05._proyecto_05.model.Circulo;
import _proyecto_05._proyecto_05.model.Cuadrado;
import _proyecto_05._proyecto_05.model.Figura;
import _proyecto_05._proyecto_05.model.Imagen;
import _proyecto_05._proyecto_05.model.Lapiz;
import _proyecto_05._proyecto_05.model.Linea;
import _proyecto_05._proyecto_05.model.Poligono;
import _proyecto_05._proyecto_05.model.Rectangulo;
import _proyecto_05._proyecto_05.model.Texto;
import _proyecto_05._proyecto_05.model.Triangulo;



public class Ventanapizarron extends JFrame{
	private static final int TOOL_UNSELECT=-1;
	private static final int TOOL_CIRCLE=1;
	private static final int TOOL_TRIANGLE=2;
	private static final int TOOL_SQUARE=3;
	private static final int TOOL_RECTANGLE=4;
	private static final int TOOL_POLYGON=5;
	private static final int TOOL_TXT=6;
	private static final int TOOL_FIG=7;
	private static final int TOOL_IMG=8;
	private static final int TOOL_PENCIL=9;
	private static final int TOOL_LINE=10;
	private static final int TOOL_SELECT=11;
	
	private static final int SETTING_CHANGE_COLOR_FOND=1;
	private static final int SETTING_CHANGE_COLOR_BORD=2;
	private static final int SETTING_CHANGE_WIDTH=3;
	private static final int SETTING_CHANGE_SIZE=4;
	
	private static final int DRAWING_ACTIVE=1;
	private static final int DRAWING_INACTIVE=2;
	
	private JPanel toolPanel;
	private JPanel dashboardPanel;
	private JPanel logPanel;
	private JPanel settingsPanel;
	
	private JButton btnCircle;
	private JButton btnTriangle;
	private JButton btnSquare;
	private JButton btnRectangle;
	private JButton btnPolygon;
	private JButton btnTxt;
	private JButton btnFig;
	private JButton btnImg;
	private JButton btnPencil;
	private JButton btnLine;
	private JButton btnSelect;
	private JButton btnChangecolorfond;
	private JButton btnChangecolorbord;
	private JButton btnChangewidth;
	private JButton btnChangesize;
	
	
	private int selectedTool;
	private int drawingState;
	private Figura pencilTemp;
	
	
	public Ventanapizarron() {
		initComponents();
		selectedTool=TOOL_UNSELECT;
		drawingState=DRAWING_INACTIVE;
	}
	
	
	
	public void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		instantiateComponents();
		buildgridlayout();
		initializerListener();
		
		
		setVisible(true);	
		}



	private void initializerListener() {
		btnCircle.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_CIRCLE;
			}
		});
		
		btnTriangle.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_TRIANGLE;
			}
		});
		btnSquare.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_SQUARE;
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_RECTANGLE;
			}
		});
		btnPolygon.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_POLYGON;
			}
		});
		btnTxt.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_TXT;
			}
		});
		btnFig.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_FIG;
			}
		});
		btnImg.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_IMG;
			}
		});
		btnPencil.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_PENCIL;
			}
		});
		btnLine.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_LINE;
			}
		});
		btnSelect.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=TOOL_SELECT;
			}
		});
		btnChangecolorfond.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=SETTING_CHANGE_COLOR_FOND;
			}
		});
		btnChangecolorbord.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=SETTING_CHANGE_COLOR_BORD;
			}
		});
		btnChangewidth.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=SETTING_CHANGE_COLOR_FOND;
			}
		});
	
		btnChangesize.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				selectedTool=SETTING_CHANGE_SIZE;
			}
		});
		dashboardPanel.addMouseListener(new MouseListener() {

			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (drawingState==DRAWING_ACTIVE && selectedTool==TOOL_PENCIL) {
					pencilTemp=null;
				}
				
			}
			

			@Override
			public void mousePressed(MouseEvent e) {
				String mensaje;
				if (drawingState==DRAWING_ACTIVE && selectedTool==TOOL_PENCIL) 
					
				try{
					pencilTemp= getFigureDraw(e.getX(), e.getY());
					pencilTemp.paint(dashboardPanel.getGraphics());
					 mensaje = "Se dibujo una figura";
				}catch(DrawingException e1) {
					mensaje="Exception";
					
				}finally {
					
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				drawingState=DRAWING_ACTIVE;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				drawingState=DRAWING_INACTIVE;
			}
			@Override
			public void mouseClicked(MouseEvent e) {;
				String mensaje;
				if (drawingState==DRAWING_ACTIVE) 
					
				try{
					Figura figura= getFigureDraw(e.getX(), e.getY());
					figura.paint(dashboardPanel.getGraphics());
					 mensaje = "Se dibujo una figura";
				}catch(DrawingException e1) {
					mensaje="Exception";
					
				}finally {
					
				}
			}

			
				
		});
		dashboardPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				
				
			}
					
			@Override
			public void mouseDragged(MouseEvent e) {
				if (drawingState==DRAWING_ACTIVE && selectedTool==TOOL_PENCIL) {
					Lapiz pencil = (Lapiz)pencilTemp;
					pencil.addPoint(e.getX(), e.getY());
					pencil.paint(dashboardPanel.getGraphics());
				}
				
			}


			
			
			
		});
		
	}


	
	private Figura getFigureDraw (int x, int y)throws DrawingException{
		Figura figura = null;
		if(selectedTool==TOOL_UNSELECT) {
			throw new DrawingException();
			
		}else if(selectedTool==TOOL_CIRCLE) {
			figura= Circulo.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_IMG) {
			figura= Imagen.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_LINE) {
			figura=Linea.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_SQUARE) {
			figura= Cuadrado.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_TRIANGLE) {
			figura=Triangulo.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_POLYGON) {
		
			figura=Poligono.getDefaults(x, y, x);
			
		}else if(selectedTool==TOOL_PENCIL) {
			figura=Lapiz.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_TXT) {
			figura=Texto.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_RECTANGLE) {
			figura= Rectangulo.getDefaults(x, y);
			
		}else if(selectedTool==TOOL_SELECT) {
			throw new DrawingException();
		}
		
		
		
		return figura;
		
		
		
		
	}
	
	
	

	private void buildgridlayout() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		toolPanel.setLayout(new GridLayout(5,2));
		toolPanel.add(btnCircle);
		toolPanel.add(btnTriangle);
		toolPanel.add(btnSquare);
		toolPanel.add(btnRectangle);
		toolPanel.add(btnPolygon);
		toolPanel.add(btnTxt);
		toolPanel.add(btnFig);
		toolPanel.add(btnImg);
		toolPanel.add(btnPencil);
		toolPanel.add(btnLine);
		toolPanel.add(btnSelect);

		
		
		pane.add(toolPanel,BorderLayout.WEST);

		
		
		pane.add(dashboardPanel,BorderLayout.CENTER);
		
		pane.add(logPanel,BorderLayout.SOUTH);
		
		pane.add(settingsPanel,BorderLayout.EAST);
		settingsPanel.setLayout(new GridLayout(2,1));
		settingsPanel.add(btnChangecolorfond);
		settingsPanel.add(btnChangecolorbord);
		settingsPanel.add(btnChangewidth);
		settingsPanel.add(btnChangesize);
	}



	private void instantiateComponents() {
		toolPanel=new JPanel();
		dashboardPanel=new JPanel();
		dashboardPanel.setBackground(Color.WHITE);
		logPanel=new JPanel();
		settingsPanel=new JPanel();
		
		btnCircle=new JButton("CI");
		btnTriangle=new JButton("TR");
		btnSquare=new JButton("CU");
		btnRectangle=new JButton("RC");
		btnPolygon=new JButton("PO");
		btnTxt=new JButton("TX");
		btnFig=new JButton("FIG");
		btnImg=new JButton("IM");
		btnPencil=new JButton("PE");
		btnLine=new JButton("LN");
		btnSelect=new JButton("SL");
		btnChangecolorfond=new JButton("CF");
		btnChangecolorbord=new JButton("CC");
		btnChangewidth=new JButton("CW");
		btnChangesize=new JButton("CS");
		
	}
	
	
	
}
