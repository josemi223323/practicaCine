package controlador;

import java.util.ArrayList;

import modelo.PeliculaDAO;
import modelo.PeliculaDTO;

public class PeliculaControlador {
	public ArrayList<PeliculaDTO> listarPeliculas(){
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.listarPeliculas();
	}

	public Boolean insertarPelicula(PeliculaDTO nuevaPelicula) {
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.insertarPeliculas(nuevaPelicula);
	}

	public Boolean actualizarPelicula(PeliculaDTO nuevaPelicula) {
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.actualizarPeliculas(nuevaPelicula);
	}

	public Boolean borrarPelicula(int idPelicula) {
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.borrarPeliculas(idPelicula);
	}

}
