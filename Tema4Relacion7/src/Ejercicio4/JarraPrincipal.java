package Ejercicio4;
import java.util.Scanner;
public class JarraPrincipal {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws JarraException {
		double capacidadInicial;
		try {
			System.out.println("¿Cuál es la capacidad de la jarra A?");
			capacidadInicial = Double.parseDouble(teclado.nextLine());
			Jarra j1 = new Jarra(capacidadInicial);
			System.out.println("¿Cuál es la capacidad de la jarra B?");
			capacidadInicial = Double.parseDouble(teclado.nextLine());
			Jarra j2 = new Jarra(capacidadInicial);
			gestionarMenu(j1, j2);
		}catch(JarraException e) {
			System.err.println(e.getMessage());
		}
	}
	public static void menu() {
		System.out.println("1.LLenar jarra");
		System.out.println("2. Vaciar jarra.");
		System.out.println("3. Volcar jarra A en B");
		System.out.println("4. Volcar jarra B en A");
		System.out.println("5. Ver estado de las jarras");
		System.out.println("6. Salir");
	}
	public static void gestionarMenu(Jarra j1, Jarra j2) throws JarraException {
		int seleccion = 0;
	
		Jarra elegida;
		while(seleccion!=6) {
			menu();
			System.out.println("Introduce una opción: ");
			seleccion = Integer.parseInt(teclado.nextLine());
			switch(seleccion) {
				case 1:
					elegida=elegirJarra(j1, j2);
					elegida.llenarJarra();
					
					break;
				case 2:
					elegida=vaciarJarra(j1, j2);
					elegida.vaciarJarra();
					
					break;
				case 3:
					j1.volcarJarra(j2);
					System.out.println("Ahora la jarra A tiene una cantidad de " + j1.getCantidadAgua() + " L de agua y la jarra B tiene " + j2.getCantidadAgua() + " L de agua");
					break;
				case 4:
					j2.volcarJarra(j1);
					System.out.println("Ahora la jarra B tiene una cantidad de " + j2.getCantidadAgua() + " L de agua y la jarra A tiene " + j1.getCantidadAgua() + " L de agua");
					break;
				case 5:
					System.out.println("Jarra A: " + j1);
					System.out.println("Jarra B: " + j2);
					break;
				case 6:
					System.out.println("El total de agua que se ha gastado llenando jarras es " + Jarra.getTotalAguaConsumida() + " L de agua");
					System.out.println("Has salido correctamente");
					break;
				default:
					System.out.println("No has elegido una opción válida");
			}
		}
	}
	
	public static Jarra elegirJarra(Jarra j1, Jarra j2) {
		Jarra elegida;
		char respuestaJarra;
	
		System.out.println("¿Qué jarra desea llenar (A/B)");
		respuestaJarra = teclado.nextLine().charAt(0);
		
		if ( respuestaJarra== 'A') {
			elegida=j1;
		}else {
			elegida=j2;
		}
		
		
		return elegida;
	}
	public static Jarra vaciarJarra(Jarra j1, Jarra j2) {
		Jarra elegida;
		char respuestaJarra;
	
		System.out.println("¿Qué jarra desea vaicar (A/B)");
		respuestaJarra = teclado.nextLine().charAt(0);
		
		if ( respuestaJarra== 'A') {
			elegida=j1;
		}else {
			elegida=j2;
		}
		
		
		return elegida;
	}
	
	
	
	
	
	
	
	
	
}