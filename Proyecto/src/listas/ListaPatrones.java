package listas;
import clases.*;
import java.util.*;

public class ListaPatrones {

	private ArrayList<Object> lista;
	private Estructura estructura;
	private Poblar poblar;
	
	public ListaPatrones() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void poblarMapasPatrones(HashMap<Integer,Object> mapa) {
		
		poblar = new Poblar();
		poblar.poblarMapasPatrones(mapa,lista);
		
	}
	
	public void crearEstructura() {
		
		int flag = 5;
		estructura = new Estructura();
		estructura.crearEstructura(lista, flag);
		
	}

	public ArrayList<Object> getLista() {
		
		return lista;
		
	}	
	
}//fin clase
