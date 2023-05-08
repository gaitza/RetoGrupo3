package vistas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Partido;
import modelo.Dao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JTextField;

public class VCrearApuestaEquipo extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JTextField tFFecha;
	private List<Partido> partidos;
	private JComboBox<String> cBLocal;
	private JComboBox<String> cBVisitante;
	private Dao dao;
	private VElegir vElegir;

	public VCrearApuestaEquipo(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		this.dao = dao;
		this.vElegir = vElegir;
		setTitle("Retabet.es");
		this.setModal(b);

		setBounds(100, 100, 450, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		cBLocal = new JComboBox();
		cBLocal.setBounds(62, 104, 108, 22);
		contentPanel.add(cBLocal);

		cBVisitante = new JComboBox();
		cBVisitante.setBounds(246, 104, 108, 22);
		contentPanel.add(cBVisitante);

		JLabel lblNewLabel = new JLabel("Equipo Local");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(78, 71, 93, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipoVisitante.setBounds(246, 71, 108, 14);
		contentPanel.add(lblEquipoVisitante);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(315, 215, 89, 23);
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);

		tFFecha = new JTextField();
		tFFecha.setBounds(182, 185, 86, 20);
		contentPanel.add(tFFecha);
		tFFecha.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(87, 166, 46, 14);
		contentPanel.add(lblFecha);

		cargarPartidos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			altaPartido();
		}
	}

	private void cargarPartidos() {
		partidos = dao.listarPartidos();

		if (!partidos.isEmpty()) {
			for (Partido par : partidos) {
				cBLocal.addItem(getName());
				cBVisitante.addItem(getName());
			}
			cBLocal.setSelectedIndex(-1);
			cBVisitante.setSelectedIndex(-1);
		}
	}

	private void altaPartido() {

		Partido par = new Partido();

		consultarPartidoLocal();

		consultarPartidoVisitante();

		par.setFechaPartido(LocalDate.parse(tFFecha.getText()));

		JOptionPane.showMessageDialog(null, "Partido creado correctamente");

	}

	private void consultarPartidoVisitante() {
		if (cBLocal.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un equipo visitante");
		} else {
			Partido par = null;

			// Recojo el codigo de la competicion seleccionada
			String cadena = (String) cBVisitante.getSelectedItem();
			int pos = cadena.indexOf(" ");
			String codEquipo = cadena.substring(0, pos);

			// Recojo toda la info de la competicion para mandar la a la vent de partido

			for (Partido parti : partidos) {
				if (parti.getCodPartido().equalsIgnoreCase(codEquipo)) {
					par = parti;
					break;
				}
			}
			// this.dispose();

		}

	}

	private void consultarPartidoLocal() {
		{
			if (cBLocal.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(this, "Selecciona un equipo local");
			} else {
				Partido par = null;

				// Recojo el codigo de la competicion seleccionada
				String cadena = (String) cBLocal.getSelectedItem();
				int pos = cadena.indexOf(" ");
				String codEquipo = cadena.substring(0, pos);

				// Recojo toda la info de la competicion para mandar la a la vent de partido

				for (Partido parti : partidos) {
					if (parti.getCodPartido().equalsIgnoreCase(codEquipo)) {
						par = parti;
						break;
					}
				}
				// this.dispose();

			}

		}
	}

}
