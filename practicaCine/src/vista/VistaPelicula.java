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
			System.out.println("5. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("= VER TODOS LAS PELICULAS =");
				listar();
				break;
			case 2:
				System.out.println("= INSERTAR Pelicula =");
				insertarPelicula();
				break;
			case 3:
				System.out.println("= MODIFICAR pelicula =");
				actualizarPelicula();
				break;
			case 4:
				System.out.println("= BORRAR pelicula =");
				borrarPelicula();
				break;
			case 5:
				salir = true;
				break;
			}
		} while (!salir);
	}


	private void borrarPelicula() {
		
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		System.out.println("introduce los datos de la pelicula: ");
		int idPelicula = Lecturas.leerEntero("introduce el id de la pelicula que quieres actualizar");
		Boolean seEjecuto = controladorPelicula.borrarPelicula(idPelicula);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error al borrar los datos");
		}
	}


	private void actualizarPelicula() {
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		System.out.println("introduce los datos de la pelicula: ");
		int idPelicula = Lecturas.leerEntero("introduce el id de la pelicula que quieres actualizar");
		String nombre = Lecturas.leerString("Nombre de la pelicula");
		String genero = Lecturas.leerString("genero de la pelicula");
		int duracion = Lecturas.leerEntero("introduce la duracion de la pelicula");
		int anio = Lecturas.leerEntero("introduce el año de lanzamiento");
		PeliculaDTO nuevaPelicula = new PeliculaDTO(idPelicula,nombre,genero,duracion,anio);
		Boolean seEjecuto = controladorPelicula.actualizarPelicula(nuevaPelicula);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error insertar los datos");
		}
		
	}


	private void insertarPelicula() {
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		System.out.println("introduce los datos de la nueva pelicula: ");
		String nombre = Lecturas.leerString("Nombre de la pelicula");
		String genero = Lecturas.leerString("genero de la pelicula");
		int duracion = Lecturas.leerEntero("introduce la duracion de la pelicula");
		int anio = Lecturas.leerEntero("introduce el año de lanzamiento");
		PeliculaDTO nuevaPelicula = new PeliculaDTO(nombre,genero,duracion,anio);
		Boolean seEjecuto = controladorPelicula.insertarPelicula(nuevaPelicula);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error al insertar los datos");
		}
		
	}


	private void listar() {
		PeliculaControlador controladorPelicula = new PeliculaControlador();
		ArrayList<PeliculaDTO> peliculaDTO = controladorPelicula.listarPeliculas();
		peliculaDTO.forEach(pelicula -> System.out.println(pelicula));
		
	}

	

}
