package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectionDB {
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/basededatos";
	private static final String usuario = "root";
	private static final String clave = "mysql123";
	
	
	public Connection conectar(){
		Connection conexion = null;
		try {
			Class.forName(controlador);
			conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexion ok");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
			
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		
		return conexion;
	}
}


