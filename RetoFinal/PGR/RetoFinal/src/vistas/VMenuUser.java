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

import modelo.Dao;
import java.awt.Window.Type;

public class VMenuUser extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton darseDeBaja;
	private JButton cerrarSesion;
	private JButton btnEditarPerfil;
	private JButton btnRealizarApuesta;
	private JButton btnRealizarApuestaCon;
	private JButton btnApuestasRealizadas;
	private JButton btnRetirarDinero;
	private JButton btnIngresarDinero;

	public VMenuUser(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;

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
		lblNewLabel.setIcon(new ImageIcon(
				ruta+"\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 498, 479, 58);
		contentPanel.add(panel_1);

		darseDeBaja = new JButton("Darse de Baja");
		darseDeBaja.setForeground(new Color(173, 255, 47));
		darseDeBaja.setFont(new Font("Arial", Font.PLAIN, 14));
		darseDeBaja.setFocusable(false);
		darseDeBaja.setBorder(null);
		darseDeBaja.setBackground(Color.DARK_GRAY);
		darseDeBaja.setBounds(54, 11, 107, 36);
		darseDeBaja.addActionListener(this);
		panel_1.add(darseDeBaja);

		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(new Color(173, 255, 47));
		cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
		cerrarSesion.setFocusable(false);
		cerrarSesion.setBorder(null);
		cerrarSesion.setBackground(Color.DARK_GRAY);
		cerrarSesion.setBounds(320, 11, 107, 36);
		cerrarSesion.addActionListener(this);
		panel_1.add(cerrarSesion);


		btnEditarPerfil = new JButton("EDITAR PERFIL");
		btnEditarPerfil.setForeground(new Color(173, 255, 47));
		btnEditarPerfil.setFont(new Font("Arial", Font.BOLD, 18));
		btnEditarPerfil.setFocusable(false);
		btnEditarPerfil.setBorder(null);
		btnEditarPerfil.setBackground(Color.DARK_GRAY);
		btnEditarPerfil.setBounds(51, 132, 380, 35);
		btnEditarPerfil.addActionListener(this);
		contentPanel.add(btnEditarPerfil);

		btnRealizarApuesta = new JButton("REALIZAR APUESTA");
		btnRealizarApuesta.setForeground(new Color(173, 255, 47));
		btnRealizarApuesta.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuesta.setFocusable(false);
		btnRealizarApuesta.setBorder(null);
		btnRealizarApuesta.setBackground(Color.DARK_GRAY);
		btnRealizarApuesta.setBounds(51, 190, 380, 35);
		btnRealizarApuesta.addActionListener(this);
		contentPanel.add(btnRealizarApuesta);

		btnRealizarApuestaCon = new JButton("REALIZAR APUESTA CON FILTROS");
		btnRealizarApuestaCon.setForeground(new Color(173, 255, 47));
		btnRealizarApuestaCon.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuestaCon.setFocusable(false);
		btnRealizarApuestaCon.setBorder(null);
		btnRealizarApuestaCon.setBackground(Color.DARK_GRAY);
		btnRealizarApuestaCon.setBounds(51, 249, 380, 35);
		btnRealizarApuestaCon.addActionListener(this);
		contentPanel.add(btnRealizarApuestaCon);

		btnApuestasRealizadas = new JButton("APUESTAS REALIZADAS");
		btnApuestasRealizadas.setForeground(new Color(173, 255, 47));
		btnApuestasRealizadas.setFont(new Font("Arial", Font.BOLD, 18));
		btnApuestasRealizadas.setFocusable(false);
		btnApuestasRealizadas.setBorder(null);
		btnApuestasRealizadas.setBackground(Color.DARK_GRAY);
		btnApuestasRealizadas.setBounds(51, 309, 380, 35);
		btnApuestasRealizadas.addActionListener(this);
		contentPanel.add(btnApuestasRealizadas);

		btnRetirarDinero = new JButton("RETIRAR DINERO");
		btnRetirarDinero.setForeground(new Color(173, 255, 47));
		btnRetirarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnRetirarDinero.setFocusable(false);
		btnRetirarDinero.setBorder(null);
		btnRetirarDinero.setBackground(Color.DARK_GRAY);
		btnRetirarDinero.setBounds(51, 421, 380, 35);
		btnRetirarDinero.addActionListener(this);
		contentPanel.add(btnRetirarDinero);

		btnIngresarDinero = new JButton("INGRESAR DINERO");
		btnIngresarDinero.setForeground(new Color(173, 255, 47));
		btnIngresarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnIngresarDinero.setFocusable(false);
		btnIngresarDinero.setBorder(null);
		btnIngresarDinero.setBackground(Color.DARK_GRAY);
		btnIngresarDinero.setBounds(51, 365, 380, 35);
		btnIngresarDinero.addActionListener(this);
		contentPanel.add(btnIngresarDinero);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta+"\\src\\fotos\\fondoUser.png"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(cerrarSesion)) {
			cerrarSesion();
		}
	}

	private void cerrarSesion() {
		// TODO Auto-generated method stub
		this.dispose();
		vElegir.setExtendedState(Frame.NORMAL);;
	}
}
