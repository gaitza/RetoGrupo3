package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Equipo;
import clases.Jugador;
import modelo.Dao;

public class VEscogerJugador extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JComboBox escogerJugador;
	private Equipo equipo;

	
	public VEscogerJugador(VElegir vElegir, boolean b, Dao dao, Equipo equipo) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.equipo = equipo;

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
		lblNewLabel.setIcon(new ImageIcon(ruta+"\\src\\fotos\\Cabecera.jpg"));
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
		btnVolver.setBounds(183, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);
		
		escogerJugador = new JComboBox();
		escogerJugador.setForeground(new Color(173, 255, 47));
		escogerJugador.setBackground(Color.DARK_GRAY);
		escogerJugador.setBounds(92, 273, 298, 35);
		escogerJugador.setFocusable(false);
		escogerJugador.setBorder(null);
		escogerJugador.addActionListener(this);
		escogerJugador.setSelectedIndex(-1);
		contentPanel.add(escogerJugador);
		
		JLabel lblNewLabel_1 = new JLabel("Escoge el jugador que quieras dar de baja:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 204, 459, 35);
		contentPanel.add(lblNewLabel_1);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(183, 330, 107, 36);
		btnContinuar.addActionListener(this);
		contentPanel.add(btnContinuar);
		
		cargarJugadores();
	}


	private void cargarJugadores() {
		// TODO Auto-generated method stub
			List<Jugador> jugadores = dao.listadoJugadores(equipo);
			for(Jugador jugador : jugadores) {
				escogerJugador.addItem(jugador.getId()+"-"+jugador.getNombreJ()+" "+jugador.getApellido1()+" "+jugador.getApellido2());
			}
			escogerJugador.setSelectedIndex(-1);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
		if(e.getSource().equals(btnContinuar)) {
			confirmar();
		}
	}


	private void confirmar() {
		// TODO Auto-generated method stub
		Jugador jug;
		
		if(escogerJugador.getSelectedIndex()!=-1) {
			jug = new Jugador();
			String cadena = (String) escogerJugador.getSelectedItem();
			int pos = cadena.indexOf("-");
			String id = cadena.substring(0, pos);
			jug.setId(id);
			
			if (dao.bajaJugador(jug)) {
				JOptionPane.showMessageDialog(this, "JUGADOR ELIMINADO CORRECTAMENTE.");
				escogerJugador.setSelectedIndex(-1);
			} else {
				JOptionPane.showMessageDialog(this, "NO SE HA CONSEGUIDO ELIMINAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "ESCOGE UN JUGADOR:");
		}
	}


	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
