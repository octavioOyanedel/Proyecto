package listas;
import clases.*;
import java.util.*;

public class ListaBusquedas {
	
	private HashMap<Integer,Object> mapa;
	private Busqueda busqueda;
	private Numero numero;
	private Columna columna;
	private Mostrar mostrar;
	
	public ListaBusquedas() {
		
		mapa = new HashMap<Integer,Object>();
		
	}
	
	public void crearColeccionBusquedas(HashMap<Integer,Object> mapa) {
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			columna = (Columna)entry.getValue();
			obtenerBusqueda(columna.getLista(),entry.getKey());
			
		}
		
	}
	
	public void obtenerBusqueda(ArrayList<Object>lista,int key) {
		
		int posicionInicial = (lista.size() - (Numero.getLargopatron() - 1));
		int posicionFinal = lista.size()-1; 
		busqueda = new Busqueda();
		
		for(int i=posicionInicial;i<=posicionFinal;i++) {
		
			numero = (Numero)lista.get(i);
			busqueda.getLista().add(numero);
			
		}
		
		mapa.put(key, busqueda);
		
	}
	
	public void mostrarColeccion() {

		mostrar = new Mostrar();
		mostrar.mostrarMapa(mapa);
		
	}	
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}	

}//fin clase
