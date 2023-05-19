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

/**
 * @author Grupo3
 *
 */
public class VMenuUser extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private JButton darseDeBaja;
	private JButton cerrarSesion;
	private JButton btnEditarPerfil;
	private JButton btnRealizarApuesta;
	private JButton btnFiltrarXDeporte;
	private JButton btnApuestasRealizadas;
	private JButton btnRetirarDinero;
	private JButton btnIngresarDinero;
	private Cuenta cuenta;
	private JPanel panel_2;
	private List<Usuario> usuarios;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param cuenta
	 */
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
		lblNewLabel.setIcon(new ImageIcon(ruta + "\\src\\fotos\\Cabecera.jpg"));
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
		btnEditarPerfil.setBounds(10, 141, 459, 35);
		btnEditarPerfil.addActionListener(this);
		contentPanel.add(btnEditarPerfil);

		btnRealizarApuesta = new JButton("REALIZAR APUESTA");
		btnRealizarApuesta.setForeground(new Color(173, 255, 47));
		btnRealizarApuesta.setFont(new Font("Arial", Font.BOLD, 18));
		btnRealizarApuesta.setFocusable(false);
		btnRealizarApuesta.setBorder(null);
		btnRealizarApuesta.setBackground(Color.DARK_GRAY);
		btnRealizarApuesta.setBounds(10, 199, 459, 35);
		btnRealizarApuesta.addActionListener(this);
		contentPanel.add(btnRealizarApuesta);

		btnFiltrarXDeporte = new JButton("REALIZAR APUESTA FILTRADA POR DEPORTE");
		btnFiltrarXDeporte.setForeground(new Color(173, 255, 47));
		btnFiltrarXDeporte.setFont(new Font("Arial", Font.BOLD, 18));
		btnFiltrarXDeporte.setFocusable(false);
		btnFiltrarXDeporte.setBorder(null);
		btnFiltrarXDeporte.setBackground(Color.DARK_GRAY);
		btnFiltrarXDeporte.setBounds(10, 258, 459, 35);
		btnFiltrarXDeporte.addActionListener(this);
		contentPanel.add(btnFiltrarXDeporte);

		btnApuestasRealizadas = new JButton("APUESTAS REALIZADAS");
		btnApuestasRealizadas.setForeground(new Color(173, 255, 47));
		btnApuestasRealizadas.setFont(new Font("Arial", Font.BOLD, 18));
		btnApuestasRealizadas.setFocusable(false);
		btnApuestasRealizadas.setBorder(null);
		btnApuestasRealizadas.setBackground(Color.DARK_GRAY);
		btnApuestasRealizadas.setBounds(10, 318, 459, 35);
		btnApuestasRealizadas.addActionListener(this);
		contentPanel.add(btnApuestasRealizadas);

		btnRetirarDinero = new JButton("RETIRAR DINERO");
		btnRetirarDinero.setForeground(new Color(173, 255, 47));
		btnRetirarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnRetirarDinero.setFocusable(false);
		btnRetirarDinero.setBorder(null);
		btnRetirarDinero.setBackground(Color.DARK_GRAY);
		btnRetirarDinero.setBounds(10, 430, 459, 35);
		btnRetirarDinero.addActionListener(this);
		contentPanel.add(btnRetirarDinero);

		btnIngresarDinero = new JButton("INGRESAR DINERO");
		btnIngresarDinero.setForeground(new Color(173, 255, 47));
		btnIngresarDinero.setFont(new Font("Arial", Font.BOLD, 18));
		btnIngresarDinero.setFocusable(false);
		btnIngresarDinero.setBorder(null);
		btnIngresarDinero.setBackground(Color.DARK_GRAY);
		btnIngresarDinero.setBounds(10, 374, 459, 35);
		btnIngresarDinero.addActionListener(this);
		contentPanel.add(btnIngresarDinero);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 88, 479, 29);
		contentPanel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ruta + "\\src\\fotos\\fondoUser.png"));
		lblNewLabel_1.setBounds(0, 88, 479, 413);
		contentPanel.add(lblNewLabel_1);

		// metodo para que se muestre en pantalla el nombre de usuario y el dinero que
		// tiene la cuenta
		for (Usuario usuario : usuarios) {
			/*
			 * a medida que se va recorriendo el for, en caso de que codigo del usuario
			 * concuerden con el de la cuenta se guarda el nombre y el saldo de ella misma
			 */
			if (usuario.getCodCuenta().equals(cuenta.getCodCuenta())) {
				JLabel lblNombreC = new JLabel("Cuenta: " + cuenta.getNombreCuenta());
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

		// Depende del boton pulsado se abrira la ventana en la que se realizara el
		// metedo escogido
		if (e.getSource().equals(cerrarSesion)) {
			cerrarSesion();
		}
		if (e.getSource().equals(darseDeBaja)) {
			baja();
		}
		if (e.getSource().equals(btnEditarPerfil)) {
			editarPerfil();
		}
		if (e.getSource().equals(btnIngresarDinero)) {
			ingresar();
		}
		if (e.getSource().equals(btnRetirarDinero)) {
			retirar();
		}
		if (e.getSource().equals(btnApuestasRealizadas)) {
			apuestasRealizadas();
		}
		if (e.getSource().equals(btnRealizarApuesta)) {
			realizarApuestas();
		}
		if (e.getSource().equals(btnFiltrarXDeporte)) {
			realizarApuestasFiltros();
		}
	}

	private void realizarApuestasFiltros() {
		// TODO Auto-generated method stub
		this.dispose();
		VRealizarApuestaFiltro vent = new VRealizarApuestaFiltro(vElegir, true, dao, cuenta);
		vent.setVisible(true);
	}

	private void realizarApuestas() {
		// TODO Auto-generated method stub
		this.dispose();
		VMenuApuestas vent = new VMenuApuestas(vElegir, true, dao, null, null, cuenta);
		vent.setVisible(true);
	}

	private void apuestasRealizadas() {
		// TODO Auto-generated method stub
		this.dispose();
		VApuestasRealizadas vent = new VApuestasRealizadas(vElegir, true, dao, cuenta);
		vent.setVisible(true);
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

	//metodo para darse de baja uno mismo
	private void baja() {
		// TODO Auto-generated method stub
		//le preguntamos si esta seguro de querer darse de baja
		int opc = JOptionPane.showConfirmDialog(this,
				"ESTAS SEGURO DE QUERER ELIMINAR TU CUENTA?\nSE BORRARA DE LA BASE DE DATOS Y NO SE PODRA RECUPERAR.");

		if (opc == 0) {
			//en caso de q la respuesta haya sido que si, le pedimos al dao que elimine la cuenta que se esta utilizando
			if (dao.darseDeBaja(cuenta)) {
				JOptionPane.showMessageDialog(this, "BAJA REALIZADA CORRECTAMENTE.");
				this.dispose();
				VInicioSesion vent = new VInicioSesion(vElegir, true, dao);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "ERROR EN LA BAJA DE LA CUENTA.");
			}
		} else if (opc == 1) {
			JOptionPane.showMessageDialog(this, "LA CUENTA NO SE HA DADO DE BAJA.");
		} else if (opc == 2) {
			JOptionPane.showMessageDialog(this, "DARSE DE BAJA CANCELADO.");
		}
	}

	// metodo en el que cierras sesion y ten envia a la ventana de iniciar sesion
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		this.dispose();
		VInicioSesion vent = new VInicioSesion(vElegir, true, dao);
		vent.setVisible(true);
	}
}
