package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;

import javax.swing.JTextField;

/**
 * @author Grupo3
 *
 */
public class VInsertarBDA extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JButton relacionar;
	private JRadioButton jugador;
	private JRadioButton equipo;
	private JRadioButton deporte;
	private JRadioButton competicion;
	private ButtonGroup grupo;
	private JPanel panelJugador;
	private JPanel panelEquipo;
	private JPanel panelDeporte;
	private JPanel panelCompeticion;
	private JTextField nombreJ;
	private JTextField primerAp;
	private JTextField segundoAp;
	private JTextField fechaNac;
	private JTextField dorsal;
	private JTextField nombreE;
	private JTextField fechaFun;
	private JTextField localidad;
	private JTextField pais;
	private JTextField estadio;
	private JTextField nombreDep;
	private JLabel lblNewLabel;
	private JTextField deporteC;
	private JTextField nombreComp;
	private JLabel lblIntroduceElNombre;
	private JLabel lblIntroduceElDeporte;
	private JComboBox comboBox;
	private JLabel lblDeporte;
	private JComboBox deportesCombo;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VInsertarBDA(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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
		contentPanel.setBackground(Color.DARK_GRAY);
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
		btnVolver.setBounds(10, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Confirmar");
		btnContinuar.setBounds(362, 11, 107, 36);
		panel_1.add(btnContinuar);
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);

		relacionar = new JButton("Relacionar Equipo, Dep y Comp.");
		relacionar.setForeground(new Color(173, 255, 47));
		relacionar.setFont(new Font("Arial", Font.PLAIN, 14));
		relacionar.setFocusable(false);
		relacionar.setBorder(null);
		relacionar.setBackground(Color.DARK_GRAY);
		relacionar.setBounds(127, 11, 225, 36);
		relacionar.addActionListener(this);
		panel_1.add(relacionar);
		btnContinuar.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Escoge la opcion de lo que quieras insertar:");
		lblNewLabel_1.setForeground(new Color(173, 255, 47));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 89, 479, 35);
		contentPanel.add(lblNewLabel_1);

		jugador = new JRadioButton("Jugador");
		jugador.setForeground(new Color(173, 255, 47));
		jugador.setHorizontalAlignment(SwingConstants.CENTER);
		jugador.setFont(new Font("Arial", Font.PLAIN, 14));
		jugador.setBackground(Color.DARK_GRAY);
		jugador.setBounds(0, 143, 120, 23);
		jugador.setFocusable(false);
		jugador.setBorder(null);
		jugador.addActionListener(this);
		contentPanel.add(jugador);

		equipo = new JRadioButton("Equipo");
		equipo.setForeground(new Color(173, 255, 47));
		equipo.setHorizontalAlignment(SwingConstants.CENTER);
		equipo.setFont(new Font("Arial", Font.PLAIN, 14));
		equipo.setBackground(Color.DARK_GRAY);
		equipo.setBounds(122, 144, 120, 23);
		equipo.setFocusable(false);
		equipo.setBorder(null);
		equipo.addActionListener(this);
		contentPanel.add(equipo);

		deporte = new JRadioButton("Deporte");
		deporte.setForeground(new Color(173, 255, 47));
		deporte.setHorizontalAlignment(SwingConstants.CENTER);
		deporte.setFont(new Font("Arial", Font.PLAIN, 14));
		deporte.setBackground(Color.DARK_GRAY);
		deporte.setBounds(244, 144, 120, 23);
		deporte.setFocusable(false);
		deporte.setBorder(null);
		deporte.addActionListener(this);
		contentPanel.add(deporte);

		competicion = new JRadioButton("Competición");
		competicion.setForeground(new Color(173, 255, 47));
		competicion.setHorizontalAlignment(SwingConstants.CENTER);
		competicion.setFont(new Font("Arial", Font.PLAIN, 14));
		competicion.setBackground(Color.DARK_GRAY);
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

		panelEquipo = new JPanel();
		panelEquipo.setBounds(0, 177, 479, 318);
		contentPanel.add(panelEquipo);
		panelEquipo.setBackground(Color.DARK_GRAY);
		panelEquipo.setLayout(null);

		nombreE = new JTextField();
		nombreE.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreE.setColumns(10);
		nombreE.setBounds(209, 11, 243, 37);
		panelEquipo.add(nombreE);

		fechaFun = new JTextField();
		fechaFun.setFont(new Font("Arial", Font.PLAIN, 16));
		fechaFun.setColumns(10);
		fechaFun.setBounds(209, 59, 243, 37);
		panelEquipo.add(fechaFun);

		localidad = new JTextField();
		localidad.setFont(new Font("Arial", Font.PLAIN, 16));
		localidad.setColumns(10);
		localidad.setBounds(209, 107, 243, 37);
		panelEquipo.add(localidad);

		pais = new JTextField();
		pais.setFont(new Font("Arial", Font.PLAIN, 16));
		pais.setColumns(10);
		pais.setBounds(209, 155, 243, 37);
		panelEquipo.add(pais);

		estadio = new JTextField();
		estadio.setFont(new Font("Arial", Font.PLAIN, 16));
		estadio.setColumns(10);
		estadio.setBounds(209, 203, 243, 37);
		panelEquipo.add(estadio);

		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setForeground(new Color(173, 255, 47));
		lblNombre_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre_1.setBounds(10, 11, 189, 37);
		panelEquipo.add(lblNombre_1);

		JLabel lblFechaFundacin = new JLabel("Fecha Fundación:");
		lblFechaFundacin.setForeground(new Color(173, 255, 47));
		lblFechaFundacin.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaFundacin.setBounds(10, 59, 189, 37);
		panelEquipo.add(lblFechaFundacin);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(173, 255, 47));
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 16));
		lblLocalidad.setBounds(10, 107, 189, 37);
		panelEquipo.add(lblLocalidad);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setForeground(new Color(173, 255, 47));
		lblPais.setFont(new Font("Arial", Font.BOLD, 16));
		lblPais.setBounds(10, 155, 189, 37);
		panelEquipo.add(lblPais);

		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setForeground(new Color(173, 255, 47));
		lblEstadio.setFont(new Font("Arial", Font.BOLD, 16));
		lblEstadio.setBounds(10, 203, 189, 37);
		panelEquipo.add(lblEstadio);

		lblDeporte = new JLabel("Deporte:");
		lblDeporte.setForeground(new Color(173, 255, 47));
		lblDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblDeporte.setBounds(10, 251, 189, 37);
		panelEquipo.add(lblDeporte);

		deportesCombo = new JComboBox();
		deportesCombo.setBounds(209, 251, 243, 37);
		panelEquipo.add(deportesCombo);

		panelEquipo.setVisible(false);

		panelCompeticion = new JPanel();
		panelCompeticion.setBackground(Color.DARK_GRAY);
		panelCompeticion.setBounds(0, 177, 479, 321);
		contentPanel.add(panelCompeticion);
		panelCompeticion.setLayout(null);

		deporteC = new JTextField();
		deporteC.setFont(new Font("Arial", Font.PLAIN, 16));
		deporteC.setColumns(10);
		deporteC.setBounds(143, 89, 200, 37);
		panelCompeticion.add(deporteC);

		nombreComp = new JTextField();
		nombreComp.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreComp.setColumns(10);
		nombreComp.setBounds(143, 217, 200, 37);
		panelCompeticion.add(nombreComp);

		lblIntroduceElNombre = new JLabel("Introduce el nombre de la competición:");
		lblIntroduceElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElNombre.setForeground(new Color(173, 255, 47));
		lblIntroduceElNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblIntroduceElNombre.setBounds(72, 38, 345, 40);
		panelCompeticion.add(lblIntroduceElNombre);

		lblIntroduceElDeporte = new JLabel("Introduce el deporte al que pertenece la competición:");
		lblIntroduceElDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElDeporte.setForeground(new Color(173, 255, 47));
		lblIntroduceElDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblIntroduceElDeporte.setBounds(10, 166, 459, 40);
		panelCompeticion.add(lblIntroduceElDeporte);

		panelDeporte = new JPanel();
		panelDeporte.setBackground(Color.DARK_GRAY);
		panelDeporte.setBounds(0, 177, 479, 318);
		contentPanel.add(panelDeporte);
		panelDeporte.setLayout(null);

		nombreDep = new JTextField();
		nombreDep.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreDep.setColumns(10);
		nombreDep.setBounds(148, 149, 200, 37);
		panelDeporte.add(nombreDep);

		lblNewLabel = new JLabel("Introduce el nombre del deporte:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(173, 255, 47));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(74, 98, 345, 40);
		panelDeporte.add(lblNewLabel);

		panelJugador = new JPanel();
		panelJugador.setBorder(null);
		panelJugador.setLayout(null);
		panelJugador.setBackground(Color.DARK_GRAY);
		panelJugador.setBounds(0, 180, 479, 318);
		contentPanel.add(panelJugador);

		nombreJ = new JTextField();
		nombreJ.setFont(new Font("Arial", Font.PLAIN, 16));
		nombreJ.setBounds(252, 11, 200, 37);
		panelJugador.add(nombreJ);
		nombreJ.setColumns(10);

		primerAp = new JTextField();
		primerAp.setFont(new Font("Arial", Font.PLAIN, 16));
		primerAp.setColumns(10);
		primerAp.setBounds(252, 59, 200, 37);
		panelJugador.add(primerAp);

		segundoAp = new JTextField();
		segundoAp.setFont(new Font("Arial", Font.PLAIN, 16));
		segundoAp.setColumns(10);
		segundoAp.setBounds(252, 107, 200, 37);
		panelJugador.add(segundoAp);

		fechaNac = new JTextField();
		fechaNac.setFont(new Font("Arial", Font.PLAIN, 16));
		fechaNac.setColumns(10);
		fechaNac.setBounds(252, 155, 200, 37);
		panelJugador.add(fechaNac);

		dorsal = new JTextField();
		dorsal.setFont(new Font("Arial", Font.PLAIN, 16));
		dorsal.setColumns(10);
		dorsal.setBounds(252, 203, 200, 37);
		panelJugador.add(dorsal);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setForeground(new Color(173, 255, 47));
		lblNombre.setBounds(10, 11, 232, 37);
		panelJugador.add(lblNombre);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(252, 251, 200, 37);
		panelJugador.add(comboBox);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setForeground(new Color(173, 255, 47));
		lblPrimerApellido.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrimerApellido.setBounds(10, 59, 232, 37);
		panelJugador.add(lblPrimerApellido);

		JLabel lblSegundoApellidonoNecesario = new JLabel("Segundo Apellido:");
		lblSegundoApellidonoNecesario.setForeground(new Color(173, 255, 47));
		lblSegundoApellidonoNecesario.setFont(new Font("Arial", Font.BOLD, 16));
		lblSegundoApellidonoNecesario.setBounds(10, 107, 232, 37);
		panelJugador.add(lblSegundoApellidonoNecesario);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(new Color(173, 255, 47));
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(10, 155, 232, 37);
		panelJugador.add(lblFechaDeNacimiento);

		JLabel lblDorsasl = new JLabel("Dorsal:");
		lblDorsasl.setForeground(new Color(173, 255, 47));
		lblDorsasl.setFont(new Font("Arial", Font.BOLD, 16));
		lblDorsasl.setBounds(10, 203, 232, 37);
		panelJugador.add(lblDorsasl);

		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setForeground(new Color(173, 255, 47));
		lblEquipo.setFont(new Font("Arial", Font.BOLD, 16));
		lblEquipo.setBounds(10, 251, 232, 37);
		panelJugador.add(lblEquipo);

		JLabel lblnoEsNecesario = new JLabel("(No es necesario)");
		lblnoEsNecesario.setForeground(new Color(173, 255, 47));
		lblnoEsNecesario.setFont(new Font("Arial", Font.BOLD, 10));
		lblnoEsNecesario.setBounds(10, 130, 100, 25);
		panelJugador.add(lblnoEsNecesario);
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
		panelDeporte.setVisible(false);
		panelCompeticion.setVisible(false);

		// cargamos en cada comboBox la informacion necesaria
		cargarEquipos();
		cargarDeportes();

	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = dao.listadoDeportes();
		for (Deporte dep : deportes) {
			deportesCombo.addItem(dep.getCodDep() + "-" + dep.getNombreDep());
		}
		deportesCombo.setSelectedIndex(-1);
	}

	private void cargarEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listadoEquipos();
		for (Equipo equipo : equipos) {
			comboBox.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		comboBox.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// dependiendo de lo que se quiera insertar se hace visible un panel u otro
		if (jugador.isSelected()) {
			panelJugador.setVisible(true);
			panelEquipo.setVisible(false);
			panelDeporte.setVisible(false);
			panelCompeticion.setVisible(false);
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
			insertarJEDC();
		}
		if (e.getSource().equals(relacionar)) {
			abrirVentanaNueva();
		}
	}

	// se abre una ventana donde se ralacionan las tablas entre si
	private void abrirVentanaNueva() {
		// TODO Auto-generated method stub
		this.dispose();
		VRelacionar vent = new VRelacionar(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	// Metodo para enviar los datos al dao
	private void insertarJEDC() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Jugador jugadorClase;
		Equipo equipoClase;
		Deporte depClase;
		Competicion compClase;

		/*
		 * Dependiendo del rdbtn seleccionado se envia al dao lo que se quiere crear, en
		 * caso de que no se consiga crear se avisara de ello mediante un JoptionPane
		 */
		if (jugador.isSelected()) {
			jugadorClase = new Jugador();
			jugadorClase.setNombreJ(nombreJ.getText());
			jugadorClase.setApellido1(primerAp.getText());
			jugadorClase.setApellido2(segundoAp.getText());
			jugadorClase.setFechaNac(LocalDate.parse(fechaNac.getText(), formateador));
			jugadorClase.setDorsal(Integer.parseInt(dorsal.getText()));
			String cadena = (String) comboBox.getSelectedItem();
			int pos = cadena.indexOf("-");
			String codEquipo = cadena.substring(0, pos);
			jugadorClase.setCodEquipo(codEquipo);

			if (dao.insertarJugador(jugadorClase)) {
				JOptionPane.showMessageDialog(this, "JUGADOR INTRODUCIDO CORRECTAMENTE.");
				nombreJ.setText("");
				primerAp.setText("");
				segundoAp.setText("");
				fechaNac.setText("");
				dorsal.setText("");
				comboBox.setSelectedIndex(-1);
			} else {
				JOptionPane.showMessageDialog(this,
						"NO SE HA CONSEGUIDO INTRODUCIR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		}

		if (equipo.isSelected()) {
			equipoClase = new Equipo();
			equipoClase.setNombreEquipo(nombreE.getText());
			equipoClase.setFechaFun(Integer.parseInt(fechaFun.getText()));
			equipoClase.setLocalidad(localidad.getText());
			equipoClase.setPais(pais.getText());
			equipoClase.setEstadio(estadio.getText());
			String cadena = (String) deportesCombo.getSelectedItem();
			int pos = cadena.indexOf("-");
			String nombreDep = cadena.substring(pos + 1);
			equipoClase.setDeporte(nombreDep);

			if (dao.insertarEquipo(equipoClase)) {
				JOptionPane.showMessageDialog(this, "EQUIPO INTRODUCIDO CORRECTAMENTE.");
				nombreE.setText("");
				fechaFun.setText("");
				localidad.setText("");
				pais.setText("");
				estadio.setText("");
				deportesCombo.setSelectedIndex(-1);
			} else {
				JOptionPane.showMessageDialog(this,
						"NO SE HA CONSEGUIDO INTRODUCIR CORRECTAMENTE.\\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		}

		if (deporte.isSelected()) {
			depClase = new Deporte();
			depClase.setNombreDep(nombreDep.getText());

			if (dao.insertarDeporte(depClase)) {
				JOptionPane.showMessageDialog(this, "DEPORTE INTRODUCIDO CORRECTAMENTE.");
				nombreDep.setText("");
			} else {
				JOptionPane.showMessageDialog(this,
						"NO SE HA CONSEGUIDO INTRODUCIR CORRECTAMENTE.\\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		}

		if (competicion.isSelected()) {
			compClase = new Competicion();
			compClase.setNombre(nombreComp.getText());
			compClase.setDeporte(deporteC.getText());

			if (dao.insertarCompeticion(compClase)) {
				JOptionPane.showMessageDialog(this, "COMPETICIÓN INTRODUCIDA CORRECTAMENTE.");
				nombreComp.setText("");
				deporteC.setText("");
			} else {
				JOptionPane.showMessageDialog(this,
						"NO SE HA CONSEGUIDO INTRODUCIR CORRECTAMENTE.\\nPOR FAVOR INTENTELO DE NUEVO.");
			}
		}
	}

	// mteodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.setFocusableWindowState(false);
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
