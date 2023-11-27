package logica.dao;

import logica.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private final Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Cliente cliente) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "INSERT INTO clients "
                            + "(name, last_name, date_of_birth, nacionality, telephone, id_reservation)"
                            + " VALUES (?,?, ?, ?, ?,?)");

            try (statement) {

                statement.setString(1, cliente.getName());
                statement.setString(2, cliente.getLast_name());
                statement.setDate(3, cliente.getDate_of_birth());
                statement.setString(4, cliente.getNacionality());
                statement.setString(5, cliente.getTelephone());
                statement.setInt(6, cliente.getId_reservation());

                statement.execute();

                System.out.print("Fue insertado el cliente: " + cliente.getName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listar() {
        List<Cliente> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement =
                    con.prepareStatement(
                            "select cl.id_client, cl.name, cl.last_name, cl.date_of_birth, cl.nacionality, cl.telephone, re.id_reservation\n" +
                                    "from clients cl\n" +
                                    "inner join reservations re on cl.id_reservation = re.id_reservation where cl.is_active = 1 and re.is_active = 1;");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new Cliente(
                                        resultSet.getInt("id_client"),
                                        resultSet.getString("name"),
                                        resultSet.getString("last_name"),
                                        resultSet.getDate("date_of_birth"),
                                        resultSet.getString("nacionality"),
                                        resultSet.getString("telephone"),
                                        resultSet.getInt("id_reservation")
                                ));
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
                    con.prepareStatement("UPDATE clients SET is_active = 0 WHERE id_client = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String name, String last_name, Date date_of_birth, String nacionality, String telephone, Integer id_client) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE clients SET "
                            + " name = ?, "
                            + " last_name = ?,"
                            + " date_of_birth = ?,"
                            + " nacionality = ?,"
                            + " telephone = ?,"
                            + " WHERE id_client = ?");

            try (statement) {
                statement.setString(1, name);
                statement.setString(2, last_name);
                statement.setDate(3, date_of_birth);
                statement.setString(4, nacionality);
                statement.setString(5, telephone);
                statement.setInt(6, id_client);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
