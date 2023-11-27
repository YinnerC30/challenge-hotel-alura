package logica.controller;


import logica.dao.ClienteDAO;
import logica.factory.ConnectionFactory;
import logica.modelo.Cliente;

import java.sql.Date;
import java.util.List;

public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController() {
        var factory = new ConnectionFactory();
        this.clienteDAO = new ClienteDAO(factory.recuperaConexion());
    }

    public int modificar(String name, String last_name, Date date_of_birth, String nacionality, String telephone, Integer id) {
        return clienteDAO.modificar(name, last_name, date_of_birth, nacionality, telephone, id);
    }

    public int eliminar(Integer id_client) {
        return clienteDAO.eliminar(id_client);
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }

    public void guardar(Cliente cliente) {
        clienteDAO.guardar(cliente);
    }


}

