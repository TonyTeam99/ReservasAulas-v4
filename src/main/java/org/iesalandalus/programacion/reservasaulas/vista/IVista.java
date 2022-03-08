/**
 * 
 */
package org.iesalandalus.programacion.reservasaulas.vista;

/**
 * @author anton
 *
 */
import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;

public interface IVista {

	void setControlador(IControlador controlador);

	void comenzar();

	void salir();
}
