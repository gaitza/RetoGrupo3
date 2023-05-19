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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.ApuestasRealizadas;
import clases.Cuenta;
import clases.Usuario;
import modelo.Dao;
import javax.swing.JTextArea;

/**
 * @author Grupo3
 *
 */
public class VVisualizarApuesta extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private Dao dao;
	private VElegir vElegir;
	private Cuenta cuenta;
	private JButton volver;
	private JTable tabla;
	private List<Usuario> usuarios;
	private ApuestasRealizadas apuestas;

	/**
	 * @param vElegir
	 * @param b
	 * @param dao
	 * @param apuestas
	 * @param cuenta
	 */
	public VVisualizarApuesta(VElegir vElegir, boolean b, Dao dao, ApuestasRealizadas apuestas, Cuenta cuenta) {
		super(vElegir);
		setTitle("Retabet.es");
		this.setModal(b);
		this.dao = dao;
		this.vElegir = vElegir;
		this.cuenta = cuenta;
		this.usuarios = dao.listarUsuarios();
		this.apuestas = apuestas;

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

		JTextArea area = new JTextArea();
		area.setForeground(new Color(173, 255, 47));
		area.setFont(new Font("Arial", Font.BOLD, 18));
		area.setEditable(false);
		area.setBackground(Color.DARK_GRAY);
		area.setBounds(54, 153, 368, 310);
		contentPanel.add(area);
		// Los espaciados y salto de linea es para que sea mas visual
		area.append("\n"+"   Equipo Local: "+apuestas.geteLocal()+".\n\n");
		area.append("   Equipo Visitante: "+apuestas.geteVisitante()+".\n\n");
		area.append("   Fecha del partido: "+apuestas.getfPartido()+".\n\n");
		area.append("   Cuota: "+apuestas.getCuota()+"€.\n\n");
		area.append("   Dinero apostado: "+apuestas.getDineroApost()+"€.\n\n");
		if(apuestas.getOpcionApost().equals(apuestas.getResultado())) {
			area.append("   Estado: GANADA.\n\n");
		} else if(!apuestas.getOpcionApost().equals(apuestas.getResultado()) && apuestas.getResultado()!=null) {
			area.append("   Estado: PERDIDA.\n\n");
		} else {
			area.append("   Estado: NO DEFINIDA\n\n");
		}
		

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
	}

	//metodo para volver a la anterior Ventana
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
