package datos;
import java.sql.*;

public class Consultas {
	
	private String sqlSorteos;
	
	public Consultas() {
		
		sqlSorteos = "SELECT * FROM testKino";//base de datos actualizada al 13 01 2018
		
	}
	
	public ResultSet obtenerResultadosConsulta(String consulta) {
		
		Conexion conexion = new Conexion();
		ResultSet resultado = null;
		
		try {
			
			PreparedStatement pst = conexion.iniciarConexion().prepareStatement(consulta);
			resultado = pst.executeQuery();
			
		}catch(SQLException e) {
			
			System.out.println("Error al consultar "+consulta);
			
		}finally {
			
			conexion.cerrarConexion(conexion.iniciarConexion());
			
		}
		
		return resultado;
		
	} 

	public int numeroFilas(ResultSet resultados) {

		int numero = 0;

		try {
			
			while(resultados.next()) {
				
				numero++;
				
			}
			
		}catch(SQLException e) {
			
			System.out.println("Error al obtener cantidad de filas de la consulta.");
			
		}
		
		return numero;
	}
	
	public int numeroColumnas(ResultSet resultados) {

		ResultSetMetaData manejoResultados;
		int numero = 0;

		try {
			
			manejoResultados = resultados.getMetaData();
			numero = manejoResultados.getColumnCount();
			
		}catch(SQLException e) {
			
			System.out.println("Error al obtener cantidad de columnas de la consulta.");
			
		}
		
		return numero;
	}

	public String getSqlSorteos() {
		
		return sqlSorteos;
		
	}	
	
}//fin clase
