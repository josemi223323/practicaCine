package vista;

import java.util.ArrayList;

import controlador.PeliculaControlador;
import modelo.PeliculaDTO;
import utils.Lecturas;

public class VistaPelicula {
	public void menuPeliculas() {
		boolean salir = false;
		do {
			System.out.println("\n=== CATEGORIAS ===");
			System.out.println("1. Ver todas las peliculas");
			System.out.println("2. Insertar Pelicula ");
			System.out.println("3. Modificar Categoria ");
			System.out.println("4. Borrar Categoria");
			System.out.println("9. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("= VER TODOS LAS CATEGORIAS =");
				listar();
				break;
			case 2:
				System.out.println("= INSERTAR Pelicula =");
				insertarPelicula();
				break;
			case 3:
				System.out.println("= MODIFICAR CATEGORIA (Por hacer) =");
		
				break;
			case 4:
				System.out.println("= BORRAR CATEGORIA (Por hacer) =");
			
				break;
			case 9:
				salir = true;
				break;
			}
		} while (!salir);
	}


	private void insertarPelicula() {
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		System.out.println("introduce los datos de la nueva pelicula: ");
		String nombre = Lecturas.leerString("Nombre de la pelicula");
		String genero = Lecturas.leerString("genero de la pelicula");
		int duracion = Lecturas.leerEntero("introduce la duracion de la pelicula");
		int anio = Lecturas.leerEntero("introduce el año de lanzamiento");
		PeliculaDTO nuevaPelicula = new PeliculaDTO(nombre,genero,duracion,anio);
		controladorPelicula.insertarPelicula(nuevaPelicula);
		
	}


	private void listar() {
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		ArrayList<PeliculaDTO> peliculaDTO = controladorPelicula.listarPeliculas();
		for(PeliculaDTO pelicula : peliculaDTO) {
			System.out.println(pelicula.toString());
		}
		
	}
	

}
