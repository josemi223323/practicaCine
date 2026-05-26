package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBBDD;

public class PeliculaDAO {
	public ArrayList<PeliculaDTO> listarPeliculas() {

		ArrayList<PeliculaDTO> listaPeliculas = new ArrayList<PeliculaDTO>();

		Connection conexion = ConexionBBDD.getConexion();

		try {
			String sql = "SELECT * FROM peliculas";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				int duracion = rs.getInt("duracion");
				int anio = rs.getInt("anio");
				PeliculaDTO pelicula = new PeliculaDTO(id,titulo,genero,duracion,anio);
				listaPeliculas.add(pelicula);
			}

			conexion.close();
			return listaPeliculas;

		} catch (SQLException e) {
			e.printStackTrace();
			return listaPeliculas;
		}

	}

	public Boolean insertarPeliculas(PeliculaDTO nuevaPelicula) {
		Connection conexion = ConexionBBDD.getConexion();

		try {
			String sql = "INSERT INTO ";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				int duracion = rs.getInt("duracion");
				int anio = rs.getInt("anio");
				PeliculaDTO pelicula = new PeliculaDTO(id,titulo,genero,duracion,anio);
				listaPeliculas.add(pelicula);
			}

			conexion.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
