package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import clases.ListadoApuestas;
import clases.Partido;
import modelo.Dao;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class VPonerResultado extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private ListadoApuestas listadoApuestas;
	private ButtonGroup grupo;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtnX;
	private JRadioButton rdbtn2;

	public VPonerResultado(VElegir vElegir, boolean b, Dao dao, ListadoApuestas listadoApuestas) {
		super(vElegir);
		getContentPane().setBackground(new Color(173, 255, 47));
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.listadoApuestas = listadoApuestas;

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

		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(173, 255, 47));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolver.setFocusable(false);
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(60, 11, 107, 36);
		btnVolver.addActionListener(this);
		panel_1.add(btnVolver);

		btnConfirmar = new JButton("Confirmar Cambios");
		btnConfirmar.setForeground(new Color(173, 255, 47));
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBorder(null);
		btnConfirmar.setBackground(Color.DARK_GRAY);
		btnConfirmar.setBounds(261, 11, 165, 36);
		btnConfirmar.addActionListener(this);
		panel_1.add(btnConfirmar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(58, 289, 368, 108);
		getContentPane().add(panel_2);
		
		rdbtn1 = new JRadioButton("1");
		rdbtn1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn1.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtn1.setBackground(Color.DARK_GRAY);
		rdbtn1.setForeground(new Color(173, 255, 47));
		rdbtn1.setBounds(0, 65, 109, 23);
		panel_2.add(rdbtn1);
		
		rdbtnX = new JRadioButton("X");
		rdbtnX.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnX.setForeground(new Color(173, 255, 47));
		rdbtnX.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtnX.setBackground(Color.DARK_GRAY);
		rdbtnX.setBounds(130, 65, 109, 23);
		panel_2.add(rdbtnX);
		
		rdbtn2 = new JRadioButton("2");
		rdbtn2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn2.setForeground(new Color(173, 255, 47));
		rdbtn2.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtn2.setBackground(Color.DARK_GRAY);
		rdbtn2.setBounds(259, 65, 109, 23);
		panel_2.add(rdbtn2);
		
		grupo = new ButtonGroup();
		grupo.add(rdbtn1);
		grupo.add(rdbtnX);
		grupo.add(rdbtn2);
		
		
		JLabel resultado = new JLabel("INTRODUCE EL RESULTADO DEL PARTIDO:");
		resultado.setForeground(new Color(173, 255, 47));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(0, 11, 368, 39);
		panel_2.add(resultado);
		resultado.setFont(new Font("Arial", Font.BOLD, 16));
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Arial", Font.BOLD, 18));
		area.setForeground(new Color(173, 255, 47));
		area.setBackground(Color.DARK_GRAY);
		area.setEditable(false);
		area.setBounds(58, 124, 368, 165);
		getContentPane().add(area);
		//Los espaciados y salto de linea es para que sea mas visual
		area.append("\n   EQUIPO LOCAL: "+listadoApuestas.geteLocal()+"\n");
		area.append("   EQUIPO VISITANTE: "+listadoApuestas.geteVisitante()+"\n");
		area.append("   FECHA DEL PARTIDO: "+listadoApuestas.getfPartido()+"\n");
		area.append("   FECHA DE LA APUESTA: "+listadoApuestas.getfApuesta()+"\n");
		area.append("   CUOTA: "+listadoApuestas.getCuota()+"€ por euro apostado.\n");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnVolver)) {
			volver();
		}
		if(e.getSource().equals(btnConfirmar)) {
			confirmarResultados();
		}
	}

	private void confirmarResultados() {
		// TODO Auto-generated method stub
		Partido partido;
		
		if(rdbtn1.isSelected()) {
			partido = new Partido();
			partido.setResultado("1");
			if (dao.insertarResultado(partido, listadoApuestas)) {
				JOptionPane.showMessageDialog(this, "LA GESTION SE HA ACTUALIZADO CORRECTAMENTE.");
			} else {
				JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
			}
		} else if(rdbtnX.isSelected()) {
			partido = new Partido();
			partido.setResultado("X");
			if (dao.insertarResultado(partido, listadoApuestas)) {
				JOptionPane.showMessageDialog(this, "LA GESTION SE HA ACTUALIZADO CORRECTAMENTE.");
			} else {
				JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
			}
		} else if(rdbtn2.isSelected()) {
			partido = new Partido();
			partido.setResultado("2");
			if (dao.insertarResultado(partido, listadoApuestas)) {
				JOptionPane.showMessageDialog(this, "LA GESTION SE HA ACTUALIZADO CORRECTAMENTE.");
			} else {
				JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "ESCOGE UN RESULTADO!");
		}
	}

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
