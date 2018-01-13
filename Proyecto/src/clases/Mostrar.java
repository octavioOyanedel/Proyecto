package clases;
import java.util.*;
import listas.*;

public class Mostrar {
	
	private Numero numero;
	private Patron patron;
	private Columna columna;
	private ListaPatron listaPatron;
	
	public Mostrar() {				
		
	}

	public void mostrarMapas(ArrayList<Object> lista) {

		for(int i = 0;i < lista.size();i++) {
			
			listaPatron = (ListaPatron)lista.get(i);
			mostrarMapa(listaPatron.getMapa());
			System.out.println(); 

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
