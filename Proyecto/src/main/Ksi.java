package main;
import listas.*;

public class Ksi {

	public static void main(String[] args) {
		
		ListaSorteos listaSorteo = new ListaSorteos();
		ListaFilas listaFilas = new ListaFilas();
		ListaSeries listaSeries = new ListaSeries();
		ListaPatrones listaPatrones = new ListaPatrones();
		listaSorteo.crearEstructura();
		listaSorteo.poblarMapaSorteos();
		listaFilas.crearEstructura();
		listaFilas.poblarMapasFilas(listaSorteo.getMapa());		
		listaSeries.crearEstructura();
		listaSeries.poblarMapaSeries(listaFilas.getLista());
		listaPatrones.crearEstructura();
		listaPatrones.poblarMapasPatrones(listaSeries.getMapa());
		//listaPatrones.mostrarMapas();
		//listaSorteo.mostrarMapa();
		//listaFilas.mostrarMapas();
		listaSeries.mostrarMapa();		

	}

}//fin clase
 