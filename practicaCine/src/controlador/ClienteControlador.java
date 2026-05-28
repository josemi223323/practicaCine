package controlador;

import java.util.ArrayList;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

public class ClienteControlador {

	public ArrayList<ClienteDTO> listarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarClientes();
	}

	public static Boolean insertartarCliente(ClienteDTO nuevoCliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.insertarClientes(nuevoCliente);
	}

}
