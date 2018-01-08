package datos;
import java.sql.*;

public class Conexion {

	private String baseDatos;
	private String usuario;
	private String password;	
	private Connection conexion;	
	
	public Conexion() {
		
		baseDatos = "jdbc:mysql://localhost/ksi";
		usuario = "desarrollo";
		password = "desarrollo"; 		
		
	}
	
	public Connection iniciarConexion() {
		
		try {
			
			conexion = DriverManager.getConnection(baseDatos,usuario,password);
			
		} catch (SQLException e) {
			
			System.out.println("Error al conectar con base de datos.");
			
		}
		
		return conexion;
		
	}	
	

	public void cerrarConexion(Connection conexion) {

		try {
			
			conexion.close();
			
		}catch(Exception e) {
			
			System.out.println("Error al cerrar conexion con base de datos.");
			
		};	
		
	}	

}//fin clase
