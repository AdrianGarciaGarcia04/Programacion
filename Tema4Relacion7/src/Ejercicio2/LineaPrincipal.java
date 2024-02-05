package Ejercicio2;

import java.util.Scanner;

import Utilidades.MiEntradaSalida;

public class LineaPrincipal {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		double ejeXPunto1, ejeXPunto2, ejeYPunto1, ejeYPunto2;
		boolean hayError = true;
		System.out.println("Selecciona el eje X del primer punto");
		ejeXPunto1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Selecciona el eje Y del primer punto");
		ejeYPunto1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Selecciona el eje X del segundo punto punto");
		ejeXPunto2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Selecciona el eje Y del segundo punto");
		ejeYPunto2 = Double.parseDouble(teclado.nextLine());
		Punto punto1 = new Punto(ejeXPunto1, ejeYPunto1);
		Punto punto2 = new Punto(ejeXPunto2, ejeYPunto2);
		Linea linea = new Linea(punto1, punto2);
		menu();
		do {
			try {
				gestionarMenu(linea);
				hayError = false;
			}catch(LineaException e) {
				System.err.println(e.getMessage());
			}
		} while (hayError);
		
		
	}
	public static void menu() {
		System.out.println("1. Mover línea: Solicitará el movimiento (A-arriba, B-ABajo, I-Izquierda, D-Derecha) y realice el movimiento");
		System.out.println("2. Mostrar Linea");
		System.out.println("3. Salir");
	}
	public static void gestionarMenu(Linea linea) throws LineaException {
		int seleccion;
		char seleccionMovimiento;
		double movimiento;
		do {
			seleccion = MiEntradaSalida.solicitarEntero("Selecciona una opción");
			switch(seleccion) {
				case 1:
					seleccionMovimiento = MiEntradaSalida.solicitarCaracter("Selecciona un movimiento (A-arriba, B-ABajo, I-Izquierda, D-Derecha)");
					System.out.println("¿Cuánto quieres mover la linea?");
					movimiento = Double.parseDouble(teclado.nextLine());
					switch(seleccionMovimiento) {
						case 'A':
							linea.moverArriba(movimiento);
							break;
						case 'B':
							linea.moverAbajo(movimiento);
							break;
						case 'I':
							linea.moverIzquierda(movimiento);
							break;
						case 'D':
							linea.moverDerecha(movimiento);
							break;
						default:
							System.out.println("No has seleccionado una opción válida");
					}
					break;
				case 2:
					System.out.println(linea.toString());
					break;
				case 3:
					System.out.println("Has salido correctamente");
					break;
				default:
					System.out.println("No has seleccionado una opción válida");
					break;
			}
		} while (seleccion!=3);
	}
}