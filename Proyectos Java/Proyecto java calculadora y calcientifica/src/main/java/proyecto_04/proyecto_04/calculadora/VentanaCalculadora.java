package proyecto_04.proyecto_04.calculadora;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import proyecto_04.proyecto_04.bs.Calculadora;
import proyecto_04.proyecto_04.exception.DivZeroException;

public class VentanaCalculadora extends JFrame{
	
	private static final Integer CERO=0;
	private static final Integer UNO=1;
	private static final Integer DOS=2;
	private static final Integer TRES=3;
	private static final Integer CUATRO=4;
	private static final Integer CINCO=5;
	private static final Integer SEIS=6;
	private static final Integer SIETE=7;
	private static final Integer OCHO=8;
	private static final Integer NUEVE=9;
	private static final String PUNTO=".";
	private static final String EMPTY_STRING="";
	
	private static final int STATE_INIT=0;
	private static final int STATE_CAPTURE=1;
	private static final int STATE_OPERATOR=2;
	private static final int STATE_CALCULATE=3;
	
	private static final int ACTION_NUMBER=0;
	private static final int ACTION_OPERATOR=1;
	private static final int ACTION_EQUAL=2;
	private static final int ACTION_CLEAN=3;
	
	private int state;
	private int operador;
	private Double valor1;
	private Double valor2;
	private Double resultado;
	private Calculadora calculadora;
	
	

	private JTextField display;
	private JButton boton0;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton botonPunto;
	private JButton botonLimpiar;
	private JButton botonPorcentaje;
	private JButton botonDivision;
	private JButton botonProducto;
	private JButton botonSuma;
	private JButton botonResta;
	private JButton botonIgual;
	
	public VentanaCalculadora() {
		state = STATE_INIT;
		calculadora =new Calculadora();
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 430);
		setResizable(false);
		
		instantiateComponents();
		buildGrid();
		initializeListener();
		
