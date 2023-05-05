package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
public class VGestionarApuestas extends JDialog implements ActionListener{
	
	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JTable table;
	private JButton btnVolver;
	private JButton btnContinuar;
=======
import clases.Apuesta;
import clases.ListadoApuestas;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VGestionarApuestas extends JDialog implements ActionListener {
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JTable tabla;
>>>>>>> 0b7b409ffd49cdd87e76c4d7d0940c72d25e39c5

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
		panel.setBounds(0, 0, 479, 88);
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(156, 0, 220, 88);
		lblNewLabel.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 498, 479, 58);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		getContentPane().add(panel_1);
<<<<<<< HEAD
		
=======

>>>>>>> 0b7b409ffd49cdd87e76c4d7d0940c72d25e39c5
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
<<<<<<< HEAD
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
=======
		btnVolver.setBounds(183, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		List<ListadoApuestas> apuestas = dao.listarApuestas();
		presentarTabla(apuestas);
>>>>>>> 0b7b409ffd49cdd87e76c4d7d0940c72d25e39c5
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
				if(e.getSource().equals(btnVolver)) {
					volver();
				}
				if(e.getSource().equals(btnContinuar)) {
					eleccion();
				}
=======
		if (e.getSource().equals(btnVolver)) {
			volver();
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		this.setFocusableWindowState(false);
		this.dispose();
		VMenuAdmin vent = new VMenuAdmin(vElegir, true, dao);
		vent.setVisible(true);
	}

	public void presentarTabla(List<ListadoApuestas> apuestas) {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.getViewport().setBackground(new Color(173, 255, 47));
		scroll.setEnabled(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		tabla = this.cargarTabla(apuestas);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=tabla.getSelectedRow();
				VPonerResultado vent = new VPonerResultado(vElegir, true, dao, apuestas.get(fila));
				vent.setVisible(true);
			}
		});
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setBorder(null);
		tabla.setBackground(Color.DARK_GRAY);
		tabla.setForeground(new Color(173, 255, 47));
		tabla.setFont(new Font("Arial", Font.PLAIN, 14));
		tabla.setRowHeight(40);
		scroll.setViewportView(tabla);
		getContentPane().add(scroll);
		scroll.setBounds(10, 132, 459, 355);
>>>>>>> 0b7b409ffd49cdd87e76c4d7d0940c72d25e39c5
		
		JLabel lblNewLabel_1 = new JLabel("APUESTAS GENERADAS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(98, 99, 294, 28);
		getContentPane().add(lblNewLabel_1);
	}

	public JTable cargarTabla(List<ListadoApuestas> apuestas) {
		String[] cabezeras = {"EQUIPO L.", "EQUIPO V.", "FECHA P.","FECHA A.", "CUOTA"};
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabezeras);

		for (ListadoApuestas a : apuestas) {
			fila[0] = a.geteLocal() + "";
			fila[1] = a.geteVisitante() + "";
			fila[2] = a.getfPartido() + "";
			fila[3] = a.getfApuesta() + "";
			fila[4] = a.getCuota() + "";

			model.addRow(fila);
		}

		return new JTable(model);
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
