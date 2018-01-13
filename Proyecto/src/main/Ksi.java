package main;
import listas.*;

public class Ksi {

	public static void main(String[] args) {
		
		ListaColumnas listaColumnas = new ListaColumnas();
		ListaPatrones listaPatrones = new ListaPatrones();
		listaColumnas.crearColeccionColumnas();
		listaPatrones.crearColeccionPatrones(listaColumnas.getMapa());
		listaColumnas.mostrarColeccion();
		//listaPatrones.mostrarColeccion();
		
	}

}//fin clase
 