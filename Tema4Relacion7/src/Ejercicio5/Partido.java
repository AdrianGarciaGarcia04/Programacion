package Ejercicio5;

public class Partido {
	private static final int ULTIMA_JORNADA = 38;
	private static final int PRIMERA_JORNADA = 1;
	private static final char[] RESULTADO = {'1', 'X', '2'};
	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int numeroGolesLocal;
	private int numeroGolesVisitantes;
	private char quiniela;
	private boolean esJugado = false;
	
	//Getters y setters
	
	
	public int getJornada() {
		return jornada;
	}
	public boolean isEsJugado() {
		return esJugado;
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public int getNumeroGolesLocal() throws PartidoException {
		if(!isEsJugado()) {
			throw new PartidoException("El partido no se ha jugado");
		}
		return numeroGolesLocal;
	}
	public int getNumeroGolesVisitantes() throws PartidoException {
		if(!isEsJugado()) {
			throw new PartidoException("El partido no se ha jugado");
		}
		return numeroGolesVisitantes;
	}
	public char getQuiniela() throws PartidoException {
		if(!isEsJugado()) {
			throw new PartidoException("El partido no se ha jugado");
		}
		return quiniela;
	}
	
	
	//Constructor
	
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
		if(equipoLocal.equals(equipoVisitante)) {
			throw new PartidoException("El equipo " + equipoLocal + " no se puede enfrentar a si mismo");
		}
		if(jornada<PRIMERA_JORNADA || jornada >ULTIMA_JORNADA) {
			throw new PartidoException("La jornada no puede ser menor que " + PRIMERA_JORNADA + " o no puede ser mayor que " + ULTIMA_JORNADA);
		}
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.jornada = jornada;
	}
	//toString
	
	public String toString() {
		String mensaje;
		if(esJugado) {
			mensaje = "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y el equipo visitante " + equipoVisitante.getNombreEquipo() + " jugado en el estadio " + equipoLocal.getNombreEstadio() + " de la ciudad " + equipoLocal.getCiudad() + " ha finalizado con " + numeroGolesLocal + " goles de equipo local y " + numeroGolesVisitantes + " goles de equipo visitante. Resultado quiniela= " + quiniela;			
		}else {
			mensaje = "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y equipo visitante " + equipoVisitante.getNombreEquipo() + " todavía no se ha jugado";
		}
		return mensaje;
	}
	
	//Otros métodos
	
	public void ponerResultado(String resultado) throws PartidoException {
		int golesLocales, golesVisitante;
		String[] goles = resultado.split("-");
		if(goles.length !=2 || Character.isLetter(goles[0].charAt(0)) || Character.isLetter(goles[1].charAt(0))) {
			throw new PartidoException("No has introducido el formato del resultado correcto. El formato es '1-2'");
		}
		golesLocales = Integer.parseInt(goles[0]);
		golesVisitante = Integer.parseInt(goles[1]);
		if(golesLocales < 0 || golesVisitante <0) {
			throw new PartidoException("Los goles deben ser mayor o iguales que cero");
		}
		this.numeroGolesLocal =golesLocales;
		this.numeroGolesVisitantes = golesVisitante;
		if(golesLocales>golesVisitante) {
			this.quiniela = RESULTADO[0];
			equipoLocal.incrementarPartidosGanados();
		}else {
			if(golesVisitante>golesLocales) {
				this.quiniela = RESULTADO[2];
				equipoVisitante.incrementarPartidosGanados();
			}else {
				this.quiniela = RESULTADO[1];
			}
		}
		this.esJugado = true;
	}
}