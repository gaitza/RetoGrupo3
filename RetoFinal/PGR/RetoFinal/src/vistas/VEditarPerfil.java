package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.Equipo;
import clases.Usuario;
import modelo.Dao;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

/**
 * @author Grupo3
 *
 */
public class VEditarPerfil extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JButton confirmar;
	private JTextField nombreNuevo;
	private JTextField tarjetaNueva;
	private JTextField fCNueva;
	private JTextField cvvNuevo;
	private JPasswordField nuevaContra;
	private JPasswordField repetirContra;
	private JPasswordField pinNuevo;
	private JCheckBox tarjeta;
	private JCheckBox contrasenia;
	private JCheckBox nombre;
	private JPanel panelNombre;
	private JPanel panelContrasenia;
	private JPanel panelTarjeta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VEditarPerfil(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;

		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
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
		volver.setBounds(54, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		confirmar = new JButton("Confirmar Cambios");
		confirmar.setForeground(new Color(173, 255, 47));
		confirmar.setFont(new Font("Arial", Font.PLAIN, 14));
		confirmar.setFocusable(false);
		confirmar.setBorder(null);
		confirmar.setBackground(Color.DARK_GRAY);
		confirmar.setBounds(280, 11, 147, 36);
		confirmar.addActionListener(this);
		panel_1.add(confirmar);

		nombre = new JCheckBox("Nombre");
		nombre.setForeground(new Color(173, 255, 47));
		nombre.setFont(new Font("Arial", Font.PLAIN, 14));
		nombre.setBackground(Color.DARK_GRAY);
		nombre.setBounds(53, 151, 97, 23);
		nombre.addActionListener(this);
		contentPanel.add(nombre);

		contrasenia = new JCheckBox("Contraseña");
		contrasenia.setForeground(new Color(173, 255, 47));
		contrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
		contrasenia.setBackground(Color.DARK_GRAY);
		contrasenia.setBounds(186, 151, 115, 23);
		contrasenia.addActionListener(this);
		contentPanel.add(contrasenia);

		tarjeta = new JCheckBox("Datos tarjeta");
		tarjeta.setForeground(new Color(173, 255, 47));
		tarjeta.setFont(new Font("Arial", Font.PLAIN, 14));
		tarjeta.setBackground(Color.DARK_GRAY);
		tarjeta.setBounds(332, 151, 115, 23);
		tarjeta.addActionListener(this);
		contentPanel.add(tarjeta);

		JLabel lblNewLabel_1 = new JLabel("Que quieres editar?");
		lblNewLabel_1.setForeground(new Color(173, 255, 47));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 99, 459, 28);
		contentPanel.add(lblNewLabel_1);

		panelNombre = new JPanel();
		panelNombre.setBackground(Color.DARK_GRAY);
		panelNombre.setBounds(0, 181, 479, 58);
		contentPanel.add(panelNombre);
		panelNombre.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Nuevo nombre de usuario:");
		lblNewLabel_1_1.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 11, 233, 36);
		panelNombre.add(lblNewLabel_1_1);

		nombreNuevo = new JTextField();
		nombreNuevo.setBounds(253, 11, 203, 36);
		panelNombre.add(nombreNuevo);
		nombreNuevo.setColumns(10);

		panelContrasenia = new JPanel();
		panelContrasenia.setBackground(Color.DARK_GRAY);
		panelContrasenia.setBounds(0, 239, 479, 94);
		contentPanel.add(panelContrasenia);
		panelContrasenia.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nueva contraseña:");
		lblNewLabel_1_1_1.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 0, 233, 36);
		panelContrasenia.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Repite la contraseña:");
		lblNewLabel_1_1_1_5.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_5.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_5.setBounds(10, 47, 233, 36);
		panelContrasenia.add(lblNewLabel_1_1_1_5);

		nuevaContra = new JPasswordField();
		nuevaContra.setBounds(253, 0, 201, 36);
		panelContrasenia.add(nuevaContra);

		repetirContra = new JPasswordField();
		repetirContra.setBounds(253, 47, 201, 36);
		panelContrasenia.add(repetirContra);

		panelTarjeta = new JPanel();
		panelTarjeta.setBackground(Color.DARK_GRAY);
		panelTarjeta.setBounds(0, 331, 479, 167);
		contentPanel.add(panelTarjeta);
		panelTarjeta.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nueva tarjeta:");
		lblNewLabel_1_1_1_1.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_1.setBounds(10, 0, 233, 36);
		panelTarjeta.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Fecha Caducidad:");
		lblNewLabel_1_1_1_2.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_2.setBounds(10, 46, 233, 36);
		panelTarjeta.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("CVV:");
		lblNewLabel_1_1_1_3.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_3.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_3.setBounds(10, 93, 233, 36);
		panelTarjeta.add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Pin:");
		lblNewLabel_1_1_1_4.setForeground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_4.setBackground(new Color(173, 255, 47));
		lblNewLabel_1_1_1_4.setBounds(10, 131, 233, 36);
		panelTarjeta.add(lblNewLabel_1_1_1_4);

		tarjetaNueva = new JTextField();
		tarjetaNueva.setColumns(10);
		tarjetaNueva.setBounds(253, 5, 203, 30);
		panelTarjeta.add(tarjetaNueva);

		fCNueva = new JTextField();
		fCNueva.setColumns(10);
		fCNueva.setBounds(253, 46, 203, 30);
		panelTarjeta.add(fCNueva);

		cvvNuevo = new JTextField();
		cvvNuevo.setColumns(10);
		cvvNuevo.setBounds(253, 93, 203, 30);
		panelTarjeta.add(cvvNuevo);

		pinNuevo = new JPasswordField();
		pinNuevo.setBounds(253, 131, 203, 30);
		panelTarjeta.add(pinNuevo);

		panelNombre.setVisible(false);
		panelContrasenia.setVisible(false);
		panelTarjeta.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		opciones();
		if (e.getSource().equals(volver)) {
			volver();
		}
		if (e.getSource().equals(confirmar)) {
			confirmar();
		}

	}

	// Metodo para editar los datos de la cuenta introducida
	private void confirmar() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String error = controlar(formateador);
		Usuario editarU;
		List<Usuario> usuarios = dao.listarUsuarios();

		if (error == "") {

			// para editar los datos del perfil minimo debes cambiar un campo
			if (!nombreNuevo.getText().equalsIgnoreCase("") || !nuevaContra.getText().equalsIgnoreCase("")
					|| !pinNuevo.getText().equalsIgnoreCase("") || !cvvNuevo.getText().equalsIgnoreCase("")
					|| !tarjetaNueva.getText().equalsIgnoreCase("") || fCNueva.getText().equalsIgnoreCase("")) {
				editarU = new Usuario();
				if (!nuevaContra.getText().equalsIgnoreCase("")) {
					editarU.setContrasenia(nuevaContra.getText());
				} else {
					editarU.setContrasenia(cuenta.getContrasenia());
				}
				if (!nombreNuevo.getText().equalsIgnoreCase("")) {
					editarU.setNombreCuenta(nombreNuevo.getText());
				} else {
					editarU.setNombreCuenta(cuenta.getNombreCuenta());
				}
				if (!pinNuevo.getText().equalsIgnoreCase("") && !cvvNuevo.getText().equalsIgnoreCase("")
						&& !tarjetaNueva.getText().equalsIgnoreCase("") && !fCNueva.getText().equalsIgnoreCase("")
						&& tarjeta.isSelected()) {

					editarU.setnTarjeta(Long.parseLong(tarjetaNueva.getText()));
					editarU.setCvv(cvvNuevo.getText());
					editarU.setPin(pinNuevo.getText());
					editarU.setFechaCaducidad(LocalDate.parse("01/" + fCNueva.getText(), formateador));

				} else if (!tarjeta.isSelected()) {
					for (Usuario usuario : usuarios) {
						if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
							editarU.setnTarjeta(usuario.getnTarjeta());
							editarU.setCvv(usuario.getCvv());
							editarU.setPin(usuario.getPin());
							editarU.setFechaCaducidad(usuario.getFechaCaducidad());
						}
					}
				} else {
					JOptionPane.showMessageDialog(this,
							"SI QUIERES CAMBIAR LA TARJETA DEBES MODIFICAR TODOS SUS CAMPOS.");
				}

				// Pedimos al dao que edite los datos de la cuenta, en caso de que no se consiga
				// editar se avisara de ello mediante un JoptionPane
				if (dao.editarPerfil(cuenta, editarU)) {
					if (tarjeta.isSelected() || contrasenia.isSelected() || nombre.isSelected()) {
						JOptionPane.showMessageDialog(this, "PERFIL EDITADO CORRECTAMENTE.");

						nombreNuevo.setText("");
						nuevaContra.setText("");
						repetirContra.setText("");
						tarjetaNueva.setText("");
						pinNuevo.setText("");
						cvvNuevo.setText("");
						fCNueva.setText("");

					} else {
						JOptionPane.showMessageDialog(this,
								"DEBES ESCOGER MINIMO UNA DE LAS TRES OPCIONES Y MODIFICARLA.");
					}

				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO EDITAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "DEBES RELLENAR AL MENOS UN CAMPO");
			}
		} else {
			JOptionPane.showMessageDialog(this, error);
		}

	}

	// metodo para controlar los datos introducidos
	private String controlar(DateTimeFormatter formateador) {
		// TODO Auto-generated method stub
		String error = "";

		// Controlar que no hay un usuario con ese nombre ya introducido
		if (nombre.isSelected()) {
			String usuario = dao.buscarNombre(nombreNuevo.getText());
			if (!nombreNuevo.getText().equalsIgnoreCase("")) {
				if (nombreNuevo.getText().length() > 25 || nombreNuevo.getText().length() == 0) {
					error += "EL NOMBRE DE USUARIO ES INCORRECTO.\n";
					nombreNuevo.setBackground(new Color(255, 0, 0));
				} else if (usuario != null) {
					error += "El NOMBRE DE USARIO YA EXISTE.\n";
					nombreNuevo.setBackground(new Color(255, 0, 0));
				} else if (nombreNuevo.getText().length() > 0 && usuario == null) {
					nombreNuevo.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR UN NOMBRE DE USUARIO.\n";
				nombreNuevo.setBackground(new Color(255, 0, 0));
			}
		}

		// Controlar si la contraseña esta introducida correctamente
		if (contrasenia.isSelected()) {
			if (!nuevaContra.getText().equalsIgnoreCase("")) {
				if (nuevaContra.getText().length() > 25) {
					error += "LA CONTRASEÑA ES DEMASIADO GRANDE.\n";
					nuevaContra.setBackground(new Color(255, 0, 0));
				} else if (nuevaContra.getText().length() < 8) {
					error += "LA CONTRASEÑA DEBE TENER AL MENOS 8 CARACTERES.\n";
					nuevaContra.setBackground(new Color(255, 0, 0));
				} else if (nuevaContra.getText().length() >= 8 && nuevaContra.getText().length() <= 25) {
					nuevaContra.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR UNA CONTRASEÑA.\n";
				nuevaContra.setBackground(new Color(255, 0, 0));
			}

			if (!repetirContra.getText().equalsIgnoreCase("")) {
				if (!nuevaContra.getText().equals(repetirContra.getText())) {
					error += "LAS CONTRASEÑAS NO COINCIDEN.\n";
					repetirContra.setBackground(new Color(255, 0, 0));
				} else {
					repetirContra.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR LA MISMA CONTRASEÑA DE ARRIBA CONTRASEÑA.\n";
				repetirContra.setBackground(new Color(255, 0, 0));
			}
		}

		if (tarjeta.isSelected()) {
			// Controlar si el pin esta introducido correctamente
			if (!pinNuevo.getText().equalsIgnoreCase("") && tarjeta.isSelected()) {
				if (pinNuevo.getText().length() > 4) {
					error += "EL PIN ES DEMASIADO GRANDE.\n";
					pinNuevo.setBackground(new Color(255, 0, 0));
				} else if (pinNuevo.getText().length() < 4) {
					error += "EL PIN ES DEMASIADO GRANDE.\n";
					pinNuevo.setBackground(new Color(255, 0, 0));
				} else if (pinNuevo.getText().length() == 4) {
					pinNuevo.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR EL PIN DE LA TARJETA.\n";
				pinNuevo.setBackground(new Color(255, 0, 0));
			}

			// Controlar si el cvv esta introducido correctamente
			if (!cvvNuevo.getText().equalsIgnoreCase("") && tarjeta.isSelected()) {
				if (cvvNuevo.getText().length() > 3) {
					error += "EL CVV ES DEMASIADO GRANDE.\n";
					cvvNuevo.setBackground(new Color(255, 0, 0));
				} else if (cvvNuevo.getText().length() < 3) {
					error += "EL CVV ES DEMASIADO GRANDE.\n";
					cvvNuevo.setBackground(new Color(255, 0, 0));
				} else if (cvvNuevo.getText().length() == 3) {
					cvvNuevo.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR EL CVV DE LA TARJETA.\n";
				cvvNuevo.setBackground(new Color(255, 0, 0));
			}

			// Controlar si el cvv esta introducido correctamente
			if (!tarjetaNueva.getText().equalsIgnoreCase("") && tarjeta.isSelected()) {
				if (tarjetaNueva.getText().length() > 16) {
					error += "EL Nº DE TARJETA ES DEMASIADO GRANDE.\n";
					tarjetaNueva.setBackground(new Color(255, 0, 0));
				} else if (tarjetaNueva.getText().length() < 16) {
					error += "EL Nº DE TARJETA ES DEMASIADO PEQUEÑO.\n";
					tarjetaNueva.setBackground(new Color(255, 0, 0));
				} else if (tarjetaNueva.getText().length() == 16) {
					tarjetaNueva.setBackground(new Color(173, 255, 47));
				}
			} else {
				error += "DEBES INTRODUCIR EL NUMERO DE LA TARJETA.\n";
				tarjetaNueva.setBackground(new Color(255, 0, 0));
			}

			// Controlar si la fecha es posterior a el dia que se introduce
			LocalDate fecha;

			if (!fCNueva.getText().equalsIgnoreCase("") && tarjeta.isSelected()) {
				try {
					fecha = LocalDate.parse("01/" + fCNueva.getText(), formateador);

					if (fecha.isBefore(LocalDate.now())) {
						error += "LA FECHA DEBE SER POSTERIOR A HOY\n";
						fCNueva.setBackground(new Color(255, 0, 0));
					} else if (fecha.isAfter(LocalDate.now())) {
						fCNueva.setBackground(new Color(173, 255, 47));
					}
				} catch (DateTimeParseException p) {
					error += "LA FECHA DEBE SER INTRODUCIDA EN FORMATO: MM/AAAA\n";
					fCNueva.setBackground(new Color(255, 0, 0));

				}
			} else {
				error += "DEBES INTRODUCIR UNA FECHA POSTERIOR A LA DE HOY.\n";
				fCNueva.setBackground(new Color(255, 0, 0));
			}
		}
		return error;

	}

	// dependiendo de lo que se quiera editar se hace visible un panel u otro
	private void opciones() {
		// TODO Auto-generated method stub
		if (nombre.isSelected() || contrasenia.isSelected() || tarjeta.isSelected()) {
			if (nombre.isSelected()) {
				panelNombre.setVisible(true);
				nombreNuevo.setBackground(Color.WHITE);
			} else {
				panelNombre.setVisible(false);
				nuevaContra.setBackground(Color.WHITE);
				repetirContra.setBackground(Color.WHITE);
			}
			if (contrasenia.isSelected()) {
				panelContrasenia.setVisible(true);
			} else {
				panelContrasenia.setVisible(false);
			}
			if (tarjeta.isSelected()) {
				panelTarjeta.setVisible(true);
				tarjetaNueva.setBackground(Color.WHITE);
				pinNuevo.setBackground(Color.WHITE);
				cvvNuevo.setBackground(Color.WHITE);
				fCNueva.setBackground(Color.WHITE);
			} else {
				panelTarjeta.setVisible(false);
			}
		} else {
			panelNombre.setVisible(false);
			panelContrasenia.setVisible(false);
			panelTarjeta.setVisible(false);
		}
	}

	// metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
