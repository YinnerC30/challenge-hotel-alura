package views;

import com.toedter.calendar.JDateChooser;
import logica.controller.ReservacionController;
import logica.modelo.Reservacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@SuppressWarnings("serial")
public class ReservasView extends JFrame {

    private final JPanel contentPane;
    public static JTextField txtValor;
    public static JDateChooser txtFechaEntrada;
    public static JDateChooser txtFechaSalida;
    public static JComboBox<String> txtFormaPago;
    int xMouse, yMouse;
    private final JLabel labelExit;
    private final JLabel labelAtras;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //Reservacion reservacion = new Reservacion();
                    /*ReservasView frame = new ReservasView(1);
                    frame.setVisible(true);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReservasView() {
        super("Reserva");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);


        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        // Código que crea los elementos de la interfáz gráfica

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 195, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);

        JSeparator separator_1_3 = new JSeparator();
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 453, 289, 2);
        panel.add(separator_1_3);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 281, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_1);

        JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 136, 169, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 221, 187, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
        lblFormaPago.setForeground(SystemColor.textInactiveText);
        lblFormaPago.setBounds(68, 382, 187, 24);
        lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblFormaPago);

        JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
        lblTitulo.setBounds(109, 60, 219, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(lblTitulo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 140, 500, 409);
        panel_1.add(imagenFondo);
        imagenFondo.setBackground(Color.WHITE);
        imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));

        JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(72, 303, 196, 14);
        lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblValor);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 362, 289, 2);
        separator_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1);

        // Componentes para dejar la interfaz con estilo Material Design
        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(429, 0, 53, 36);
        panel_1.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
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
        panel.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MenuUsuario().setVisible(true);
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
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));

        JLabel lblSiguiente = new JLabel("SIGUIENTE");
        lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
        lblSiguiente.setForeground(Color.WHITE);
        lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblSiguiente.setBounds(0, 0, 122, 35);


        //Campos que guardaremos en la base de datos
        txtFechaEntrada = new JDateChooser();
        txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
        txtFechaEntrada.setBounds(68, 161, 289, 35);
        txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
        txtFechaEntrada.setBackground(Color.WHITE);
        txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
        txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
        txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
        panel.add(txtFechaEntrada);

        txtFechaSalida = new JDateChooser();
        txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
        txtFechaSalida.setBounds(68, 246, 289, 35);
        txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
        txtFechaSalida.setBackground(Color.WHITE);
        txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtFechaSalida.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        panel.add(txtFechaSalida);


        txtValor = new JTextField();
        txtValor.setColumns(10);
        txtValor.setBackground(Color.WHITE);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setForeground(Color.BLACK);
        txtValor.setBounds(78, 328, 280, 33);
        txtValor.setEditable(true);
        txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(txtValor);


        txtFormaPago = new JComboBox();
        txtFormaPago.setBounds(68, 417, 289, 38);
        txtFormaPago.setBackground(SystemColor.text);
        txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtFormaPago.setModel(new DefaultComboBoxModel(new String[]{"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
        panel.add(txtFormaPago);

        JPanel btnsiguiente = new JPanel();
        btnsiguiente.add(lblSiguiente);
        btnsiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                System.out.println(ReservasView.txtValor.getText());
                if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null &&
                        !ReservasView.txtValor.getText().trim().isEmpty()) {

                    try {
                        Reservacion reservacion = obtenerDatosFormulario();
                        dispose();
                        ReservacionController reservacionController = new ReservacionController();
                        Integer id_reservation = reservacionController.guardar(reservacion);
                        RegistroHuesped registro = new RegistroHuesped(id_reservation);
                        registro.setVisible(true);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor introducido no es numerico");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos, vuelve a intentarlo");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                }

            }
        });
        btnsiguiente.setLayout(null);
        btnsiguiente.setBackground(SystemColor.textHighlight);
        btnsiguiente.setBounds(238, 493, 122, 35);
        panel.add(btnsiguiente);
        btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


        txtFechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // Calcula la diferencia en días entre las dos fechas
                Long diasDeDiferencia = obtenerDiasDeDiferencia();

                if (diasDeDiferencia != null && diasDeDiferencia <= 0) {
                    JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto, la fecha de entrada debe ser inferior a la fecha de salida");
                    txtFechaEntrada.setDate(null);
                }
            }
        });

        txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {

                Long diasDeDiferencia = obtenerDiasDeDiferencia();

                if (diasDeDiferencia != null && diasDeDiferencia <= 0) {
                    JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto, la fecha de salida debe ser superior a la fecha de entrada");
                    txtFechaSalida.setDate(null);
                }
            }
        });


    }

    public ReservasView(Reservacion reservacion) {
        super("Reserva");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);


        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 910, 560);
        contentPane.add(panel);
        panel.setLayout(null);

        // Código que crea los elementos de la interfáz gráfica

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(SystemColor.textHighlight);
        separator_1_2.setBounds(68, 195, 289, 2);
        separator_1_2.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_2);

        JSeparator separator_1_3 = new JSeparator();
        separator_1_3.setForeground(SystemColor.textHighlight);
        separator_1_3.setBackground(SystemColor.textHighlight);
        separator_1_3.setBounds(68, 453, 289, 2);
        panel.add(separator_1_3);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(SystemColor.textHighlight);
        separator_1_1.setBounds(68, 281, 289, 11);
        separator_1_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1_1);

        JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
        lblCheckIn.setForeground(SystemColor.textInactiveText);
        lblCheckIn.setBounds(68, 136, 169, 14);
        lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckIn);

        JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
        lblCheckOut.setForeground(SystemColor.textInactiveText);
        lblCheckOut.setBounds(68, 221, 187, 14);
        lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblCheckOut);

        JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
        lblFormaPago.setForeground(SystemColor.textInactiveText);
        lblFormaPago.setBounds(68, 382, 187, 24);
        lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblFormaPago);

        JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
        lblTitulo.setBounds(109, 60, 219, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(lblTitulo);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(428, 0, 482, 560);
        panel_1.setBackground(new Color(12, 138, 199));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo = new JLabel("");
        logo.setBounds(197, 68, 104, 107);
        panel_1.add(logo);
        logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 140, 500, 409);
        panel_1.add(imagenFondo);
        imagenFondo.setBackground(Color.WHITE);
        imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));

        JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
        lblValor.setForeground(SystemColor.textInactiveText);
        lblValor.setBounds(72, 303, 196, 14);
        lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        panel.add(lblValor);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.textHighlight);
        separator_1.setBounds(68, 362, 289, 2);
        separator_1.setBackground(SystemColor.textHighlight);
        panel.add(separator_1);

        // Componentes para dejar la interfaz con estilo Material Design
        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setBounds(429, 0, 53, 36);
        panel_1.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setForeground(Color.WHITE);
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
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
        panel.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Busqueda busqueda = new Busqueda();
                busqueda.setVisible(true);
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
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));


        JLabel lblActulizar = new JLabel("ACTUALIZAR");
        lblActulizar.setHorizontalAlignment(SwingConstants.CENTER);
        lblActulizar.setForeground(Color.WHITE);
        lblActulizar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblActulizar.setBounds(0, 0, 122, 35);

        JPanel btnActualizar = new JPanel();
        btnActualizar.add(lblActulizar);
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null &&
                        !ReservasView.txtValor.getText().trim().isEmpty()) {

                    try {
                        Reservacion reservacionModificada = obtenerDatosFormulario();


                        ReservacionController reservacionController = new ReservacionController();
                        reservacionController.modificar(
                                reservacionModificada.getDate_of_entry(),
                                reservacionModificada.getDate_of_exit(),
                                reservacionModificada.getValue_stay_price(),
                                reservacionModificada.getForm_payment(),
                                reservacionModificada.getTotal(),
                                reservacion.getId_reservation());
                        dispose();
                        new Busqueda().setVisible(true);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor introducido no es numerico");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos, vuelve a intentarlo");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                }

            }
        });

        btnActualizar.setLayout(null);
        btnActualizar.setBackground(SystemColor.textHighlight);
        btnActualizar.setBounds(238, 493, 122, 35);
        panel.add(btnActualizar);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


        //Campos que guardaremos en la base de datos
        txtFechaEntrada = new JDateChooser();
        txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
        txtFechaEntrada.setBounds(68, 161, 289, 35);
        txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
        txtFechaEntrada.setBackground(Color.WHITE);
        txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
        txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
        txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
        txtFechaEntrada.setDate(reservacion.getDate_of_entry());
        panel.add(txtFechaEntrada);

        txtFechaSalida = new JDateChooser();
        txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
        txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
        txtFechaSalida.setBounds(68, 246, 289, 35);
        txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
        txtFechaSalida.setBackground(Color.WHITE);
        txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));

        txtFechaSalida.setDateFormatString("yyyy-MM-dd");
        txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        txtFechaSalida.setDate(reservacion.getDate_of_exit());
        panel.add(txtFechaSalida);

        txtValor = new JTextField();
        txtValor.setColumns(10);
        txtValor.setBackground(Color.WHITE);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setForeground(Color.BLACK);
        txtValor.setBounds(78, 328, 280, 33);
        txtValor.setEditable(true);
        txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
        txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        String valor = String.valueOf(reservacion.getValue_stay_price());
        txtValor.setText(valor);
        panel.add(txtValor);


        txtFormaPago = new JComboBox();
        txtFormaPago.setBounds(68, 417, 289, 38);
        txtFormaPago.setBackground(SystemColor.text);
        txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtFormaPago.setModel(new DefaultComboBoxModel(new String[]{"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
        txtFormaPago.setSelectedItem(reservacion.getForm_payment());
        panel.add(txtFormaPago);


        txtFechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // Calcula la diferencia en días entre las dos fechas
                Long diasDeDiferencia = obtenerDiasDeDiferencia();

                if (diasDeDiferencia != null && diasDeDiferencia <= 0) {
                    JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto, la fecha de entrada debe ser inferior a la fecha de salida");
                    txtFechaEntrada.setDate(null);
                }
            }
        });

        txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {

                Long diasDeDiferencia = obtenerDiasDeDiferencia();

                if (diasDeDiferencia != null && diasDeDiferencia <= 0) {
                    JOptionPane.showMessageDialog(null, "Rango de fechas incorrecto, la fecha de salida debe ser superior a la fecha de entrada");
                    txtFechaSalida.setDate(null);
                }
            }
        });
    }

    // Codigo para obtener información

    public Reservacion obtenerDatosFormulario() throws ParseException, NumberFormatException {
        Date fechaEntrada = txtFechaEntrada.getDate();
        java.sql.Date date_of_entry = new java.sql.Date(fechaEntrada.getTime());

        Date fechaSalida = txtFechaSalida.getDate();
        java.sql.Date date_of_exit = new java.sql.Date(fechaSalida.getTime());
        float value_stay_price = Float.parseFloat(txtValor.getText());
        String form_payment = (String) txtFormaPago.getSelectedItem();

        // Calcula la diferencia en días entre las dos fechas
        Long diasDeDiferencia = obtenerDiasDeDiferencia();

        return new Reservacion(
                date_of_entry,
                date_of_exit,
                value_stay_price,
                form_payment,
                value_stay_price * diasDeDiferencia
        );
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

    public Long obtenerDiasDeDiferencia() {
        if (txtFechaEntrada.getDate() != null && txtFechaSalida.getDate() != null) {
            Date fechaEntrada = txtFechaEntrada.getDate();
            Date fechaSalida = txtFechaSalida.getDate();

            java.sql.Date fecha1 = new java.sql.Date(fechaEntrada.getTime());
            java.sql.Date fecha2 = new java.sql.Date(fechaSalida.getTime());

            // Convierte las fechas java.sql.Date a java.time.LocalDate
            LocalDate localDate1 = fecha1.toLocalDate();
            LocalDate localDate2 = fecha2.toLocalDate();

            // Calcula la diferencia en días entre las dos fechas
            Long diasDeDiferencia = ChronoUnit.DAYS.between(localDate1, localDate2);
            return diasDeDiferencia;
        }
        return null;
    }


}
