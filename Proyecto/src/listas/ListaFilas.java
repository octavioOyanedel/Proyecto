package listas;
import clases.*;
import java.util.*;

public class ListaFilas {
	
	private ArrayList<Object> lista;
	private Estructura estructura;
	private Mostrar mostrar;
	
	public ListaFilas() {
		
		lista = new ArrayList<Object>();
		
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

}//fin clase