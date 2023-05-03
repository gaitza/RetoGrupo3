package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Dao;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class VGestionarApuestas extends JDialog implements ActionListener{
	
	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JTable table;
	private JButton btnVolver;
	private JButton btnContinuar;

	public VGestionarApuestas(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		getContentPane().setBackground(new Color(173, 255, 47));
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;

		setTitle("Retabet.es");
		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 479, 88);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 498, 479, 58);
		getContentPane().add(panel_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(50, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(new Color(173, 255, 47));
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnContinuar.setFocusable(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(334, 11, 107, 36);
		btnContinuar.addActionListener(this);
		panel_1.add(btnContinuar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 459, 372);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(173, 255, 47));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBackground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource().equals(btnVolver)) {
					volver();
				}
				if(e.getSource().equals(btnContinuar)) {
					eleccion();
				}
		
	}
	
	private void eleccion() {
		// TODO Auto-generated method stub
		
	}

	private void volver() {
		// TODO Auto-generated method stub
		this.setFocusableWindowState(false);
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao);
		vent.setVisible(true);
	}
}
