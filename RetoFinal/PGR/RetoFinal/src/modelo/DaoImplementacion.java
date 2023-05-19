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
import clases.ApuestasRealizadas;
import clases.Competicion;
import clases.Cuenta;
import clases.Deporte;
import clases.Equipo;
import clases.Jugador;
import clases.Jugar;
import clases.ListadoApuestas;
import clases.Participar;
import clases.Partido;
import clases.Realizar;
import clases.Usuario;

/**
 * @author Grupo3
 *
 */
public class DaoImplementacion implements Dao {

	private Connection con;
	private PreparedStatement stnt;

	// Sentencias SQL que se utilizarana para diferentes metodos

	// Sentencias SQL de REGISTRARSE
	private final String REGISTRAR_CUENTA = "INSERT INTO Cuenta (Cod_Cuenta, Nombre_Cuenta, email, Contraseña) values (?, ?, ?, ?)";
	private final String REGISTRAR_USUARIO = "insert into usuario (cod_cuenta, NTarjeta, fecha_caducidad, cvv, pin, saldo) values (?, ?, ?, ?, ?, ?)";
	private final String BUSCAR_ULTIMO_CODCUENTA = "SELECT Cod_Cuenta FROM Cuenta ORDER BY Cod_Cuenta desc LIMIT 1";
	private final String CONSEGUIR_USUARIO = "SELECT * FROM Cuenta WHERE Nombre_Cuenta=?";

	// Sentencias SQL de INICIAR SESION
	private final String BUSCAR_ADMIN = "SELECT * FROM Administrador WHERE Cod_Cuenta=?";
	private final String BUSCAR_USER = "SELECT * FROM Cuenta WHERE Nombre_Cuenta=? && Contraseña=?";
	private final String CONSEGUIR_CONTRASENIA = "SELECT * FROM Cuenta WHERE email=?";

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
	private final String EDITAR_USUARIO = "update usuario set NTarjeta=?, fecha_caducidad=?, cvv=?, pin=? where cod_cuenta=?";
	private final String INGRESAR_DINERO = "update usuario set saldo=saldo+? where cod_cuenta=?";
	private final String RETIRAR_DINERO = "update usuario set saldo=saldo-? where cod_cuenta=?";

	// Sentencias SQL de APUESTAS REALIZADAS
	private final String LISTAR_APUESTAS_REALIZADAS = "select e.nombre, e2.nombre, fecha_partido, fecha_apuesta, cuota, p.cod_partido, a.cod_apuesta, resultado, dinero_apost, opcion_apost from apuesta a join sobre s on a.Cod_Apuesta=s.Cod_Apuesta join partido p on s.Cod_Partido=p.Cod_Partido join jugar j on j.Cod_Partido=p.Cod_Partido join equipo e on j.Cod_Equipo_Local=e.Cod_Equipo join equipo e2 on j.Cod_Equipo_Visitante=e2.Cod_Equipo join realizar r on r.cod_apuesta=a.cod_apuesta where cod_cuenta=?";

	// Sentencias SQL de REALIZAR APUESTA
	private final String REALIZAR_APUESTA = "insert into realizar (Cod_Cuenta, Cod_Apuesta, Dinero_Apost, Opcion_Apost) values (?, ?, ?, ?)";
	private final String ACTUALIZAR_SALDO = "update usuario set saldo=saldo-? where cod_cuenta=?";

	// Sentencias SQL de REALIZAR APUESTA FILTRADA POR DEPORTE
	private final String LISTAR_APUESTAS_USERS = "select distinct e.nombre, e2.nombre, fecha_partido, fecha_apuesta, cuota, p.cod_partido, a.cod_apuesta, e.deporte from apuesta a join sobre s on a.Cod_Apuesta=s.Cod_Apuesta join partido p on s.Cod_Partido=p.Cod_Partido join jugar j on j.Cod_Partido=p.Cod_Partido join equipo e on j.Cod_Equipo_Local=e.Cod_Equipo join equipo e2 on j.Cod_Equipo_Visitante=e2.Cod_Equipo join participar pr on e.cod_equipo=pr.cod_equipo";

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

