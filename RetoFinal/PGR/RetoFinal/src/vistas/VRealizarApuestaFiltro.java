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

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VRealizarApuestaFiltro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JButton btnContinuar;
	private JComboBox deportesCombo;
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VRealizarApuestaFiltro(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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
		btnVolver.setBounds(43, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(323, 11, 107, 36);
		btnContinuar.addActionListener(this);
		panel_1.add(btnContinuar);

		deportesCombo = new JComboBox();
		deportesCombo.setForeground(new Color(173, 255, 47));
		deportesCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		deportesCombo.setBackground(Color.DARK_GRAY);
		deportesCombo.setBounds(68, 286, 343, 40);
		contentPanel.add(deportesCombo);

		JLabel lblEligeElDeporte = new JLabel("Elige el deporte sobre el que quieres realizar la apuesta:");
		lblEligeElDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeElDeporte.setFont(new Font("Arial", Font.BOLD, 16));
		lblEligeElDeporte.setBounds(10, 221, 459, 45);
		contentPanel.add(lblEligeElDeporte);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnContinuar)) {
			continuar();
		}
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	private void continuar() {
		// TODO Auto-generated method stub
		if (deportesCombo.getSelectedIndex() == -1 ) {

			this.dispose();
			VMenuApuestas vent = new VMenuApuestas(vElegir, true, dao, null, null, cuenta);
			vent.setVisible(true);

		} else {

			Deporte deportes = new Deporte();
			String cadenaDeporte = (String) deportesCombo.getSelectedItem();
			int posDep = cadenaDeporte.indexOf("-");
			String codDeporte = cadenaDeporte.substring(0, posDep);
			String nombreDep = cadenaDeporte.substring(posDep + 1);
			deportes.setCodDep(codDeporte);
			deportes.setNombreDep(nombreDep);
			
			this.dispose();
			VMenuApuestas vent = new VMenuApuestas(vElegir, true, dao, deportes, null, cuenta);
			vent.setVisible(true);
			
		}

	}

	//Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

}
