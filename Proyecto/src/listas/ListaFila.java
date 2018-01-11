package listas;
import java.util.*;
import clases.*;

public class ListaFila {
	
	private HashMap<Integer,Object> mapa;
	private Estructura estructura;	
	
	public ListaFila() {
		
		mapa = new HashMap<Integer,Object>();
		
	}
	
	public void crearEstructura() {
		
		int flag = 2;
		estructura = new Estructura();
		estructura.crearEstructura(mapa, flag);
		
	}
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}	
	
}//fin clase
