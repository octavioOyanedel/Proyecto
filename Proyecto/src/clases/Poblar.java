package clases;
import listas.*;
import java.util.*;
import datos.*;
import java.sql.*;

public class Poblar {
	
	private Consultas consulta;
	private Sorteo sorteo;
	private Numero numero;
	private Serie serie;
	private Fila fila;
	private ListaFila listaFila;
	private ResultSet resultados;
	
	public Poblar() {
		
	}
	
	public void poblarMapaSeries(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {
		
		for(int i=0;i < lista.size();i++) {
			
			listaFila = (ListaFila)lista.get(i);
			poblarMapaSeries(listaFila.getMapa(),mapa,i);
			
		}
		
	}
	
	public void poblarMapaSeries(HashMap<Integer,Object> mapaFilas,HashMap<Integer,Object> mapaSeries,int indice) {
		
		int key = 0;
		
		switch(indice) {
		
			case 0 :
				key = 1;
				break;	
				
			case 1 :
				key = 6;
				break;	
				
			case 2 :
				
				key = 11;
				break;	
			case 3 :
				
				key = 16;
				break;	
			case 4 :
				
				key = 21;
				break;	
			default : 
				
		    	 
				System.out.println("indice no valido");	
				
		}

		poblarMapaSeries(mapaFilas,mapaSeries,key,indice);
		
	}
	
	public void poblarMapaSeries(HashMap<Integer,Object> mapaFilas,HashMap<Integer,Object> mapaSeries,int key,int indice){		
		
		int posicion;
		
		for(int i=0;i < Numero.getLargofila();i++) {
			
			posicion = 0;
			
			for(Map.Entry<Integer, Object>entry : mapaFilas.entrySet()) {
				
				fila = (Fila)entry.getValue();
				numero = (Numero)fila.getLista().get(i);
				poblarMapaSeries(mapaSeries,numero,key,posicion);
				posicion++;
			}		
			
			key++;
			
		}
						
	}
	
	public void poblarMapaSeries(HashMap<Integer,Object> mapa,Numero numeroFila,int key,int posicion) {
		
		serie = (Serie)mapa.get(key);
		numero = (Numero)serie.getLista().get(posicion);
		numero.setNumero(numeroFila.getNumero());
		
	}
	
	public void poblarMapasFilas(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {
		
		for(int i = 0;i < Numero.getLargofila();i++) {
			
			listaFila = (ListaFila)lista.get(i);
			poblarMapasFilas(listaFila.getMapa(),mapa,i);
			
		}
		
	}
	
	public void poblarMapasFilas(HashMap<Integer,Object> mapaFilas,HashMap<Integer,Object> mapaSorteos,int indice){
		
		int inicio = 0;
		int fin = 0;
		int key;
		
		switch(indice) {
	
			case 0 :
				
				inicio = 0;
				fin = 4;
				break;
				
			case 1 :
				
				inicio = 5;
				fin = 9;	
				break;
				
			case 2 :
				
				inicio = 10;
				fin = 14;	
				break;
				
			case 3 :
				
				inicio = 15;
				fin = 19;	
				break;
				
			case 4 :
				
				inicio = 20;
				fin = 24;	
				break;
				
			default : 
		    	 
				System.out.println("indice no valido");		
		}
		
		for(Map.Entry<Integer, Object>entry : mapaSorteos.entrySet()) {
			
			sorteo = (Sorteo)entry.getValue();
			key = entry.getKey();
			poblarMapasFilas(mapaFilas,sorteo.getLista(),key,inicio,fin);
			
		}
		
	}
	
	public void poblarMapasFilas(HashMap<Integer,Object> mapa,ArrayList<Object> lista,int key,int inicio,int fin) {
		
		int indice = 0;
		Numero numeroFila;
		Numero numeroSorteo;
		
		fila = (Fila)mapa.get(key);
		
		for(int i = inicio;i <= fin;i++) {
			
			numeroSorteo = (Numero)lista.get(i);
			numeroFila = (Numero)fila.getLista().get(indice);
			numeroFila.setNumero(numeroSorteo.getNumero());
			indice++;
			
		}
		
	}
	
	public void poblarMapaSorteos(HashMap<Integer,Object> mapa) {
		
		int key = 1;
		consulta = new Consultas();
		resultados = consulta.obtenerResultadosConsulta(consulta.getSqlSorteos());
		
		try {			

			while(resultados.next()) {
				
				sorteo = new Sorteo();
				sorteo = (Sorteo)mapa.get(key);
						
				for(int i = 2;i <= Numero.getLargosorteo();i++) {
					
					poblarListaSorteos(sorteo.getLista(),resultados.getInt(i));
									
				}				

				key++;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error al poblar mapaSorteos");
			
		}		
		
	}

	public void poblarListaSorteos(ArrayList<Object> lista,int numeroResultSet) {
		
		int posicion = numeroResultSet - 1;
		numero = (Numero)lista.get(posicion);
		numero.setNumero(numeroResultSet);
	}
	
}//fin clase
