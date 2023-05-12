package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.Usuario;
import modelo.Dao;
import java.awt.Window.Type;

public class VMenuUser extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton darseDeBaja;
	private JButton cerrarSesion;
	private JButton btnEditarPerfil;
	private JButton btnRealizarApuesta;
	private JButton btnRealizarApuestaCon;
	private JButton btnApuestasRealizadas;
	private JButton btnRetirarDinero;
	private JButton btnIngresarDinero;
	private Cuenta cuenta;
	private JPanel panel_2;
	private List<Usuario> usuarios;

	public VMenuUser(VElegir vElegir, boolean b, Dao dao, Cuenta cuenta) {
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
		lblNewLabel.setIcon(new ImageIcon(
				ruta+"\\src\\fotos\\Cabecera.jpg"));
		lblNewLabel.setBounds(156, 0, 220, 88);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 498, 479, 58);
		contentPanel.add(panel_1);

		darseDeBaja = new JButton("Darse de Baja");
		darseDeBaja.setForeground(new Color(173, 255, 47));
		darseDeBaja.setFont(new Font("Arial", Font.PLAIN, 14));
		darseDeBaja.setFocusable(false);
		darseDeBaja.setBorder(null);
		darseDeBaja.setBackground(Color.DARK_GRAY);
		darseDeBaja.setBounds(54, 11, 107, 36);
		darseDeBaja.addActionListener(this);
		panel_1.add(darseDeBaja);

		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(new Color(173, 255, 47));
		cerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
		cerrarSesion.setFocusable(false);
		cerrarSesion.setBorder(null);
		cerrarSesion.setBackground(Color.DARK_GRAY);
		cerrarSesion.setBounds(320, 11, 107, 36);
		cerrarSesion.addActionListener(this);
		panel_1.add(cerrarSesion);


		btnEditarPerfil = new JButton("EDITAR PERFIL");
		btnEditarPerfil.setForeground(new Color(173, 255, 47));
		btnEditarPerfil.setFont(new Font("Arial", Font.BOLD, 18));
		btnEditarPerfil.setFocusable(false);
		btnEditarPerfil.setBorder(null);
		btnEditarPerfil.setBackground(Color.DARK_GRAY);
		btnEditarPerfil.setBounds(52, 141, 380, 35);
		btnEditarPerfil.addActionListener(this);
		contentPanel.add(btnEditarPerfil);

		btnRealizarApuesta = new JButton("REALIZAR APUESTA");
		btnRealizarApuesta.setForeground(new Color(173, 255, 47));
		btnRealizarApuesta.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuesta.setFocusable(false);
		btnRealizarApuesta.setBorder(null);
		btnRealizarApuesta.setBackground(Color.DARK_GRAY);
		btnRealizarApuesta.setBounds(52, 199, 380, 35);
		btnRealizarApuesta.addActionListener(this);
		contentPanel.add(btnRealizarApuesta);

		btnRealizarApuestaCon = new JButton("REALIZAR APUESTA CON FILTROS");
		btnRealizarApuestaCon.setForeground(new Color(173, 255, 47));
		btnRealizarApuestaCon.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuestaCon.setFocusable(false);
		btnRealizarApuestaCon.setBorder(null);
		btnRealizarApuestaCon.setBackground(Color.DARK_GRAY);
		btnRealizarApuestaCon.setBounds(52, 258, 380, 35);
		btnRealizarApuestaCon.addActionListener(this);
		contentPanel.add(btnRealizarApuestaCon);

		btnApuestasRealizadas = new JButton("APUESTAS REALIZADAS");
		btnApuestasRealizadas.setForeground(new Color(173, 255, 47));
		btnApuestasRealizadas.setFont(new Font("Arial", Font.BOLD, 18));
		btnApuestasRealizadas.setFocusable(false);
		btnApuestasRealizadas.setBorder(null);
		btnApuestasRealizadas.setBackground(Color.DARK_GRAY);
		btnApuestasRealizadas.setBounds(52, 318, 380, 35);
		btnApuestasRealizadas.addActionListener(this);
		contentPanel.add(btnApuestasRealizadas);

		btnRetirarDinero = new JButton("RETIRAR DINERO");
		btnRetirarDinero.setForeground(new Color(173, 255, 47));
		btnRetirarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnRetirarDinero.setFocusable(false);
		btnRetirarDinero.setBorder(null);
		btnRetirarDinero.setBackground(Color.DARK_GRAY);
		btnRetirarDinero.setBounds(52, 430, 380, 35);
		btnRetirarDinero.addActionListener(this);
		contentPanel.add(btnRetirarDinero);

		btnIngresarDinero = new JButton("INGRESAR DINERO");
		btnIngresarDinero.setForeground(new Color(173, 255, 47));
		btnIngresarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnIngresarDinero.setFocusable(false);
		btnIngresarDinero.setBorder(null);
		btnIngresarDinero.setBackground(Color.DARK_GRAY);
		btnIngresarDinero.setBounds(52, 374, 380, 35);
		btnIngresarDinero.addActionListener(this);
		contentPanel.add(btnIngresarDinero);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 88, 479, 29);
		contentPanel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta+"\\src\\fotos\\fondoUser.png"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);
		
		for (Usuario usuario : usuarios) {
			if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
				JLabel lblNombreC = new JLabel("Cuenta: "+cuenta.getNombreCuenta());
				lblNombreC.setHorizontalAlignment(SwingConstants.LEFT);
				lblNombreC.setFont(new Font("Arial", Font.BOLD, 12));
				lblNombreC.setForeground(new Color(173, 255, 47));
				lblNombreC.setBounds(10, 0, 223, 29);
				panel_2.add(lblNombreC);

				JLabel lblDineroEnLa = new JLabel("DINERO: " + usuario.getSaldo() + "€");
				lblDineroEnLa.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDineroEnLa.setFont(new Font("Arial", Font.BOLD, 12));
				lblDineroEnLa.setForeground(new Color(173, 255, 47));
				lblDineroEnLa.setBounds(246, 0, 223, 29);
				panel_2.add(lblDineroEnLa);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(cerrarSesion)) {
			cerrarSesion();
		}
		if(e.getSource().equals(darseDeBaja)) {
			baja();
		}
		if(e.getSource().equals(btnEditarPerfil)) {
			editarPerfil();
		}
		if(e.getSource().equals(btnIngresarDinero)) {
			ingresar();
		}
		if(e.getSource().equals(btnRetirarDinero)) {
			retirar();
		}
	}

	private void retirar() {
		// TODO Auto-generated method stub
		this.dispose();
		VRetirarDinero vent = new VRetirarDinero(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	private void ingresar() {
		// TODO Auto-generated method stub
		this.dispose();
		VIngresarDinero vent = new VIngresarDinero(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	private void editarPerfil() {
		// TODO Auto-generated method stub
		this.dispose();
		VEditarPerfil vent = new VEditarPerfil(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	private void baja() {
		// TODO Auto-generated method stub
		int opc= JOptionPane.showConfirmDialog(this, "ESTAS SEGURO DE QUERER ELIMINAR TU CUENTA?\nSE BORRARA DE LA BASE DE DATOS Y NO SE PODRA RECUPERAR.");
		
		if(opc==0) {
			if (dao.darseDeBaja(cuenta)) {
				JOptionPane.showMessageDialog(this, "BAJA REALIZADA CORRECTAMENTE.");
			} else {
				JOptionPane.showMessageDialog(this, "ERROR EN LA BAJA DE LA CUENTA.");
			}
		}else if(opc==1) {
			JOptionPane.showMessageDialog(this, "LA CUENTA NO SE HA DADO DE BAJA.");
		}else if(opc==2) {
			JOptionPane.showMessageDialog(this, "DARSE DE BAJA CANCELADO.");
		}
	}

	private void cerrarSesion() {
		// TODO Auto-generated method stub
		this.dispose();
		vElegir.setExtendedState(Frame.NORMAL);;
	}
}
