package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import modelo.Dao;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

/**
 * @author Grupo3
 *
 */
public class VElegirApuesta extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnEquipo;
	private JButton btnJugador;
	private Dao dao;
	private final JPanel contentPanel = new JPanel();
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VElegirApuesta(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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

		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(192, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnJugador = new JButton("Jugador");
		btnJugador.setForeground(new Color(173, 255, 47));
		btnJugador.setFont(new Font("Arial", Font.PLAIN, 18));
		btnJugador.setFocusable(false);
		btnJugador.setBorder(null);
		btnJugador.setBackground(Color.DARK_GRAY);
		btnJugador.setBounds(157, 336, 180, 50);
		btnJugador.addActionListener(this);
		contentPanel.add(btnJugador);

		btnEquipo = new JButton("Equipo");
		btnEquipo.setForeground(new Color(173, 255, 47));
		btnEquipo.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEquipo.setFocusable(false);
		btnEquipo.setBorder(null);
		btnEquipo.setBackground(Color.DARK_GRAY);
		btnEquipo.setBounds(157, 209, 180, 50);
		btnEquipo.addActionListener(this);
		contentPanel.add(btnEquipo);

		JLabel lblNewLabel_1 = new JLabel("PULSA EL TIPO DE APUESTA QUE DESEES");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 121, 459, 50);
		contentPanel.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEquipo)) {
			crearApuestaEquipo();
		}
		if (e.getSource().equals(btnJugador)) {

		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}

	}

	// metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	// se te dirige a la ventana de elegir el deporte y la competicion sobre la que
	// creas la apuesta
	private void crearApuestaEquipo() {
		// TODO Auto-generated method stub
		this.dispose();
		VDeporteCompeticionDeApuesta vent = new VDeporteCompeticionDeApuesta(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
