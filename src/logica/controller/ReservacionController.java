package logica.controller;

import logica.dao.ReservacionDAO;
import logica.factory.ConnectionFactory;
import logica.modelo.Reservacion;

import java.sql.Date;
import java.util.List;

public class ReservacionController {
    private final ReservacionDAO reservacionDAO;

    public ReservacionController() {
        var factory = new ConnectionFactory();
        this.reservacionDAO = new ReservacionDAO(factory.recuperaConexion());
    }

    public Integer guardar(Reservacion reservacion) {
        return reservacionDAO.guardar(reservacion);
    }

    public List<Reservacion> listar() {
        return reservacionDAO.listar();
    }

    public int modificar(Integer id_client,
                         Date date_of_entry,
                         Date date_of_exit,
                         float value_stay_price,
                         String form_payment,
                         float total,
                         Integer id_reservation) {

        return reservacionDAO.modificar(
                id_client,
                date_of_entry,
                date_of_exit,
                value_stay_price,
                form_payment,
                total,
                id_reservation);
    }

    public int eliminar(Integer id_reservation) {
        return reservacionDAO.eliminar(id_reservation);
    }


}
