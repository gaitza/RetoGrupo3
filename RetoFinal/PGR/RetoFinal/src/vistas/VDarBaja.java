package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.ListadoApuestas;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author Grupo3
 *
 */
public class VDarBaja extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JRadioButton jugador;
	private JRadioButton equipo;
	private JRadioButton deporte;
	private JRadioButton competicion;
	private ButtonGroup grupo;
	private JPanel panelJugador;
	private JPanel panelEquipo;
	private JPanel panelDeporte;
	private JPanel panelCompeticion;
	private JTable table;
	private JComboBox bajaEquipo;
	private JComboBox bajaDeporte;
	private JComboBox bajaCompeticion;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VDarBaja(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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

		panelJugador = new JPanel();
		panelJugador.setBorder(null);
		panelJugador.setLayout(null);
		panelJugador.setBackground(new Color(173, 255, 47));
		panelJugador.setBounds(0, 180, 479, 318);
		contentPanel.add(panelJugador);

		JLabel lblNewLabel_1_2 = new JLabel("Escoge el equipo del jugador que quieras dar de baja:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_2.setBounds(0, 11, 479, 32);

		panelJugador.add(lblNewLabel_1_2);
		panelJugador.setVisible(false);
		panelJugador.setVisible(false);

		panelDeporte = new JPanel();
		panelDeporte.setBackground(new Color(173, 255, 47));
		panelDeporte.setBounds(0, 177, 479, 318);
		contentPanel.add(panelDeporte);
		panelDeporte.setLayout(null);

		bajaDeporte = new JComboBox();
		bajaDeporte.setForeground(new Color(173, 255, 47));
		bajaDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		bajaDeporte.setBackground(Color.DARK_GRAY);
		bajaDeporte.setBounds(10, 154, 459, 34);
		panelDeporte.add(bajaDeporte);

		JLabel lblNewLabel_1_1_2 = new JLabel("Escoge el deporte que quieras dar de baja:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1_2.setBounds(0, 94, 479, 35);
		panelDeporte.add(lblNewLabel_1_1_2);
		panelDeporte.setVisible(false);

		panelCompeticion = new JPanel();
		panelCompeticion.setBackground(new Color(173, 255, 47));
		panelCompeticion.setBounds(0, 177, 479, 321);
		contentPanel.add(panelCompeticion);
		panelCompeticion.setLayout(null);

		bajaCompeticion = new JComboBox();
		bajaCompeticion.setForeground(new Color(173, 255, 47));
		bajaCompeticion.setFont(new Font("Arial", Font.BOLD, 16));
		bajaCompeticion.setBackground(Color.DARK_GRAY);
		bajaCompeticion.setBounds(10, 157, 459, 34);
		panelCompeticion.add(bajaCompeticion);

		JLabel lblNewLabel_1_1_1 = new JLabel("Escoge la competición que quieras dar de baja:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setBounds(0, 97, 479, 35);
		panelCompeticion.add(lblNewLabel_1_1_1);
		panelCompeticion.setVisible(false);

		panelEquipo = new JPanel();
		panelEquipo.setBounds(0, 177, 479, 318);
		contentPanel.add(panelEquipo);
		panelEquipo.setBackground(new Color(173, 255, 47));
		panelEquipo.setLayout(null);

		bajaEquipo = new JComboBox();
		bajaEquipo.setForeground(new Color(173, 255, 47));
		bajaEquipo.setFont(new Font("Arial", Font.BOLD, 16));
		bajaEquipo.setBackground(Color.DARK_GRAY);
		bajaEquipo.setBounds(10, 156, 459, 34);
		panelEquipo.add(bajaEquipo);

		JLabel lblNewLabel_1_1 = new JLabel("Escoge el equipo que quieras dar de baja:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(0, 96, 479, 35);
		panelEquipo.add(lblNewLabel_1_1);

		panelEquipo.setVisible(false);

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
		btnVolver.setBounds(55, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Confirmar Baja");
		btnContinuar.setBounds(266, 11, 162, 36);
		panel_1.add(btnContinuar);
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Escoge la opcion de lo que quieras dar de baja:");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 89, 479, 35);
		contentPanel.add(lblNewLabel_1);

		jugador = new JRadioButton("Jugador");
		jugador.setForeground(Color.DARK_GRAY);
		jugador.setHorizontalAlignment(SwingConstants.CENTER);
		jugador.setFont(new Font("Arial", Font.PLAIN, 14));
		jugador.setBackground(new Color(173, 255, 47));
		jugador.setBounds(0, 143, 120, 23);
		jugador.setFocusable(false);
		jugador.setBorder(null);
		jugador.addActionListener(this);
		contentPanel.add(jugador);

		equipo = new JRadioButton("Equipo");
		equipo.setForeground(Color.DARK_GRAY);
		equipo.setHorizontalAlignment(SwingConstants.CENTER);
		equipo.setFont(new Font("Arial", Font.PLAIN, 14));
		equipo.setBackground(new Color(173, 255, 47));
		equipo.setBounds(122, 144, 120, 23);
		equipo.setFocusable(false);
		equipo.setBorder(null);
		equipo.addActionListener(this);
		contentPanel.add(equipo);

		deporte = new JRadioButton("Deporte");
		deporte.setForeground(Color.DARK_GRAY);
		deporte.setHorizontalAlignment(SwingConstants.CENTER);
		deporte.setFont(new Font("Arial", Font.PLAIN, 14));
		deporte.setBackground(new Color(173, 255, 47));
		deporte.setBounds(244, 144, 120, 23);
		deporte.setFocusable(false);
		deporte.setBorder(null);
		deporte.addActionListener(this);
		contentPanel.add(deporte);

		competicion = new JRadioButton("Competición");
		competicion.setForeground(Color.DARK_GRAY);
		competicion.setHorizontalAlignment(SwingConstants.CENTER);
		competicion.setFont(new Font("Arial", Font.PLAIN, 14));
		competicion.setBackground(new Color(173, 255, 47));
		competicion.setBounds(359, 144, 120, 23);
		competicion.setFocusable(false);
		competicion.setBorder(null);
		competicion.addActionListener(this);
		contentPanel.add(competicion);

		grupo = new ButtonGroup();
		grupo.add(jugador);
		grupo.add(equipo);
		grupo.add(deporte);
		grupo.add(competicion);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 479, 88);
		contentPanel.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel_2.setBounds(156, 0, 220, 88);
		panel_2.add(lblNewLabel_2);

		// Guardamos todas los equipo que hay en la BDA
		List<Equipo> equipos = dao.listadoEquipos();

		// Creamos la tabla con los equipos guardados recientemente
		presentarTabla(equipos);

		// cargamos en cada comboBox la informacion necesaria
		cargarEquipos();
		cargarDeportes();
		cargarCompeticiones();

	}

	private void cargarCompeticiones() {
		// TODO Auto-generated method stub
		List<Competicion> competiciones = dao.listadoCompeticiones();
		for (Competicion comp : competiciones) {
			bajaCompeticion.addItem(comp.getCodCompeticion() + "-" + comp.getNombre() + "-" + comp.getDeporte());
		}
		bajaCompeticion.setSelectedIndex(-1);
	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = dao.listadoDeportes();
		for (Deporte dep : deportes) {
			bajaDeporte.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
		}
		bajaDeporte.setSelectedIndex(-1);
	}

	private void cargarEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listadoEquipos();
		for (Equipo equipo : equipos) {
			bajaEquipo.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		bajaEquipo.setSelectedIndex(-1);
	}

	/**
	 * @param equipos
	 */
	public void presentarTabla(List<Equipo> equipos) {
		JScrollPane scroll = new JScrollPane();
		scroll.setLocation(10, 310);
		scroll.setSize(459, -267);
		scroll.setBorder(null);
		scroll.getViewport().setBackground(new Color(173, 255, 47));
		scroll.setEnabled(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		panelJugador.add(scroll);

		table = new JTable((TableModel) null);
		table = this.cargarTabla(equipos);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.getSelectedRow();
				VEscogerJugador vent = new VEscogerJugador(vElegir, true, dao, equipos.get(fila));
				vent.setVisible(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(null);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(new Color(173, 255, 47));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setRowHeight(40);
		scroll.setViewportView(table);
		scroll.setBounds(10, 50, 459, 257);
	}

	/**
	 * @param equipos
	 * @return JTable(model)
	 */
	private JTable cargarTabla(List<Equipo> equipos) {
		// TODO Auto-generated method stub
		String[] cabeceras = { "NOMBRE", "AÑO F.", "LOCALIDAD", "PAIS", "ESTADIO", "DEPORTE" };
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabeceras);

		for (Equipo a : equipos) {
			fila[0] = a.getNombreEquipo() + "";
			fila[1] = a.getFechaFun() + "";
			fila[2] = a.getLocalidad() + "";
			fila[3] = a.getPais() + "";
			fila[4] = a.getEstadio() + "";
			fila[5] = a.getDeporte() + "";

			model.addRow(fila);
		}

		return new JTable(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// dependiendo de lo que se quiera dar de baja se hace visible un panel u otro
		if (jugador.isSelected()) {
			panelJugador.setVisible(true);
			panelEquipo.setVisible(false);
			panelDeporte.setVisible(false);
			panelCompeticion.setVisible(false);
			btnContinuar.setVisible(false);
			btnVolver.setBounds(189, 11, 107, 36);
		} else {
			btnContinuar.setVisible(true);
			btnVolver.setBounds(55, 11, 107, 36);
		}
		if (equipo.isSelected()) {
			panelEquipo.setVisible(true);
			panelJugador.setVisible(false);
			panelDeporte.setVisible(false);
			panelCompeticion.setVisible(false);
		}
		if (deporte.isSelected()) {
			panelEquipo.setVisible(false);
			panelJugador.setVisible(false);
			panelDeporte.setVisible(true);
			panelCompeticion.setVisible(false);
		}
		if (competicion.isSelected()) {
			panelEquipo.setVisible(false);
			panelJugador.setVisible(false);
			panelDeporte.setVisible(false);
			panelCompeticion.setVisible(true);
		}

		if (e.getSource().equals(btnVolver)) {
			volver();
		}
		if (e.getSource().equals(btnContinuar)) {
			confirmar();
		}
	}

	// Metodo para enviar los datos al dao
	private void confirmar() {
		// TODO Auto-generated method stub
		Equipo equipoClase;
		Deporte depClase;
		Competicion compClase;

		/*
		 * Dependiendo del rdbtn seleccionado se envia al dao lo que se quiere dar de
		 * baja, en caso de que no se consiga eliminar se avisara de ello mediante un
		 * JoptionPane
		 */
		if (equipo.isSelected()) {
			if (bajaEquipo.getSelectedIndex() != -1) {
				equipoClase = new Equipo();
				String cadena = (String) bajaEquipo.getSelectedItem();
				int pos = cadena.indexOf("-");
				String cod = cadena.substring(0, pos);
				equipoClase.setCodEquipo(cod);

				if (dao.bajaEquipo(equipoClase)) {
					JOptionPane.showMessageDialog(this, "EQUIPO ELIMINADO CORRECTAMENTE.");
					bajaEquipo.setSelectedIndex(-1);
				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO ELIMINAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UN EQUIPO:");
			}
		}

		if (deporte.isSelected()) {
			if (bajaDeporte.getSelectedIndex() != -1) {
				depClase = new Deporte();
				String cadena = (String) bajaDeporte.getSelectedItem();
				int pos = cadena.indexOf("-");
				String cod = cadena.substring(0, pos);
				depClase.setCodDep(cod);

				if (dao.bajaDeporte(depClase)) {
					JOptionPane.showMessageDialog(this, "DEPORTE ELIMINADO CORRECTAMENTE.");
					bajaDeporte.setSelectedIndex(-1);
				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO ELIMINAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UN DEPORTE:");
			}
		}

		if (competicion.isSelected()) {
			if (bajaCompeticion.getSelectedIndex() != -1) {
				compClase = new Competicion();
				String cadena = (String) bajaCompeticion.getSelectedItem();
				int pos = cadena.indexOf("-");
				String cod = cadena.substring(0, pos);
				compClase.setCodCompeticion(cod);

				if (dao.bajaCompeticion(compClase)) {
					JOptionPane.showMessageDialog(this, "COMPETICION ELIMINADA CORRECTAMENTE.");
					bajaCompeticion.setSelectedIndex(-1);
				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO ELIMINAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UNA COMPETICIÓN:");
			}
		}
	}

	// metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.setFocusableWindowState(false);
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
