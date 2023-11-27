package logica.test;

import logica.controller.ClienteController;

public class ClienteTest {


    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        clienteController.eliminar(1);
    }

}
