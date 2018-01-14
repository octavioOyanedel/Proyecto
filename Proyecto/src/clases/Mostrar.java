package clases;
import java.util.*;
import listas.*;

public class Mostrar {
	
	private Numero numero;
	private Patron patron;
	private Columna columna;
	private Busqueda busqueda;
	private ListaPatron listaPatron;
	private ListaCandidato listaCandidato;
	
	public Mostrar() {				
		
	}

	public void mostrarMapas(ArrayList<Object> lista) {

		if(lista.get(0) instanceof ListaPatron) {
			
			for(int i = 0;i < lista.size();i++) {
				
				listaPatron = (ListaPatron)lista.get(i);
				mostrarMapa(listaPatron.getMapa());
				System.out.println(); 

			}			
			
		}
		
		if(lista.get(0) instanceof ListaCandidato) {
		
			int numero = 0;
			for(int i = 0;i < lista.size();i++) {
				numero = i+1;
				System.out.println("Numero: "+numero); 
				listaCandidato = (ListaCandidato)lista.get(i);
				mostrarMapa(listaCandidato.getMapa());
				System.out.println(); 
	
			}
			
		}
		
	}
	
	public void mostrarMapa(HashMap<Integer,Object> mapa) {

		for(Map.Entry<Integer, Object> entry : mapa.entrySet()) {

			if(entry.getValue() instanceof Columna) {
				
				columna = (Columna)mapa.get(entry.getKey());
				mostrarMapa(columna.getLista());
				System.out.println("");	
			}
			
			if(entry.getValue() instanceof Patron) {
				
				patron = (Patron)mapa.get(entry.getKey());
				mostrarMapa(patron.getLista());
				System.out.println("");	
			}	
			
			if(entry.getValue() instanceof Busqueda) {
				
				busqueda = (Busqueda)mapa.get(entry.getKey());
				mostrarMapa(busqueda.getLista());
				System.out.println("");	
			}	
			
		}
		
	}
	
	public void mostrarMapa(ArrayList<Object> lista) {
		
		for(int i = 0; i < lista.size(); i++) {
			
			numero = (Numero)lista.get(i);
			System.out.print(formatoNumero(numero.getNumero()));
			
		}
		
	}
	
	public String formatoNumero(int numero) {
		
		String cadenaNumero = String.valueOf(numero);
		
		if(numero >= 0 && numero < 10) {
			
			String formato = "%02d";
			String cadena = String.format(formato, numero);
			cadena = "["+cadena+"]";
			return cadena;
		
		}
		
		cadenaNumero = "["+cadenaNumero+"]";
		return cadenaNumero;
		
	}		
	
}//fin clase
