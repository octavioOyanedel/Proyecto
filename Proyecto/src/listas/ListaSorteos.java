package listas;
import java.util.*;
import clases.*;

public class ListaSorteos {
	
	private HashMap<Integer,Object> mapa;
	private Estructura estructura;	
	private Mostrar mostrar;
	private Poblar poblar;
		
	public ListaSorteos() {
				
		mapa = new HashMap<Integer,Object>();		
		
	}

	public void poblarMapaSorteos() {
		
		poblar = new Poblar();
		poblar.poblarMapaSorteos(mapa);
		
	}
	
	public void mostrarMapa() {
		
		mostrar = new Mostrar();
		mostrar.mostrarMapa(mapa);
		
	}
	
	public void crearEstructura() {
		
		int flag = 1;
		estructura = new Estructura();
		estructura.crearEstructura(mapa,flag);
		
	}
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}		

}//fin clase
