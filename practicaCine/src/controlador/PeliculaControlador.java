package controlador;

import java.util.ArrayList;

import modelo.PeliculaDAO;
import modelo.PeliculaDTO;

public class PeliculaControlador {
	public ArrayList<PeliculaDTO> listarPeliculas(){
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.listarPeliculas();
	}

	public ArrayList<PeliculaDTO> insertarPelicula(PeliculaDTO nuevaPelicula) {
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		return peliculaDAO.insertarPeliculas(nuevaPelicula);
	}

}
