package RepasoArray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Restaurante {
	private static final int MAXIMO = 5;
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int numeroMesas;
		System.out.println("Numero de mesas: ");
		numeroMesas = Integer.parseInt(teclado.nextLine());
		int[] mesas = new int[numeroMesas];
		int[] numeroPersonas = new int[numeroMesas];
		asignarMesas(mesas, numeroPersonas);
		System.out.println("Gracias. Hasta pronto");
	}
	public static void asignarMesas(int[] mesas, int[] personas) {
		int numeroPersonas;
		int cont = -1;
		boolean haySitio;
		boolean sitioConCeroPersonas;
		asignarNumeroMesas(mesas);
		asignarMesasPorDefecto(personas);
		System.out.println("¿Cuántos son? (Introduzca -1 para salir)");
		numeroPersonas = Integer.parseInt(teclado.nextLine());
		while(numeroPersonas!=-1) {
			haySitio = false;
			sitioConCeroPersonas = false;
			if(numeroPersonas>4) {
				System.out.println("Lo siento, no admitimos grupos de " + numeroPersonas + ", haga grupos de 4 personas como máximo e intente de nuevo");
			}else {
				
				for(int i = 0, k=0;i<mesas.length && !sitioConCeroPersonas;i++) {
					if(numeroPersonas <= ((MAXIMO - 1) - personas[i]) + k) {
						cont = i;
						haySitio = true;
						k--;
						if(personas[i] == 0) {
							sitioConCeroPersonas = true;
						}
					}
				}
				if(!haySitio) {
					System.out.println("Lo siento, en estos momentos no queda sitio.");
				}else {
					personas[cont] += numeroPersonas;
					if(sitioConCeroPersonas) {
						System.out.println("Por favor, siéntense en la mesa número " + (cont + 1));
					}else {
						System.out.println("Tendrán que compartir mesa. Por favor, siéntense en la mesa número " + (cont + 1));
					}
				}
			}
			System.out.println("Mesas:    " + Arrays.toString(mesas));
			System.out.println("Personas: " + Arrays.toString(personas));
			System.out.println("¿Cuántos son? (Introduzca -1 para salir)");
			numeroPersonas = Integer.parseInt(teclado.nextLine());
		}
	}
	public static void asignarMesasPorDefecto(int [] personas) {
		int numeroAleatorio;
		Random serieAleatoria = new Random();
		for(int i = 0;i<personas.length;i++) {
			numeroAleatorio=serieAleatoria.nextInt(MAXIMO);
			personas[i] = numeroAleatorio;
		}
	}
	public static void asignarNumeroMesas(int[] mesas) {
		for(int i = 0; i<mesas.length;i++) {
			mesas[i] = (i+1);
		}
	}
}