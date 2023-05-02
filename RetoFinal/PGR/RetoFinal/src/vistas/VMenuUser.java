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
	private JButton volver;
	private JButton iniciar;

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

		volver = new JButton("Darse de Baja");
		volver.setForeground(new Color(173, 255, 47));
		volver.setFont(new Font("Arial", Font.PLAIN, 14));
		volver.setFocusable(false);
		volver.setBorder(null);
		volver.setBackground(Color.DARK_GRAY);
		volver.setBounds(54, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		iniciar = new JButton("Cerrar Sesion");
		iniciar.setForeground(new Color(173, 255, 47));
		iniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		iniciar.setFocusable(false);
		iniciar.setBorder(null);
		iniciar.setBackground(Color.DARK_GRAY);
		iniciar.setBounds(320, 11, 107, 36);
		iniciar.addActionListener(this);
		panel_1.add(iniciar);

		JButton btnEditarPerfil = new JButton("EDITAR PERFIL");
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarPerfil.setForeground(new Color(173, 255, 47));
		btnEditarPerfil.setFont(new Font("Arial", Font.BOLD, 18));
		btnEditarPerfil.setFocusable(false);
		btnEditarPerfil.setBorder(null);
		btnEditarPerfil.setBackground(Color.DARK_GRAY);
		btnEditarPerfil.setBounds(51, 132, 380, 35);
		contentPanel.add(btnEditarPerfil);

		JButton btnRealizarApuesta = new JButton("REALIZAR APUESTA");
		btnRealizarApuesta.setForeground(new Color(173, 255, 47));
		btnRealizarApuesta.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuesta.setFocusable(false);
		btnRealizarApuesta.setBorder(null);
		btnRealizarApuesta.setBackground(Color.DARK_GRAY);
		btnRealizarApuesta.setBounds(51, 190, 380, 35);
		contentPanel.add(btnRealizarApuesta);

		JButton btnRealizarApuestaCon = new JButton("REALIZAR APUESTA CON FILTROS");
		btnRealizarApuestaCon.setForeground(new Color(173, 255, 47));
		btnRealizarApuestaCon.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuestaCon.setFocusable(false);
		btnRealizarApuestaCon.setBorder(null);
		btnRealizarApuestaCon.setBackground(Color.DARK_GRAY);
		btnRealizarApuestaCon.setBounds(51, 249, 380, 35);
		contentPanel.add(btnRealizarApuestaCon);

		JButton btnApuestasRealizadas = new JButton("APUESTAS REALIZADAS");
		btnApuestasRealizadas.setForeground(new Color(173, 255, 47));
		btnApuestasRealizadas.setFont(new Font("Arial", Font.BOLD, 18));
		btnApuestasRealizadas.setFocusable(false);
		btnApuestasRealizadas.setBorder(null);
		btnApuestasRealizadas.setBackground(Color.DARK_GRAY);
		btnApuestasRealizadas.setBounds(51, 309, 380, 35);
		contentPanel.add(btnApuestasRealizadas);

		JButton btnRetirarDinero = new JButton("RETIRAR DINERO");
		btnRetirarDinero.setForeground(new Color(173, 255, 47));
		btnRetirarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnRetirarDinero.setFocusable(false);
		btnRetirarDinero.setBorder(null);
		btnRetirarDinero.setBackground(Color.DARK_GRAY);
		btnRetirarDinero.setBounds(51, 421, 380, 35);
		contentPanel.add(btnRetirarDinero);

		JButton btnApuestasRealizadas_2 = new JButton("INGRESAR DINERO");
		btnApuestasRealizadas_2.setForeground(new Color(173, 255, 47));
		btnApuestasRealizadas_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnApuestasRealizadas_2.setFocusable(false);
		btnApuestasRealizadas_2.setBorder(null);
		btnApuestasRealizadas_2.setBackground(Color.DARK_GRAY);
		btnApuestasRealizadas_2.setBounds(51, 365, 380, 35);
		contentPanel.add(btnApuestasRealizadas_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta+"\\src\\fotos\\fondoUser.png"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
