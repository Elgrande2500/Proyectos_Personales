package proyecto_04.proyecto_04.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import proyecto_04.proyecto_04.calculadora.VentanaCalculadora;
import proyecto_04.proyecto_04.cientifica.VentanaCalculadoraCientifica;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ventanaopcion extends JFrame{
	
	private JButton ventanacalcunormal;
	private JButton ventanacalcucientifica;

	
	private VentanaCalculadora VentanaCalculadora;
	private VentanaCalculadoraCientifica VentanaCalculadoraCientifica;
	
	
	public ventanaopcion () {
		initComponents();

	}
	
	
	private  void initComponents () {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(370, 100);
		setResizable(false);
		
		instantiateComponents();
		buildGrid();
		initializeListener();
		
		setVisible(true);
	}
	
	private void instantiateComponents() {
		
		ventanacalcunormal= new JButton ("Calculadora Normal");
		ventanacalcucientifica= new JButton ("Calculadora Cientifica");
	}
	
	private void buildGrid() {
		Container pane = getContentPane();
		GridBagLayout opcion =new GridBagLayout();
		GridBagConstraints opciones= new GridBagConstraints();
		pane.setLayout(opcion);
		
		
		
		opciones.gridwidth=1;
		opciones.weightx=0.5;
		opciones.ipady=40;
		opciones.gridx=0;
		opciones.gridy=1;
		pane.add(ventanacalcunormal, opciones);
		
		opciones.gridwidth=1;
		opciones.gridx=1;
		opciones.gridy=1;
		pane.add(ventanacalcucientifica, opciones);
		
	}
	
	private void initializeListener() {
		ventanacalcunormal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Accion(VentanaCalculadora.class);
				
			}

private void Accion(Class<proyecto_04.proyecto_04.calculadora.VentanaCalculadora> class1) {
	 VentanaCalculadora = new VentanaCalculadora();
				
			}
			
		});
		ventanacalcucientifica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Accion2(VentanaCalculadoraCientifica.class);
		
	}
private void Accion2(Class<VentanaCalculadoraCientifica> class1) {
	VentanaCalculadoraCientifica =new VentanaCalculadoraCientifica();
				
			}

		
		
		});
	}
	
	
}
