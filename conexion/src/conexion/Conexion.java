package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_conexion", "", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
