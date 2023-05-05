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
import modelo.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class VCrearApuestaEquipoDeporte extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JLabel lblDeporte;
	private JComboBox<String> cBDeporte;
	private List<Deporte> deportes;
	private Dao dao;
	private VElegir vElegir;

	public VCrearApuestaEquipoDeporte(VElegir vElegir, boolean b, Dao dao) {
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
		setLocationRelativeTo(null);

		JLabel lblDeporte = new JLabel("New label");
		lblDeporte.setBounds(89, 107, 46, 14);
		contentPanel.add(lblDeporte);

		JButton btnAceptar = new JButton("New button");
		btnAceptar.setBounds(239, 197, 89, 23);
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);

		cBDeporte = new JComboBox();
		cBDeporte.setBounds(239, 103, 102, 22);
		contentPanel.add(cBDeporte);

		cargarDeportes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			consultarDeporte();
		}
	}

	private void cargarDeportes() {
		// TODO Auto-generated method stub
		deportes = dao.listarDeporte();

		if (!deportes.isEmpty()) {
			for (Deporte dep : deportes) {
				cBDeporte.addItem(dep.getNombreDep());
			}

			cBDeporte.setSelectedIndex(-1);
		}
	}

	private void consultarDeporte() {
		//
		if (cBDeporte.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un deporte");
		} else {
			Deporte dep = null;

			// Recojo el codigo del deporte seleccionado
			String cadena = (String) cBDeporte.getSelectedItem();
			int pos = cadena.indexOf(" ");
			String codDeporte = cadena.substring(0, pos);

			// Recojo toda la info del deporte para mandar la a la vent de competicion

			for (Deporte depor : deportes) {
				if (depor.getCodDep().equalsIgnoreCase(codDeporte)) {
					dep = depor;
					break;
				}
			}
			// this.dispose();

		}

	}

}
