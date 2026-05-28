package Principal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import utils.ConexionBBDD;
import vista.VistaCliente;
import vista.VistaPelicula;

public class Principal {
	public static void main(String[] args) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		do {
			System.out.println("1 Peliculas");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				
				System.out.println("=== Peliculas  ===");
				VistaPelicula vistaPelicula = new VistaPelicula();
				vistaPelicula.menuPeliculas();
				break;
			case 2:
				System.out.println("=== Cliente  ===");
				VistaCliente vistaCliente = new VistaCliente();
				vistaCliente.menuCliente();
				break;
			
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}
}