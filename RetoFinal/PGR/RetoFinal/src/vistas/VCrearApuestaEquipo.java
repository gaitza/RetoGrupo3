package vistas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Apuesta;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugar;
import clases.Partido;
import modelo.Dao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Grupo3
 *
 */
public class VCrearApuestaEquipo extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnAceptar;
	private JTextField tFFecha;
	private JComboBox cBLocal;
	private JComboBox cBVisitante;
	private Dao dao;
	private VElegir vElegir;
	private Deporte deportes;
	private Competicion competiciones;
	private JTextField cuota;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param deportes
	 * @param competiciones
	 * @param cuenta
	 */
	public VCrearApuestaEquipo(VElegir vElegir, boolean b, Dao dao, Deporte deportes, Competicion competiciones, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.deportes = deportes;
		this.competiciones = competiciones;
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

		cBLocal = new JComboBox();
		cBLocal.setForeground(new Color(173, 255, 47));
		cBLocal.setBackground(Color.DARK_GRAY);
		cBLocal.setFont(new Font("Arial", Font.PLAIN, 16));
		cBLocal.setBounds(10, 224, 192, 36);
		contentPanel.add(cBLocal);

		cBVisitante = new JComboBox();
		cBVisitante.setBackground(Color.DARK_GRAY);
		cBVisitante.setFont(new Font("Arial", Font.PLAIN, 16));
		cBVisitante.setForeground(new Color(173, 255, 47));
		cBVisitante.setBounds(277, 224, 192, 36);
		contentPanel.add(cBVisitante);

		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipoVisitante.setFont(new Font("Arial", Font.BOLD, 18));
		lblEquipoVisitante.setBounds(277, 179, 192, 36);
		contentPanel.add(lblEquipoVisitante);

		tFFecha = new JTextField();
		tFFecha.setBounds(246, 333, 192, 36);
		contentPanel.add(tFFecha);
		tFFecha.setColumns(10);

		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(43, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(173, 255, 47));
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAceptar.setFocusable(false);
		btnAceptar.setBorder(null);
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setBounds(323, 11, 107, 36);
		btnAceptar.addActionListener(this);
		panel_1.add(btnAceptar);

		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipoLocal.setFont(new Font("Arial", Font.BOLD, 18));
		lblEquipoLocal.setBounds(10, 182, 192, 31);
		contentPanel.add(lblEquipoLocal);

		JLabel lblFechaDelPartido = new JLabel("Fecha del partido:");
		lblFechaDelPartido.setFont(new Font("Arial", Font.BOLD, 18));
		lblFechaDelPartido.setBounds(44, 334, 192, 31);
		contentPanel.add(lblFechaDelPartido);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(212, 224, 55, 36);
		contentPanel.add(lblNewLabel_1);

		JLabel lblCuota = new JLabel("Cuota:");
		lblCuota.setFont(new Font("Arial", Font.BOLD, 18));
		lblCuota.setBounds(44, 402, 192, 31);
		contentPanel.add(lblCuota);

		cuota = new JTextField();
		cuota.setColumns(10);
		cuota.setBounds(246, 401, 192, 36);
		contentPanel.add(cuota);

		//cargamos en cada comboBox la informacion de los equipos
		cargarEquipoLocal();
		cargarEquipoVisitante();
	}

	private void cargarEquipoVisitante() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listarEquiposPorDeporteYCompeticion(deportes, competiciones);
		for (Equipo equipo : equipos) {
			cBVisitante.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		cBVisitante.setSelectedIndex(-1);
	}

	private void cargarEquipoLocal() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = dao.listarEquiposPorDeporteYCompeticion(deportes, competiciones);
		for (Equipo equipo : equipos) {
			cBLocal.addItem(equipo.getCodEquipo() + "-" + equipo.getNombreEquipo());
		}
		cBLocal.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			confirmarPartido();
		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	//Metodo para enviar los datos al dao
	private void confirmarPartido() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String error = controlar(formateador);
		Jugar jugar;
		Partido partido;
		Apuesta apuesta;

		String cadenaLocal = (String) cBLocal.getSelectedItem();
		int posL = cadenaLocal.indexOf("-");
		String codLocal = cadenaLocal.substring(0, posL);

		String cadenaVisitante = (String) cBVisitante.getSelectedItem();
		int posV = cadenaVisitante.indexOf("-");
		String codVisitante = cadenaVisitante.substring(0, posV);

		//el equipo local y el visitante no pueden ser el mismo
		if (!codLocal.equalsIgnoreCase(codVisitante)) {
			if (error == "") {
				partido = new Partido();
				partido.setFechaPartido(LocalDate.parse(tFFecha.getText(), formateador));

				jugar = new Jugar();
				jugar.setCodELocal(codLocal);
				jugar.setCodEVisit(codVisitante);

				apuesta = new Apuesta();
				apuesta.setCuota(Float.parseFloat(cuota.getText()));

				//Pedimos al dao que cree la apuesta, en caso de que no se consiga crear se avisara de ello mediante un JoptionPane
				if (dao.crearApuesta(partido, jugar, apuesta)) {
					JOptionPane.showMessageDialog(this, "LA APUESTA SE HA CREADO CORRECTAMENTE.");
					this.dispose();
					VDeporteCompeticionDeApuesta vent = new VDeporteCompeticionDeApuesta(vElegir, true, dao, cuenta);
					vent.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "LA APUESTA NO SE HA CREADO CORRECTAMENTE.");
				}
			} else {
				JOptionPane.showMessageDialog(this, error);
			}
		} else {
			JOptionPane.showMessageDialog(this, "NO PUEDES INTRODUCIR COMO LOCAL Y VISITANTE AL MISMO EQUIPO.");
		}
	}

	//Metodo para controlar los datos introducidos
	/**
	 * @param formateador
	 * @return
	 */
	private String controlar(DateTimeFormatter formateador) {
		// TODO Auto-generated method stub
		String error = "";
		LocalDate fecha;

		// metodo con el que se controla q lo introducido es una fecha y es posterior a la fecha actual
		if (!tFFecha.getText().equalsIgnoreCase("")) {
			try {
				fecha = LocalDate.parse(tFFecha.getText(), formateador);

				if (fecha.isBefore(LocalDate.now())) {
					error += "LA FECHA DEBE SER POSTERIOR A HOY\n";
					tFFecha.setBackground(new Color(255, 0, 0));
				} else if (fecha.isAfter(LocalDate.now())) {
					tFFecha.setBackground(new Color(173, 255, 47));
				}
			} catch (DateTimeParseException p) {
				error += "LA FECHA DEBE SER INTRODUCIDA EN FORMATO: DD/MM/AAAA\n";
				tFFecha.setBackground(new Color(255, 0, 0));

			}
		} else {
			error += "DEBES INTRODUCIR UNA FECHA POSTERIOR A LA DE HOY.\n";
			tFFecha.setBackground(new Color(255, 0, 0));
		}

		//metodo para controlar que la cuota es un numero y es mayor a 1  
		if (!cuota.getText().equalsIgnoreCase("")) {
			try {
				float num = Float.parseFloat(cuota.getText());
				if (num <= 1) {
					error += "LA CUOTA DEBE SER SIEMPRE SUPERIOR A 1.";
					cuota.setBackground(new Color(255, 0, 0));
				} else {
					cuota.setBackground(new Color(173, 255, 47));
				}
			} catch (Exception e) {
				// TODO: handle exception
				error += "LA CUOTA DEBE SER UN NUMERO, EN CASO DE SER DECIMAL: 1.04.";
				cuota.setBackground(new Color(255, 0, 0));
			}
		} else {
			error += "DEBES RELLENAR CUOTA CON UN NUMERO.";
			cuota.setBackground(new Color(255, 0, 0));
		}

		return error;
	}

	//metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VDeporteCompeticionDeApuesta vent = new VDeporteCompeticionDeApuesta(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}
}
