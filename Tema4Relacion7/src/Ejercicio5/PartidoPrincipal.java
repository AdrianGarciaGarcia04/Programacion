package Ejercicio5;

import Utilidades.MiEntradaSalida;

public class PartidoPrincipal {

	public static void main(String[] args) {
		boolean hayError = true;
		try {
			Partido partido1 = new Partido(7, new Equipo("Real Madrid", "Santiago Bernabeu", "Madrid"), new Equipo("FC Barcelona", "Camp Nou", "Barcelona"));
			partido1.ponerResultado("2-1");
			System.out.println(partido1);
		}catch(PartidoException e) {
			System.err.println(e.getMessage());
		}
		do {
			try {
				Partido partido2 = crearPartido();
				partido2.ponerResultado("0-0");
				System.out.println(partido2);
				System.out.println(partido2.getEquipoLocal());
				System.out.println(partido2.getEquipoVisitante());
				Partido partido3 = crearPartido();
				partido3.ponerResultado("1-2");
				System.out.println(partido3);
				System.out.println(partido3.getEquipoLocal());
				System.out.println(partido3.getEquipoVisitante());
				hayError = false;
			}catch(PartidoException e) {
				System.err.println(e.getMessage());
			}
		} while (hayError);
	}

	public static Partido crearPartido() throws PartidoException {
		
		int jornada;
		Partido partido;
		Equipo equipoLocal;
		Equipo equipoVisitante;
		jornada = MiEntradaSalida.solicitarEntero("Introduce la jornada del partido");
		equipoLocal = crearEquipo("Introduce el nombre del equipo local");
		equipoVisitante = crearEquipo("Introduce el nombre del equipo visitante");
		partido = new Partido(jornada, equipoLocal, equipoVisitante);
		return partido;
	}
	public static Equipo crearEquipo(String mensaje) {
		String nombreEquipo;
		String estadio;
		String ciudad;
		Equipo equipo;
		nombreEquipo = MiEntradaSalida.solicitarCadena(mensaje);
		estadio = MiEntradaSalida.solicitarCadena("Introduce el estadio del equipo");
		ciudad = MiEntradaSalida.solicitarCadena("Introduce la ciudad del equipo");
		equipo = new Equipo(nombreEquipo, estadio, ciudad);
		return equipo;
	}
}
