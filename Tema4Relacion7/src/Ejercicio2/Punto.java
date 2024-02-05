package Ejercicio2;

import java.util.Objects;

public class Punto {
	
	private double ejeX;
	private double ejeY;
	
	public Punto(double ejeX, double ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}

	public double getEjeX() {
		return ejeX;
	}

	public void setEjeX(double ejeX) {
		this.ejeX = ejeX;
	}

	public double getEjeY() {
		return ejeY;
	}

	public void setEjeY(double ejeY) {
		this.ejeY = ejeY;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ejeX, ejeY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(ejeX) == Double.doubleToLongBits(other.ejeX)
				&& Double.doubleToLongBits(ejeY) == Double.doubleToLongBits(other.ejeY);
	}

	@Override
	public String toString() {
		return "("+ ejeX + "," + ejeY + ")";
	}
	
	
	
}
