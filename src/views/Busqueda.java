package views;

import logica.controller.ClienteController;
import logica.controller.ReservacionController;
import logica.modelo.Cliente;
import logica.modelo.Reservacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private final JPanel contentPane;
    private final JTextField txtBuscar;
    private final JTable tbHuespedes;
    private final JTable tbReservas;
    private final DefaultTableModel modelo;
    private final DefaultTableModel modeloHuesped;
    private final JLabel labelAtras;
    private final JLabel labelExit;
    int xMouse, yMouse;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(331, 62, 280, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);


        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas no sean editables
            }
        };
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        tbReservas.setModel(modelo);

        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        ReservacionController reservacionController = new ReservacionController();
        List<Reservacion> listaReservaciones = reservacionController.listar();

        for (Reservacion reserva : listaReservaciones) {
            Object[] datos = new Object[]{reserva.getId_reservation(), reserva.getDate_of_entry(), reserva.getDate_of_exit(), reserva.getValue_stay_price(), reserva.getForm_payment()};
            modelo.addRow(datos);
        }



        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHuesped = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas no sean editables
            }
        };

        modeloHuesped.addColumn("Número de Huesped");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Número de Reserva");

        tbHuespedes.setModel(modeloHuesped);

        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        ClienteController clienteController = new ClienteController();
        List<Cliente> listaClientes = clienteController.listar();

        for (Cliente cliente : listaClientes) {
            Object[] datos = new Object[]{cliente.getId_client(), cliente.getName(), cliente.getLast_name(), cliente.getDate_of_birth(), cliente.getNacionality(), cliente.getTelephone(), cliente.getId_reservation()};
            modeloHuesped.addRow(datos);
        }


        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indexTab = panel.getSelectedIndex();
                String indiceRegistro = txtBuscar.getText();

                if (indexTab == 0) {

                    if (modelo.getRowCount() == 0) {
                        ReservacionController reservacionController = new ReservacionController();
                        List<Reservacion> reservacions = reservacionController.listar();

                        for (Reservacion reserva : reservacions) {
                            Object[] datos = new Object[]{reserva.getId_reservation(), reserva.getDate_of_entry(), reserva.getDate_of_exit(), reserva.getValue_stay_price(), reserva.getForm_payment()};
                            modelo.addRow(datos);
                        }
                    }

                    if (!indiceRegistro.trim().isEmpty()) {
                        modelo.setRowCount(0);
                        List<Reservacion> reservacions = new ReservacionController().buscarRegistros(indiceRegistro);
                        for (Reservacion reserva : reservacions) {
                            Object[] datos = new Object[]{reserva.getId_reservation(), reserva.getDate_of_entry(), reserva.getDate_of_exit(), reserva.getValue_stay_price(), reserva.getForm_payment()};
                            modelo.addRow(datos);
                        }
                    }
                }

                else {
                    if (modeloHuesped.getRowCount() == 0) {
                        ClienteController clienteController = new ClienteController();
                        List<Cliente> listaClientes = clienteController.listar();

                        for (Cliente cliente : listaClientes) {
                            Object[] datos = new Object[]{cliente.getId_client(), cliente.getName(), cliente.getLast_name(), cliente.getDate_of_birth(), cliente.getNacionality(), cliente.getTelephone(), cliente.getId_reservation()};
                            modeloHuesped.addRow(datos);
                        }
                    }

                    if (!indiceRegistro.trim().isEmpty()) {
                        modeloHuesped.setRowCount(0);
                        List<Cliente> listaResultados = new ClienteController().buscarRegistros(indiceRegistro);
                        for (Cliente cliente : listaResultados) {
                            Object[] datos = new Object[]{cliente.getId_client(), cliente.getName(), cliente.getLast_name(), cliente.getDate_of_birth(), cliente.getNacionality(), cliente.getTelephone(), cliente.getId_reservation()};
                            modeloHuesped.addRow(datos);
                        }
                    }
                }


            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexTab = panel.getSelectedIndex();
				int indiceFilaSeleccionada;
				int idRegistro;
				if (indexTab == 0) {
					indiceFilaSeleccionada = tbReservas.getSelectedRow();

                    if (indiceFilaSeleccionada != -1) { // Verifica si hay una fila seleccionada
                        int cantidadColumnas = tbReservas.getColumnCount();
                        Object[] datosFila = new Object[cantidadColumnas];

                        for (int columna = 0; columna < cantidadColumnas; columna++) {
                            datosFila[columna] = tbReservas.getValueAt(indiceFilaSeleccionada, columna);
                        }

                        Reservacion reservacion = convertToReservation(datosFila);
                        dispose();
                        ReservasView reservasView = new ReservasView(reservacion);
                        reservasView.setVisible(true);
                    } else {
                        System.out.println("No hay fila seleccionada.");
                    }

				} else {
                    indiceFilaSeleccionada = tbHuespedes.getSelectedRow();

                    if (indiceFilaSeleccionada != -1) { // Verifica si hay una fila seleccionada
                        int cantidadColumnas = tbHuespedes.getColumnCount();
                        Object[] datosFila = new Object[cantidadColumnas];

                        for (int columna = 0; columna < cantidadColumnas; columna++) {
                            datosFila[columna] = tbHuespedes.getValueAt(indiceFilaSeleccionada, columna);
                        }

                        Cliente cliente = convertToClient(datosFila);
                        dispose();
                        RegistroHuesped registroHuesped = new RegistroHuesped(cliente);
                        registroHuesped.setVisible(true);
                    } else {
                        System.out.println("No hay fila seleccionada.");
                    }
				}

			}
		});

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indexTab = panel.getSelectedIndex();
				int indiceFilaSeleccionada;
				int idRegistro;
                if (indexTab == 0) {
                    indiceFilaSeleccionada = tbReservas.getSelectedRow();
					idRegistro = (int) tbReservas.getValueAt(indiceFilaSeleccionada, 0);
					new ReservacionController().eliminar(idRegistro);
					dispose();
					Busqueda busqueda = new Busqueda();
					busqueda.setVisible(true);

                } else {
                    indiceFilaSeleccionada = tbHuespedes.getSelectedRow();
					idRegistro = (int) tbHuespedes.getValueAt(indiceFilaSeleccionada, 0);
					new ClienteController().eliminar(idRegistro);
					dispose();
					Busqueda busqueda = new Busqueda();
					busqueda.setVisible(true);
                }




            }
        });
    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    public Reservacion convertToReservation(Object[] datos) {
        Integer id_reservation = (Integer) datos[0];
        Date date_of_entry = (Date) datos[1];
        java.sql.Date dateOfEntry = new java.sql.Date(date_of_entry.getTime());
        Date date_of_exit = (Date) datos[2];
        java.sql.Date dateOfExit = new java.sql.Date(date_of_exit.getTime());
        float value_of_stay = (float) datos[3];
        String form_payment = (String) datos[4];

        return new Reservacion(id_reservation, dateOfEntry, dateOfExit, value_of_stay, form_payment);


    }

    public Cliente convertToClient(Object[] datos) {
        Integer id_client = (Integer) datos[0];
        String name = (String) datos[1];
        String last_name = (String) datos[2];
        Date dateOfBirth = (Date) datos[3];
        java.sql.Date date_of_birth = new java.sql.Date(dateOfBirth.getTime());
        String nacionality = (String) datos[4];
        String telephone = (String) datos[5];
        Integer id_reservation = (Integer) datos[6];

        return new Cliente(id_client, name, last_name, date_of_birth, nacionality, telephone, id_reservation);


    }
}
