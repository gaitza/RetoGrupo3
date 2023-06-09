package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * @author Grupo3
 *
 */
public class VElegir extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton iniciarSesion;
	private JButton registrarse;
	private Dao dao;

	/**
	 * @param dao
	 */
	public VElegir(Dao dao) {

		String ruta = System.getProperty("user.dir");
		this.dao = dao;

		setTitle("Retabet.es");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		iniciarSesion = new JButton("Iniciar Sesion");
		iniciarSesion.setFont(new Font("Arial", Font.BOLD, 24));
		iniciarSesion.setForeground(new Color(173, 255, 47));
		iniciarSesion.setBackground(new Color(0, 0, 0));
		iniciarSesion.setBounds(120, 224, 225, 58);
		iniciarSesion.setBorder(null);
		iniciarSesion.addActionListener(this);
		iniciarSesion.setFocusable(false);
		contentPane.add(iniciarSesion);

		registrarse = new JButton("Registrarse");
		registrarse.setFont(new Font("Arial", Font.BOLD, 24));
		registrarse.setForeground(new Color(173, 255, 47));
		registrarse.setBackground(new Color(0, 0, 0));
		registrarse.setBorder(null);
		registrarse.setBounds(120, 355, 225, 58);
		registrarse.addActionListener(this);
		registrarse.setFocusable(false);
		contentPane.add(registrarse);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 479, 88);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 498, 479, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel Contacto = new JLabel("Contactanos:");
		Contacto.setFont(new Font("Arial", Font.PLAIN, 14));
		Contacto.setForeground(new Color(255, 255, 255));
		Contacto.setBounds(26, 22, 91, 14);
		panel_1.add(Contacto);

		JLabel lblNewLabel_2 = new JLabel("    +34 629 72 15 77                    info@retabet.es");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(127, 22, 342, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Fondo.jpg"));
		lblNewLabel_1.setBounds(0, 85, 479, 429);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		VInicioSesion inicioSesion = new VInicioSesion(this, true, dao);
		VRegistrarse registrar = new VRegistrarse(this, true, dao);

		/*
		 * si se pulsa el boton de iniciar sesion te envia a la ventana de iniciar
		 * sesion y en cambio se pulsea el boto de registrarse te envia al de
		 * registrarse
		 */
		if (e.getSource().equals(iniciarSesion)) {
			iniciarSesion(inicioSesion);
			// Metodo de que en caso de que se cierre cualquier ventana, la JFrame tambien
			// se cerrara
			try {
				VMenuAdmin admin = new VMenuAdmin(this, true, dao, null);
				VMenuUser user = new VMenuUser(this, true, dao, null);
				if ((!admin.isActive() || !user.isActive()) || inicioSesion.isActive()) {
					if (this.getExtendedState() == ICONIFIED)
						this.dispose();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				if (inicioSesion.isActive()) {
					if (this.getExtendedState() == ICONIFIED)
						this.dispose();
				}
			} finally {
				this.dispose();
			}
		}
		if (e.getSource().equals(registrarse)) {
			registrarse(registrar);
			if (registrar.isActive()) {
				if (this.getExtendedState() == ICONIFIED)
					this.dispose();
			}
		}

	}

	// se guarda la JFrame y se abre la ventana de registrarse
	private void registrarse(VRegistrarse registrar) {
		// TODO Auto-generated method stub
		this.setExtendedState(ICONIFIED);
		registrar.setVisible(true);
	}

	// se guarda la JFrame y se abre la ventana de iniciar sesion
	private void iniciarSesion(VInicioSesion inicioSesion) {
		// TODO Auto-generated method stub
		this.setExtendedState(ICONIFIED);
		inicioSesion.setVisible(true);
	}
}
