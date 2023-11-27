package logica.dao;

import logica.modelo.Cliente;
import logica.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Usuario usuario) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "INSERT INTO users "
                            + "(name, last_name, password)"
                            + " VALUES (?,?, ?)" , Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setString(1, usuario.getName());
                statement.setString(2, usuario.getLast_name());
                statement.setString(3, usuario.getPassword());
                //statement.setBoolean(4, usuario.getIs_active());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        usuario.setId_user(resultSet.getInt(1));

                        System.out.printf("Fue insertado el producto: %s%n", usuario);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Usuario> listar() {
        List<Usuario> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement =
                    con.prepareStatement(
                            "SELECT " +
                                    "name, " +
                                    "last_name, " +
                                    "password " +
                                    "FROM users" +
                                    "WHERE is_active = 1");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new Usuario(
                                        resultSet.getString("name"),
                                        resultSet.getString("last_name"),
                                        resultSet.getString("password")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement =
                    con.prepareStatement("UPDATE users SET is_active = 0 WHERE id_user = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String name, String last_name, String password, Integer id_user) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE clients SET "
                            + " name = ?, "
                            + " last_name = ?,"
                            + " password = ?"
                            + " WHERE id_user = ?");

            try (statement) {
                statement.setString(1, name);
                statement.setString(2, last_name);
                statement.setString(3, password);
                statement.setInt(4, id_user);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUsuario(String name, String password) {
        try (Connection connection = con) {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT id_user FROM users WHERE name = ? and password = ? and is_active = 1"
            );

            try (statement) {
                statement.setString(1, name);
                statement.setString(2, password);
                statement.execute();

                try (ResultSet resultSet = statement.getResultSet()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