		setVisible(true);
	}
	

	
	private void initializeListener() {
		boton0.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				capturarNumero(CERO.toString());
				
			}
		});
		boton1.addActionListener(new ActionListener(){
	
			public void actionPerformed(ActionEvent e) {
				capturarNumero(UNO.toString());
			}
		});
		boton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(DOS.toString());
			}
		});
		boton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(TRES.toString());
			}
		});
		boton4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				capturarNumero(CUATRO.toString());
			}
		});
		boton5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CINCO.toString());
			}
		});
		boton6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SEIS.toString());
			}
		});
		boton7.addActionListener(new ActionListener(){
	
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SIETE.toString());
			}
		});
		boton8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(OCHO.toString());
			}
		});
		boton9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(NUEVE.toString());
			}
		});
		botonPunto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarNumero(PUNTO);
			}
		});
		botonLimpiar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
			}
		});
		botonSuma.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_SUMA);
			}
		});
		botonResta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RESTA);
			}
		});
		botonProducto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PRODUCTO);
			}
		});
		botonDivision.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_DIVISION);
			}
		});
		botonPorcentaje.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PORCENTAJE);
			}
		});

		botonIgual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actualizarEstado(ACTION_EQUAL);
			 actualizarDisplay("");
			}
		});
	}

	private void buildGrid() {
		Container pane = getContentPane();
		GridBagLayout calculadoraGrid =new GridBagLayout();
		GridBagConstraints calculadoraGridContraints= new GridBagConstraints();
		pane.setLayout(calculadoraGrid);
		
		calculadoraGridContraints.fill=GridBagConstraints.HORIZONTAL;
		calculadoraGridContraints.weightx=0.5;
		calculadoraGridContraints.ipady=40;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=0;
		calculadoraGridContraints.gridwidth=4;
		pane.add(display, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=1;
		pane.add(botonLimpiar, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=1;
		pane.add(botonPorcentaje, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=1;
		pane.add(botonDivision, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=1;
		pane.add(botonProducto, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=2;
		pane.add(boton7, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=2;
		pane.add(boton8, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=2;
		pane.add(boton9, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=2;
		pane.add(botonSuma, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=3;
		pane.add(boton4, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=3;
		pane.add(boton5, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=3;
		pane.add(boton6, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=3;
		pane.add(botonResta, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=4;
		pane.add(boton1, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=4;
		pane.add(boton2, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=4;
		pane.add(boton3, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=4;
		calculadoraGridContraints.gridheight=2;
		calculadoraGridContraints.ipady=109;
		pane.add(botonIgual, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=5;
		calculadoraGridContraints.gridwidth=2;
		calculadoraGridContraints.gridheight=1;
		calculadoraGridContraints.ipady=40;
		pane.add(boton0, calculadoraGridContraints);
		
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=5;
		calculadoraGridContraints.gridwidth=1;
		pane.add(botonPunto, calculadoraGridContraints);
		
	}

	private void instantiateComponents() {
		display = new JTextField("");
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		boton0 = new JButton("0");
		boton1 = new JButton("1");
		boton2= new JButton("2");
		boton3= new JButton("3");
		boton4= new JButton("4");
		boton5 = new JButton("5");
		boton6 = new JButton("6");
		boton7 = new JButton("7");
		boton8 = new JButton("8");
		boton9 = new JButton("9");
		botonPunto = new JButton(".");
		botonLimpiar = new JButton("AC");
		botonPorcentaje = new JButton("%");
		botonDivision = new JButton("/");
		botonProducto = new JButton("x");
		botonSuma = new JButton("+");
		botonResta = new JButton("-");
		botonIgual = new JButton("=");
		
	}
	
	public void actualizarDisplay(String valor) {
		System.out.println("-->ESTADO:"+ state);
		if(state == STATE_INIT) {			
			display.setText(valor);	
			}else if(state == STATE_CAPTURE) {
		String valorActual = display.getText();
		display.setText(valorActual+valor);
		}else if (state == STATE_OPERATOR) {
			
			String valorString = display.getText();
			display.setText(valor);
			valor1 =Double.parseDouble(valorString);
		}else if(state== STATE_CALCULATE) {
			String resultadoString = null;
			String valorString = display.getText();
			valor2=Double.parseDouble(valorString);
			try {
			resultado= calculadora.calculate(operador, valor1, valor2);
			resultadoString=resultado.toString();
			} catch (DivZeroException e) {
				resultadoString="SYNTAX ERROR";
				actualizarEstado(ACTION_CLEAN);
				JOptionPane.showMessageDialog(this, "SYNTAX ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
			} finally {
				display.setText(resultadoString);
			}
			display.setText(resultado.toString());
		}
	}
	
	private void capturarNumero(String numero) {
		actualizarDisplay(numero);
		actualizarEstado(ACTION_NUMBER);
	}
	
	private void capturarOperador(int operador) {
		setOperador(operador);
		actualizarEstado(ACTION_OPERATOR);
	}
	
	
	public void limpiarDisplay() {
		display.setText(EMPTY_STRING);
		actualizarEstado(ACTION_CLEAN);
	}
	
	private void actualizarEstado(int action) {
		if(action==ACTION_CLEAN) {
			state= STATE_INIT;
		}else if(state==STATE_INIT && action ==ACTION_NUMBER|| state == STATE_OPERATOR && action == ACTION_NUMBER 
				|| state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state=STATE_CAPTURE;
			} else if (state == STATE_CAPTURE && action == ACTION_OPERATOR || state == STATE_CALCULATE && action == ACTION_OPERATOR) {
				state = STATE_OPERATOR;
			} else if (state == STATE_CAPTURE && action == ACTION_EQUAL){
				state= STATE_CALCULATE;
			} 
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getOperador() {
		return operador;
	}

	public void setOperador(int operador) {
		this.operador = operador;
	}

	public Double getValor1() {
		return valor1;
	}

	public void setValor1(Double valor1) {
		this.valor1 = valor1;
	}

	public Double getValor2() {
		return valor2;
	}

	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}


}
