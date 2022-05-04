package org.iesalandalus.programacion.reservasaulas.mvc.vista.grafica.controladores;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.grafica.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorStagePrincipal {

	private List<Profesor> coleccionProfesores = new ArrayList<>();

	@FXML
	private Button botonProfesores;

	@FXML
	private Button botonAulas;

	@FXML
	private Button botonReservas;

	@FXML
	void salir(ActionEvent event) {

		// True si pulsas aceptar y false si pulsas cancelar
		if (Dialogos.mostrarDialogoConfirmacion("Salir de la Aplicación", "¿Realmente quieres salir?", null)) {
			System.exit(0);
		}
	}

	@FXML
	private TableColumn<?, ?> tcNombre;

	@FXML
	private TableColumn<?, ?> tcCorreo;

	@FXML
	private TableColumn<?, ?> tcHora;

	@FXML
	private TableColumn<?, ?> tcPuntos;

	@FXML
	private TableView<?> tvProfesores;

	@FXML
	private TableColumn<?, ?> tcAula;

	@FXML
	private TableColumn<?, ?> tcDia;

	@FXML
	private TableColumn<?, ?> tcTlf;

	@FXML
	void profesores(ActionEvent event) {

	}

	@FXML
	void aulas(ActionEvent event) {

	}

	@FXML
	void reservas(ActionEvent event) {

	}

}
