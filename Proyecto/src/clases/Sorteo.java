package clases;
import java.util.*;

public class Sorteo {
	
	private ArrayList<Object> lista;
	private Estructura estructura;	
	
	public Sorteo() {
		
		lista = new ArrayList<Object>();
		
	}
	
	public void crearEstructura() {
		
		int flag = 1;
		estructura = new Estructura();
		estructura.crearEstructura(lista,flag);		
		
	}	
	
	public ArrayList<Object> getLista() {
		
		return lista;
		
	}	

}//fin clase
