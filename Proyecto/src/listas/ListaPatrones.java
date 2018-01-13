package listas;
import clases.*;
import java.util.*;

public class ListaPatrones {

	private ArrayList<Object> lista;
	private ListaPatron listaPatron;
	private Mostrar mostrar;
	private Columna columna;
	
	public ListaPatrones() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void crearColeccionPatrones(HashMap<Integer,Object> mapa) {
		
		for(int i=0;i<Numero.getLargosorteo();i++) {
			
			listaPatron = new ListaPatron();
			int key = i+1;
			columna = (Columna)mapa.get(key);
			listaPatron.crearColeccionPatrones(columna.getLista());
			lista.add(listaPatron);

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
