package logica.dao;

import logica.modelo.Reservacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservacionDAO {

    private final Connection con;

    public ReservacionDAO(Connection con) {
        this.con = con;
    }

    public Integer guardar(Reservacion reservacion) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "INSERT INTO reservations" +
                            "(date_of_entry, " +
                            "date_of_exit, " +
                            "value_stay_price, " +
                            "form_payment, " +
                            "total)"
                            + " VALUES (?, ?,?,?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setDate(1, reservacion.getDate_of_entry());
                statement.setDate(2, reservacion.getDate_of_exit());
                statement.setFloat(3, reservacion.getValue_stay_price());
                statement.setString(4, reservacion.getForm_payment());
                statement.setFloat(5, reservacion.getTotal());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        reservacion.setId_reservation(resultSet.getInt(1));
                        return reservacion.getId_reservation();

                        //System.out.printf("Fue insertado el producto: %s%n", reservacion);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Reservacion> listar() {
        List<Reservacion> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement =
                    con.prepareStatement("select " +
                            "id_reservation, " +
                            "date_of_entry, " +
                            "date_of_exit, " +
                            "value_stay_price, " +
                            "form_payment " +
                            "from reservations " +
                            "where  is_active = 1;");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new Reservacion(
                                        resultSet.getInt("id_reservation"),
                                        resultSet.getDate("date_of_entry"),
                                        resultSet.getDate("date_of_exit"),
                                        resultSet.getFloat("value_stay_price"),
                                        resultSet.getString("form_payment")
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
                    con.prepareStatement("UPDATE reservations SET is_active = 0 WHERE id_reservation = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(Integer id_client, Date date_of_entry, Date date_of_exit, float value_stay_price, String form_payment, float total, Integer id_reservation) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE reservations SET "
                            + " date_of_entry = ?,"
                            + " date_of_exit = ?,"
                            + " value_stay_price = ?,"
                            + " form_payment = ?,"
                            + " total = ?"
                            + " WHERE id_reservation = ?");

            try (statement) {
                statement.setDate(1, date_of_entry);
                statement.setDate(2, date_of_exit);
                statement.setFloat(3, value_stay_price);
                statement.setString(4, form_payment);
                statement.setFloat(5, total);
                statement.setInt(6, id_reservation);
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


