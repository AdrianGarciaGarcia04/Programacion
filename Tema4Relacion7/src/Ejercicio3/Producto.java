package Ejercicio3;

import java.util.Objects;

public class Producto {
	private int codigo;
	private String descripcion;
	private double precioSinIva;
	private Categoria categoria;
	private static int numeroCodigos = 0;
	
	public Producto(String descripcion, double precioSinIva, Categoria categoria) throws ProductoException {
		this.descripcion = descripcion;
		setPrecioSinIva(precioSinIva);
		this.categoria = categoria;
		codigo = numeroCodigos + 1;
		numeroCodigos++;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecioSinIva() {
		return precioSinIva;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public double getPrecioConIva() {
		return precioSinIva + precioSinIva*(categoria.getIva()/100);
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecioSinIva(double precioSinIva) throws ProductoException {
		if(precioSinIva<0) {
			throw new ProductoException("No puede establecerse un precio menor que cero");
		}
		this.precioSinIva = precioSinIva;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}
	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Descripcion: " + descripcion + ", Precio sin el IVA: " + precioSinIva
				+ ", Categoria:" + categoria + ", Precio con el IVA: " + getPrecioConIva();
	}
	
}
