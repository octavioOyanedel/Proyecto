package listas;
import clases.*;
import java.util.*;

public class ListaCandidatos {
	
	private ArrayList<Object> lista;
	private ListaCandidato listaCandidato;
	private ListaPatron listaPatron;
	private Busqueda busqueda;
	private Mostrar mostrar;

	public ListaCandidatos() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void crearColeccionCandidatos(HashMap<Integer,Object> mapaBusqueda,ArrayList<Object> listaPatrones) {
		
		for(Map.Entry<Integer, Object>entry : mapaBusqueda.entrySet()) {
			
			int indice = entry.getKey()-1;
			busqueda = (Busqueda)entry.getValue();
			listaPatron = (ListaPatron)listaPatrones.get(indice);
			listaCandidato = new ListaCandidato();
			listaCandidato.obtenerCandidatos(busqueda.getLista(),listaPatron.getMapa());
			lista.add(listaCandidato);
			
		}
		
	}
	
	public void mostrarColeccion() {

		mostrar = new Mostrar();
		mostrar.mostrarMapas(lista);
		
	}	
	
	public ArrayList<Object> getLista() {
		
		return lista;
		
	}	
	
}//fin clase
