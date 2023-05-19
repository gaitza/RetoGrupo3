package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.ApuestasRealizadas;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.ListadoApuestas;
import clases.Usuario;
import modelo.Dao;

/**
 * @author Grupo3
 *
 */
public class VMenuApuestas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JTable tabla;
	private List<Usuario> usuarios;
	private Deporte deportes;
	private Competicion competiciones;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param deportes
	 * @param competiciones
	 * @param cuenta
	 */
	public VMenuApuestas(VElegir vElegir, boolean b, Dao dao, Deporte deportes, Competicion competiciones,
			Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;
		this.usuarios = dao.listarUsuarios();
		this.deportes = deportes;
		this.competiciones = competiciones;

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
		volver.setBounds(187, 11, 107, 36);
		volver.addActionListener(this);
		panel_1.add(volver);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 85, 479, 29);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

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
				panel_3.add(lblNombreC);

				JLabel lblDineroEnLa = new JLabel("DINERO: " + usuario.getSaldo() + "€");
				lblDineroEnLa.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDineroEnLa.setFont(new Font("Arial", Font.BOLD, 12));
				lblDineroEnLa.setForeground(new Color(173, 255, 47));
				lblDineroEnLa.setBounds(246, 0, 223, 29);
				panel_3.add(lblDineroEnLa);
			}
		}

		// Guardamos todas las apuestas
		List<ListadoApuestas> apuestas = dao.listarApuestasParaUsers(deportes);

		// Creamos la tabla con las apuestas guardadas recientemente
		presentarTabla(apuestas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(volver)) {
			volver();
		}
	}

	// Metodo para volver a la anterior ventana
	private void volver() {
		// TODO Auto-generated method stub
		// si el deporte es nulo es porque viene desde la ventana del manu de usuario,
		// entonces se volvera a dicha ventana
		if (deportes == null) {
			this.dispose();
			VMenuUser vent = new VMenuUser(vElegir, true, dao, cuenta);
			vent.setVisible(true);
		}
		// En caso de que el deporte no sea nulo es porque viene desde la ventana de
		// realizar apuesta con filtro, entonces se volvera a dicha ventana
		else {
			this.dispose();
			VRealizarApuestaFiltro vent = new VRealizarApuestaFiltro(vElegir, true, dao, cuenta);
			vent.setVisible(true);
		}
	}

	/**
	 * @param apuestas
	 */
	public void presentarTabla(List<ListadoApuestas> apuestas) {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.getViewport().setBackground(new Color(173, 255, 47));
		scroll.setEnabled(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		tabla = this.cargarTabla(apuestas);

		/*
		 * mediante un evento le pedimos que al clicar en una fila nos envie a otra
		 * ventana para ralizar una apuesta
		 */
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.getSelectedRow();
				VRealizarApuesta vent = new VRealizarApuesta(vElegir, true, dao, cuenta, apuestas.get(fila));
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
		contentPanel.add(scroll);
		scroll.setBounds(10, 132, 459, 355);
	}

	/**
	 * @param apuestas
	 * @return
	 */
	public JTable cargarTabla(List<ListadoApuestas> apuestas) {
		String[] cabeceras = { "EQUIPO L.", "EQUIPO V.", "FECHA P.", "FECHA A.", "CUOTA" };
		String[] fila = new String[10];

		DefaultTableModel model = new DefaultTableModel(null, cabeceras);

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

}
