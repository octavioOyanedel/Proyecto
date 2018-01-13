package listas;
import clases.*;
import datos.*;
import java.util.*;
import java.sql.*;

public class ListaColumnas {
	
	private HashMap<Integer,Object> mapa;
	private Columna columna;
	private Numero numero;
	private ResultSet resultados;
	private Consultas consulta;
	private Mostrar mostrar;
	
	public ListaColumnas() {
		
		mapa = new HashMap<Integer,Object>();
		
	}
	
	public void mostrarColeccion() {
		
		mostrar = new Mostrar();
		mostrar.mostrarMapa(mapa);
		
	}
	
	public void crearColeccionColumnas() {
		
		consulta = new Consultas();
		resultados = consulta.obtenerResultadosConsulta(consulta.getSqlSorteos());
		
		for(int i=1;i<=Numero.getLargosorteo();i++) {
			
			columna = new Columna();
			
			try {
				
				resultados.beforeFirst();
				
				while(resultados.next()) {
					
					int posicionColumna = i+1;			
					numero = new Numero();
					numero.setNumero(resultados.getInt(posicionColumna));
					columna.getLista().add(numero);
					
					
				}
				
			}catch(SQLException e) {
				
				System.out.println("Error en nmetodo crearColeccionColumnas");
				
			}	
			
			mapa.put(i, columna);

		}
		
	}
	
	public HashMap<Integer, Object> getMapa() {
		
		return mapa;
		
	}

}//fin clase
