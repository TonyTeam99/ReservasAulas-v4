/**
 * 
 */
package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

/**
 * @author anton
 *
 */
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IProfesores;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IReservas;

public interface IFuenteDatos {

	IAulas crearAulas();

	IProfesores crearProfesores();

	IReservas crearReservas();
}
