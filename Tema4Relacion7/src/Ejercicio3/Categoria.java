package Ejercicio3;

import java.util.Objects;

public class Categoria {
	private String nombre;
	private double iva;
	
	public Categoria(String nombre, double iva) throws ProductoException {
		this.nombre = nombre;
		setIva(iva);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) throws ProductoException {
		if(iva<0) {
			throw new ProductoException("No puedes introducir un IVA menor que cero");
		}
		this.iva = iva;
	}
	@Override
	public String toString() {
		return nombre + ", IVA: " + iva;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
