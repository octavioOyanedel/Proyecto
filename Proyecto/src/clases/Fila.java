package clases;
import java.util.*;

public class Fila {

	private ArrayList<Object> lista;
	private Estructura estructura;	
	
	public Fila() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void crearEstructura() {
		
		int flag = 3;
		estructura = new Estructura();
		estructura.crearEstructura(lista, flag);
		
	}
	
	public ArrayList<Object> getLista() {
		
		return lista;
		
	}	
	
}//fin clase