	// Metodo para registrarse en el programa
	/**
	 * @param usuario
	 */
	@Override
	public boolean registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codC = codigoCuentas();

		// 1 abrimos conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(REGISTRAR_CUENTA);

			// ejecutamos la sentencia
			stnt.setString(1, codC);
			stnt.setString(2, usuario.getNombreCuenta());
			stnt.setString(3, usuario.getEmail());
			stnt.setString(4, usuario.getContrasenia());

			/*
			 * si se ha introducido bien los datos en la base de datos pasara por el if, en
			 * caso de no se te avisara en pantalla que no se ha conseguido introducir
			 * correctamente
			 */
			if (stnt.executeUpdate() == 1) {
				// preparar la sentencia sql
				stnt = con.prepareStatement(REGISTRAR_USUARIO);
				// ejecutamos la sentencia
				stnt.setString(1, codC);
				stnt.setString(2, String.valueOf(usuario.getnTarjeta()));
				stnt.setDate(3, Date.valueOf(usuario.getFechaCaducidad()));
				stnt.setString(4, usuario.getCvv());
				stnt.setString(5, usuario.getPin());
				stnt.setFloat(6, usuario.getSaldo());

				/*
				 * si se ha introducido bien los datos en la base de datos pasara por el if y te
				 * saldra un mensaje de que se a creado la cuenta correctamente, en caso de no
				 * se te avisara en pantalla que no se ha conseguido crear correctamente
				 */
				if (stnt.executeUpdate() == 1) {
					altaCorrecta = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Por ultimo cerramos la conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para generar el codigo de la cuenta automaticamente
	@Override
	public String codigoCuentas() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// 1 abrimos la conexion
		this.abrirConexion();

		try {
			// mediante la sentencia cogemos el ultimo codigo que hay introducido en la base
			// de datos
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODCUENTA);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// guardamos el ultimo codigo +1 en una variable y le damos el formato de 001
				codigo = Integer.parseInt(rs.getString("Cod_Cuenta")) + 1;
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		// devolvemos el codigo creado recientemente
		return cod;
	}

	/*
	 * Metodos para iniciar sesion en el programa, primero se buscara en la tabla de
	 * administrador, si es encontrado se iniciara como administrador, sino como
	 * usuario
	 */
	/**
	 * @param nombre
	 * @param contrasenia
	 */
	@Override
	public Cuenta iniciar(String nombre, String contrasenia) {
		// TODO Auto-generated method stub
		Cuenta cuenta = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(BUSCAR_USER);

			// ejecutamos la sentencia
			stnt.setString(1, nombre);
			stnt.setString(2, contrasenia);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = new Cuenta();
				cuenta.setCodCuenta(rs.getString("Cod_Cuenta"));
				cuenta.setNombreCuenta(rs.getString("Nombre_Cuenta"));
				cuenta.setEmail(rs.getString("email"));
				cuenta.setContrasenia(rs.getString("Contraseña"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		// devolvemos la cuenta con la que se ha iniciado sesion
		return cuenta;
	}

	/**
	 * @param cod
	 */
	@Override
	public boolean esAdmin(String cod) {
		// TODO Auto-generated method stub

		boolean admin = false;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(BUSCAR_ADMIN);

			// ejecutamos la sentencia
			stnt.setString(1, cod);
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				admin = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		// devolvemos si es administrador o no
		return admin;
	}

	// Metodo por si el usuario se ha olvidado de la contraseña de la cuenta
	/**
	 * @param email
	 * @return cuenta
	 */
	@Override
	public String contraOlvidada(String email) {
		// TODO Auto-generated method stub
		String cuenta = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(CONSEGUIR_CONTRASENIA);

			// ejecutamos la sentencia
			stnt.setString(1, email);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Contraseña");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		return cuenta;
	}

	// Metodo para buscar el usuario por el nombre
	/**
	 * @param usuario
	 * @return cuenta
	 */
	@Override
	public String buscarNombre(String usuario) {
		// TODO Auto-generated method stub
		String cuenta = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(CONSEGUIR_USUARIO);

			// ejecutamos la sentencia
			stnt.setString(1, usuario);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Nombre_Cuenta");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		return cuenta;
	}

	// Metodo de buscar el email para conseguir la contraseña
	/**
	 * @param email
	 * @return cuenta
	 */
	@Override
	public String buscarEmail(String email) {
		// TODO Auto-generated method stub
		String cuenta = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(CONSEGUIR_CONTRASENIA);

			// ejecutamos la sentencia
			stnt.setString(1, email);

			ResultSet rs = stnt.executeQuery();
			if (rs.next()) {
				cuenta = rs.getString("Email");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();
		return cuenta;
	}

	// AQUI COMIENZAN LOS METODOS QUE SE PUEDEN REALIZAR COMO ADMINISTRADOR

	// Metodo para listar los equipos por deportes y competiciones
	/**
	 * @param deportes
	 * @param competiciones
	 * @return equipos
	 */
	@Override
	public List<Equipo> listarEquiposPorDeporteYCompeticion(Deporte deportes, Competicion competiciones) {
		// TODO Auto-generated method stub
		List<Equipo> equipos = new ArrayList();
		ResultSet rs = null;
		Equipo equipo;

		// 1 abrimos conexion
		this.abrirConexion();

		try {

			// 2 preparar sentencia sql
			stnt = con.prepareStatement(BUSCAR_EQUIPO_DE_UN_DEPORTE);
			stnt.setString(1, deportes.getNombreDep());
			stnt.setString(2, competiciones.getCodCompeticion());

			// 3 ejecutar sentencia sql
			rs = stnt.executeQuery();

			// Guardar los datos del equipo mientras rs.next()
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

		// cerramos la conexion
		this.cerrarConexion();
		return equipos;
	}

	// Metodo para crear apuestas
	/**
	 * @param partido
	 * @param jugar
	 * @param apuesta
	 */
	@Override
	public boolean crearApuesta(Partido partido, Jugar jugar, Apuesta apuesta) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codP = codigoPartidos();
		String codA = codigoApuestas();

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(CREAR_PARTIDO);

			// preparar la sentencia sql
			stnt.setString(1, codP);
			stnt.setDate(2, Date.valueOf(partido.getFechaPartido()));
			stnt.setString(3, null);

			// si se ha ejecutado correctamente entra en el if
			if (stnt.executeUpdate() == 1) {

				// preparar la sentencia sql
				stnt = con.prepareStatement(CREAR_JUGAR);

				// ejecutamos la sentencia
				stnt.setString(1, codP);
				stnt.setString(2, jugar.getCodELocal());
				stnt.setString(3, jugar.getCodEVisit());

				// si se ha ejecuta correctamente entra en el if
				if (stnt.executeUpdate() == 1) {

					// preparar la sentencia sql
					stnt = con.prepareStatement(CREAR_APUESTA);

					// ejecutamos la sentencia
					stnt.setString(1, codA);
					stnt.setDate(2, Date.valueOf(LocalDate.now()));
					stnt.setFloat(3, apuesta.getCuota());

					// si se ha ejecutado correctamente entra en el if
					if (stnt.executeUpdate() == 1) {

						// preparar la sentencia sql
						stnt = con.prepareStatement(CREAR_SOBRE);

						// ejecutamos la sentencia
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

		// cerramos la conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para crear automaticamente el codigo de apuestas
	/**
	 * @return cod
	 */
	private String codigoApuestas() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODAPUESTA);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Cod_Apuesta")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();
		return cod;
	}

	// Metodo para crear el codigo de los partidos automaticamente
	/**
	 * @return cod
	 */
	private String codigoPartidos() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos la conexion
		this.abrirConexion();

		try {
			// preparar la sentencia sql
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODPARTIDO);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Cod_Partido")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();
		return cod;
	}

	/**
	 * @return apuestas
	 * 
	 */
	@Override
	public List<ListadoApuestas> listarApuestas() {
		// TODO Auto-generated method stub
		List<ListadoApuestas> apuestas = new ArrayList<>();
		ListadoApuestas apuesta;
		ResultSet rs = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(LISTAR_APUESTAS);

			// ejecutamos la sentencia
			rs = stnt.executeQuery();

			// guardamos los datos q queremos presentar en la tabala en un arraylist
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

		// cerramos conexion
		this.cerrarConexion();
		return apuestas;
	}

	// Metodo para insertar el resultado de la apuesta
	/**
	 * @param partido
	 * @param listadoApuestas
	 * @param cuenta
	 * @return modificado
	 */
	@Override
	public boolean insertarResultado(Partido partido, ListadoApuestas listadoApuestas, Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean modificado = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(INSERTAR_RESULTADO);

			// ejecutamos la sentencia
			stnt.setString(1, partido.getResultado());
			stnt.setString(2, listadoApuestas.getCodPartido());

			// en caso de que se haya ejecutado bien entra en el if
			if (stnt.executeUpdate() == 1) {

				// preparamos la sentencia
				stnt = con.prepareStatement(INSERTAR_GESTIONAR);

				// ejecutamos la sentencia
				stnt.setString(1, cuenta.getCodCuenta());
				stnt.setString(2, listadoApuestas.getCodApuesta());

				// en caso de que se haya ejecutado bien entra en el if
				if (stnt.executeUpdate() == 1) {
					stnt = con.prepareStatement(ACTUALIZAR_SALDOS);

					// ejecutamos la sentencia
					stnt.setString(1, listadoApuestas.getCodApuesta());
					stnt.setString(2, partido.getResultado());
					stnt.setString(3, listadoApuestas.getCodPartido());

					if (stnt.execute()) {
						System.out.println("3");
						modificado = true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		// cerramos la conexion
		this.cerrarConexion();

		return modificado;
	}

	// Metodo para insertar un jugador nuevo
	/**
	 * @param jugador
	 */
	@Override
	public boolean insertarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codJugador = codigoJugador();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(INSERTAR_JUGADOR);

			// ejecutamos la sentencia
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

		// cerramos la conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para crea el codigo de juagador automaticamente
	/**
	 * @return cod
	 */
	private String codigoJugador() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODJUGADOR);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Id_Jugador")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%05d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();
		return cod;
	}

	// Metodo insertar un equipo nuevo
	/**
	 * @param equipo
	 */
	@Override
	public boolean insertarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codEquipo = codigoEquipo();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(INSERTAR_EQUIPO);

			// ejecutamos la sentencia
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

		// cerramos la conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para generar el codigo del equipo automatico
	/**
	 * @return cod
	 */
	private String codigoEquipo() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencoa
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODEQUIPO);

			// ejecutamos sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Cod_Equipo")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();
		return cod;
	}

	// Metodo para insertar un deporte nuevo
	/**
	 * @param deporte
	 */
	@Override
	public boolean insertarDeporte(Deporte deporte) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codDeporte = codigoDeporte();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(REGISTRAR_CUENTA);

			// ejecutamos la sentencia
			stnt.setString(1, codDeporte);
			stnt.setString(2, deporte.getNombreDep());

			if (stnt.executeUpdate() == 1) {
				altaCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos la conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para crear el codigo de deporte automaticamente
	/**
	 * @return cod
	 */
	private String codigoDeporte() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODDEPORTE);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Cod_Dep")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();
		return cod;
	}

	// Metodo para insertar una competicion nueva
	/**
	 * @param competicion
	 */
	@Override
	public boolean insertarCompeticion(Competicion competicion) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;
		String codCompeticion = codigoCompeticion();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(REGISTRAR_CUENTA);

			// ejecutamos la sentencia
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

		// cerramos conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para crea el codigo de competicion automaticamente
	/**
	 * @return cod
	 */
	private String codigoCompeticion() {
		// TODO Auto-generated method stub
		int codigo = 0;
		String cod = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(BUSCAR_ULTIMO_CODCOMPETICION);

			// ejecutamos la sentencia
			ResultSet rs = stnt.executeQuery();

			if (rs.next()) {
				// Guardamos en una variable el ultimo codigo + 1
				codigo = Integer.parseInt(rs.getString("Cod_Comp")) + 1;

				// le damos el formato que deseamos
				cod = String.format("%03d", codigo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();
		return cod;
	}

	// Metodo para listar los equipos
	/**
	 * @return equipos
	 */
	@Override
	public List<Equipo> listadoEquipos() {
		// TODO Auto-generated method stub
		List<Equipo> equipos = new ArrayList();
		ResultSet rs = null;
		Equipo equipo;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparar sentencia sql
			stnt = con.prepareStatement(SELECT_EQUIPOS);

			// ejecutar sentencia sql
			rs = stnt.executeQuery();

			// guardamos toda la informacion de los equipos
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

		// cerramos conexion
		this.cerrarConexion();
		return equipos;
	}

	// Metodo para listar lods deportes
	/**
	 * @return deportes
	 */
	@Override
	public List<Deporte> listadoDeportes() {
		// TODO Auto-generated method stub
		List<Deporte> deportes = new ArrayList();
		ResultSet rs = null;
		Deporte deporte;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparar sentencia sql
			stnt = con.prepareStatement(SELECT_DEPORTES);

			// ejecutar sentencia sql
			rs = stnt.executeQuery();

			// Guardamos la informacion de todos los deportes
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
		// cerramos conexion
		this.cerrarConexion();
		return deportes;
	}

	// Metodo para listar las competiciones
	/**
	 * @return competiciones
	 */
	@Override
	public List<Competicion> listadoCompeticiones() {
		// TODO Auto-generated method stub
		List<Competicion> competiciones = new ArrayList();
		ResultSet rs = null;
		Competicion competicion;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparar sentencia sql
			stnt = con.prepareStatement(SELECT_COMPETICIONES);

			// ejecutar sentencia sql
			rs = stnt.executeQuery();

			// guardamos la informacion de las competiciones
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

		// cerramos conexion
		this.cerrarConexion();
		return competiciones;
	}

	// Metodo de insertar la informacion en la tabla de participar
	/**
	 * @param participar
	 * @param dep
	 */
	@Override
	public boolean insertarParticipar(Participar participar, Deporte dep) {
		// TODO Auto-generated method stub
		boolean altaCorrecta = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(RELACIONAR_TABLAS);

			// en caso de cumplir las restricciones entra en el if
			if (participar.getDeporteE().equalsIgnoreCase(participar.getDeporteC())
					&& participar.getDeporteE().equalsIgnoreCase(dep.getNombreDep())
					&& participar.getDeporteC().equalsIgnoreCase(dep.getNombreDep())) {

				// ejecutamos la sentencia
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

		// cerramos conexion
		this.cerrarConexion();

		return altaCorrecta;
	}

	// Metodo para listar los jugadores
	/**
	 * @param equipo
	 * @return jugadores
	 */
	@Override
	public List<Jugador> listadoJugadores(Equipo equipo) {
		// TODO Auto-generated method stub
		List<Jugador> jugadores = new ArrayList();
		ResultSet rs = null;
		Jugador jugador;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparar sentencia sql
			stnt = con.prepareStatement(SELECT_JUGADORES);
			stnt.setString(1, equipo.getCodEquipo());

			// ejecutar sentencia sql
			rs = stnt.executeQuery();

			// guardamos la informacion de los jugadores
			while (rs.next()) {
				jugador = new Jugador();
				jugador.setId(rs.getString("Id_Jugador"));
				jugador.setNombreJ(rs.getString("Nombre"));
				jugador.setApellido1(rs.getString("Apellido1"));

				// en caso de no tener segundo apellido se introduce como nulo
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

		// cerramos conexion
		this.cerrarConexion();
		return jugadores;
	}

	// Metodo para dar de baja un jugador
	/**
	 * @param jug
	 */
	@Override
	public boolean bajaJugador(Jugador jug) {
		// TODO Auto-generated method stub
		boolean bajaCorrecta = false;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparamos la sentencia
			stnt = con.prepareStatement(ELIMINAR_JUGADOR);

			// ejecutamos la sentencia
			stnt.setString(1, jug.getId());

			if (stnt.executeUpdate() == 1) {
				bajaCorrecta = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return bajaCorrecta;
	}

	// Metodo para dar de baja un equipo
	/**
	 * @param equipoClase
	 */
	@Override
	public boolean bajaEquipo(Equipo equipoClase) {
		// TODO Auto-generated method stub
		boolean bajaCorrecta = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(ELIMINAR_EQUIPO);

			// ejecutamos la sentencia
			stnt.setString(1, equipoClase.getCodEquipo());

			if (stnt.executeUpdate() == 1) {
				bajaCorrecta = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return bajaCorrecta;
	}

	// Metodo para dar de baja un deporte
	/**
	 * @param depClase
	 */
	@Override
	public boolean bajaDeporte(Deporte depClase) {
		// TODO Auto-generated method stub
		boolean bajaCorrecta = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(ELIMINAR_DEPORTE);

			// ejecutamos la sentencia
			stnt.setString(1, depClase.getCodDep());

			if (stnt.executeUpdate() == 1) {
				bajaCorrecta = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return bajaCorrecta;
	}

	// Metodo para dar de baja una competicion
	/**
	 * @param compClase
	 */
	@Override
	public boolean bajaCompeticion(Competicion compClase) {
		// TODO Auto-generated method stub
		boolean bajaCorrecta = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(ELIMINAR_COMPETICION);

			// ejecutamos sentencia
			stnt.setString(1, compClase.getCodCompeticion());

			if (stnt.executeUpdate() == 1) {
				bajaCorrecta = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return bajaCorrecta;
	}

	// Metodo para modificar los datos de un equipo
	/**
	 * @param equipoClase
	 */
	@Override
	public boolean modificarEquipo(Equipo equipoClase) {
		// TODO Auto-generated method stub
		boolean modificacionCorrecta = false;
		List<Equipo> equipos = listadoEquipos();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(MODIFICAR_EQUIPO);
			/*
			 * ejecutamos sentencia, en caso de haber modificado una opcion se introducira
			 * el dato nuevo, al contrario se introducira el dato que ya estaba introducido
			 */
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
				modificacionCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cerramos conexion
		this.cerrarConexion();

		return modificacionCorrecta;
	}

	// Metodo para modificar los datos de un deporte
	/**
	 * @param depClase
	 */
	@Override
	public boolean modificarDeporte(Deporte depClase) {
		// TODO Auto-generated method stub
		boolean modificacionCorrecta = false;
		List<Deporte> deportes = listadoDeportes();

		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(MODIFICAR_DEPORTE);

			/*
			 * ejecutamos sentencia, en caso de haber modificado una opcion se introducira
			 * el dato nuevo, al contrario se introducira el dato que ya estaba introducido
			 */
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
				modificacionCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return modificacionCorrecta;
	}

	// Metodo para modificar los datos de una competicion
	/**
	 * @param compClase
	 */
	@Override
	public boolean modificarCompeticion(Competicion compClase) {
		// TODO Auto-generated method stub
		boolean modificacionCorrecta = false;
		List<Competicion> competiciones = listadoCompeticiones();

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(MODIFICAR_COMPETICION);

			/*
			 * ejecutamos sentencia, en caso de haber modificado una opcion se introducira
			 * el dato nuevo, al contrario se introducira el dato que ya estaba introducido
			 */
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
				modificacionCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return modificacionCorrecta;
	}

	// Metodo para modificar los datos de un jugador
	/**
	 * @param jugClase
	 * @param codEquipo
	 */
	@Override
	public boolean modificarJugador(Jugador jug, Equipo codEquipo) {
		// TODO Auto-generated method stub
		boolean modificacionCorrecta = false;
		List<Jugador> jugadores = listadoJugadores(codEquipo);

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(MODIFICAR_JUGADOR);

			/*
			 * ejecutamos sentencia, en caso de haber modificado una opcion se introducira
			 * el dato nuevo, al contrario se introducira el dato que ya estaba introducido
			 */
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
				modificacionCorrecta = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return modificacionCorrecta;
	}

	// AQUI COMIENZAN LOS METODOS QUE SE PUEDEN REALIZAR COMO USUARIO

	// Metodo para darse de baja a uno mismo
	/**
	 * @param cuenta
	 */
	@Override
	public boolean darseDeBaja(Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean baja = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(DARSE_DE_BAJA);

			// ejecutamos sentencia
			stnt.setString(1, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				baja = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return baja;
	}

	// Metodo para editar tu perfil
	/**
	 * @param cuenta
	 * @param editarU
	 */
	@Override
	public boolean editarPerfil(Cuenta cuenta, Usuario editarU) {
		// TODO Auto-generated method stub
		boolean modificacion = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(EDITAR_CUENTA);

			// ejecutamos sentencia
			stnt.setString(1, editarU.getNombreCuenta());
			stnt.setString(2, editarU.getContrasenia());
			stnt.setString(3, cuenta.getCodCuenta());

			// en caso de haberse ejecutado correctamente entra en el if
			if (stnt.executeUpdate() == 1) {
				// preparamos sentencia
				stnt = con.prepareStatement(EDITAR_USUARIO);

				// ejecutamos sentencia
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

		// cerramos conexion
		this.cerrarConexion();

		return modificacion;
	}

	// Metodo para listar los usuarios
	/**
	 * @param users
	 */
	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> users = new ArrayList();
		ResultSet rs = null;
		Usuario user;

		// abrimos conexion
		this.abrirConexion();

		try {

			// preparar sentencia sql
			stnt = con.prepareStatement(SELECT_USUARIOS);

			// ejecutar sentencia sql
			rs = stnt.executeQuery();

			// guardar toda la info de los usuarios existenetes
			while (rs.next()) {
				user = new Usuario();
				user.setCodCuenta(rs.getString("Cod_Cuenta"));
				user.setnTarjeta(Long.parseLong(rs.getString("NTarjeta")));
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

		// cerramos conexion
		this.cerrarConexion();
		return users;
	}

	// Metodo para ingresar dinero en la cuenta
	/**
	 * @param cuenta
	 * @param text
	 */
	@Override
	public boolean ingresarDinero(Cuenta cuenta, String text) {
		// TODO Auto-generated method stub
		boolean ingreso = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(INGRESAR_DINERO);

			// ejecutamos sentencia
			stnt.setString(1, text);
			stnt.setString(2, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				ingreso = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return ingreso;
	}

	// Metodo para retirar dinero de la cuenta
	/**
	 * @param cuenta
	 * @param text
	 */
	@Override
	public boolean retirarDinero(Cuenta cuenta, String text) {
		// TODO Auto-generated method stub
		boolean retirada = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(RETIRAR_DINERO);

			// ejecutamos sentencia
			stnt.setString(1, text);
			stnt.setString(2, cuenta.getCodCuenta());

			if (stnt.executeUpdate() == 1) {
				retirada = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return retirada;
	}

	// Metodo para listar las apuestas relaizadas por el mismo usuario
	/**
	 * @param cuenta
	 */
	@Override
	public List<ApuestasRealizadas> listarApuestasRealizadas(Cuenta cuenta) {
		// TODO Auto-generated method stub
		List<ApuestasRealizadas> apuestas = new ArrayList<>();
		ApuestasRealizadas apuesta;
		ResultSet rs = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(LISTAR_APUESTAS_REALIZADAS);

			// ejecutamos sentencia
			stnt.setString(1, cuenta.getCodCuenta());

			rs = stnt.executeQuery();

			// guardamos toda la informacion de las apuestas realizadas por el usuario
			while (rs.next()) {
				apuesta = new ApuestasRealizadas();
				apuesta.seteLocal(rs.getString("e.nombre"));
				apuesta.seteVisitante(rs.getString("e2.nombre"));
				apuesta.setfPartido(rs.getDate("fecha_partido").toLocalDate());
				apuesta.setfApuesta(rs.getDate("fecha_apuesta").toLocalDate());
				apuesta.setCuota(rs.getFloat("cuota"));
				apuesta.setCodPartido(rs.getString("p.cod_partido"));
				apuesta.setCodApuesta(rs.getString("a.cod_apuesta"));
				apuesta.setOpcionApost(rs.getString("opcion_apost"));
				apuesta.setResultado(rs.getString("resultado"));
				apuesta.setDineroApost(rs.getInt("dinero_apost"));
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

		// cerramos conexion
		this.cerrarConexion();
		return apuestas;
	}

	// Metodo para realizar una apuesta
	/**
	 * @param cuenta
	 * @param apostado
	 * @param codApuesta
	 */
	@Override
	public boolean relizarApuesta(Cuenta cuenta, Realizar apostado, String codApuesta) {
		// TODO Auto-generated method stub
		boolean apuesta = false;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos la sentencia
			stnt = con.prepareStatement(REALIZAR_APUESTA);

			// ejecutamos la sentencia
			stnt.setString(1, cuenta.getCodCuenta());
			stnt.setString(2, codApuesta);
			stnt.setInt(3, apostado.getDineroApost());
			stnt.setString(4, apostado.getOpcionApost());

			// en caso de haberse actualizado correctamente entra al if y actualizamos el
			// saldo de la cuenta
			if (stnt.executeUpdate() == 1) {
				// preparamos la sentencia
				stnt = con.prepareStatement(ACTUALIZAR_SALDO);

				// ejecutamos sentencia
				stnt.setInt(1, apostado.getDineroApost());
				stnt.setString(2, cuenta.getCodCuenta());

				if (stnt.executeUpdate() == 1) {
					apuesta = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cerramos conexion
		this.cerrarConexion();

		return apuesta;
	}

	// Metodo para listar las apuestas filtradas por deporte
	/**
	 * @param deportes
	 * @return apuestas
	 */
	@Override
	public List<ListadoApuestas> listarApuestasParaUsers(Deporte deportes) {
		// TODO Auto-generated method stub
		List<ListadoApuestas> apuestas = new ArrayList<>();
		ListadoApuestas apuesta;
		ResultSet rs = null;

		// abrimos conexion
		this.abrirConexion();

		try {
			// preparamos sentencia
			stnt = con.prepareStatement(LISTAR_APUESTAS_USERS);

			// ejecutamos sentencia
			rs = stnt.executeQuery();

			// guardamos la informacion necesaria para mostrarla en la tabla
			while (rs.next()) {

				/*
				 * en caso de no haber puesto ningun filtro te muestra todas las apuestas, en
				 * cambio si ha introducido un deporte previamente solo se mostraran las
				 * apuestas de ese deporte
				 */
				if (deportes == null) {
					apuesta = new ListadoApuestas();
					apuesta.seteLocal(rs.getString("e.nombre"));
					apuesta.seteVisitante(rs.getString("e2.nombre"));
					apuesta.setfPartido(rs.getDate("fecha_partido").toLocalDate());
					apuesta.setfApuesta(rs.getDate("fecha_apuesta").toLocalDate());
					apuesta.setCuota(rs.getFloat("cuota"));
					apuesta.setCodPartido(rs.getString("p.cod_partido"));
					apuesta.setCodApuesta(rs.getString("a.cod_apuesta"));
					apuestas.add(apuesta);
				} else if (deportes != null && deportes.getNombreDep().equalsIgnoreCase(rs.getString("e.deporte"))) {
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

		//cerrar conexion
		this.cerrarConexion();
		return apuestas;
	}

}
