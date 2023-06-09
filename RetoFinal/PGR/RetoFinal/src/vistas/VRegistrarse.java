package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import modelo.Dao;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;

/**
 * @author Grupo3
 *
 */
public class VRegistrarse extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField fCaducidad;
	private JTextField cvv;
	private JPasswordField pin;
	private JTextField saldo;
	private JTextField nTarjeta;
	private JPasswordField contrasenia;
	private JTextField email;
	private JTextField nombre;
	private JButton Volver;
	private JButton Crear;
	private Dao dao;
	private VElegir vElegir;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 */
	public VRegistrarse(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);

		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;

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

		Volver = new JButton("Volver");
		Volver.setForeground(new Color(173, 255, 47));
		Volver.setBackground(Color.DARK_GRAY);
		Volver.setFont(new Font("Arial", Font.PLAIN, 14));
		Volver.setBounds(51, 11, 107, 36);
		Volver.setBorder(null);
		Volver.setFocusable(false);
		Volver.addActionListener(this);
		panel_1.add(Volver);

		Crear = new JButton("Crear");
		Crear.setBackground(Color.DARK_GRAY);
		Crear.setForeground(new Color(173, 255, 47));
		Crear.setFont(new Font("Arial", Font.PLAIN, 14));
		Crear.setBounds(313, 11, 115, 37);
		Crear.setBorder(null);
		Crear.setFocusable(false);
		Crear.addActionListener(this);
		panel_1.add(Crear);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		lblNombre.setBounds(53, 115, 112, 35);
		contentPanel.add(lblNombre);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 18));
		lblEmail.setBounds(53, 161, 112, 35);
		contentPanel.add(lblEmail);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 18));
		lblContrasea.setBounds(53, 207, 112, 35);
		contentPanel.add(lblContrasea);

		JLabel lblNtarjeta = new JLabel("Nº Tarjeta:");
		lblNtarjeta.setForeground(Color.WHITE);
		lblNtarjeta.setFont(new Font("Arial", Font.BOLD, 18));
		lblNtarjeta.setBounds(53, 253, 112, 35);
		contentPanel.add(lblNtarjeta);

		JLabel lblFechaCaducidad = new JLabel("Fecha Caducidad:");
		lblFechaCaducidad.setForeground(Color.WHITE);
		lblFechaCaducidad.setFont(new Font("Arial", Font.BOLD, 18));
		lblFechaCaducidad.setBounds(53, 299, 162, 35);
		contentPanel.add(lblFechaCaducidad);

		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Arial", Font.BOLD, 18));
		lblCvv.setBounds(53, 345, 112, 35);
		contentPanel.add(lblCvv);

		JLabel lblPin = new JLabel("PIN:");
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Arial", Font.BOLD, 18));
		lblPin.setBounds(53, 391, 112, 35);
		contentPanel.add(lblPin);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 18));
		lblSaldo.setBounds(53, 437, 112, 35);
		contentPanel.add(lblSaldo);

		fCaducidad = new JFormattedTextField();
		fCaducidad.setFont(new Font("Arial", Font.PLAIN, 18));
		fCaducidad.setBounds(225, 299, 210, 35);
		contentPanel.add(fCaducidad);
		fCaducidad.setBorder(null);
		fCaducidad.setColumns(10);
		fCaducidad.setToolTipText("Formato MM/AAAA");

		cvv = new JTextField();
		cvv.setFont(new Font("Arial", Font.PLAIN, 18));
		cvv.setColumns(10);
		cvv.setBounds(225, 345, 210, 35);
		cvv.setBorder(null);
		contentPanel.add(cvv);

		pin = new JPasswordField();
		pin.setFont(new Font("Arial", Font.PLAIN, 18));
		pin.setColumns(10);
		pin.setBounds(225, 391, 210, 35);
		pin.setBorder(null);
		contentPanel.add(pin);

		saldo = new JTextField();
		saldo.setFont(new Font("Arial", Font.PLAIN, 18));
		saldo.setColumns(10);
		saldo.setBounds(225, 437, 210, 35);
		saldo.setBorder(null);
		contentPanel.add(saldo);

		nTarjeta = new JTextField();
		nTarjeta.setFont(new Font("Arial", Font.PLAIN, 18));
		nTarjeta.setColumns(10);
		nTarjeta.setBounds(225, 253, 210, 35);
		nTarjeta.setBorder(null);
		contentPanel.add(nTarjeta);

		contrasenia = new JPasswordField();
		contrasenia.setFont(new Font("Arial", Font.PLAIN, 18));
		contrasenia.setColumns(10);
		contrasenia.setBounds(225, 207, 210, 35);
		contrasenia.setBorder(null);
		contentPanel.add(contrasenia);

		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(225, 161, 210, 35);
		email.setBorder(null);
		contentPanel.add(email);

		nombre = new JTextField();
		nombre.setBackground(new Color(255, 255, 255));
		nombre.setFont(new Font("Arial", Font.PLAIN, 18));
		nombre.setColumns(10);
		nombre.setBounds(225, 115, 210, 35);
		nombre.setBorder(null);
		contentPanel.add(nombre);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Fondo2.jpg"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(Volver)) {
			volver();
		}
		if (e.getSource().equals(Crear)) {
			registrar();
		}
	}

	private void registrar() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Usuario user;
		String error = controlar(formateador);

		if (error == "") {
			user = new Usuario();
			user.setNombreCuenta(nombre.getText());
			user.setEmail(email.getText());
			user.setContrasenia(contrasenia.getText());
			user.setnTarjeta(Long.parseLong(nTarjeta.getText()));
			user.setFechaCaducidad(LocalDate.parse("01/" + fCaducidad.getText(), formateador));
			user.setCvv(cvv.getText());
			user.setPin(pin.getText());
			user.setSaldo(Float.parseFloat(saldo.getText()));

			if (dao.registrar(user)) {
				JOptionPane.showMessageDialog(this, "LA CUENTA SE HA CREADO CORRECTAMENTE.");
				this.dispose();
				VInicioSesion vent = new VInicioSesion(vElegir, true, dao);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "LA CUENTA NO SE HA CREADO CORRECTAMENTE");
			}
		} else {
			JOptionPane.showMessageDialog(this, error);
		}

	}

	/**
	 * @param formateador
	 * @return
	 */
	private String controlar(DateTimeFormatter formateador) {
		// TODO Auto-generated method stub
		String error = "";

		// Controlar que no hay un usuario con ese nombre ya introducido
		String usuario = dao.buscarNombre(nombre.getText());
		if (!nombre.getText().equalsIgnoreCase("")) {
			if (nombre.getText().length() > 25 || nombre.getText().length() == 0) {
				error += "EL NOMBRE DE USUARIO ES INCORRECTO.\n";
				nombre.setBackground(new Color(255, 0, 0));
			} else if (usuario != null) {
				error += "El NOMBRE DE USARIO YA EXISTE.\n";
				nombre.setBackground(new Color(255, 0, 0));
			} else if (nombre.getText().length() > 0 && usuario == null) {
				nombre.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR UN NOMBRE DE USUARIO.\n";
			nombre.setBackground(new Color(255, 0, 0));
		}

		// Controlar si la contraseña esta introducida correctamente
		if (!contrasenia.getText().equalsIgnoreCase("")) {
			if (contrasenia.getText().length() > 25) {
				error += "LA CONTRASEÑA ES DEMASIADO GRANDE.\n";
				contrasenia.setBackground(new Color(255, 0, 0));
			} else if (contrasenia.getText().length() < 8) {
				error += "LA CONTRASEÑA DEBE TENER AL MENOS 8 CARACTERES.\n";
				contrasenia.setBackground(new Color(255, 0, 0));
			} else if (contrasenia.getText().length() >= 8 && contrasenia.getText().length() <= 25) {
				contrasenia.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR UNA CONTRASEÑA.\n";
			contrasenia.setBackground(new Color(255, 0, 0));
		}

		// Controlar si el pin esta introducido correctamente
		if (!pin.getText().equalsIgnoreCase("")) {
			if (pin.getText().length() > 4) {
				error += "EL PIN ES DEMASIADO GRANDE.\n";
				pin.setBackground(new Color(255, 0, 0));
			} else if (pin.getText().length() < 4) {
				error += "EL PIN ES DEMASIADO GRANDE.\n";
				pin.setBackground(new Color(255, 0, 0));
			} else if (pin.getText().length() == 4) {
				pin.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL PIN DE LA TARJETA.\n";
			pin.setBackground(new Color(255, 0, 0));
		}

		// Controlar si el cvv esta introducido correctamente
		if (!cvv.getText().equalsIgnoreCase("")) {
			if (cvv.getText().length() > 3) {
				error += "EL CVV ES DEMASIADO GRANDE.\n";
				cvv.setBackground(new Color(255, 0, 0));
			} else if (cvv.getText().length() < 3) {
				error += "EL CVV ES DEMASIADO GRANDE.\n";
				cvv.setBackground(new Color(255, 0, 0));
			} else if (cvv.getText().length() == 3) {
				cvv.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL CVV DE LA TARJETA.\n";
			cvv.setBackground(new Color(255, 0, 0));
		}

		// Controlar si el cvv esta introducido correctamente
		if (!nTarjeta.getText().equalsIgnoreCase("")) {
			if (nTarjeta.getText().length() > 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO GRANDE.\n";
				nTarjeta.setBackground(new Color(255, 0, 0));
			} else if (nTarjeta.getText().length() < 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO PEQUEÑO.\n";
				nTarjeta.setBackground(new Color(255, 0, 0));
			} else if (nTarjeta.getText().length() == 16) {
				nTarjeta.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL NUMERO DE LA TARJETA.\n";
			nTarjeta.setBackground(new Color(255, 0, 0));
		}

		// Controlar si la fecha es posterior a el dia que se introduce
		LocalDate fecha;

		if (!fCaducidad.getText().equalsIgnoreCase("")) {
			try {
				fecha = LocalDate.parse("01/" + fCaducidad.getText(), formateador);

				if (fecha.isBefore(LocalDate.now())) {
					error += "LA FECHA DEBE SER POSTERIOR A HOY\n";
					fCaducidad.setBackground(new Color(255, 0, 0));
				} else if (fecha.isAfter(LocalDate.now())) {
					fCaducidad.setBackground(new Color(173, 255, 47));
				}
			} catch (DateTimeParseException p) {
				error += "LA FECHA DEBE SER INTRODUCIDA EN FORMATO: MM/AAAA\n";
				fCaducidad.setBackground(new Color(255, 0, 0));

			}
		} else {
			error += "DEBES INTRODUCIR UNA FECHA POSTERIOR A LA DE HOY.\n";
			fCaducidad.setBackground(new Color(255, 0, 0));
		}

		// Controlar que el saldo sea mayor que 0
		if (!saldo.getText().equalsIgnoreCase("")) {
			if (Float.parseFloat(saldo.getText()) >= 0) {
				saldo.setBackground(new Color(173, 255, 47));
			} else {
				error += "EL SALDO DEBE SER SUPERIOR o IGUAL A 0€.\n";
				saldo.setBackground(new Color(255, 0, 0));
			}
		} else {
			error += "MINIMO DEBES INTRODUCIR UN 0 EN SALDO.\n";
			saldo.setBackground(new Color(255, 0, 0));
		}

		// Contorlar que se introduce un email
		if (!email.getText().equalsIgnoreCase("")) {
			Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
			Matcher matcher = pattern.matcher(email.getText());

			if (email.getText().equalsIgnoreCase(dao.buscarEmail(email.getText()))) {
				error += "El EMAIL INTRODUCIDO YA EXISTE.\n";
				email.setBackground(new Color(255, 0, 0));
				return error;
			} else if (matcher.matches()) {
				email.setBackground(new Color(173, 255, 47));
				return error;
			} else {
				error += "EMAIL INTRODUCIDO INCORRECTAMENTE.\n";
				email.setBackground(new Color(255, 0, 0));
				return error;
			}
		} else {
			error += "INTRODUCE UN EMAIL.\n";
			email.setBackground(new Color(255, 0, 0));
			return error;
		}
	}

	//Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		vElegir.setExtendedState(Frame.NORMAL);
	}
}
