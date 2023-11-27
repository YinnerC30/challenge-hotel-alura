package logica.controller;

import logica.dao.UsuarioDAO;
import logica.factory.ConnectionFactory;
import logica.modelo.Usuario;

import java.sql.Date;
import java.util.List;

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        var factory = new ConnectionFactory();
        this.usuarioDAO = new UsuarioDAO(factory.recuperaConexion());
    }

    public void guardar(Usuario usuario) {
        usuarioDAO.guardar(usuario);
    }

    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    public int modificar(String name, String last_name, String password, Integer id) {
        return usuarioDAO.modificar(name, last_name, password, id);
    }

    public int eliminar(Integer id_user) {
        return usuarioDAO.eliminar(id_user);
    }

    public Boolean loginUsuario(String name, String password) {
        return usuarioDAO.loginUsuario( name, password);
    }


}
