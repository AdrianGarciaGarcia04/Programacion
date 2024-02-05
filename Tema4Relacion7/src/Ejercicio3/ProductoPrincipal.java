package Ejercicio3;

import java.util.Scanner;

import Utilidades.MiEntradaSalida;

public class ProductoPrincipal {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String nombreDeLaCategoria;
		double IVA;
		String nombreProducto;
		double precioProducto;
		boolean hayError = true;
		do {
			try {
				Categoria categoria1 = new Categoria("Primeras necesidades", 2);
				Producto barraDePan = new Producto("Pan", 1, categoria1);
				Producto ordenador = new Producto("Ordenador portátil", 499, new Categoria("Electrodoméstico", 21));
				System.out.println(barraDePan);
				System.out.println(ordenador.toString());
				System.out.println("El precio con IVA de un ordenador es " + ordenador.getPrecioConIva());
				hayError = false;
			}catch(ProductoException e) {
				System.err.println(e.getMessage());
			}catch(NullPointerException e) {
				System.err.println("El nombre o la descripción no deben estar vacias");
			}catch(NumberFormatException e) {
				System.err.println("EN el precio o en el IVA debes introducir un número");
			}
		} while (hayError);
		hayError = true;
		do {
			try {
				nombreDeLaCategoria = MiEntradaSalida.solicitarCadena("Introduce el nombre de la categoria");
				System.out.println("Introduce el IVA de la categoria");
				IVA = Double.parseDouble(teclado.nextLine());
				nombreProducto = MiEntradaSalida.solicitarCadena("Introduce el nombre del producto");
				System.out.println("Introduce el precio del producto");
				precioProducto = Double.parseDouble(teclado.nextLine());
				Categoria categoria2 = new Categoria(nombreDeLaCategoria, IVA);
				Producto producto = new Producto(nombreProducto, precioProducto, categoria2);
				System.out.println("Aquí tiene su producto");
				System.out.println(producto);
				hayError = false;
			}catch(ProductoException e) {
				System.err.println(e.getMessage());
			}catch(NullPointerException e) {
				System.err.println("El nombre o la descripción no deben estar vacias");
			}catch(NumberFormatException e) {
				System.err.println("EN el precio o en el IVA debes introducir un número");
			}
		} while (hayError);
		
	}

}
