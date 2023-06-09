package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VModificar extends JDialog implements ActionListener {

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
	private JTextField nombreE;
	private JTextField localidad;
	private JTextField pais;
	private JTextField estadio;
	private JTextField nombreDep;
	private JLabel lblNewLabel;
	private JTextField nombreComp;
	private JLabel lblIntroduceElNombre;
	private JLabel lblIntroduceElDeporte;
	private JTable table;
	private JComboBox deportesCombo;
	private JComboBox equiposCombo;
	private JComboBox competicionesCombo;
	private JComboBox deporteC;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VModificar(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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
		btnVolver.setBounds(37, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Confirmar");
		btnContinuar.setBounds(337, 11, 107, 36);
		panel_1.add(btnContinuar);
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Escoge la opcion de lo que quieras modificar:");
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

		panelCompeticion = new JPanel();
		panelCompeticion.setBackground(new Color(173, 255, 47));
		panelCompeticion.setBounds(0, 177, 479, 321);
		contentPanel.add(panelCompeticion);
		panelCompeticion.setLayout(null);

		nombreComp = new JTextField();
		nombreComp.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreComp.setColumns(10);
		nombreComp.setBounds(141, 163, 200, 37);
		panelCompeticion.add(nombreComp);

		lblIntroduceElNombre = new JLabel(
				"<html>Introduce el nombre nuevo de la competición: (en caso de querer modificarlo)</html>");
		lblIntroduceElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElNombre.setForeground(Color.DARK_GRAY);
		lblIntroduceElNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblIntroduceElNombre.setBounds(59, 112, 355, 40);
		panelCompeticion.add(lblIntroduceElNombre);

		lblIntroduceElDeporte = new JLabel(
				"<html>Introduce el deporte nuevo al que pertenece la competición: (en caso de querer modificarlo)</html>");
		lblIntroduceElDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElDeporte.setForeground(Color.DARK_GRAY);
		lblIntroduceElDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblIntroduceElDeporte.setBounds(59, 222, 361, 40);
		panelCompeticion.add(lblIntroduceElDeporte);

		competicionesCombo = new JComboBox();
		competicionesCombo.setForeground(new Color(173, 255, 47));
		competicionesCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		competicionesCombo.setBackground(Color.DARK_GRAY);
		competicionesCombo.setBounds(84, 48, 305, 38);
		panelCompeticion.add(competicionesCombo);

		JLabel lblEscogeLaCompeticion = new JLabel("Escoge la competición que quieras modificar:");
		lblEscogeLaCompeticion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscogeLaCompeticion.setForeground(Color.DARK_GRAY);
		lblEscogeLaCompeticion.setFont(new Font("Arial", Font.BOLD, 16));
		lblEscogeLaCompeticion.setBounds(10, 11, 459, 40);
		panelCompeticion.add(lblEscogeLaCompeticion);

		deporteC = new JComboBox();
		deporteC.setBackground(Color.DARK_GRAY);
		deporteC.setForeground(new Color(173, 255, 47));
		deporteC.setFont(new Font("Arial", Font.PLAIN, 16));
		deporteC.setBounds(84, 273, 305, 37);
		panelCompeticion.add(deporteC);
		panelCompeticion.setVisible(false);

		panelEquipo = new JPanel();
		panelEquipo.setBounds(0, 177, 479, 318);
		contentPanel.add(panelEquipo);
		panelEquipo.setBackground(new Color(173, 255, 47));
		panelEquipo.setLayout(null);

		nombreE = new JTextField();
		nombreE.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreE.setColumns(10);
		nombreE.setBounds(252, 126, 200, 37);
		panelEquipo.add(nombreE);

		localidad = new JTextField();
		localidad.setFont(new Font("Arial", Font.PLAIN, 16));
		localidad.setColumns(10);
		localidad.setBounds(252, 174, 200, 37);
		panelEquipo.add(localidad);

		pais = new JTextField();
		pais.setFont(new Font("Arial", Font.PLAIN, 16));
		pais.setColumns(10);
		pais.setBounds(252, 222, 200, 37);
		panelEquipo.add(pais);

		estadio = new JTextField();
		estadio.setFont(new Font("Arial", Font.PLAIN, 16));
		estadio.setColumns(10);
		estadio.setBounds(252, 270, 200, 37);
		panelEquipo.add(estadio);

		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setForeground(Color.DARK_GRAY);
		lblNombre_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre_1.setBounds(10, 126, 232, 37);
		panelEquipo.add(lblNombre_1);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(Color.DARK_GRAY);
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocalidad.setBounds(10, 174, 232, 37);
		panelEquipo.add(lblLocalidad);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setForeground(Color.DARK_GRAY);
		lblPais.setFont(new Font("Arial", Font.BOLD, 16));
		lblPais.setBounds(10, 222, 232, 37);
		panelEquipo.add(lblPais);

		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setForeground(Color.DARK_GRAY);
		lblEstadio.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstadio.setBounds(10, 270, 232, 37);
		panelEquipo.add(lblEstadio);

		equiposCombo = new JComboBox();
		equiposCombo.setForeground(new Color(173, 255, 47));
		equiposCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		equiposCombo.setBackground(Color.DARK_GRAY);
		equiposCombo.setBounds(86, 48, 305, 38);
		panelEquipo.add(equiposCombo);

		JLabel lblEscogeElEquipo = new JLabel("Escoge el equipo que quieras modificar:");
		lblEscogeElEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscogeElEquipo.setForeground(Color.DARK_GRAY);
		lblEscogeElEquipo.setFont(new Font("Arial", Font.BOLD, 16));
		lblEscogeElEquipo.setBounds(10, 11, 459, 40);
		panelEquipo.add(lblEscogeElEquipo);

		JLabel lblNoEsNecesario = new JLabel("No es necesario modificar todos los campos.");
		lblNoEsNecesario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoEsNecesario.setForeground(Color.DARK_GRAY);
		lblNoEsNecesario.setFont(new Font("Arial", Font.BOLD, 16));
		lblNoEsNecesario.setBounds(10, 86, 459, 40);
		panelEquipo.add(lblNoEsNecesario);

		panelEquipo.setVisible(false);

		panelDeporte = new JPanel();
		panelDeporte.setBackground(new Color(173, 255, 47));
		panelDeporte.setBounds(0, 177, 479, 318);
		contentPanel.add(panelDeporte);
		panelDeporte.setLayout(null);

		nombreDep = new JTextField();
		nombreDep.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreDep.setColumns(10);
		nombreDep.setBounds(135, 193, 200, 37);
		panelDeporte.add(nombreDep);

		lblNewLabel = new JLabel("<html>Introduce el nuevo nombre del deporte: (en caso de querer modificarlo)</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(84, 142, 305, 40);
		panelDeporte.add(lblNewLabel);

		deportesCombo = new JComboBox();
		deportesCombo.setBackground(Color.DARK_GRAY);
		deportesCombo.setForeground(new Color(173, 255, 47));
		deportesCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		deportesCombo.setBounds(84, 68, 305, 38);
		panelDeporte.add(deportesCombo);

		JLabel lblEscogeElDeporte = new JLabel("Escoge el deporte que quieras modificar:");
		lblEscogeElDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscogeElDeporte.setForeground(Color.DARK_GRAY);
		lblEscogeElDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblEscogeElDeporte.setBounds(10, 31, 459, 40);
		panelDeporte.add(lblEscogeElDeporte);
		panelDeporte.setVisible(false);

		panelJugador = new JPanel();
		panelJugador.setBorder(null);
		panelJugador.setLayout(null);
		panelJugador.setBackground(new Color(173, 255, 47));
		panelJugador.setBounds(0, 180, 479, 318);
		contentPanel.add(panelJugador);
		panelJugador.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 479, 88);
		contentPanel.add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel_2.setBounds(156, 0, 220, 88);
		panel_2.add(lblNewLabel_2);
		panelJugador.setVisible(false);

		// Guardamos todas los Equipos
		List<Equipo> equipos = dao.listadoEquipos();

		// Creamos la tabla con los Equipos guardados recientemente
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
			competicionesCombo.addItem(comp.getCodCompeticion() + "-" + comp.getNombre() + "-" + comp.getDeporte());
		}
		competicionesCombo.setSelectedIndex(-1);
	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = dao.listadoDeportes();
		for (Deporte dep : deportes) {
			deportesCombo.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
			deporteC.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
		}
		deportesCombo.setSelectedIndex(-1);
		deporteC.setSelectedIndex(-1);
	}

	private void cargarEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listadoEquipos();
		for (Equipo equipo : equipos) {
			equiposCombo.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		equiposCombo.setSelectedIndex(-1);
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
				VModificarJugador vent = new VModificarJugador(vElegir, true, dao, equipos.get(fila));
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
	 * @return
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
			eleccion();
		}
	}

	private void eleccion() {
		// TODO Auto-generated method stub
		Equipo equipoClase;
		Deporte depClase;
		Competicion compClase;

		/*
		 * Dependiendo del rdbtn seleccionado se envia al dao lo que se quiere
		 * modificar, en caso de que no se consiga eliminar se avisara de ello mediante
		 * un JoptionPane
		 */
		if (equipo.isSelected()) {
			if (equiposCombo.getSelectedIndex() != -1) {
				if (!nombreE.getText().equalsIgnoreCase("") || !localidad.getText().equalsIgnoreCase("")
						|| !pais.getText().equalsIgnoreCase("") || !estadio.getText().equalsIgnoreCase("")) {
					equipoClase = new Equipo();
					String cadena = (String) equiposCombo.getSelectedItem();
					int pos = cadena.indexOf("-");
					String cod = cadena.substring(0, pos);
					equipoClase.setCodEquipo(cod);
					equipoClase.setNombreEquipo(nombreE.getText());
					equipoClase.setLocalidad(localidad.getText());
					equipoClase.setPais(pais.getText());
					equipoClase.setEstadio(estadio.getText());

					if (dao.modificarEquipo(equipoClase)) {
						JOptionPane.showMessageDialog(this, "EQUIPO MODIFICADO CORRECTAMENTE.");
						equiposCombo.setSelectedIndex(-1);
						nombreE.setText("");
						localidad.setText("");
						pais.setText("");
						estadio.setText("");
					} else {
						JOptionPane.showMessageDialog(this,
								"NO SE HA CONSEGUIDO MODIFICAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
					}
				} else {
					JOptionPane.showMessageDialog(this, "DEBES RELLENAR AL MENOS UN CAMPO");
				}

			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UN EQUIPO.");
			}
		}

		if (deporte.isSelected()) {
			if (deportesCombo.getSelectedIndex() != -1) {
				depClase = new Deporte();
				String cadena = (String) deportesCombo.getSelectedItem();
				int pos = cadena.indexOf("-");
				String cod = cadena.substring(0, pos);
				depClase.setCodDep(cod);
				depClase.setNombreDep(nombreDep.getText());

				if (dao.modificarDeporte(depClase)) {
					JOptionPane.showMessageDialog(this, "DEPORTE MODIFICADO CORRECTAMENTE.");
					deportesCombo.setSelectedIndex(-1);
					nombreDep.setText("");
				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO MODIFICAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UN DEPORTE.");
			}
		}

		if (competicion.isSelected()) {
			if (competicionesCombo.getSelectedIndex() != -1) {
				compClase = new Competicion();
				String cadena = (String) competicionesCombo.getSelectedItem();
				int pos = cadena.indexOf("-");
				String cod = cadena.substring(0, pos);
				compClase.setCodCompeticion(cod);

				compClase.setNombre(nombreComp.getText());

				String cadena2 = (String) deporteC.getSelectedItem();
				int pos2 = cadena2.indexOf("-");
				String deporte = cadena2.substring(pos2 + 1);
				compClase.setDeporte(deporte);

				if (dao.modificarCompeticion(compClase)) {
					JOptionPane.showMessageDialog(this, "COMPETICION MODIFICADA CORRECTAMENTE.");
					competicionesCombo.setSelectedIndex(-1);
					nombreComp.setText("");
					deporteC.setSelectedIndex(-1);
				} else {
					JOptionPane.showMessageDialog(this,
							"NO SE HA CONSEGUIDO MODIFICAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
				}
			} else {
				JOptionPane.showMessageDialog(this, "ESCOGE UNA COMPETICIÓN.");
			}
		}
	}

	// Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.setFocusableWindowState(false);
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
