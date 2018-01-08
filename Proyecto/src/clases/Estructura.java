package clases;
import listas.*;
import java.util.*;
import datos.*;

public class Estructura {
	
	private Sorteo sorteo;	
	private Numero numero;
	private Fila fila;
	private Serie serie;
	private Consultas consulta;
	private ListaFila listaFila;
	private int sorteos;
	
	public Estructura() {
			 			
	}
	
	public void crearEstructura(HashMap<Integer,Object> mapa) {
		
		int key = 0;
		
		for(int i = 0;i < Numero.getLargototal();i++) {
			
			key = i + 1;
			
			serie = new Serie();			
			serie.crearEstructura();
			mapa.put(key, serie);
			
		}
		
	}
	
	public void crearEstructura(HashMap<Integer,Object> mapa,int flag) {
		
		int key = 0;
		consulta = new Consultas();
		sorteos = consulta.numeroFilas(consulta.obtenerResultadosConsulta(consulta.getSqlSorteos()));
		
		for(int i = 0;i < sorteos;i++) {
						
			key = i + 1;
			
			switch(flag) {
			
				case 1 :
					
					sorteo = new Sorteo();			
					sorteo.crearEstructura();
					mapa.put(key, sorteo);
					break;
					
				case 2 :
					
					fila = new Fila();			
					fila.crearEstructura();
					mapa.put(key, fila);
					break;	
					
				default : 
			    	 
					System.out.println("flag no valido");
					
			}			

		}
		
	}

	public void crearEstructura(ArrayList<Object> lista,int flag) {
		
		switch(flag) {
		
			case 1 :
				
				for(int i = 0;i < Numero.getLargototal();i++) {
					
					numero = new Numero();			
					lista.add(numero);
					
				}
				break;
				
			case 2 :
				
				for(int i = 0;i < Numero.getLargofila();i++) {
					
					listaFila = new ListaFila();
					listaFila.crearEstructura();
					lista.add(listaFila);
					
				}
				break;	
				
			case 3 :
				
				for(int i = 0;i < Numero.getLargofila();i++) {
					
					numero = new Numero();			
					lista.add(numero);
					
				}
				break;	
				
			case 4 :
				
				consulta = new Consultas();
				sorteos = consulta.numeroFilas(consulta.obtenerResultadosConsulta(consulta.getSqlSorteos()));
				
				for(int i = 0;i < sorteos;i++) {
					
					numero = new Numero();			
					lista.add(numero);
					
				}
				break;	
				
			default : 
		    	 
				System.out.println("flag no valido");
				
		}		
		
	}
		
}//fin clase
