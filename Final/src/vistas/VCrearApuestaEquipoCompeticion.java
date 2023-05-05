package vistas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Competicion;
import modelo.Dao;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VCrearApuestaEquipoCompeticion extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnAceptar;
	private JLabel lblCompeticion;
	private JComboBox<String> cBCompeticion;
	private List<Competicion> competiciones;
	private Dao dao;
	private VElegir vElegir;
	private final JPanel contentPanel = new JPanel();
	
	
	
	public VCrearApuestaEquipoCompeticion(VElegir vElegir, boolean b, Dao dao) {
		super(vElegir);
		this.dao = dao;
		this.vElegir = vElegir;
		setTitle("Retabet.es");
		this.setModal(b);
		
		setBounds(100, 100, 450, 252);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			cBCompeticion = new JComboBox();
			cBCompeticion.setBounds(221, 56, 149, 22);
			contentPanel.add(cBCompeticion);
		}
		
		lblCompeticion = new JLabel("Competicion:");
		lblCompeticion.setFont(new Font("Arial", Font.BOLD, 18));
		lblCompeticion.setBounds(57, 55, 118, 20);
		contentPanel.add(lblCompeticion);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(137, 132, 141, 30);
		btnAceptar.addActionListener(this);
		contentPanel.add(btnAceptar);
		
		cargarCompeticiones();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			consultarCompeticion();
		}
	}
	
	
	private void cargarCompeticiones() {
		// TODO Auto-generated method stub
		competiciones = dao.listarCompeticion();

		if(!competiciones.isEmpty()) {
		for (Competicion com : competiciones) {
			cBCompeticion.addItem(com.getNombre());
		}

		cBCompeticion.setSelectedIndex(-1);
		}
	}


	private void consultarCompeticion() {
		// 
		if(cBCompeticion.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Selecciona una competicion");
		}else {
			Competicion com = null;
			
			//Recojo el codigo de la competicion seleccionada
			String cadena = (String) cBCompeticion.getSelectedItem();
			int pos = cadena.indexOf(" ");
			String codCompeticion = cadena.substring(0, pos);
			
			//Recojo toda la info de la competicion para mandar la a la vent de partido
			
			for(Competicion competi : competiciones) {
				if (competi.getCodCompeticion().equalsIgnoreCase(codCompeticion)) {
					com = competi;
					break;
				}
			}
			//this.dispose();
			
		}
		
		
		
	}
	
	
	
}
