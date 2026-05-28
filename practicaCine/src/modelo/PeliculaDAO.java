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
			String sql = "INSERT INTO cine.peliculas(titulo,genero,duracion,anio) VALUES (?,?,?,?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nuevaPelicula.getTitulo());
			ps.setString(2, nuevaPelicula.getGenero());
			ps.setInt(3, nuevaPelicula.getDuracion());
			ps.setInt(4, nuevaPelicula.getAnio());
			int rs = ps.executeUpdate();

			conexion.close();
			return rs > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Boolean actualizarPeliculas(PeliculaDTO nuevaPelicula) {
		Connection conexion = ConexionBBDD.getConexion();

		try {
			String sql = "UPDATE cine.peliculas SET titulo = ?, genero = ?, duracion = ?, anio = ? WHERE id = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, nuevaPelicula.getTitulo());
			ps.setString(2, nuevaPelicula.getGenero());
			ps.setInt(3, nuevaPelicula.getDuracion());
			ps.setInt(4, nuevaPelicula.getAnio());
			ps.setInt(5, nuevaPelicula.getId());
			int rs = ps.executeUpdate();

			conexion.close();
			return rs > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean borrarPeliculas(int idPelicula) {
		Connection conexion = ConexionBBDD.getConexion();
		try {
			String sql = "DELETE FROM cine.peliculas where id = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, idPelicula);
			int rs = ps.executeUpdate();

			conexion.close();
			return rs > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
