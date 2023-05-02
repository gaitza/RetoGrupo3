package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Cuenta;
import clases.Usuario;

public class DaoImplementacion implements Dao {

	private Connection con;
	private PreparedStatement stnt;

	// Sentencias SQL que se utilizarana para diferentes metodos

	// Sentencias SQL de REGISTRARSE
	private final String REGISTRAR_CUENTA = "INSERT INTO Cuenta (Cod_Cuenta, Nombre_Cuenta, email, Contraseña) values (?, ?, ?, ?)";
	private final String REGISTRAR_USUARIO = "INSERT INTO Usuario (Cod_Cuenta, NºTarjeta, Fecha_Caducidad, CVV, Pin, Saldo) values (?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODCUENTA = "SELECT Cod_Cuenta FROM Cuenta ORDER BY Cod_Cuenta desc LIMIT 1";
	private final String CONSEGUIR_USUARIO = "SELECT * FROM Cuenta WHERE Nombre_Cuenta=?";

	// Sentencias SQL de INICIAR SESION
	private final String BUSCAR_ADMIN = "SELECT * FROM Administrador WHERE Cod_Cuenta=?";
	private final String BUSCAR_USER = "SELECT * FROM Cuenta WHERE Nombre_Cuenta=? && Contraseña=?";
	private final String CONSEGUIR_CONTRASEÑA = "SELECT * FROM Cuenta WHERE email=?";

	// Metodo conexion con bda
	public void abrirConexion() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/apuestas?serverTimezone=Europe/Madrid&useSSL=false", "root",
					"abcd*1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Metodo desconexion con bda
	public void cerrarConexion() {
		try {
			if (stnt != null) {
				stnt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codC = codigoCuentas();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(REGISTRAR_CUENTA);

			stnt.setString(1, codC);
			stnt.setString(2, usuario.getNombreCuenta());
			stnt.setString(3, usuario.getEmail());
			stnt.setString(4, usuario.getContraseña());

			if (stnt.executeUpdate() == 1) {
				stnt = con.prepareStatement(REGISTRAR_USUARIO);
				stnt.setString(1, codC);
				stnt.setLong(2, usuario.getnTarjeta());
				stnt.setDate(3, Date.valueOf(usuario.getFechaCaducidad()));
				stnt.setString(4, usuario.getCvv());
				stnt.setString(5, usuario.getPin());
				stnt.setFloat(6, usuario.getSaldo());

				if (stnt.executeUpdate() == 1) {
					altaCorrecta = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	@Override
	public String codigoCuentas() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODCUENTA);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Cuenta")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	@Override
	public Cuenta iniciar(String nombre, String contrasenia) {
		// TODO Auto-generated method stub
		Cuenta cuenta = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_USER);
			stnt.setString(1, nombre);
			stnt.setString(2, contrasenia);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = new Cuenta();
				cuenta.setCodCuenta(rs.getString("Cod_Cuenta"));
				cuenta.setNombreCuenta(rs.getString("Nombre_Cuenta"));
				cuenta.setEmail(rs.getString("email"));
				cuenta.setContraseña(rs.getString("Contraseña"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cuenta;
	}

	@Override
	public boolean esAdmin(String cod) {
		// TODO Auto-generated method stub

		boolean admin = false;

		this.abrirConexion();

		try {

			stnt = con.prepareStatement(BUSCAR_ADMIN);
			stnt.setString(1, cod);
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				admin = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public String contraOlvidada(String email) {
		// TODO Auto-generated method stub
		String cuenta = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(CONSEGUIR_CONTRASEÑA);
			stnt.setString(1, email);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Contraseña");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cuenta;
	}

	@Override
	public String buscarNombre(String usuario) {
		// TODO Auto-generated method stub
		String cuenta = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(CONSEGUIR_USUARIO);
			stnt.setString(1, usuario);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Nombre_Cuenta");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cuenta;
	}

	@Override
	public String buscarEmail(String email) {
		// TODO Auto-generated method stub
		String cuenta = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(CONSEGUIR_CONTRASEÑA);
			stnt.setString(1, email);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Email");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cuenta;
	}

}
