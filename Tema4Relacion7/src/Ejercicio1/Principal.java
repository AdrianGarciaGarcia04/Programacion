package Ejercicio1;

import java.util.Scanner;

import Utilidades.MiEntradaSalida;

public class Principal {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int rangoInferior;
		int rangoSuperior;
		MiEntradaSalida.solicitarEntero("Introduce un número entero");
		MiEntradaSalida.solicitarEnteroPositivo("Introduce un número positivo");
		System.out.println("Introduce el rango inferior para solocitar un número");
		rangoInferior = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el rango superior para solocitar un número");
		rangoSuperior = Integer.parseInt(teclado.nextLine());
		MiEntradaSalida.solicitarEnteroEnRango("Introduce un entero entre " + rangoInferior + " y " + rangoSuperior, rangoInferior, rangoSuperior);
		MiEntradaSalida.solicitarCaracter("Introduce un caracter");
		MiEntradaSalida.solicitarCaracterSN("Introduce un caracter (S/N)");
		MiEntradaSalida.solicitarCadena("Introduce una cadena");
	}

}
