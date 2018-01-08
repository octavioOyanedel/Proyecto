package main;
import listas.*;

public class Ksi {

	public static void main(String[] args) {
		
		ListaSorteos listaSorteo = new ListaSorteos();
		ListaFilas listaFilas = new ListaFilas();
		ListaSeries listaSeries = new ListaSeries();
		listaSorteo.crearEstructura();
		listaSorteo.poblarMapaSorteos();
		listaFilas.crearEstructura();
		listaFilas.poblarMapasFilas(listaSorteo.getMapa());		
		listaSeries.crearEstructura();
		listaSeries.poblarMapaSeries(listaFilas.getLista());

		//listaSorteo.mostrarMapa();
		//listaFilas.mostrarMapas();
		listaSeries.mostrarMapa();		

	}

}//fin clase
 