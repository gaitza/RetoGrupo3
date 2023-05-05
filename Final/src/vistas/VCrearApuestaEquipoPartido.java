package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Competicion;
import clases.Deporte;
import clases.Partido;
import modelo.Dao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VCrearApuestaEquipoPartido extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JLabel lblVisitante;
	private JLabel lblLocal;
	private JComboBox<String> cBLocal;
	private JComboBox<String> cBVisitante;
	private List<Partido> partidos;
	private Dao dao;
	private VElegir vElegir;

	public VCrearApuestaEquipoPartido(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		this.dao = dao;
		this.vElegir = vElegir;
		setTitle("Retabet.es");
		this.setModal(b);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(284, 190, 89, 23);
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);

		cBLocal = new JComboBox();
		cBLocal.setBounds(69, 90, 98, 22);
		contentPanel.add(cBLocal);

		cBVisitante = new JComboBox();
		cBVisitante.setBounds(275, 90, 98, 22);
		contentPanel.add(cBVisitante);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(98, 50, 46, 14);
		contentPanel.add(lblLocal);

		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setBounds(299, 50, 46, 14);
		contentPanel.add(lblVisitante);

		cargarPartidos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			consultarPartidoLocal();
			consultarPartidoVisitante();
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

	private void consultarPartidoLocal() {
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

}
