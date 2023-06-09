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

/**
 * @author Grupo3
 *
 */
public class VModificarJugador extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JComboBox escogerJugador;
	private JComboBox dorsalNuevo;
	private JComboBox equipoNuevo;
	private Equipo equipo;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param equipo
	 */
	public VModificarJugador(VElegir vElegir, boolean b, Dao dao, Equipo equipo) {
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
		btnVolver.setBounds(40, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(332, 11, 107, 36);
		panel_1.add(btnContinuar);
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.addActionListener(this);

		escogerJugador = new JComboBox();
		escogerJugador.setForeground(new Color(173, 255, 47));
		escogerJugador.setBackground(Color.DARK_GRAY);
		escogerJugador.setBounds(91, 145, 298, 35);
		escogerJugador.setFocusable(false);
		escogerJugador.setBorder(null);
		escogerJugador.addActionListener(this);
		escogerJugador.setSelectedIndex(-1);
		contentPanel.add(escogerJugador);

		JLabel lblNewLabel_1 = new JLabel("Escoge el jugador que quieras dar modificar:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 99, 459, 35);
		contentPanel.add(lblNewLabel_1);

		dorsalNuevo = new JComboBox();
		dorsalNuevo.setForeground(new Color(173, 255, 47));
		dorsalNuevo.setBackground(Color.DARK_GRAY);
		dorsalNuevo.setBounds(264, 280, 58, 35);
		contentPanel.add(dorsalNuevo);

		JLabel lblNewLabel_1_1 = new JLabel("No es necesario rellenar todos los campos");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 216, 459, 35);
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Dorsal nuevo:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(123, 278, 136, 35);
		contentPanel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Escoge el nuevo equipo:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(10, 344, 459, 35);
		contentPanel.add(lblNewLabel_1_1_2);

		equipoNuevo = new JComboBox();
		equipoNuevo.setForeground(new Color(173, 255, 47));
		equipoNuevo.setBackground(Color.DARK_GRAY);
		equipoNuevo.setBounds(91, 390, 298, 35);
		contentPanel.add(equipoNuevo);

		// cargamos en cada comboBox la informacion necesaria
		cargarJugadores();
		cargarEquipos();
		cargarDorsales();

	}

	private void cargarEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listadoEquipos();
		for (Equipo equipo : equipos) {
			equipoNuevo.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		equipoNuevo.setSelectedIndex(-1);
	}

	private void cargarJugadores() {
		// TODO Auto-generated method stub
		List<Jugador> jugadores = dao.listadoJugadores(equipo);
		for (Jugador jugador : jugadores) {
			escogerJugador.addItem(jugador.getId() + "-" + jugador.getNombreJ() + " " + jugador.getApellido1() + " "
					+ jugador.getApellido2());
		}
		escogerJugador.setSelectedIndex(-1);

	}

	private void cargarDorsales() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100; i++) {
			dorsalNuevo.addItem(i);
		}
		dorsalNuevo.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
		if (e.getSource().equals(btnContinuar)) {
			continuar();
		}
	}

	//cerramos la ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	//metodo para modificar el jugador seleccionado
	private void continuar() {
		// TODO Auto-generated method stub
		Jugador jug;

		if (escogerJugador.getSelectedIndex() != -1) {
			jug = new Jugador();
			String cadena = (String) escogerJugador.getSelectedItem();
			int pos = cadena.indexOf("-");
			String id = cadena.substring(0, pos);
			jug.setId(id);

			if (dorsalNuevo.getSelectedIndex() != -1) {
				String num = dorsalNuevo.getSelectedItem().toString();
				jug.setDorsal(Integer.parseInt(num));
			} else {
				jug.setDorsal(0);
			}

			if (equipoNuevo.getSelectedIndex() != -1) {
				String cadena2 = (String) equipoNuevo.getSelectedItem();
				int pos2 = cadena2.indexOf("-");
				String codEquipo = cadena2.substring(0, pos2);
				jug.setCodEquipo(codEquipo);
			} else {
				jug.setCodEquipo("000");
			}

			//le pedimos al dao que modifique el jugador, encaso de que se consiga modificar correctamente se le avisara de ello
			if (dao.modificarJugador(jug, equipo)) {
				JOptionPane.showMessageDialog(this, "JUGADOR MODIFICADO CORRECTAMENTE.");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this,
						"NO SE HA CONSEGUIDO MODIFICAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "ESCOGE UN JUGADOR:");
		}
	}

}
