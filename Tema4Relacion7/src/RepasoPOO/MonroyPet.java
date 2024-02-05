package RepasoPOO;

import java.util.Objects;

public class MonroyPet {
	
	private static final int PUNTOS_POR_MINUTO = 3;
	private static final int PRECIO_COMIDA = 30;
	private static final String[] tipos = {"PERRO", "GATO"};
	private String nombre;
	private String tipo;
	private int puntos;
	private int comida;
	private static int minutos = 0;
	
	//Constructor
	public MonroyPet(String nombre, String tipo) throws MonroyPetException {
		if(!tipo.equalsIgnoreCase(tipos[0]) && !tipo.equalsIgnoreCase(tipos[1])) {
			throw new MonroyPetException("El tipo que has seleccionado no existe");
		}
		setNombre(nombre);
		this.puntos = 0;
		this.comida = 2;
		this.tipo = tipo;
	}
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public int getPuntos() {
		return puntos;
	}
	public int getComida() {
		return comida;
	}
	public static int getMinutos() {
		return minutos;
	}
	public void setNombre(String nombre) throws MonroyPetException {
		if(nombre.isEmpty()) {
			throw new MonroyPetException("El nombre no debe estar vacío");
		}
		this.nombre = nombre;
	}
	//toString
	public String toString() {
		String mensaje;
		if(tipo.equals(tipos[0])) {
			mensaje = "La mascota " + nombre + " tiene " + comida + " huesos y tiene un total de " + puntos + " puntos";
		}else {
			mensaje = "La mascota " + nombre + " tiene " + comida + " pescados y tiene un total de " + puntos + " puntos";
		}
		return mensaje;
	}
	//equals
	
	public int hashCode() {
		return Objects.hash(nombre, tipo);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonroyPet other = (MonroyPet) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(tipo, other.tipo);
	}
	
	//Otros métodos
	
	public void darComida() throws MonroyPetException {
		if(comida == 0) {
			throw new MonroyPetException("No tienes suficiente comida para tu mascota. Compra comida o intenta jugar con él para obtener puntos y comprar comida");
		}
		comida--;
	}
	
	public void comprarComida(int numeroComidaParaComprar) throws MonroyPetException {
		if(numeroComidaParaComprar<=0) {
			throw new MonroyPetException("Compra un número mayor que cero");
		}
		if(puntos<numeroComidaParaComprar*PRECIO_COMIDA) {
			throw new MonroyPetException("No tienes suficientes puntos para comprar comida, intenta jugar con tu mascota para obtener puntos");
		}
		puntos -= numeroComidaParaComprar*PRECIO_COMIDA;
		comida+=numeroComidaParaComprar;
	}
	public void jugar(int minutosParaJugar) throws MonroyPetException {
		if(minutosParaJugar<=0) {
			throw new MonroyPetException("No puede jugar cero o menos minutos");
		}
		if(minutosParaJugar>20) {
			throw new MonroyPetException("No puedes jugar más de 20 minutos con tu mascota");
		}
		if(minutos + minutosParaJugar>100) {
			throw new MonroyPetException("Ya mismo te acercas a los 100 minutos y las mascotas tienen sueño, selecciona menos minutos para jugar y que no se cansen (te faltan " + (minutos-minutosParaJugar) + " minutos");
		}
		this.puntos+= minutosParaJugar*PUNTOS_POR_MINUTO;
		minutos += minutosParaJugar;
	}	
}