package listas;
import clases.*;
import java.util.*;

public class ListaFilas {
	
	private ArrayList<Object> lista;
	private Estructura estructura;
	private Mostrar mostrar;
	private Poblar poblar;
	
	public ListaFilas() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void poblarMapasFilas(HashMap<Integer,Object> mapa) {
		
		poblar = new Poblar();
		poblar.poblarMapasFilas(mapa,lista);
		
	}
	
	public void crearEstructura() {
		
		int flag = 2;
		estructura = new Estructura();
		estructura.crearEstructura(lista, flag);
		
	}
	
	public void mostrarMapas() {
		
		mostrar = new Mostrar();
		mostrar.mostrarMapas(lista);
		
	}

	public ArrayList<Object> getLista() {
		
		return lista;
		
	}

}//fin clase