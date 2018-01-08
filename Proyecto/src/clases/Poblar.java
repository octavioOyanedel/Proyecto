package clases;
import java.util.*;
import datos.*;
import java.sql.*;

public class Poblar {
	
	private Consultas consulta;
	private Sorteo sorteo;
	private Numero numero;
	private ResultSet resultados;
	
	public Poblar() {
		
	}
	
	public void poblarMapaSorteos(HashMap<Integer,Object> mapa) {
		
		int key = 1;
		consulta = new Consultas();
		resultados = consulta.obtenerResultadosConsulta(consulta.getSqlSorteos());
		
		try {			

			while(resultados.next()) {
				
				sorteo = new Sorteo();
				sorteo = (Sorteo)mapa.get(key);
						
				for(int i = 2;i <= Numero.getLargosorteo();i++) {
					
					poblarListaSorteos(sorteo.getLista(),resultados.getInt(i));
									
				}				

				key++;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error al poblar mapaSorteos");
			
		}		
		
	}

	public void poblarListaSorteos(ArrayList<Object> lista,int numeroResultSet) {
		
		int posicion = numeroResultSet - 1;
		numero = (Numero)lista.get(posicion);
		numero.setNumero(numeroResultSet);
	}
	
}//fin clase
