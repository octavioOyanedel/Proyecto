package listas;
import java.util.*;
import clases.*;

public class ListaSeries {
	
	private HashMap<Integer,Object> mapa;
	private Estructura estructura;
	private Mostrar mostrar;
	private Poblar poblar;
	
	public ListaSeries() {
		
		mapa = new HashMap<Integer,Object>();
		
	}
	
	public void poblarMapaSeries(ArrayList<Object> lista) {
		
		poblar = new Poblar();
		poblar.poblarMapaSeries(mapa,lista);
		
	}
	
	public void crearEstructura() {
		
		estructura = new Estructura();
		estructura.crearEstructura(mapa);
				
	}
	
	public void mostrarMapa() {
		
		mostrar = new Mostrar();
		mostrar.mostrarMapa(mapa);
		
	}	
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}	
	
}//fin clase
