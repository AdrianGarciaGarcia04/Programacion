package Ejercicio2;

import java.util.Objects;

public class Linea {
	
	private Punto punto1;
	private Punto punto2;
	public Linea(Punto punto1, Punto punto2) {
		this.punto1 = punto1;
		this.punto2 = punto2;
	}
	public Punto getPunto1() {
		return punto1;
	}
	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}
	public Punto getPunto2() {
		return punto2;
	}
	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}
	@Override
	public int hashCode() {
		return Objects.hash(punto1, punto2);
	}
	public boolean equals(Linea linea) {
		boolean sonIguales = false;
		if((punto1.equals(linea.getPunto1())  && punto2.equals(linea.getPunto2()) ) || punto2.equals(linea.getPunto1())  && punto1.equals(linea.getPunto2())) {
			sonIguales = true;
		}
		return sonIguales;
	}
	public void moverDerecha(double movimiento) throws LineaException {
		if(movimiento<=0) {
			throw new LineaException("Para mover la linea debes introducir un número mayor que 0");
		}
		punto1.setEjeX(punto1.getEjeX() + movimiento);
		punto2.setEjeX(punto2.getEjeX() + movimiento);
	}
	public void moverIzquierda(double movimiento) throws LineaException {
		if(movimiento<=0) {
			throw new LineaException("Para mover la linea debes introducir un número mayor que 0");
		}
		punto1.setEjeX(punto1.getEjeX() - movimiento);
		punto2.setEjeX(punto2.getEjeX() - movimiento);
	}
	public void moverArriba(double movimiento) throws LineaException {
		if(movimiento<=0) {
			throw new LineaException("Para mover la linea debes introducir un número mayor que 0");
		}
		punto1.setEjeY(punto1.getEjeY() + movimiento);
		punto2.setEjeY(punto2.getEjeY() + movimiento);
	}
	public void moverAbajo(double movimiento) throws LineaException {
		if(movimiento<=0) {
			throw new LineaException("Para mover la linea debes introducir un número mayor que 0");
		}
		punto1.setEjeY(punto1.getEjeY() - movimiento);
		punto2.setEjeY(punto2.getEjeY() - movimiento);
	}
	@Override
	public String toString() {
		return "[" + punto1 + "," + punto2 + "]";
	}
	
}