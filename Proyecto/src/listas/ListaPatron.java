package listas;
import java.util.*;
import clases.*;

public class ListaPatron {

	private HashMap<Integer,Object> mapa;
	private Patron patron;
	private Numero numero;
	
	public ListaPatron() {
		
		mapa = new HashMap<Integer,Object>();
		
	}

	public void crearColeccionPatrones(ArrayList<Object> lista) {
		
		int key = 1;
		int factor = Numero.getLargopatron()/2;
		int posicionInicial = factor;
		int posicionFinal = lista.size()-1-factor;
		
		for(int i=posicionInicial;i<=posicionFinal;i++) {
			
			patron = new Patron();
			int posicionInicialPatron = i-factor;
			int posicionFinalPatron = i+factor;
			
			for(int j=posicionInicialPatron;j<=posicionFinalPatron;j++) {

				numero = (Numero)lista.get(j);
				patron.getLista().add(numero);
				
			}

			patron.getLista().add(new Numero(1));
			agregarPatron(patron,key);			
			key++;
			
		}
		
	}

	public void agregarPatron(Patron patron,int key) {

		if(existePatronEnMapa(patron)) {
			
			incrementarSuma(patron);
			
		}else {
			
			mapa.put(key, patron);
			
		}			
		
	}
	
	public void incrementarSuma(Patron patron) {
		
		int key = buscarKey(patron);
		Patron patronTemp;
		patronTemp = (Patron)mapa.get(key);
		numero = (Numero)patronTemp.getLista().get(Numero.getLargopatron());
		numero.setNumero(numero.getNumero()+1);
		
	}	
	
	public int buscarKey(Patron patron) {
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			if(compararPatrones((Patron)entry.getValue(),patron)) {
				
				return entry.getKey();
				
			}
			
		}
		
		return 0;
		
	}
	
	public boolean existePatronEnMapa(Patron patron) {
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			Patron patronMapa = (Patron)entry.getValue();
			
			if(compararPatrones(patronMapa,patron)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
		
	public boolean compararPatrones(Patron patronMapa,Patron patron) {
		
		int i = 0;
		Numero numeroAlmacenado = new Numero();
		Numero numeroCandidato = new Numero();
		
		while(i<Numero.getLargopatron()) {
			
			numeroAlmacenado = (Numero)patronMapa.getLista().get(i);
			numeroCandidato = (Numero)patron.getLista().get(i);
			
			if(numeroAlmacenado.getNumero() != numeroCandidato.getNumero()) {
				
				return false;
				
			}
			
			i++;
			
		}
		
		return true;
		
	}
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}	
	
}//fin clase
