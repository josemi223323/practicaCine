package practicaCine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	public static Connection getConexion() {
		String servidor = "jdbc:mysql://localhost:3306/cine";

		String usuario = "root";
		String contraseña = "practicaroot";
		try {
			Connection conexion = DriverManager.getConnection(servidor, usuario, contraseña);
			return conexion;
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
			return null;
		}
	}
}