package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.Usuario;
import modelo.Dao;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * @author Grupo3
 *
 */
public class VIngresarDinero extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JButton ingresar;
	private JTextField ingreso;
	private JTextField tarjeta;
	private JTextField cvv;
	private JTextField fCaducidad;
	private JPasswordField pin;
	private List<Usuario> usuarios;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VIngresarDinero(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;
		this.usuarios = dao.listarUsuarios();

		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 255, 47));
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

		volver = new JButton("Volver");
		volver.setForeground(new Color(173, 255, 47));
		volver.setFont(new Font("Arial", Font.PLAIN, 14));
		volver.setFocusable(false);
		volver.setBorder(null);
		volver.setBackground(Color.DARK_GRAY);
		volver.setBounds(48, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		ingresar = new JButton("Ingresar");
		ingresar.setForeground(new Color(173, 255, 47));
		ingresar.setFont(new Font("Arial", Font.PLAIN, 14));
		ingresar.setFocusable(false);
		ingresar.setBorder(null);
		ingresar.setBackground(Color.DARK_GRAY);
		ingresar.setBounds(318, 11, 107, 36);
		ingresar.addActionListener(this);
		panel_1.add(ingresar);

		JLabel lblNewLabel_1 = new JLabel("Cantidad del ingreso:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 131, 230, 53);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Nº de la Tarjeta:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 218, 230, 53);
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("CVV/CVC:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 273, 230, 53);
		contentPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Caducidad:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(10, 329, 230, 53);
		contentPanel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("PIN:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(10, 434, 230, 53);
		contentPanel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_2 = new JLabel("AL SER EL INGRESO > 20 DEBES INTRODUCIR PIN");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 403, 479, 39);
		contentPanel.add(lblNewLabel_2);

		ingreso = new JTextField();
		/*
		 * añadimos un evento en el que si el ingreso que se quiere realizar es mayor a
		 * 20 se hace visible el apartado de pin
		 */
		ingreso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!ingreso.getText().equalsIgnoreCase("")) {
					try {
						if (Float.parseFloat(ingreso.getText()) > 20) {
							lblNewLabel_2.setVisible(true);
							lblNewLabel_1_4.setVisible(true);
							pin.setVisible(true);
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "NO PUEDES INTRODUCIR LETRAS.");
					}
				} else {
					lblNewLabel_2.setVisible(false);
					lblNewLabel_1_4.setVisible(false);
					pin.setVisible(false);
				}
			}
		});
		ingreso.setBounds(250, 140, 205, 38);
		contentPanel.add(ingreso);
		ingreso.setColumns(10);

		tarjeta = new JTextField();
		tarjeta.setColumns(10);
		tarjeta.setBounds(250, 227, 205, 38);
		contentPanel.add(tarjeta);

		cvv = new JTextField();
		cvv.setColumns(10);
		cvv.setBounds(250, 282, 205, 38);
		contentPanel.add(cvv);

		fCaducidad = new JTextField();
		fCaducidad.setColumns(10);
		fCaducidad.setBounds(250, 338, 205, 38);
		contentPanel.add(fCaducidad);

		pin = new JPasswordField();
		pin.setColumns(10);
		pin.setBounds(250, 443, 205, 38);
		contentPanel.add(pin);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 197, 479, 2);
		contentPanel.add(panel_2);

		lblNewLabel_2.setVisible(false);
		lblNewLabel_1_4.setVisible(false);
		pin.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 85, 479, 29);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		// metodo para que se muestre en pantalla el nombre de usuario y el dinero que
		// tiene la cuenta
		for (Usuario usuario : usuarios) {
			/*
			 * a medida que se va recorriendo el for, en caso de que codigo del usuario
			 * concuerden con el de la cuenta se guarda el nombre y el saldo de ella misma
			 */
			if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
				JLabel lblNombreC = new JLabel("Cuenta: " + cuenta.getNombreCuenta());
				lblNombreC.setHorizontalAlignment(SwingConstants.LEFT);
				lblNombreC.setFont(new Font("Arial", Font.BOLD, 12));
				lblNombreC.setForeground(new Color(173, 255, 47));
				lblNombreC.setBounds(10, 0, 223, 29);
				panel_3.add(lblNombreC);

				JLabel lblDineroEnLa = new JLabel("DINERO: " + usuario.getSaldo() + "€");
				lblDineroEnLa.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDineroEnLa.setFont(new Font("Arial", Font.BOLD, 12));
				lblDineroEnLa.setForeground(new Color(173, 255, 47));
				lblDineroEnLa.setBounds(246, 0, 223, 29);
				panel_3.add(lblDineroEnLa);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(volver)) {
			volver();
		}
		if (e.getSource().equals(ingresar)) {
			ingresar();
		}
	}

	// metodo para ingresar dinero en la cuenta
	private void ingresar() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String error = controlar(formateador);
		List<Usuario> usuarios = dao.listarUsuarios();

		if (error == "") {
			if (!pin.getText().equalsIgnoreCase("") && !cvv.getText().equalsIgnoreCase("")
					&& !tarjeta.getText().equalsIgnoreCase("") && !fCaducidad.getText().equalsIgnoreCase("")
					&& pin.isVisible()) {

				for (Usuario usuario : usuarios) {
					/*
					 * buscamos el usuario al que hay que introducirle el dinero, para ello deben
					 * coincidir todos los datos introducidos con la base de datos
					 */
					if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())
							&& usuario.getnTarjeta() == Long.parseLong(tarjeta.getText())
							&& usuario.getFechaCaducidad()
									.equals(LocalDate.parse("01/" + fCaducidad.getText(), formateador))
							&& usuario.getCvv().equals(cvv.getText()) && usuario.getPin().equals(pin.getText())) {

						// Pedimos al dao que ingrese el dinero en la cuenta, en caso de que no se
						// consiga ingresar se avisara de ello mediante un JoptionPane
						if (dao.ingresarDinero(cuenta, ingreso.getText())) {
							JOptionPane.showMessageDialog(this, "INGRESO HECHO CORRECTAMENTE.");
							ingreso.setText("");
							tarjeta.setText("");
							pin.setText("");
							cvv.setText("");
							fCaducidad.setText("");

							tarjeta.setBackground(Color.WHITE);
							pin.setBackground(Color.WHITE);
							cvv.setBackground(Color.WHITE);
							fCaducidad.setBackground(Color.WHITE);
						} else {
							JOptionPane.showMessageDialog(this,
									"NO SE HA CONSEGUIDO INGRESAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
						}

					} else {
						JOptionPane.showMessageDialog(this, "LOS DATOS NO COINCIDEN CON LO REGISTRADO EN SU CUENTA.");
					}
				}

			} else if (!pin.isVisible()) {
				for (Usuario usuario : usuarios) {
					if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())
							&& usuario.getnTarjeta() == Long.parseLong(tarjeta.getText())
							&& usuario.getFechaCaducidad()
									.equals(LocalDate.parse("01/" + fCaducidad.getText(), formateador))
							&& usuario.getCvv().equals(cvv.getText())) {

						if (dao.ingresarDinero(cuenta, ingreso.getText())) {
							JOptionPane.showMessageDialog(this, "INGRESO HECHO CORRECTAMENTE.");
							ingreso.setText("");
							tarjeta.setText("");
							pin.setText("");
							cvv.setText("");
							fCaducidad.setText("");

							tarjeta.setBackground(Color.WHITE);
							pin.setBackground(Color.WHITE);
							cvv.setBackground(Color.WHITE);
							fCaducidad.setBackground(Color.WHITE);

						} else {
							JOptionPane.showMessageDialog(this,
									"NO SE HA CONSEGUIDO INGRESAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
							tarjeta.setBackground(Color.WHITE);
							pin.setBackground(Color.WHITE);
							cvv.setBackground(Color.WHITE);
							fCaducidad.setBackground(Color.WHITE);
						}

					} else {
						JOptionPane.showMessageDialog(this, "LOS DATOS NO COINCIDEN CON LO REGISTRADO EN SU CUENTA.");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "DEBES RELLENAR TODOS LOS CAMPOS.");
			}

		} else {
			JOptionPane.showMessageDialog(this, error);
		}
	}

	//Metodo para controlar los datos introducidos
	/**
	 * @param formateador
	 * @return
	 */
	private String controlar(DateTimeFormatter formateador) {
		// TODO Auto-generated method stub
		String error = "";

		// Controlar si el pin esta introducido correctamente
		if (pin.isVisible()) {
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
		if (!tarjeta.getText().equalsIgnoreCase("")) {
			if (tarjeta.getText().length() > 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO GRANDE.\n";
				tarjeta.setBackground(new Color(255, 0, 0));
			} else if (tarjeta.getText().length() < 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO PEQUEÑO.\n";
				tarjeta.setBackground(new Color(255, 0, 0));
			} else if (tarjeta.getText().length() == 16) {
				tarjeta.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL NUMERO DE LA TARJETA.\n";
			tarjeta.setBackground(new Color(255, 0, 0));
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
		return error;
	}

	// Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
		vent.setVisible(rootPaneCheckingEnabled);
	}
}
