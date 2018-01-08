package clases;
import java.util.*;

public class Serie {
	
	private ArrayList<Object> lista;
	private Estructura estructura;
	
	public Serie() {
		
		lista = new ArrayList<Object>();
		
	}

	public void crearEstructura() {
		
		int flag = 4;
		estructura = new Estructura();
		estructura.crearEstructura(lista,flag);
		
	}
	
	public ArrayList<Object> getLista() {
		
		return lista;
		
	}

}//fin clase