package RepasoArray;

import java.util.Arrays;

import Utilidades.MiEntradaSalida;

public class ArraysColores {
	private static final int NUMERO_PALABRAS_ARRAY = 8;
	private static final String[] COLORES = {"VERDE", "ROJO", "BLANCO", "NEGRO", "AZUL", "AMARILLO", "ROSA"};	
	public static void main(String[] args) {
		String[] vector;
		boolean seEncuentra;
		int posicionArrayAuxiliar =0;
		vector = new String[NUMERO_PALABRAS_ARRAY];
		pedirElementos(vector);
		String[] vectorAuxiliar = new String[NUMERO_PALABRAS_ARRAY];
		for(int i = 0; i<vector.length;i++) {
			seEncuentra = false;;
			for(int j = 0; j<COLORES.length && !seEncuentra;j++) {
				if(vector[i].equalsIgnoreCase(COLORES[j])) {
					seEncuentra = true;
					vectorAuxiliar[posicionArrayAuxiliar] = vector[i];
					posicionArrayAuxiliar++;
				}
			}
		}
		moverElementos(vector, vectorAuxiliar, posicionArrayAuxiliar);
		System.out.println(Arrays.toString(vector));
	}
	private static void pedirElementos(String[] vector) {
		String palabra;
		for(int i = 0; i<vector.length;i++) {
			palabra = MiEntradaSalida.solicitarCadena("Introduce una palabra " + (i+1) +  "/" + NUMERO_PALABRAS_ARRAY);
			vector[i] = palabra;
		}
	}
	private static void moverElementos(String[] vector, String[] vectorAuxiliar, int posicionNoTieneLetras) {
		boolean seEncuentra;
		for(int i= posicionNoTieneLetras, k=0; i<vector.length;k++) {
			seEncuentra = false;
			for(int j = 0; j<COLORES.length && !seEncuentra;j++) {
				if(vector[k].equalsIgnoreCase(COLORES[j])) {
					seEncuentra = true;
				}
			}
			if(!seEncuentra) {
				vectorAuxiliar[i] = vector[k];
				i++;
			}
		}
		for(int i = 0;i<vector.length;i++) {
			vector[i] = vectorAuxiliar[i];
		}
	}
}
