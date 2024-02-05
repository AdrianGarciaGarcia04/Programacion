package RepasoArray;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysCincuerizado {
	private static final int NUMERO_ELEMENTOS = 4;
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int[] vector = new int[NUMERO_ELEMENTOS];
		pedirElementos(vector);
		System.out.println("Tus números son: " + Arrays.toString(vector));
		System.out.println("Ahora vamos a cincuerizarlo");
		cincuerizarNumeros(vector);
		System.out.println("Ahora tu array es: " + Arrays.toString(vector));
	}
	public static void pedirElementos(int[] vector) {
		int numero;
		for(int i = 0;i<vector.length;i++) {
			System.out.println("Introduce un número " + (i+1) + "/" + (vector.length));
			numero = Integer.parseInt(teclado.nextLine());
			vector[i] = numero;
		}
	}
	public static void cincuerizarNumeros(int[] vector) {
		int resto;
		for(int i = 0; i<vector.length;i++) {
			resto = vector[i] % 5;
			if(resto!=0) {
				vector[i] += 5 - resto;
			}
		}
	}
}