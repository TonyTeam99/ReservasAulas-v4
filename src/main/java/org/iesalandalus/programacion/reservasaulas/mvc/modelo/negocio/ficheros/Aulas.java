package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IAulas;

public class Aulas implements IAulas {
	
	private List<Aula> coleccionAulas;
	private static final String NOMBRE_FICHERO_AULAS = ".\\src\\main\\java\\org\\iesalandalus\\programacion\\reservasaulas\\mvc\\modelo\\negocio\\ficheros\\Ficheros\\Aulas.dat";
	
	public Aulas () {
		coleccionAulas = new ArrayList<Aula>();
		
	}
	
	public Aulas(IAulas aulasOriginal) {
		if (aulasOriginal == null)
			throw new NullPointerException("ERROR: No se pueden copiar aulas nulas.");
		
		if (aulasOriginal.getNumAulas() == 0)
			coleccionAulas = new ArrayList<Aula>();
		else 
			setAulas(aulasOriginal);
	}
	
	public void comenzar(){
		leer();
	}
	
	public void terminar(){
		escribir();
	}
	
	private void leer(){
		File fileAulas = new File(NOMBRE_FICHERO_AULAS); // creamos el fichero
		
		// creamos el flujo y recorremos las aulas para ir copiandolas del fichero
		try{ 
			FileInputStream fileIS = new FileInputStream(fileAulas);// creamos el flujo
		    ObjectInputStream objectIS = new ObjectInputStream(fileIS);// definimos que el tipo de dato va a ser objeto
			
			Aula aula = null;
			do {
				aula = (Aula) objectIS.readObject();
				insertar(aula);

			} while (aula != null);
			
			objectIS.close(); //cerramos flujo
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: No puedo encontrar la clase que tengo que leer.");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: No puedo abrir el fichero de aulas.");
		} catch (EOFException e) {
			System.out.println("Fichero aulas le??do.");
		} catch (IOException e) {
			System.out.println("ERROR inesperado de Entrada/Salida.");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void escribir(){
		File ficheroAulas = new File(NOMBRE_FICHERO_AULAS); // creamos el fichero
		
		// creamos el flujo y recorremos las aulas para ir copiandolas en el fichero
		try {
			FileOutputStream fileOS = new FileOutputStream(ficheroAulas); // creamos el flujo
	        ObjectOutputStream objectOS = new ObjectOutputStream(fileOS); // definimos que el tipo de dato va a ser objeto
			
			for (Aula aula : coleccionAulas)
				objectOS.writeObject(aula);
			System.out.println("Fichero aulas escrito.");

			objectOS.close();//cerramos flujo
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: No puedo abrir el fichero de aulas.");
		} catch (IOException e) {
			System.out.println("ERROR inesperado de Entrada/Salida.");
		}
	}
	
	private void setAulas(IAulas aulas) {

		coleccionAulas = copiaProfundaAulas(aulas.getAulas());
	}
	
	@Override
	public List<Aula> getAulas() {
		if (getNumAulas() == 0)
			throw new NullPointerException("ERROR: No se ha creado ningun aula aun.");
		
		Comparator<Aula> comparator = Comparator.comparing(Aula::getNombre);
		
		List<Aula> copiaAulas = copiaProfundaAulas(coleccionAulas);
		
		Collections.sort(copiaAulas, comparator);
		
		return copiaAulas;
	}
	
	private List<Aula> copiaProfundaAulas(List<Aula> coleccionAulasOriginal) {
		
		List<Aula> coleccionCopiaAulas;
		
		coleccionCopiaAulas = new ArrayList<Aula>();
		
		// recorremos todas las aulas comparando
		Iterator<Aula> it = coleccionAulasOriginal.iterator();
		while(it.hasNext()) {
			Aula aulaCopia = new Aula(it.next());
			coleccionCopiaAulas.add(aulaCopia);
		}
		return coleccionCopiaAulas;
		
	}
	
	@Override
	public void insertar (Aula aula) throws OperationNotSupportedException {
		if (aula == null) 
			throw new NullPointerException("ERROR: No se puede insertar un aula nula.");
		
		if (buscar(aula) != null)
			throw new OperationNotSupportedException("ERROR: Ya existe un aula con ese nombre.");
		
		// insertamos la nueva cita y actualizamos el tama??o
		coleccionAulas.add(new Aula(aula));
	}
	
	@Override
	public Aula buscar (Aula aula) {
		if (aula == null)
			throw new NullPointerException("ERROR: No se puede buscar un aula nula.");
		
		// si el indice supera al tama??o, es que no lo ha encontrado y es un objeto nuevo
		if (coleccionAulas.contains(aula))
			return new Aula(aula); 
		else
			return null;
	}
	
	@Override
	public void borrar (Aula aula) throws OperationNotSupportedException {
		if (aula == null) 
			throw new NullPointerException("ERROR: No se puede borrar un aula nula.");
		
		if (buscar(aula) == null) 			
			throw new OperationNotSupportedException("ERROR: No existe ning??n aula con ese nombre.");
		
		coleccionAulas.remove(aula);
	}
	
	@Override
	public List<String> representar() throws OperationNotSupportedException {
		if (getNumAulas() == 0)
			throw new OperationNotSupportedException("ERROR: La lista de aulas est?? vacia.");
		
		List<String> representacion = new ArrayList<String>();
		
		for (Aula a : coleccionAulas)
			representacion.add(a.toString());			
	
		return representacion;
	}

	@Override
	public int getNumAulas() {
		return coleccionAulas.size();
	}
	

}
