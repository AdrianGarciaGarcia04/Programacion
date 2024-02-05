package RepasoPOO;

import java.util.Scanner;

public class MonroyPetPrincipal {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int seleccion;
		try {
			MonroyPet mascota1 = crearMascota("Crea tu primera mascota");
			MonroyPet mascota2 = crearMascota("Crea tu segunda mascota");
			do {
				menu();
				seleccion = pedirNumero("Introduzca una opción");
				gestionarMenu(seleccion, mascota1, mascota2);
			} while (seleccion!=5 && MonroyPet.getMinutos()<100);
		}catch(MonroyPetException e) {
			System.err.println(e.getMessage());
		}
		if(MonroyPet.getMinutos()>=100) {
			System.out.println("Las mascotas tienen sueño... Se van a dormir ZZZZZ");
		}
		
	}
	public static void menu() {
		System.out.println("1. Dar comida a la mascota");
		System.out.println("2. Comprar comida");
		System.out.println("3. Jugar");
		System.out.println("4. Información de masoctas");
		System.out.println("5. Salir");
	}
	public static void gestionarMenu(int opcion, MonroyPet mascota1, MonroyPet mascota2) {
		int numeroMascota;
		int numeroComida;
		int minutos = 0;
		try {
			switch(opcion) {
				case 1:
					numeroMascota = solicitarMascota("Selecciona una mascota (1-2)");
					if(numeroMascota == 1) {
						mascota1.darComida();
					}else {
						mascota2.darComida();
					}
					System.out.println("Tu mascota ha comido correctamente");
					break;
				case 2:
					numeroComida = pedirNumero("Introduce el numero de comida que quieres comprar");
					numeroMascota = solicitarMascota("Selecciona una mascota (1-2)");
					if(numeroMascota == 1) {
						mascota1.comprarComida(numeroComida);
					}else {
						mascota2.comprarComida(numeroComida);
					}
					System.out.println("Has comprado comida correctamente correctamente");
					break;
				case 3:
					numeroMascota = solicitarMascota("Selecciona una mascota (1-2)");
					minutos = pedirNumero("¿Cuántos minutos vas a jugar con tu mascota?");
					if(numeroMascota == 1) {
						mascota1.jugar(minutos);
					}else {
						mascota2.jugar(minutos);
					}
					break;
				case 4:
					System.out.println(mascota1);
					System.out.println(mascota2);
					break;
				case 5:
					System.out.println("Has salido correctamente");
			}
		}catch(MonroyPetException e) {
			System.err.println(e.getMessage());
		}
		
	}
	private static int pedirNumero(String msg) {
		int seleccion;
		System.out.println(msg);
		seleccion = Integer.parseInt(teclado.nextLine());
		return seleccion;
	}
	private static int solicitarMascota(String msg) {
		int mascota;
		System.out.println(msg);
		do {
			mascota = Integer.parseInt(teclado.nextLine());
			if(mascota<1 || mascota>2) {
				System.out.println("Solo existe la mascota numero 1 y la numero 2");
			}
		} while (mascota<1 || mascota>2);
		return mascota;
	}
	private static MonroyPet crearMascota(String msg) throws MonroyPetException {
		MonroyPet mascota;
		String nombre, tipo;
		System.out.println(msg);
		System.out.println("¿Cómo quieres llamar a tu mascota?");
		nombre = teclado.nextLine();
		System.out.println("¿Qué tipo es tu mascota?");
		tipo = teclado.nextLine();
		mascota = new MonroyPet(nombre, tipo);
		return mascota;
	}
}