package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class VElegirApuesta extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VElegir vElegir;
	private JButton btnJugador;
	private JButton btnEquipo;
	private Dao dao;
	private final JPanel contentPanel = new JPanel();

	public VElegirApuesta(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		this.dao = dao;
		this.vElegir = vElegir;
		setTitle("Retabet.es");
		this.setModal(b);
		
		setBounds(100, 100, 450, 451);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Crear apuesta");
			lblNewLabel.setBounds(133, 54, 155, 14);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}

		btnJugador = new JButton("Jugador");
		btnJugador.setFont(new Font("Arial", Font.BOLD, 25));
		btnJugador.setBounds(137, 251, 151, 60);
		btnJugador.addActionListener(this);
		contentPanel.add(btnJugador);
		
		btnEquipo = new JButton("Equipo");
		btnEquipo.setFont(new Font("Arial", Font.BOLD, 25));
		btnEquipo.setBounds(137, 136, 151, 60);
		btnEquipo.addActionListener(this);
		contentPanel.add(btnEquipo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEquipo)) {
			crearApuestaEquipo();
		}
		if (e.getSource().equals(btnJugador)) {
			crearApuestaJugador();
		}

	}

	private void crearApuestaJugador() {
		// TODO Auto-generated method stub
		this.dispose();
		VCrearApuestaJugador vent = new VCrearApuestaJugador();
		vent.setVisible(true);
	}

	private void crearApuestaEquipo() {
		// TODO Auto-generated method stub
		this.dispose();
		VCrearApuestaEquipoCompeticion vent = new VCrearApuestaEquipoCompeticion(vElegir, true, dao);
		vent.setVisible(true);
	}
}
