package clases;
import listas.*;
import java.util.*;
import datos.*;
import java.sql.*;

public class Poblar {
	
	private Consultas consulta;
	private Sorteo sorteo;
	private Numero numero;
	private Numero numeroTemp;
	private Numero numeroCentro;
	private Numero numeroIzq;
	private Numero numeroDer;
	private Serie serie;
	private Fila fila;
	private Patron patron;
	private Estructura estructura;
	private ListaFila listaFila;
	private ListaPatron listaPatron;
	private ResultSet resultados;
	private int sorteos;
	
	public Poblar() {
		
	}

	public void poblarMapasPatrones(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {
		
		int key = 0;
		
		for(int i = 0;i <lista.size();i++) {
			
			key = i+1;
			serie = (Serie)mapa.get(key);
			listaPatron = (ListaPatron)lista.get(i);
			obtenerPatrones(serie.getLista(),listaPatron.getMapa());
			
		}
		
	}

	public void obtenerPatrones(ArrayList<Object> lista,HashMap<Integer,Object> mapa) {
		
		int inicio = 0;
		int fin = 0;
		int largoPatron = Numero.getLargopatron();
		int factor = obtenerFactor(largoPatron);
		consulta = new Consultas();
		sorteos = consulta.numeroFilas(consulta.obtenerResultadosConsulta(consulta.getSqlSorteos()));
		
		inicio = factor;
		fin = sorteos-factor;
		
		for(int i = inicio;i <= fin;i++ ) {
			
			armarPatronTemporal(mapa,lista,i,factor);
									
		}
		
	}

	public void armarPatronTemporal(HashMap<Integer,Object> mapa,ArrayList<Object> lista,int indice,int factor) {
		
		int flag = 6;		
		int posicionMedia = Numero.getLargopatron()/2;
		ArrayList<Object> listaPatronTemporal = new ArrayList<Object>();
		estructura = new Estructura();
		estructura.crearEstructura(listaPatronTemporal, flag);
		numero = (Numero)lista.get(indice);
		numeroCentro = (Numero)listaPatronTemporal.get(posicionMedia);
		numeroCentro.setNumero(numero.getNumero());
		armarPatronTemporalIzq(lista,listaPatronTemporal,indice,factor,posicionMedia);
		armarPatronTemporalDer(lista,listaPatronTemporal,indice,factor,posicionMedia);
		comprobarPatron(mapa,listaPatronTemporal);
		
	}

	public void comprobarPatron(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {
		
		int key = 0;
		
		if(mapa.isEmpty()) {

			agregarPatron(mapa,lista);
			
		}else {

			if(existePatron(mapa,lista)) {
				
				key = buscarKey(mapa,lista);
				
				if(key != 0) {
					
					incrementarPatron(mapa,key);
					
				}else {
					
					agregarPatron(mapa,lista);
					
				}
								
			}else {
				
				agregarPatron(mapa,lista);
				
			}
			
		}

	}
	
	public int buscarKey(HashMap<Integer,Object> mapa,ArrayList<Object> lista){
		
		int cont = 0;
		int control = Numero.getLargopatron();
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			patron = (Patron)entry.getValue();
			
			for(int i = 0;i < lista.size();i++) {
				
				numeroTemp = (Numero)lista.get(i);
				numero = (Numero)patron.getLista().get(i);
				
				if(numeroTemp.getNumero() == numero.getNumero()) {
					
					cont++;
					
				}
								
			}
			
			if(cont == control) {
				
				return entry.getKey();
				
			}
			
		}
				
		return 0;
		
	}

	public void agregarPatron(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {

		int flag = 7;
		int key = 0;
		patron = new Patron();
		estructura = new Estructura();
		estructura.crearEstructura(patron.getLista(), flag);
		copiarNumerosPatrones(lista,patron.getLista());
		numero = (Numero)patron.getLista().get(Numero.getLargopatron());
		numero.setNumero(numero.getNumero()+1);
		key = ultimaKey(mapa) + 1;
		mapa.put(key, patron);
		
	}
	
	public int ultimaKey(HashMap<Integer,Object> mapa) {
		
		int key = 0;
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			key = entry.getKey();
			
		}
		
		return key;
	}

	public void copiarNumerosPatrones(ArrayList<Object> listaTemp,ArrayList<Object> listaPatron) {

		for(int i  = 0; i < listaTemp.size();i++) {
			
			numeroTemp = (Numero)listaTemp.get(i);
			numero = (Numero)listaPatron.get(i);
			numero.setNumero(numeroTemp.getNumero());
						
		}
		
	}

	public boolean existePatron(HashMap<Integer,Object> mapa,ArrayList<Object> lista) {

		int cont = 0;
		int control = Numero.getLargopatron();
		
		for(Map.Entry<Integer, Object>entry : mapa.entrySet()) {
			
			patron = (Patron)entry.getValue();
			
			for(int i = 0;i < lista.size();i++) {
				
				numeroTemp = (Numero)lista.get(i);
				numero = (Numero)patron.getLista().get(i);
				
				if(numeroTemp.getNumero() == numero.getNumero()) {
					
					cont++;
					
				}
								
			}
			
			if(cont == control) {
				
				return true;
				
			}
			
		}
				
		return false;
		
	}
	
	public void incrementarPatron(HashMap<Integer,Object> mapa,int key) {
		
		patron = (Patron)mapa.get(key);
		numero = (Numero)patron.getLista().get(Numero.getLargopatron());
		numero.setNumero(numero.getNumero()+1);
	}
	
	public void armarPatronTemporalIzq(ArrayList<Object> lista,ArrayList<Object> listaTemp,int indice,int factor,int posicionMedia) {
		
		for(int i = 0;i < factor;i++ ) {
			
			numero = (Numero)lista.get(indice-1);
			numeroIzq = (Numero)listaTemp.get(posicionMedia-1);
			numeroIzq.setNumero(numero.getNumero());
			
		}
		
	}
	
	public void armarPatronTemporalDer(ArrayList<Object> lista,ArrayList<Object> listaTemp,int indice,int factor,int posicionMedia) {
		
		for(int i = 0;i < factor;i++ ) {
			
			numero = (Numero)lista.get(indice+1);
			numeroDer = (Numero)listaTemp.get(posicionMedia+1);
			numeroDer.setNumero(numero.getNumero());
			
		}		
		
	}	
	
	public int obtenerFactor(int largoPatron) {
		
		int factor = 0;
		
		switch(largoPatron) {
		
		case 3 :
			factor = 1;
			break;	
			
		case 5 :
			factor = 2;
			break;
			
		case 7 :
			factor = 3;
			break;	
			
		case 9 :
			factor = 4;
			break;	
			
		case 11 :
			factor = 5;
			break;	
			
		case 13 :
			factor = 6;
			break;	
			
		case 14 :
			factor = 7;
			break;	
			
		default : 
	    	 
			System.out.println("largoPatron no valido");	
		
		}
		
		return factor;
		
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
