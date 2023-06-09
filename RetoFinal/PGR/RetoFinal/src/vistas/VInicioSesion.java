package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import modelo.Dao;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * @author Grupo3
 *
 */
public class VInicioSesion extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private JTextField nombre;
	private JPasswordField contrasenia;
	private JButton olvidarContrasenia;
	private JButton registrarse;
	private JButton iniciar;
	private VElegir vElegir;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 */
	public VInicioSesion(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

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

		registrarse = new JButton("Registrate");
		registrarse.setForeground(new Color(173, 255, 47));
		registrarse.setFont(new Font("Arial", Font.PLAIN, 14));
		registrarse.setFocusable(false);
		registrarse.setBorder(null);
		registrarse.setBackground(Color.DARK_GRAY);
		registrarse.setBounds(54, 11, 107, 36);
		registrarse.addActionListener(this);
		panel_1.add(registrarse);

		iniciar = new JButton("Iniciar Sesion");
		iniciar.setForeground(new Color(173, 255, 47));
		iniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		iniciar.setFocusable(false);
		iniciar.setBorder(null);
		iniciar.setBackground(Color.DARK_GRAY);
		iniciar.setBounds(320, 11, 107, 36);
		iniciar.addActionListener(this);
		panel_1.add(iniciar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		lblNombre.setBounds(53, 216, 112, 35);
		contentPanel.add(lblNombre);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 18));
		lblContrasea.setBounds(53, 322, 112, 35);
		contentPanel.add(lblContrasea);

		nombre = new JTextField();
		nombre.setFont(new Font("Arial", Font.PLAIN, 14));
		nombre.setBounds(175, 216, 257, 35);
		contentPanel.add(nombre);
		nombre.setColumns(10);

		contrasenia = new JPasswordField();
		contrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
		contrasenia.setColumns(10);
		contrasenia.setBounds(175, 322, 257, 35);
		contentPanel.add(contrasenia);

		olvidarContrasenia = new JButton("¿Has olvidado tu contraseña?");
		olvidarContrasenia.setForeground(new Color(173, 255, 47));
		olvidarContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));
		olvidarContrasenia.setFocusable(false);
		olvidarContrasenia.setBorder(null);
		olvidarContrasenia.setBackground(Color.DARK_GRAY);
		olvidarContrasenia.setBounds(105, 393, 276, 35);
		olvidarContrasenia.addActionListener(this);
		contentPanel.add(olvidarContrasenia);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Fondo2.jpg"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(olvidarContrasenia)) {
			visualizarContra();
		}
		if (e.getSource().equals(iniciar)) {
			iniciar();
		}
		if (e.getSource().equals(registrarse)) {
			registrate();
		}
	}

	/*
	 * en caso de haber olvidado la contraseña hemos creado un metodo en el que se
	 * te pida el email y posteiormente te saldra la contraseña
	 */
	private void visualizarContra() {
		// TODO Auto-generated method stub
		String nombreC = dao.buscarNombre(nombre.getText());

		if (nombreC == null) {
			nombreC = "";
		}

		if (!nombre.getText().equalsIgnoreCase("") && nombreC.equalsIgnoreCase(nombre.getText())) {
			String respEmail = JOptionPane.showInputDialog("INTRODUCE EL EMAIL DEL USUARIO.");
			String email = dao.buscarEmail(respEmail);
			if (email == null) {
				email = "";
			}

			if (email.equalsIgnoreCase(respEmail)) {
				String contrasenia = dao.contraOlvidada(respEmail);
				JOptionPane.showMessageDialog(this, "LA CONTRASEÑA DEL USUARIO ES:\n" + contrasenia);
			} else {
				JOptionPane.showMessageDialog(this, "EMAIL MAL INTRODUCIDO");
			}
		} else if (nombre.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "INTRODUCE EL NOMBRE DE USUARIO PRIMERO.");
		} else if (!nombreC.equalsIgnoreCase(nombre.getText())) {
			JOptionPane.showMessageDialog(this, "ESE USUARIO NO EXISTE.");
		}
	}

	// metodo para iniciar sesion
	private void iniciar() {
		// TODO Auto-generated method stub
		Cuenta cuenta = dao.iniciar(nombre.getText(), contrasenia.getText());
		if (cuenta != null) {

			/*
			 * pedimos al dao que inicie sesion, en caso de que sea admin se abrira el menu
			 * de administrador, en cambio si es usuario el menu de usuario
			 */
			if (dao.esAdmin(cuenta.getCodCuenta())) {
				this.dispose();
				VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao, cuenta);
				vent.setVisible(true);
			} else {
				this.dispose();
				VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
				vent.setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "NOMBRE O CONTRASEÑA MAL INTRODUCIDOS.");
		}
	}

	// Metodo para volver a la anterior ventana
	private void registrate() {
		// TODO Auto-generated method stub
		this.dispose();
		VRegistrarse vent = new VRegistrarse(vElegir, true, dao);
		vent.setVisible(true);
	}
}
