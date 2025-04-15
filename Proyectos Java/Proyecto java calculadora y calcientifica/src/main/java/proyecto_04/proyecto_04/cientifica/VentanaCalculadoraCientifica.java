package proyecto_04.proyecto_04.cientifica;


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

public class VentanaCalculadoraCientifica extends JFrame{
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
	private static final String CUBO="³";
	private static final String CUADRADO="²";
	private static final String	ELEVACION="^";
	private static final String E_CON_X="e^x";
	private static final String DIEZ_ELEVADO="10x";
	private static final String UNO_SOBRE="1/x";
	private static final String RAIZ="√";
	private static final String RAIZ_CUBICA="³√";
	private static final String RAIZ_X="X√";
	private static final String LOGARITMO_NATURAL="ln";
	private static final String LOGARITMO_BASE_10="log10";
	private static final String FACTOR="X!";
	private static final String SENO="sin";
	private static final String COS="cos";
	private static final String TANG="tan";
	private static final String E="e";
	private static final String PI="π";
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
	
	private JButton botoncuadrado;
	private JButton	botoncubo;
	private JButton botonelevar;
	private JButton botonex;
	private JButton boton10x;
	private JButton boton1x;
	private JButton botonraiz;
	private JButton botonraizcubica;
	private JButton botonxraiz;
	private JButton botonloganatu;
	private JButton botonlogabase10;
	private JButton botonfactor;
	private JButton botonsin;
	private JButton botoncos;
	private JButton botontan;
	private JButton botone;
	private JButton botonpi;
	
	public VentanaCalculadoraCientifica() {
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
		calculadoraGridContraints.gridwidth=7;
		pane.add(display, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=1;
		pane.add(botonraiz, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=1;
		pane.add(botonraizcubica, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=1;
		pane.add(botonxraiz, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=1;
		pane.add(botoncuadrado, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=4;
		calculadoraGridContraints.gridy=1;
		pane.add(botoncubo, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=5;
		calculadoraGridContraints.gridy=1;
		pane.add(botonelevar, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=6;
		calculadoraGridContraints.gridy=1;
		pane.add(boton1x, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=2;
		pane.add(botonsin, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=2;
		pane.add(botoncos, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=2;
		pane.add(botontan, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=2;
		pane.add(botone, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=4;
		calculadoraGridContraints.gridy=2;
		pane.add(botonex, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=5;
		calculadoraGridContraints.gridy=2;
		pane.add(botonfactor, calculadoraGridContraints);
			
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=5;
		calculadoraGridContraints.gridy=2;
		pane.add(botonlogabase10, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=6;
		calculadoraGridContraints.gridy=2;
		pane.add(botonloganatu, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=3;
		pane.add(boton7, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=3;
		pane.add(boton8, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=3;
		pane.add(boton9, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=3;
		pane.add(botonLimpiar, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=4;
		calculadoraGridContraints.gridy=3;
		pane.add(botonPorcentaje, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=4;
		pane.add(botonDivision, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=4;
		calculadoraGridContraints.gridy=4;
		pane.add(botonProducto, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=4;
		pane.add(boton4, calculadoraGridContraints);
		
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=4;
		pane.add(boton5, calculadoraGridContraints);
		
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=4;
		pane.add(boton6, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=0;
		calculadoraGridContraints.gridy=5;
		pane.add(boton1, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=1;
		calculadoraGridContraints.gridy=5;
		pane.add(boton2, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=2;
		calculadoraGridContraints.gridy=5;
		pane.add(boton3, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=3;
		calculadoraGridContraints.gridy=5;
		pane.add(botonSuma, calculadoraGridContraints);
		
		calculadoraGridContraints.gridwidth=1;
		calculadoraGridContraints.gridx=4;
		calculadoraGridContraints.gridy=5;
		pane.add(botonResta, calculadoraGridContraints);
		
		calculadoraGridContraints.ipady=170;
		calculadoraGridContraints.gridheight=3;
		calculadoraGridContraints.gridwidth=3;
		calculadoraGridContraints.gridx=5;
		calculadoraGridContraints.ipadx=175;
		calculadoraGridContraints.gridy=3;
		pane.add(botonIgual, calculadoraGridContraints);

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
		botoncuadrado = new JButton("²");
		botoncubo = new JButton("³");
		botonelevar = new JButton("^");
		botonex = new JButton("e^x");
		boton10x = new JButton("10x");
		boton1x = new JButton("1/x");
		botonraiz = new JButton("√");
		botonraizcubica = new JButton("³√");
		botonxraiz = new JButton("X√");
		botonloganatu = new JButton("ln");
		botonlogabase10 = new JButton("log10");
		botonfactor = new JButton("X!");
		botonsin = new JButton("sin");
		botoncos = new JButton("cos");
		botontan = new JButton("tan");
		botone = new JButton("e");
		botonpi = new JButton("π");
	
	
	
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
		botoncuadrado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_CUADRADO);
			}
		});
		botoncubo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_CUBO);
			}
		});
		botonelevar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_ELEVACION);
			}
		});
		botonex.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_E_CON_X);
			}
		});
		boton10x.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_10ELEVADO);
			}
		});
		boton1x.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_UNO_SOBRE);
			}
		});
		botonraiz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RAIZ);
			}
		});
		botonraizcubica.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RAIZ_CUBICA);
			}
		});
		botonxraiz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RAIZX);
			}
		});
		botonloganatu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_LOGANATURAL);
			}
		});
		botonlogabase10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_LOGARITMO);
			}
		});
		botonfactor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_FACTORIAL);
			}
		});
		botonsin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_SIN);
			}
		});
		botoncos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_COS);
			}
		});
		botontan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_TAN);
			}
		});
		botone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_E);
			}
		});
		botonpi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PI);
			}
		});
		botonIgual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actualizarEstado(ACTION_EQUAL);
			 actualizarDisplay("");
			}
		});
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
		
		private void actualizarEstado(int action){
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
