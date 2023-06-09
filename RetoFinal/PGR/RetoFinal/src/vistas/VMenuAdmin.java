package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VMenuAdmin extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton sesionOf;
	private JButton crearApuestas;
	private JButton gestionarApuesta;
	private JButton insertarBDA;
	private JButton darBaja;
	private JButton modificar;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VMenuAdmin(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;

		setTitle("Retabet.es");
		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 479, 88);
		contentPanel.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 498, 479, 58);
		contentPanel.add(panel_1);

		sesionOf = new JButton("Cerrar Sesion");
		sesionOf.setForeground(new Color(173, 255, 47));
		sesionOf.setFont(new Font("Arial", Font.PLAIN, 14));
		sesionOf.setFocusable(false);
		sesionOf.setBorder(null);
		sesionOf.setBackground(Color.DARK_GRAY);
		sesionOf.setBounds(180, 11, 107, 36);
		sesionOf.addActionListener(this);
		panel_1.add(sesionOf);

		crearApuestas = new JButton("CREAR APUESTAS");
		crearApuestas.setForeground(new Color(173, 255, 47));
		crearApuestas.setFont(new Font("Arial", Font.BOLD, 18));
		crearApuestas.setFocusable(false);
		crearApuestas.setBorder(null);
		crearApuestas.setBackground(Color.DARK_GRAY);
		crearApuestas.setBounds(37, 158, 410, 35);
		crearApuestas.addActionListener(this);
		contentPanel.add(crearApuestas);

		gestionarApuesta = new JButton("GESTIONAR APUESTAS");
		gestionarApuesta.setForeground(new Color(173, 255, 47));
		gestionarApuesta.setFont(new Font("Arial", Font.BOLD, 18));
		gestionarApuesta.setFocusable(false);
		gestionarApuesta.setBorder(null);
		gestionarApuesta.setBackground(Color.DARK_GRAY);
		gestionarApuesta.setBounds(37, 218, 410, 35);
		gestionarApuesta.addActionListener(this);
		contentPanel.add(gestionarApuesta);

		insertarBDA = new JButton("INSERTAR NUEVOS JUGADORES,EQUIPOS...");
		insertarBDA.setForeground(new Color(173, 255, 47));
		insertarBDA.setFont(new Font("Arial", Font.BOLD, 18));
		insertarBDA.setFocusable(false);
		insertarBDA.setBorder(null);
		insertarBDA.setBackground(Color.DARK_GRAY);
		insertarBDA.setBounds(37, 278, 410, 35);
		insertarBDA.addActionListener(this);
		contentPanel.add(insertarBDA);

		darBaja = new JButton("DAR DE BAJA (JUGADORES,EQUIPOS...)");
		darBaja.setForeground(new Color(173, 255, 47));
		darBaja.setFont(new Font("Arial", Font.BOLD, 18));
		darBaja.setFocusable(false);
		darBaja.setBorder(null);
		darBaja.setBackground(Color.DARK_GRAY);
		darBaja.setBounds(37, 337, 410, 35);
		darBaja.addActionListener(this);
		contentPanel.add(darBaja);

		modificar = new JButton("MODIFICAR INFORMACION(JUGADORES...)");
		modificar.setForeground(new Color(173, 255, 47));
		modificar.setFont(new Font("Arial", Font.BOLD, 18));
		modificar.setFocusable(false);
		modificar.setBorder(null);
		modificar.setBackground(Color.DARK_GRAY);
		modificar.setBounds(37, 396, 410, 35);
		modificar.addActionListener(this);
		contentPanel.add(modificar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta + "\\src\\fotos\\fondoAdmin.jpg"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Depende del boton pulsado se abrira la ventana en la que se realizara el
		// metedo escogido
		if (e.getSource().equals(sesionOf)) {
			cerrarSesion();
		}
		if (e.getSource().equals(crearApuestas)) {
			crearApuestas();
		}
		if (e.getSource().equals(gestionarApuesta)) {
			gestionarApuestas();
		}
		if (e.getSource().equals(insertarBDA)) {
			insertarBDA();
		}
		if (e.getSource().equals(darBaja)) {
			darBaja();
		}
		if (e.getSource().equals(modificar)) {
			modificar();
		}
	}

	private void modificar() {
		// TODO Auto-generated method stub
		VModificar vent = new VModificar(vElegir, true, dao, cuenta);
		this.dispose();
		vent.setVisible(true);
	}

	private void darBaja() {
		// TODO Auto-generated method stub
		VDarBaja vent = new VDarBaja(vElegir, true, dao, cuenta);
		this.dispose();
		vent.setVisible(true);
	}

	private void insertarBDA() {
		// TODO Auto-generated method stub
		VInsertarBDA vent = new VInsertarBDA(vElegir, true, dao, cuenta);
		this.dispose();
		vent.setVisible(true);
	}

	private void gestionarApuestas() {
		// TODO Auto-generated method stub
		VGestionarApuestas vent = new VGestionarApuestas(vElegir, true, dao, cuenta);
		this.dispose();
		vent.setVisible(true);
	}

	private void crearApuestas() {
		// TODO Auto-generated method stub
		VElegirApuesta vent = new VElegirApuesta(vElegir, true, dao, cuenta);
		this.dispose();
		vent.setVisible(true);
	}

	//metodo para cerrar sesion, se enviara a la apanalla de iniciar sesion
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		this.dispose();
		VInicioSesion vent = new VInicioSesion(vElegir, true, dao);
		vent.setVisible(true);
	}

}
