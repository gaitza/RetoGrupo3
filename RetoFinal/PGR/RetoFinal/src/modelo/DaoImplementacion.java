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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import clases.Apuesta;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.Jugar;
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

	// AQUI COMIENZAN LAS SENTENCIAS QUE REALIZAN LOS METODOS DE ADMINISTRADOR
	// Sentencias SQL de CREAR APUESTA
	private final String BUSCAR_EQUIPO_DE_UN_DEPORTE = "select * from Equipo where deporte=? && cod_equipo in (select cod_equipo from participar where cod_comp=?);";
	private final String CREAR_PARTIDO = "insert into partido (Cod_Partido, Fecha_Partido, Resultado) values (?, ?, ?)";
	private final String CREAR_JUGAR = "insert into jugar (Cod_Partido, Cod_Equipo_Local, Cod_Equipo_Visitante) values (?, ?, ?)";
	private final String CREAR_APUESTA = "insert into apuesta (Cod_Apuesta, Fecha_Apuesta, Cuota) values (?, ?, ?)";
	private final String CREAR_SOBRE = "insert into Sobre (Cod_Apuesta, Cod_Partido) values (?, ?)";
	private final String BUSCAR_ULTIMO_CODPARTIDO = "SELECT Cod_Partido FROM Partido ORDER BY Cod_Partido desc LIMIT 1";
	private final String BUSCAR_ULTIMO_CODAPUESTA = "SELECT Cod_Apuesta FROM Apuesta ORDER BY Cod_Apuesta desc LIMIT 1";

	// Sentencias SQL de GESTIONAR APUESTAS
	private final String LISTAR_APUESTAS = "select e.nombre, e2.nombre, fecha_partido, fecha_apuesta, cuota, p.cod_partido, a.cod_apuesta from apuesta a join sobre s on a.Cod_Apuesta=s.Cod_Apuesta join partido p on s.Cod_Partido=p.Cod_Partido join jugar j on j.Cod_Partido=p.Cod_Partido join equipo e on j.Cod_Equipo_Local=e.Cod_Equipo join equipo e2 on j.Cod_Equipo_Visitante=e2.Cod_Equipo";
	private final String INSERTAR_RESULTADO = "update partido set resultado=? where cod_partido=?";
	private final String INSERTAR_GESTIONAR = "insert into gestionar (Cod_Cuenta, Cod_Apuesta) values (?, ?)";
	private final String ACTUALIZAR_SALDOS = "call ActualizarSaldos(?, ?, ?)";

	// Sentencias SQL de INSERTARBDA
	private final String SELECT_EQUIPOS = "select * from Equipo";
	private final String SELECT_DEPORTES = "select * from Deporte";
	private final String SELECT_COMPETICIONES = "select * from Competicion";
	private final String RELACIONAR_TABLAS = "insert into participar (Cod_Equipo, Cod_Comp, Cod_Dep) values (?, ?, ?)";
	private final String INSERTAR_JUGADOR = "insert into jugador (id_jugador, nombre, apellido1, apellido2, fecha_nac, dorsal, cod_equipo) values (?, ?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODJUGADOR = "SELECT Id_Jugador FROM Jugador ORDER BY Id_Jugador desc LIMIT 1";
	private final String INSERTAR_EQUIPO = "insert into equipo (cod_equipo, nombre, fecha_fun, localidad, pais, estadio, deporte) values (?, ?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODEQUIPO = "SELECT Cod_Equipo FROM Equipo ORDER BY Cod_Equipo desc LIMIT 1";
	private final String INSERTAR_DEPORTE = "insert into deporte (cod_dep, nombre) values (?; ?)";
	private final String BUSCAR_ULTIMO_CODDEPORTE = "SELECT Cod_Dep FROM Deporte ORDER BY Cod_Dep desc LIMIT 1";
	private final String INSERTAR_COMPETICION = "insert into competicion (cod_comp, nombre, deporte) values (?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODCOMPETICION = "SELECT Cod_Comp FROM Jugador ORDER BY Cod_Comp desc LIMIT 1";

	// Sentencias SQL de DARBAJA
	private final String SELECT_JUGADORES = "select * from Jugador where Cod_Equipo=?";
	private final String ELIMINAR_JUGADOR = "delete from Jugador where Id_Jugador=?";
	private final String ELIMINAR_EQUIPO = "delete from Equipo where Cod_Equipo=?";
	private final String ELIMINAR_DEPORTE = "delete from Deporte where Cod_Dep=?";
	private final String ELIMINAR_COMPETICION = "delete from Competicion where Cod_Comp=?";

	// Sentencias SQL de MODIFICARDATOS
	private final String MODIFICAR_EQUIPO = "update equipo set nombre=?, localidad=?, pais=?, estadio=? where Cod_Equipo=?";
	private final String MODIFICAR_DEPORTE = "update deporte set nombre=? where Cod_Dep=?";
	private final String MODIFICAR_COMPETICION = "update competicion set nombre=?, Deporte=? where Cod_Comp=?";
	private final String MODIFICAR_JUGADOR = "update jugador set dorsal=?, Cod_Equipo=? where Id_Jugador=?";

	// AQUI COMIENZAN LAS SENTENCIAS QUE REALIZAN LOS METODOS DE USUARIO
	// Sentencia SQL de DARSE DE BAJA
	private final String DARSE_DE_BAJA = "delete from cuenta where cod_cuenta=?";

	// Sentencias SQL de EDITAR PERFIL
	private final String SELECT_USUARIOS = "select * from usuario";
	private final String EDITAR_CUENTA = "update cuenta set nombre_cuenta=?, contraseña=? where cod_cuenta=?";
	private final String EDITAR_USUARIO = "update usuario set NºTarjeta=?, fecha_caducidad=?, cvv=?, pin=? where cod_cuenta=?";
	private final String INGRESAR_DINERO = "update usuario set saldo=saldo+? where cod_cuenta=?";
	private final String RETIRAR_DINERO = "update usuario set saldo=saldo-? where cod_cuenta=?";

	// AQUI COMIENZAN TODOS LOS METODOS PARA NUESTRA APLICACION
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

	// AQUI COMIENZAN LOS METODOS QUE SE PUEDEN REALIZAR COMO ADMINISTRADOR

	@Override
	public List<Equipo> listarEquiposPorDeporte(Deporte deportes, Competicion competiciones) {
		// TODO Auto-generated method stub
		List<Equipo> equipos = new ArrayList();
		ResultSet rs = null;
		Equipo equipo;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(BUSCAR_EQUIPO_DE_UN_DEPORTE);
			stnt.setString(1, deportes.getNombreDep());
			stnt.setString(2, competiciones.getCodCompeticion());

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				equipo = new Equipo();
				equipo.setCodEquipo(rs.getString("Cod_Equipo"));
				equipo.setNombreEquipo(rs.getString("Nombre"));
				equipo.setDeporte(rs.getString("Deporte"));
				equipo.setEstadio(rs.getString("Estadio"));
				equipo.setLocalidad(rs.getString("Localidad"));
				equipo.setPais(rs.getString("Pais"));
				equipo.setFechaFun(rs.getInt("Fecha_Fun"));
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
	public boolean crearApuesta(Partido partido, Jugar jugar, Apuesta apuesta) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codP = codigoPartidos();
		String codA = codigoApuestas();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(CREAR_PARTIDO);

			stnt.setString(1, codP);
			stnt.setDate(2, Date.valueOf(partido.getFechaPartido()));
			stnt.setString(3, null);

			if (stnt.executeUpdate() == 1) {
				stnt = con.prepareStatement(CREAR_JUGAR);
				stnt.setString(1, codP);
				stnt.setString(2, jugar.getCodELocal());
				stnt.setString(3, jugar.getCodEVisit());

				if (stnt.executeUpdate() == 1) {
					stnt = con.prepareStatement(CREAR_APUESTA);
					stnt.setString(1, codA);
					stnt.setDate(2, Date.valueOf(LocalDate.now()));
					stnt.setFloat(3, apuesta.getCuota());

					if (stnt.executeUpdate() == 1) {
						stnt = con.prepareStatement(CREAR_SOBRE);
						stnt.setString(1, codA);
						stnt.setString(2, codP);

						if (stnt.executeUpdate() == 1) {
							altaCorrecta = true;
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return altaCorrecta;
	}

	private String codigoApuestas() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODAPUESTA);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Apuesta")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
	}

	private String codigoPartidos() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODPARTIDO);

			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				codigo = Integer.parseInt(rs.getString("Cod_Partido")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.cerrarConexion();
		return cod;
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
				apuesta.setCodApuesta(rs.getString("a.cod_apuesta"));
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
	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas, Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean modificado = false;
		this.abrirConexion();

		try {
			stnt = con.prepareStatement(INSERTAR_RESULTADO);

			stnt.setString(1, partido.getResultado());
			stnt.setString(2, listadoApuestas.getCodPartido());

			if (stnt.executeUpdate() == 1) {
				stnt = con.prepareStatement(INSERTAR_GESTIONAR);
				stnt.setString(1, cuenta.getCodCuenta());
				stnt.setString(2, listadoApuestas.getCodApuesta());
				if (stnt.executeUpdate() == 1) {
					stnt = con.prepareStatement(ACTUALIZAR_SALDOS);
					
					stnt.setString(1, listadoApuestas.getCodApuesta());
					stnt.setString(2, partido.getResultado());
					stnt.setString(3, listadoApuestas.getCodPartido());

					if (stnt.executeUpdate() == 1) {
						modificado = true;
					}
				}
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
			stnt = con.prepareStatement(INSERTAR_EQUIPO);
			stnt.setString(1, codEquipo);
			stnt.setString(2, equipo.getNombreEquipo());
			stnt.setInt(3, equipo.getFechaFun());
			stnt.setString(4, equipo.getLocalidad());
			stnt.setString(5, equipo.getPais());
			stnt.setString(6, equipo.getEstadio());
			stnt.setString(7, equipo.getDeporte());

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
				equipo.setEstadio(rs.getString("Estadio"));
				equipo.setLocalidad(rs.getString("Localidad"));
				equipo.setPais(rs.getString("Pais"));
				equipo.setFechaFun(rs.getInt("Fecha_Fun"));
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
			if (participar.getDeporteE().equalsIgnoreCase(participar.getDeporteC())
					&& participar.getDeporteE().equalsIgnoreCase(dep.getNombreDep())
					&& participar.getDeporteC().equalsIgnoreCase(dep.getNombreDep())) {
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

	@Override
	public List<Jugador> listadoJugadores(Equipo equipo) {
		// TODO Auto-generated method stub
		List<Jugador> jugadores = new ArrayList();
		ResultSet rs = null;
		Jugador jugador;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(SELECT_JUGADORES);
			stnt.setString(1, equipo.getCodEquipo());

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				jugador = new Jugador();
				jugador.setId(rs.getString("Id_Jugador"));
				jugador.setNombreJ(rs.getString("Nombre"));
				jugador.setApellido1(rs.getString("Apellido1"));
				if (rs.getString("Apellido2") != null) {
					jugador.setApellido2(rs.getString("Apellido2"));
				}
				jugador.setFechaNac(rs.getDate("Fecha_Nac").toLocalDate());
				jugador.setDorsal(rs.getInt("Dorsal"));
				jugador.setCodEquipo(rs.getString("Cod_Equipo"));
				jugadores.add(jugador);
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
		return jugadores;
	}

	@Override
	public boolean bajaJugador(Jugador jug) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		this.abrirConexion();

		try {

			stnt = con.prepareStatement(ELIMINAR_JUGADOR);
			stnt.setString(1, jug.getId());

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

	@Override
	public boolean bajaEquipo(Equipo equipoClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		this.abrirConexion();

		try {

			stnt = con.prepareStatement(ELIMINAR_EQUIPO);
			stnt.setString(1, equipoClase.getCodEquipo());

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

	@Override
	public boolean bajaDeporte(Deporte depClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		this.abrirConexion();

		try {

			stnt = con.prepareStatement(ELIMINAR_DEPORTE);
			stnt.setString(1, depClase.getCodDep());

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

	@Override
	public boolean bajaCompeticion(Competicion compClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		this.abrirConexion();

		try {

			stnt = con.prepareStatement(ELIMINAR_COMPETICION);
			stnt.setString(1, compClase.getCodCompeticion());

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

	@Override
	public boolean modificarEquipo(Equipo equipoClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		List<Equipo> equipos = listadoEquipos();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(MODIFICAR_EQUIPO);
			stnt.setString(5, equipoClase.getCodEquipo());

			if (!equipoClase.getNombreEquipo().equalsIgnoreCase("")) {
				stnt.setString(1, equipoClase.getNombreEquipo());
			} else {
				for (Equipo equipo : equipos) {
					if (equipoClase.getCodEquipo().equalsIgnoreCase(equipo.getCodEquipo())) {
						stnt.setString(1, equipo.getNombreEquipo());
					}
				}
			}
			if (!equipoClase.getLocalidad().equalsIgnoreCase("")) {
				stnt.setString(2, equipoClase.getLocalidad());
			} else {
				for (Equipo equipo : equipos) {
					if (equipoClase.getCodEquipo().equalsIgnoreCase(equipo.getCodEquipo())) {
						stnt.setString(2, equipo.getLocalidad());
					}
				}
			}
			if (!equipoClase.getPais().equalsIgnoreCase("")) {
				stnt.setString(3, equipoClase.getPais());
			} else {
				for (Equipo equipo : equipos) {
					if (equipoClase.getCodEquipo().equalsIgnoreCase(equipo.getCodEquipo())) {
						stnt.setString(3, equipo.getPais());
					}
				}
			}
			if (!equipoClase.getEstadio().equalsIgnoreCase("")) {
				stnt.setString(4, equipoClase.getEstadio());
			} else {
				for (Equipo equipo : equipos) {
					if (equipoClase.getCodEquipo().equalsIgnoreCase(equipo.getCodEquipo())) {
						stnt.setString(4, equipo.getEstadio());
					}
				}
			}

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

	@Override
	public boolean modificarDeporte(Deporte depClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		List<Deporte> deportes = listadoDeportes();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(MODIFICAR_DEPORTE);
			stnt.setString(2, depClase.getCodDep());

			if (!depClase.getNombreDep().equalsIgnoreCase("")) {
				stnt.setString(1, depClase.getNombreDep());
			} else {
				for (Deporte deporte : deportes) {
					if (depClase.getCodDep().equalsIgnoreCase(deporte.getCodDep())) {
						stnt.setString(1, deporte.getNombreDep());
					}
				}
			}

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

	@Override
	public boolean modificarCompeticion(Competicion compClase) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		List<Competicion> competiciones = listadoCompeticiones();

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(MODIFICAR_COMPETICION);
			stnt.setString(3, compClase.getCodCompeticion());

			if (!compClase.getNombre().equalsIgnoreCase("")) {
				stnt.setString(1, compClase.getNombre());
			} else {
				for (Competicion comp : competiciones) {
					if (compClase.getCodCompeticion().equalsIgnoreCase(comp.getCodCompeticion())) {
						stnt.setString(1, comp.getNombre());
					}
				}
			}
			if (!compClase.getDeporte().equalsIgnoreCase("")) {
				stnt.setString(2, compClase.getDeporte());
			} else {
				for (Competicion comp : competiciones) {
					if (compClase.getCodCompeticion().equalsIgnoreCase(comp.getCodCompeticion())) {
						stnt.setString(2, comp.getDeporte());
					}
				}
			}

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

	@Override
	public boolean modificarJugador(Jugador jug, Equipo codEquipo) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		List<Jugador> jugadores = listadoJugadores(codEquipo);

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(MODIFICAR_JUGADOR);
			stnt.setString(3, jug.getId());

			if (jug.getDorsal() != 0) {
				stnt.setInt(1, jug.getDorsal());
			} else {
				for (Jugador jugador : jugadores) {
					if (jug.getId().equalsIgnoreCase(jugador.getId())) {
						stnt.setInt(1, jugador.getDorsal());
					}
				}
			}
			if (!jug.getCodEquipo().equalsIgnoreCase("000")) {
				stnt.setString(2, jug.getCodEquipo());
			} else {
				for (Jugador jugador : jugadores) {
					if (jug.getId().equalsIgnoreCase(jugador.getId())) {
						stnt.setString(2, jugador.getCodEquipo());
					}
				}
			}

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

	// AQUI COMIENZAN LOS METODOS QUE SE PUEDEN REALIZAR COMO USUARIO

	@Override
	public boolean darseDeBaja(Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean baja = false;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(DARSE_DE_BAJA);
			stnt.setString(1, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				baja = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return baja;
	}

	@Override
	public boolean editarPerfil(Cuenta cuenta, Usuario editarU) {
		// TODO Auto-generated method stub
		boolean modificacion = false;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(EDITAR_CUENTA);
			stnt.setString(1, editarU.getNombreCuenta());
			stnt.setString(2, editarU.getContraseña());
			stnt.setString(3, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				stnt = con.prepareStatement(EDITAR_USUARIO);
				stnt.setLong(1, editarU.getnTarjeta());
				stnt.setDate(2, Date.valueOf(editarU.getFechaCaducidad()));
				stnt.setString(3, editarU.getCvv());
				stnt.setString(4, editarU.getPin());
				stnt.setString(5, cuenta.getCodCuenta());

				if (stnt.executeUpdate() == 1) {
					modificacion = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return modificacion;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> users = new ArrayList();
		ResultSet rs = null;
		Usuario user;

		// 1º abrimos conexion
		this.abrirConexion();

		try {

			// 2º preparar sentencia sql
			stnt = con.prepareStatement(SELECT_USUARIOS);

			// 3º ejecutar sentencia sql
			rs = stnt.executeQuery();

			while (rs.next()) {
				user = new Usuario();
				user.setCodCuenta(rs.getString("Cod_Cuenta"));
				user.setnTarjeta(Long.parseLong(rs.getString("NºTarjeta")));
				user.setCvv(rs.getString("CVV"));
				user.setPin(rs.getString("Pin"));
				user.setFechaCaducidad(rs.getDate("Fecha_Caducidad").toLocalDate());
				user.setSaldo(rs.getFloat("Saldo"));
				users.add(user);
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
		return users;
	}

	@Override
	public boolean ingresarDinero(Cuenta cuenta, String text) {
		// TODO Auto-generated method stub
		boolean ingreso = false;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(INGRESAR_DINERO);
			stnt.setString(1, text);
			stnt.setString(2, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				ingreso = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return ingreso;
	}

	@Override
	public boolean retirarDinero(Cuenta cuenta, String text) {
		// TODO Auto-generated method stub
		boolean retirada = false;

		this.abrirConexion();

		try {
			stnt = con.prepareStatement(RETIRAR_DINERO);
			stnt.setString(1, text);
			stnt.setString(2, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				retirada = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cerrarConexion();

		return retirada;
	}

}
