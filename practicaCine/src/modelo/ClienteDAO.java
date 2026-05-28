package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.ConexionBBDD;

public class ClienteDAO {

	public ArrayList<ClienteDTO> listarClientes() {
		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();

		Connection conexion = ConexionBBDD.getConexion();

		try {
			String sql = "SELECT * FROM clientes";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				int telefono = rs.getInt("telefono");
				ClienteDTO clienteNuevo = new ClienteDTO(id,nombre,email,telefono);
				listaClientes.add(clienteNuevo);
			}

			conexion.close();
			return listaClientes;

		} catch (SQLException e) {
			e.printStackTrace();
			return listaClientes;
		}
	}

	public Boolean insertarClientes(ClienteDTO nuevoCliente) {
		String telefonoTexto = Integer.toString(nuevoCliente.getTelefono());
		String correoTexto = nuevoCliente.getEmail();
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
				  "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		Pattern pattern = Pattern.compile(emailPattern);
		if (correoTexto != null) {
			Matcher matcher = pattern.matcher(correoTexto);
		if (matcher.matches()) {
		}else {
			 System.out.println("El correo no es valido");
			 return false;
		}
		}
		if(telefonoTexto.length() > 9 || telefonoTexto.length() < 9) {
			System.out.println("el numero tiene que tener 9 digitos");
			return false;
		}

		Connection conexion = ConexionBBDD.getConexion();
		try {
			String sql = "INSERT INTO cine.clientes(nombre,email,telefono) VALUES (?'?'?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nuevoCliente.getNombre());
			ps.setString(2, nuevoCliente.getEmail());
			ps.setInt(3, nuevoCliente.getTelefono());
			int rs = ps.executeUpdate();
			conexion.close();
			if(rs > 0) {
				return true;
			}
			return false;

			

			
			

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
