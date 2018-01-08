package main;
import listas.*;

public class Ksi {

	public static void main(String[] args) {
		
		ListaSorteos listaSorteo = new ListaSorteos();
		ListaFilas listaFilas = new ListaFilas();
		listaSorteo.crearEstructura();
		listaSorteo.poblarMapaSorteos();
		listaFilas.crearEstructura();
		//listaFilas.mostrarMapas();
		//listaSorteo.mostrarMapa();

	}

}//fin clase
 