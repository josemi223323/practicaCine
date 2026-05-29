package vista;

import java.util.ArrayList;

import controlador.ClienteControlador;
import modelo.ClienteDTO;
import utils.Lecturas;

public class VistaCliente {
	public void menuCliente() {
		boolean salir = false;
		do {
			System.out.println("\n=== CLIENTES ===");
			System.out.println("1. Ver todos los clientes ");
			System.out.println("2. Insertar Cliente ");
			System.out.println("3. Modificar Cliente ");
			System.out.println("4. Borrar Cliente");
			System.out.println("5. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opción: ", 1, 9);
			switch (opcion) {
			case 1:
				System.out.println("= VER TODOS LOS CLIENTES =");
				listarClientes();
				break;
			case 2:
				System.out.println("= INSERTAR Cliente =");
				insertarCliente();
				break;
			case 3:
				System.out.println("= MODIFICAR Cliente  =");
				actualizarCliente();
				break;
			case 4:
				System.out.println("= BORRAR Cliente  =");
				borrarCliente();
				break;
			case 5:
				salir = true;
				break;
			}
		} while (!salir);
	}


	private void borrarCliente() {
		
		ClienteControlador clienteControlador = new ClienteControlador();
		System.out.println("introduce los datos de la pelicula: ");
		int idCliente = Lecturas.leerEntero("introduce el id de la pelicula que quieres borrar");
		Boolean seEjecuto = clienteControlador.borrarCliente(idCliente);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error al borrar los datos");
		}
	}


	private void actualizarCliente() {
		ClienteControlador clienteControlador = new ClienteControlador();
		System.out.println("introduce los datos del cliente");
		int idCliente = Lecturas.leerEntero("introduce un id");
		String nombre = Lecturas.leerString("introduce el nombre del cliente");
		String email = Lecturas.leerString("introduce el correo del cliente");
		int telefono = Lecturas.leerEntero("introduce el numero de telefono");
		ClienteDTO nuevoCliente = new ClienteDTO(idCliente,nombre,email,telefono);
		Boolean seEjecuto = clienteControlador.actualizarCliente(nuevoCliente);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error al actualizar los datos");
		}
		
	}


	private void insertarCliente() {
		ClienteControlador clienteControlador = new ClienteControlador();
		System.out.println("introduce los datos del cliente");
		String nombre = Lecturas.leerString("introduce el nombre del cliente");
		String email = Lecturas.leerString("introduce el correo del cliente");
		int telefono = Lecturas.leerEntero("introduce el numero de telefono");
		ClienteDTO nuevoCliente = new ClienteDTO(nombre,email,telefono);
		Boolean seEjecuto = clienteControlador.insertarCliente(nuevoCliente);
		if(seEjecuto) {
			System.out.println("los datos se actualizaron");
		}else {
			System.out.println("hubo un error al insertar los datos");
		}
		
	}


	private void listarClientes() {
		ClienteControlador clienteControlador = new ClienteControlador();
		ArrayList<ClienteDTO> ListaClientes = clienteControlador.listarClientes();
		ListaClientes.forEach(clientes -> System.out.println(clientes));
	}

	

}
