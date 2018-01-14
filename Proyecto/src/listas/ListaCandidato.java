package listas;
import java.util.*;
import clases.*;

public class ListaCandidato {
	
	private HashMap<Integer,Object> mapa;
	private Patron patron;
	
	public ListaCandidato() {
		
		mapa = new HashMap<Integer,Object>();
		
	}
	
	public void obtenerCandidatos(ArrayList<Object> lista,HashMap<Integer,Object> mapaPatrones) {
		
		int key = 1;
		
		for(Map.Entry<Integer, Object>entry : mapaPatrones.entrySet()) {
			
			patron = (Patron)entry.getValue();
			
			if(compararListas(lista,patron.getLista())) {

				mapa.put(key, patron);
				
			}
			
			key++;
			
		}
		
	}
	
	public boolean compararListas(ArrayList<Object>listaBusqueda,ArrayList<Object>listaPatron) {
		
		int posicionFinal = Numero.getLargopatron()-2;
		Numero numeroBusqueda;
		Numero numeropatron;
		
		for(int i=0;i<=posicionFinal;i++) {
			
			numeroBusqueda = (Numero)listaBusqueda.get(i);
			numeropatron = (Numero)listaPatron.get(i);
			
			if(numeroBusqueda.getNumero() != numeropatron.getNumero()) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}

	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}	
	
}//fin clase
