package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.ListadoApuestas;
import clases.Participar;
import clases.Partido;
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

	// Sentencias SQL de GESTIONAR APUESTAS
	private final String LISTAR_APUESTAS = "select e.nombre, e2.nombre, fecha_partido, fecha_apuesta, cuota, p.cod_partido from apuesta a join sobre s on a.Cod_Apuesta=s.Cod_Apuesta join partido p on s.Cod_Partido=p.Cod_Partido join jugar j on j.Cod_Partido=p.Cod_Partido join equipo e on j.Cod_Equipo_Local=e.Cod_Equipo join equipo e2 on j.Cod_Equipo_Visitante=e2.Cod_Equipo";
	private final String INSERTAR_RESULTADO = "update partido set resultado=? where cod_partido=?";

	// Sentencias SQL de INSERTARBDA
	private final String SELECT_EQUIPOS = "select * from Equipo";
	private final String SELECT_DEPORTES = "select * from Deporte";
	private final String SELECT_COMPETICIONES = "select * from Competicion";
	private final String RELACIONAR_TABLAS = "insert into participar (Cod_Equipo, Cod_Comp, Cod_Dep) values (?, ?, ?)";
	private final String INSERTAR_JUGADOR = "insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (?, ?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODJUGADOR = "SELECT Id_Jugador FROM Jugador ORDER BY Id_Jugador desc LIMIT 1";
	private final String INSERTAR_EQUIPO = "insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio) values (?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODEQUIPO = "SELECT Cod_Equipo FROM Equipo ORDER BY Cod_Equipo desc LIMIT 1";
	private final String INSERTAR_DEPORTE = "insert into deporte (cod_dep, nombre) values (?; ?)";
	private final String BUSCAR_ULTIMO_CODDEPORTE = "SELECT Cod_Dep FROM Deporte ORDER BY Cod_Dep desc LIMIT 1";
	private final String INSERTAR_COMPETICION = "insert into competicion (cod_comp, nombre, deporte) values (?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODCOMPETICION = "SELECT Cod_Comp FROM Jugador ORDER BY Cod_Comp desc LIMIT 1";

	// Metodo conexion con bda
	public void abrirConexion() {
		try {
			Properties conexionBDA = new Properties();
			String rutaProyecto = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(rutaProyecto + "\\src\\modelo\\ConexionBDA.properties");
			conexionBDA.load(fis);

			final String URL = conexionBDA.getProperty("url");
			final String USER = conexionBDA.getProperty("user");
			final String PASSWORD = conexionBDA.getProperty("password");

			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

	@Override
	public List<ListadoApuestas> listarApuestas() {
		// TODO Auto-generated method stub
		List<ListadoApuestas> apuestas = new ArrayList<>();
		ListadoApuestas apuesta;
		ResultSet rs = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(LISTAR_APUESTAS);

			rs = stnt.executeQuery();
			while (rs.next()) {
				apuesta = new ListadoApuestas();
				apuesta.seteLocal(rs.getString("e.nombre"));
				apuesta.seteVisitante(rs.getString("e2.nombre"));
				apuesta.setfPartido(rs.getDate("fecha_partido").toLocalDate());
				apuesta.setfApuesta(rs.getDate("fecha_apuesta").toLocalDate());
				apuesta.setCuota(rs.getFloat("cuota"));
				apuesta.setCodPartido(rs.getString("p.cod_partido"));
				apuestas.add(apuesta);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stnt != null) {
					stnt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

		this.cerrarConexion();
		return apuestas;
	}

	@Override
	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas) {
		// TODO Auto-generated method stub
		boolean modificado = false;
		this.abrirConexion();

		try {
			stnt = con.prepareStatement(INSERTAR_RESULTADO);

			stnt.setString(1, partido.getResultado());
			stnt.setString(2, listadoApuestas.getCodPartido());

			if (stnt.executeUpdate() == 1) {
				modificado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return modificado;
	}

	@Override
	public boolean insertarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codJugador = codigoJugador();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(INSERTAR_JUGADOR);
			stnt.setString(1, codJugador);
			stnt.setString(2, jugador.getNombreJ());
			stnt.setString(3, jugador.getApellido1());
			stnt.setString(4, jugador.getApellido2());
			stnt.setDate(5, Date.valueOf(jugador.getFechaNac()));
			stnt.setInt(6, jugador.getDorsal());
			stnt.setString(7, jugador.getCodEquipo());

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	private String codigoJugador() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODJUGADOR);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Id_Jugador")) + 1;
				cod = String.format("%05d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	@Override
	public boolean insertarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codEquipo = codigoEquipo();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(REGISTRAR_CUENTA);
			stnt.setString(1, codEquipo);
			stnt.setString(2, equipo.getNombreEquipo());
			stnt.setInt(3, equipo.getFechaFun());
			stnt.setString(4, equipo.getLocalidad());
			stnt.setString(5, equipo.getPais());
			stnt.setString(6, equipo.getEstadio());

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	private String codigoEquipo() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODEQUIPO);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Equipo")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	@Override
	public boolean insertarDeporte(Deporte deporte) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codDeporte = codigoDeporte();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(REGISTRAR_CUENTA);
			stnt.setString(1, codDeporte);
			stnt.setString(2, deporte.getNombreDep());

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	private String codigoDeporte() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODDEPORTE);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Dep")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	@Override
	public boolean insertarCompeticion(Competicion competicion) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codCompeticion = codigoCompeticion();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(REGISTRAR_CUENTA);
			stnt.setString(1, codCompeticion);
			stnt.setString(2, competicion.getNombre());
			stnt.setString(3, competicion.getDeporte());

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	private String codigoCompeticion() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODCOMPETICION);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Comp")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	@Override
	public List<Equipo> listadoEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = new ArrayList();
		ResultSet rs = null;
		Equipo equipo;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(SELECT_EQUIPOS);

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				equipo = new Equipo();
				equipo.setCodEquipo(rs.getString("Cod_Equipo"));
				equipo.setNombreEquipo(rs.getString("Nombre"));
				equipo.setDeporte(rs.getString("Deporte"));
				equipos.add(equipo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stnt != null) {
					stnt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		this.cerrarConexion();
		return equipos;
	}

	@Override
	public List<Deporte> listadoDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = new ArrayList();
		ResultSet rs = null;
		Deporte deporte;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(SELECT_DEPORTES);

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				deporte = new Deporte();
				deporte.setCodDep(rs.getString("Cod_Dep"));
				deporte.setNombreDep(rs.getString("Nombre"));
				deportes.add(deporte);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stnt != null) {
					stnt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		this.cerrarConexion();
		return deportes;
	}

	@Override
	public List<Competicion> listadoCompeticiones() {
		// TODO Auto-generated method stub
		List<Competicion> competiciones = new ArrayList();
		ResultSet rs = null;
		Competicion competicion;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(SELECT_COMPETICIONES);

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				competicion = new Competicion();
				competicion.setCodCompeticion(rs.getString("Cod_Comp"));
				competicion.setNombre(rs.getString("Nombre"));
				competicion.setDeporte(rs.getString("Deporte"));
				competiciones.add(competicion);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (stnt != null) {
					stnt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		this.cerrarConexion();
		return competiciones;
	}

	@Override
	public boolean insertarParticipar(Participar participar, Deporte dep) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(RELACIONAR_TABLAS);
			if (participar.getDeporteE().equalsIgnoreCase(participar.getDeporteC()) && participar.getDeporteE().equalsIgnoreCase(dep.getNombreDep()) && participar.getDeporteC().equalsIgnoreCase(dep.getNombreDep())) {
				stnt.setString(1, participar.getCodEquipo());
				stnt.setString(2, participar.getCodCompeticion());
				stnt.setString(3, participar.getCodDeporte());
			}

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

}
