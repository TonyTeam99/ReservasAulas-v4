package org.iesalandalus.programacion.reservasaulas.mvc.vista.texto;

public enum Opcion {
	SALIR("Salir") {
		public void ejecutar() {
			vistaTexto.salir();
		}
	},
	INSERTAR_AULA("Insertar aula") {
		public void ejecutar() {
			vistaTexto.insertarAula();
		}
	},
	BORRAR_AULA("Borrar aula") {
		public void ejecutar() {
			vistaTexto.borrarAula();
		}
	},
	BUSCAR_AULA("Buscar aula") {
		public void ejecutar() {
			vistaTexto.buscarAula();
		}
	},
	LISTAS_AULAS("Listar aulas") {
		public void ejecutar() {
			vistaTexto.listarAulas();
		}
	},
	INSERTAR_PROFESOR("Insertar profesor") {
		public void ejecutar() {
			vistaTexto.insertarProfesor();
		}
	},
	BORRAR_PROFESOR("Borrar profesor") {
		public void ejecutar() {
			vistaTexto.borrarProfesor();
		}
	},
	BUSCAR_PROFESOR("Buscar profesor") {
		public void ejecutar() {
			vistaTexto.buscarProfesor();
		}
	},
	LISTAR_PROFESORES("Listar profesores") {
		public void ejecutar() {
			vistaTexto.listarProfesores();
		}
	},
	INSERTAR_RESERVA("Insertar reserva") {
		public void ejecutar() {
			vistaTexto.realizarReserva();
		}
	},
	BORRAR_RESERVA("Borrar reserva") {
		public void ejecutar() {
			vistaTexto.anularReserva();
		}
	},
	LISTAR_RESERVAS("Listar reservas") {
		public void ejecutar() {
			vistaTexto.listarReservas();
		}
	},
	LISTAR_RESERVAS_AULA("Listar reservas aula") {
		public void ejecutar() {
			vistaTexto.listarReservasAula();
		}
	},
	LISTAR_RESERVAS_PROFESOR("Listar reservas profesor") {
		public void ejecutar() {
			vistaTexto.listarReservasProfesor();
		}
	},
	CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad") {
		public void ejecutar() {
			vistaTexto.consultarDisponibilidad();
		}
	};

	private String mensajeAMostrar;
	static VistaTexto vistaTexto;

	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}

	public String getMensajeAMostrar() {
		return mensajeAMostrar;
	}

	public abstract void ejecutar();

	protected static void setVista(VistaTexto vistaIntoducida) {
		if (vistaIntoducida == null)
			throw new NullPointerException("ERROR: La vista no pueda ser nula.");

		Opcion.vistaTexto = vistaIntoducida;
	}

	public String toString() {
		return String.format("%d.- %s", ordinal(), mensajeAMostrar);
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("Ordinal de la opción no válido");
		}
		return values()[ordinal];
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

}
