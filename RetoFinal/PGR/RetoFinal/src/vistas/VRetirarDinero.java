package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.Usuario;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VRetirarDinero extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JButton retirada;
	private JTextField retirar;
	private JTextField tarjeta;
	private List<Usuario> usuarios;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
	public VRetirarDinero(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;
		this.usuarios = dao.listarUsuarios();

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

		volver = new JButton("Volver");
		volver.setForeground(new Color(173, 255, 47));
		volver.setFont(new Font("Arial", Font.PLAIN, 14));
		volver.setFocusable(false);
		volver.setBorder(null);
		volver.setBackground(Color.DARK_GRAY);
		volver.setBounds(48, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		retirada = new JButton("Retirar");
		retirada.setForeground(new Color(173, 255, 47));
		retirada.setFont(new Font("Arial", Font.PLAIN, 14));
		retirada.setFocusable(false);
		retirada.setBorder(null);
		retirada.setBackground(Color.DARK_GRAY);
		retirada.setBounds(318, 11, 107, 36);
		retirada.addActionListener(this);
		panel_1.add(retirada);

		JLabel lblNewLabel_1 = new JLabel("Cantidad a retirar:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(62, 186, 148, 53);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Nº de la Tarjeta:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(72, 295, 138, 53);
		contentPanel.add(lblNewLabel_1_1);

		retirar = new JTextField();
		retirar.setBounds(220, 195, 205, 38);
		contentPanel.add(retirar);
		retirar.setColumns(10);

		tarjeta = new JTextField();
		tarjeta.setColumns(10);
		tarjeta.setBounds(220, 304, 205, 38);
		contentPanel.add(tarjeta);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(58, 284, 382, 3);
		contentPanel.add(panel_2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(58, 360, 382, 3);
		contentPanel.add(panel_2_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.BLACK);
		panel_2_2.setBounds(58, 284, 4, 79);
		contentPanel.add(panel_2_2);

		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBackground(Color.BLACK);
		panel_2_2_1.setBounds(435, 284, 4, 79);
		contentPanel.add(panel_2_2_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 85, 479, 29);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		for (Usuario usuario : usuarios) {
			if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
				JLabel lblNombreC = new JLabel("Cuenta: "+cuenta.getNombreCuenta());
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
		if (e.getSource().equals(retirada)) {
			retirar();
		}
	}

	private void retirar() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String error = controlar(formateador);

		if (error == "") {
			if (!tarjeta.getText().equalsIgnoreCase("")) {

				for (Usuario usuario : usuarios) {
					if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
						if (usuario.getnTarjeta() == Long.parseLong(tarjeta.getText())) {
							if (usuario.getSaldo() > Float.parseFloat(retirar.getText())) {
								if (dao.retirarDinero(cuenta, retirar.getText())) {
									JOptionPane.showMessageDialog(this, "INGRESO HECHO CORRECTAMENTE.");
									retirar.setText("");
									tarjeta.setText("");
								} else {
									JOptionPane.showMessageDialog(this,
											"NO SE HA CONSEGUIDO INGRESAR CORRECTAMENTE.\nPOR FAVOR INTENTELO DE NUEVO.");
								}
							} else {
								JOptionPane.showMessageDialog(this,
										"EL DINERO QUE QUIERES RETIRAR ES MAYOR AL QUE TIENES EN LA CUENTA.");
							}
						} else {
							JOptionPane.showMessageDialog(this,
									"LA TARJETA NO COINCIDE CON LA REGISTRADA EN LA CUENTA.");
							tarjeta.setBackground(new Color(255, 0, 0));
						}
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, "DEBES RELLENAR TODOS LOS CAMPOS.");
			}

		} else {
			JOptionPane.showMessageDialog(this, error);
		}
	}

	/**
	 * @param formateador
	 * @return
	 */
	private String controlar(DateTimeFormatter formateador) {
		// TODO Auto-generated method stub
		String error = "";

		// Controlar si el cvv esta introducido correctamente
		if (!tarjeta.getText().equalsIgnoreCase("")) {
			if (tarjeta.getText().length() > 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO GRANDE.\n";
			} else if (tarjeta.getText().length() < 16) {
				error += "EL Nº DE TARJETA ES DEMASIADO PEQUEÑO.\n";
				tarjeta.setBackground(new Color(255, 0, 0));
			} else if (tarjeta.getText().length() == 16) {
			}
		} else {
			error += "DEBES INTRODUCIR EL NUMERO DE LA TARJETA.\n";
		}

		// Controlar que ha introducido un numero y no una cadena de letras
		if (!retirar.getText().equalsIgnoreCase("")) {
			try {
				Float.parseFloat(retirar.getText());
			} catch (Exception e2) {
				// TODO: handle exception
				error += "NO PUEDES INTRODUCIR LETRAS.";
			}
		} else {
			error += "DEBES INTRODUCIR LA CANTIDAD QUE QUIERES RETIRAR.";
		}

		return error;
	}

	//Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
		vent.setVisible(rootPaneCheckingEnabled);
	}
}
