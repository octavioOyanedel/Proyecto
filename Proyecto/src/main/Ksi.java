package main;
import listas.*;

public class Ksi {

	public static void main(String[] args) {
		
		ListaColumnas listaColumnas = new ListaColumnas();
		ListaPatrones listaPatrones = new ListaPatrones();
		ListaBusquedas listaBusqueda = new ListaBusquedas();
		ListaCandidatos listaCandidatos = new ListaCandidatos();

		listaColumnas.crearColeccionColumnas();
		listaPatrones.crearColeccionPatrones(listaColumnas.getMapa());
		//listaColumnas.mostrarColeccion();
		listaPatrones.mostrarColeccion();
		listaBusqueda.crearColeccionBusquedas(listaColumnas.getMapa());
		listaBusqueda.mostrarColeccion();
		listaCandidatos.crearColeccionCandidatos(listaBusqueda.getMapa(),listaPatrones.getLista());
		listaCandidatos.mostrarColeccion();
		
	}

}//fin clase
 