package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.ListadoApuestas;
import clases.Partido;
import clases.Realizar;
import clases.Usuario;
import modelo.Dao;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
 * @author Grupo3
 *
 */
public class VRealizarApuesta extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JButton confirmar;
	private JTable tabla;
	private List<Usuario> usuarios;
	private ListadoApuestas listadoApuestas;
	private JTextField cvv;
	private JTextField nTarjeta;
	private JTextField dineroApost;
	private ButtonGroup grupo;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtnX;
	private JRadioButton rdbtn2;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 * @param listadoApuestas
	 */
	public VRealizarApuesta(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta, ListadoApuestas listadoApuestas) {
		super(vElegir);
		getContentPane().setBackground(new Color(173, 255, 47));
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;
		this.listadoApuestas = listadoApuestas;
		this.usuarios = dao.listarUsuarios();

		setTitle("Retabet.es");
		String ruta = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ruta + "\\src\\fotos\\Logo.jpg"));

		setBounds(100, 100, 495, 595);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 86, 479, 27);
		getContentPane().add(panel_3);

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

		volver = new JButton("Volver");
		volver.setForeground(new Color(173, 255, 47));
		volver.setFont(new Font("Arial", Font.PLAIN, 14));
		volver.setFocusable(false);
		volver.setBorder(null);
		volver.setBackground(Color.DARK_GRAY);
		volver.setBounds(66, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		confirmar = new JButton("Confirmar");
		confirmar.setForeground(new Color(173, 255, 47));
		confirmar.setFont(new Font("Arial", Font.PLAIN, 14));
		confirmar.setFocusable(false);
		confirmar.setBorder(null);
		confirmar.setBackground(Color.DARK_GRAY);
		confirmar.setBounds(316, 11, 107, 36);
		confirmar.addActionListener(this);
		panel_1.add(confirmar);

		JTextArea area = new JTextArea();
		area.setFont(new Font("Arial", Font.BOLD, 18));
		area.setForeground(new Color(173, 255, 47));
		area.setBackground(Color.DARK_GRAY);
		area.setEditable(false);
		area.setBounds(58, 131, 368, 128);
		getContentPane().add(area);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(58, 259, 368, 88);
		getContentPane().add(panel_2);

		rdbtn1 = new JRadioButton("1");
		rdbtn1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn1.setForeground(new Color(173, 255, 47));
		rdbtn1.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtn1.setBackground(Color.DARK_GRAY);
		rdbtn1.setBounds(0, 57, 109, 23);
		panel_2.add(rdbtn1);

		rdbtnX = new JRadioButton("X");
		rdbtnX.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnX.setForeground(new Color(173, 255, 47));
		rdbtnX.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtnX.setBackground(Color.DARK_GRAY);
		rdbtnX.setBounds(122, 57, 109, 23);
		panel_2.add(rdbtnX);

		rdbtn2 = new JRadioButton("2");
		rdbtn2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn2.setForeground(new Color(173, 255, 47));
		rdbtn2.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtn2.setBackground(Color.DARK_GRAY);
		rdbtn2.setBounds(233, 57, 109, 23);
		panel_2.add(rdbtn2);

		grupo = new ButtonGroup();
		grupo.add(rdbtn1);
		grupo.add(rdbtnX);
		grupo.add(rdbtn2);

		JLabel lblGanaLocalEmpate = new JLabel("GANA LOCAL        EMPATE     GANA VISITANTE");
		lblGanaLocalEmpate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaLocalEmpate.setForeground(new Color(173, 255, 47));
		lblGanaLocalEmpate.setFont(new Font("Arial", Font.BOLD, 16));
		lblGanaLocalEmpate.setBounds(0, 11, 368, 39);
		panel_2.add(lblGanaLocalEmpate);

		cvv = new JTextField();
		cvv.setBounds(209, 451, 192, 36);
		getContentPane().add(cvv);
		cvv.setColumns(10);

		nTarjeta = new JTextField();
		nTarjeta.setColumns(10);
		nTarjeta.setBounds(209, 404, 192, 36);
		getContentPane().add(nTarjeta);

		JLabel lblNewLabel_1 = new JLabel("Nº Tarjeta:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(58, 404, 141, 36);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("CVV:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(58, 451, 141, 36);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Dinero Apostado:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(58, 358, 141, 36);
		getContentPane().add(lblNewLabel_1_2);

		dineroApost = new JTextField();
		dineroApost.setColumns(10);
		dineroApost.setBounds(209, 358, 192, 36);
		getContentPane().add(dineroApost);

		// Los espaciados y salto de linea es para que sea mas visual
		area.append("\n   EQUIPO LOCAL: " + listadoApuestas.geteLocal() + "\n");
		area.append("   EQUIPO VISITANTE: " + listadoApuestas.geteVisitante() + "\n");
		area.append("   FECHA DEL PARTIDO: " + listadoApuestas.getfPartido() + "\n");
		area.append("   FECHA DE LA APUESTA: " + listadoApuestas.getfApuesta() + "\n");
		area.append("   CUOTA: " + listadoApuestas.getCuota() + "€ por euro apostado.\n");

		for (Usuario usuario : usuarios) {
			if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
				JLabel lblNombreC = new JLabel("Cuenta: " + cuenta.getNombreCuenta());
				lblNombreC.setHorizontalAlignment(SwingConstants.LEFT);
				lblNombreC.setFont(new Font("Arial", Font.BOLD, 12));
				lblNombreC.setForeground(new Color(173, 255, 47));
				lblNombreC.setBounds(10, 0, 223, 29);
				panel_3.add(lblNombreC);

				JLabel lblDineroEnLa = new JLabel("DINERO: " + usuario.getSaldo() + "€");
				lblDineroEnLa.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDineroEnLa.setFont(new Font("Arial", Font.BOLD, 12));
				lblDineroEnLa.setForeground(new Color(173, 255, 47));
				lblDineroEnLa.setBounds(246, 0, 223, 29);
				panel_3.add(lblDineroEnLa);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(volver)) {
			volver();
		}
		if (e.getSource().equals(confirmar)) {
			confirmar();
		}
	}

	private void confirmar() {
		// TODO Auto-generated method stub
		Realizar apostado;
		String error = controlar();

		if (error.equalsIgnoreCase("")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())
						&& usuario.getnTarjeta() == Long.parseLong(nTarjeta.getText())
						&& usuario.getCvv().equals(cvv.getText())) {
					apostado = new Realizar();
					apostado.setDineroApost(Integer.parseInt(dineroApost.getText()));
					if (rdbtn1.isSelected()) {
						apostado.setOpcionApost("1");
						if (dao.relizarApuesta(cuenta, apostado, listadoApuestas.getCodApuesta())) {
							JOptionPane.showMessageDialog(this, "LA APUESTA SE HA REALIZADO CORRECTAMENTE.");
							this.dispose();
						} else {
							JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
						}
					} else if (rdbtnX.isSelected()) {
						apostado.setOpcionApost("X");
						if (dao.relizarApuesta(cuenta, apostado, listadoApuestas.getCodApuesta())) {
							JOptionPane.showMessageDialog(this, "LA APUESTA SE HA REALIZADO CORRECTAMENTE.");
							this.dispose();
						} else {
							JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
						}
					} else if (rdbtn2.isSelected()) {
						apostado.setOpcionApost("2");
						if (dao.relizarApuesta(cuenta, apostado, listadoApuestas.getCodApuesta())) {
							JOptionPane.showMessageDialog(this, "LA APUESTA SE HA REALIZADO CORRECTAMENTE.");
							this.dispose();
						} else {
							JOptionPane.showMessageDialog(this, "ERROR EN LA CONFIRMACION.");
						}
					} else {
						JOptionPane.showMessageDialog(this, "ESCOGE UN RESULTADO!");
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, error);
		}
	}

	/**
	 * @return
	 */
	private String controlar() {
		// TODO Auto-generated method stub
		String error = "";

		// Controlar si el dinero introducido es valido
		if (!dineroApost.getText().equalsIgnoreCase("")) {
			try {
				int num = Integer.parseInt(dineroApost.getText());
				if (num > 1) {
					for (Usuario usuario : usuarios) {
						if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
							if (num > usuario.getSaldo()) {
								error += "LA CANTIDAD QUE QUIERES INTRODUCIR ES MAYOR A TU SALDO.\n";
							} else {
								dineroApost.setBackground(new Color(173, 255, 47));
							}
						}
					}
				} else {
					error += "EL NUMERO INTRODUCIDO DEBE SER MAYOR A 1.\n";
					dineroApost.setBackground(new Color(255, 0, 0));
				}
			} catch (Exception e2) {
				// TODO: handle exception
				error += "LO INTRODUCIDO EN EL DINERO APOSTADO DEBE SER UN NUMERO ENTERO.\n";
				dineroApost.setBackground(new Color(255, 0, 0));
			}
		} else {
			error += "DEBES INTRODUCIR LA CANTIDAD QUE QUIERES APOSTAR.\n";
			dineroApost.setBackground(new Color(255, 0, 0));
		}

		// Controlar si el cvv esta introducido correctamente
		if (!cvv.getText().equalsIgnoreCase("")) {
			if (cvv.getText().length() > 3) {
				error += "EL CVV ES DEMASIADO GRANDE.\n";
				cvv.setBackground(new Color(255, 0, 0));
			} else if (cvv.getText().length() < 3) {
				error += "EL CVV ES DEMASIADO GRANDE.\n";
				cvv.setBackground(new Color(255, 0, 0));
			} else if (cvv.getText().length() == 3) {
				cvv.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL CVV DE LA TARJETA.\n";
			cvv.setBackground(new Color(255, 0, 0));
		}

		// Controlar si el cvv esta introducido correctamente
		if (!nTarjeta.getText().equalsIgnoreCase("")) {
			if (nTarjeta.getText().length() > 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO GRANDE.\n";
				nTarjeta.setBackground(new Color(255, 0, 0));
			} else if (nTarjeta.getText().length() < 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO PEQUEÑO.\n";
				nTarjeta.setBackground(new Color(255, 0, 0));
			} else if (nTarjeta.getText().length() == 16) {
				nTarjeta.setBackground(new Color(173, 255, 47));
			}
		} else {
			error += "DEBES INTRODUCIR EL NUMERO DE LA TARJETA.\n";
			nTarjeta.setBackground(new Color(255, 0, 0));
		}
		return error;
	}

	//Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuApuestas vent = new VMenuApuestas(vElegir, true, dao, null, null, cuenta);
		vent.setVisible(true);
	}
}
