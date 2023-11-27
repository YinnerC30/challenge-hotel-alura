package logica.controller;

import logica.modelo.Cliente;
import logica.modelo.Reservacion;
import logica.modelo.Usuario;
import views.Login;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static sun.util.logging.PlatformLogger.Bridge.convert;

public class Main {

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }

}
