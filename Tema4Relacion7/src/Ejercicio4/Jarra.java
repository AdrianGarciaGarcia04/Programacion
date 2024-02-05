package Ejercicio4;

public class Jarra {
	private double capacidad;
	private double cantidadAgua;
	private static double totalAguaConsumida;
	
	//Constructor
	public Jarra(double capacidad) throws JarraException {
		if(capacidad<0) {
			throw new JarraException("Una jarra no puede tener una capacidad de 0 litros o menos");
		}
		cantidadAgua = 0;
		this.capacidad = capacidad;
	}
	//Getters

	public double getCapacidad() {
		return capacidad;
	}

	public double getCantidadAgua() {
		return cantidadAgua;
	}

	public static double getTotalAguaConsumida() {
		return totalAguaConsumida;
	}
	//toString
	public String toString() {
		return "Capacidad: " + capacidad + " L de agua. Cantidad: " + cantidadAgua + " L de agua";
	}
	
	//Otros métodos
	
	public void llenarJarra() {
		totalAguaConsumida+=capacidad - cantidadAgua;
		cantidadAgua = capacidad;
	}
	public void vaciarJarra() throws JarraException {
		cantidadAgua=0;
		
	}
	public void volcarJarra(Jarra j2) throws JarraException {
		double cantidadARellenar; 
		if(this.cantidadAgua<0) {
			if(j2.cantidadAgua != j2.capacidad) {
				cantidadARellenar = j2.capacidad - j2.cantidadAgua;
				if(this.cantidadAgua>=cantidadARellenar) {
					j2.cantidadAgua += cantidadARellenar;
					this.cantidadAgua -=cantidadARellenar;
				}else {
					j2.cantidadAgua += this.cantidadAgua;
					vaciarJarra();
				}
			}else {
				System.out.println("La jarra que intentas llenar esta llena");
			}
		}else {
			System.out.println("La jarra no tiene agua, por lo que no puedes llenar  a ninguna otra jarra");
		}
	}
}