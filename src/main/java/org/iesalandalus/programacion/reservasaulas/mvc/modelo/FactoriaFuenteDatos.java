package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.ficheros.FactoriaFuenteDatosFicheros;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.memoria.FactoriaFuenteDatosMemoria;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.mongodb.FactoriaFuenteDatosMongoDB;

public enum FactoriaFuenteDatos {

	MEMORIA() {
		public IFuenteDatos crear() {
			return new FactoriaFuenteDatosMemoria();
		}
	},

	MONGODB() {
		public IFuenteDatos crear() {
			return new FactoriaFuenteDatosMongoDB();
		}
	},

	FICHEROS() {
		public IFuenteDatos crear() {
			return new FactoriaFuenteDatosFicheros();
		}
	},;

	public abstract IFuenteDatos crear();
}