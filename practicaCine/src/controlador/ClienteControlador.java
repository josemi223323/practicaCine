package controlador;

import java.util.ArrayList;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

public class ClienteControlador {

	public ArrayList<ClienteDTO> listarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarClientes();
	}

	public Boolean insertarCliente(ClienteDTO nuevoCliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.insertarClientes(nuevoCliente);
	}

	public Boolean actualizarCliente(ClienteDTO nuevoCliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.actualizarClientes(nuevoCliente);
	}

	public Boolean borrarCliente(int idCliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.borrarClientes(idCliente);
	}

}
