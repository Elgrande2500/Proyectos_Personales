package proyecto_04.proyecto_04.bs;

import proyecto_04.proyecto_04.exception.DivZeroException;

public class Calculadora {
	public static final int OPERATOR_SUMA= 1;
	public static final int OPERATOR_RESTA= 2;
	public static final int OPERATOR_PRODUCTO= 3;
	public static final int OPERATOR_DIVISION= 4;
	public static final int OPERATOR_PORCENTAJE= 5;
	
	public static final int OPERATOR_CUADRADO=6;
	public static final int OPERATOR_CUBO=7;
	public static final int OPERATOR_ELEVACION=8;
	public static final int OPERATOR_E_CON_X=9;
	public static final int OPERATOR_10ELEVADO=10;
	public static final int OPERATOR_UNO_SOBRE=11;
	public static final int OPERATOR_RAIZ=12;
	public static final int OPERATOR_RAIZ_CUBICA=13;
	public static final int OPERATOR_RAIZX=14;
	public static final int OPERATOR_LOGANATURAL=15;
	public static final int OPERATOR_LOGARITMO=16;
	public static final int OPERATOR_FACTORIAL=17;
	public static final int OPERATOR_SIN=18;
	public static final int OPERATOR_COS=19;
	public static final int OPERATOR_TAN=20;
	public static final int OPERATOR_E=21;
	public static final int OPERATOR_PI=22;
	
	public Double calculate(int operador, Double valor1, Double valor2) throws DivZeroException{
		Double resultado;
		switch (operador) {
		case OPERATOR_SUMA:
			resultado= Suma(valor1, valor2);
		break;
		case OPERATOR_RESTA:
			resultado= resta(valor1, valor2);
			break;
		case OPERATOR_PRODUCTO:
			resultado=producto(valor1, valor2);
			break;
		case OPERATOR_DIVISION:
			System.out.println("-->" + valor1 + "" + valor2);
			resultado=division(valor1, valor2);
			break;
		case OPERATOR_PORCENTAJE:
			resultado= porcentaje(valor1, valor2);
			break;
		case OPERATOR_CUADRADO:
			resultado= cuadrado(valor1);
			break;
		case OPERATOR_CUBO:
			resultado= cubo (valor1);
			break;
		case OPERATOR_ELEVACION :
			resultado= elevacion(valor1, valor2);
			break;
		case OPERATOR_E_CON_X:
			resultado= econx(valor1);
			break;
		case OPERATOR_10ELEVADO:
			resultado= diezelevado(valor1);
			break;
		case OPERATOR_UNO_SOBRE:
			resultado= unosobre (valor1);
			break;
		case OPERATOR_RAIZ:
			resultado= raiz(valor1);
			break;
		case OPERATOR_RAIZ_CUBICA:
			resultado= raizcubica(valor1);
			break;
		case OPERATOR_RAIZX:
			resultado= raizx(valor1, valor2);
			break;
		case OPERATOR_LOGANATURAL:
			resultado= loganatural(valor1);
			break;
		case OPERATOR_LOGARITMO:
			resultado= logaritmo(valor1);
			break;
		case OPERATOR_FACTORIAL:
			resultado= factorial (valor1);
		case OPERATOR_SIN:
			resultado= sin(valor1);
			break;
		case OPERATOR_COS:
			resultado= cos(valor1);
			break;
		case OPERATOR_TAN:
			resultado= tan(valor1);
			break;
		case OPERATOR_E:
			resultado= e (valor1);
			break;
		case OPERATOR_PI:
			resultado= pi(valor1);
			break;
		 default:
			 resultado=-1.0;
			break;

			
		}
		return resultado;
	}
	
	public Double Suma(Double sumando1, Double sumando2) {
		return sumando1+sumando2;
	}
	
	public Double resta (Double minuendo, Double sustraendodo) {
		return minuendo-sustraendodo;
	}
	
	public Double producto (Double factor1, Double factor2) {
		return factor1*factor2;
	}
	
	public Double division (Double dividendo, Double divisor) throws DivZeroException{
		if(divisor==0) {
			throw new DivZeroException();
			
			
		}
		return dividendo/divisor;
	}
	
	public Double porcentaje (Double cantidad, double porcentaje) {
		return (cantidad*porcentaje)/100;
	}
	public Double cuadrado (Double numero) {
		return numero*numero;
	}
	public Double cubo(Double numero) {
		return numero*numero*numero;
	}
	public Double elevacion (Double n, double base) {
		return Math.pow(base, n);
	}
	public Double econx (Double x) {
		return 2.718281828*x;
	}
	public Double diezelevado (Double uno) {
		return Math.pow(10, uno);
	}
	
	public Double unosobre(Double numero) {
		return 1/numero;
	}
	public Double raiz (Double numero) {
		return Math.sqrt(numero);
	}
	public Double raizcubica (Double numero){
		return Math.cbrt(numero);
	}
	public Double raizx (Double numero, double numero2){
		return numero;
	}
	public Double loganatural (Double logaritmo) {
		return Math.log(logaritmo);
	}
	public Double logaritmo (Double logaritmo) {
		return Math.log10(logaritmo);
	}
	public Double factorial(Double factor) {
		double numero = 0;
		for (double i = numero;i>0;i++) {
			factor=factor*i;
		}
		return factor;
	}
	public Double sin (Double seno) {
		return Math.sin(seno);
	}
	public Double cos (Double coseno) {
		return Math.cos(coseno);
	}
	public Double tan (Double tangente) {
		return Math.tan(tangente);
	}
	public Double e (Double e) {
		return Math.E;
	}
	public Double pi (Double pi) {
		return Math.PI;
	}
}

	
	
	
	

