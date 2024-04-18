package ejercicio20_CentroEducativo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.ejemploCentroEducativo.entidades.Estudiante;



public class ControladorEstudiante extends SuperControlador{
	
	private static String nombreTabla = "centroeducativo.estudiante";

	public static Estudiante getPrimero() {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Estudiante getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(), 
					"select * from " + nombreTabla
					+ " order by id desc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Estudiante getAnterior(int idActual) {
		try {
			String sql = "select * from " + nombreTabla + " where id < " + idActual
					+ " order by id desc limit 1";
			return getEntidad (ConnectionManager.getConexion(), sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Estudiante getSiguiente(int idActual) {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " where id > " + idActual
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static int insercion (Estudiante o) {
		try {
			int nuevoId = nextIdEnTabla("estudiante");
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(""
					+ "insert into estudiante (id, nombre, apellido1, apellido2, imagen, idTipologiaSexo, "
					+ "dni, direccion, email, telefono, colorPreferido) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getApellido1());
			ps.setString(4, o.getApellido2());
			ps.setBytes(5, o.getImagen());
			ps.setInt(6, o.getIdTipologiaSexo());
			ps.setString(7, o.getDni());
			ps.setString(8, o.getDireccion());
			ps.setString(9, o.getEmail());
			ps.setString(10, o.getTelefono());
			ps.setString(11, o.getColorPreferido());
			
			
			ps.executeUpdate();
			return nuevoId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void modificacion (Estudiante o) {
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(""
					+ "update " + nombreTabla + " set nombre = ?, apellido1 = ?,"
							+ " apellido2 = ?, imagen = ?, idTipologiaSexo = ?,"
							+ " dni = ?, direccion = ?, email = ?, telefono = ?, colorPreferido = ? "
					+ "where id = ?");
			
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getApellido1());
			ps.setString(3, o.getApellido2());
			ps.setBytes(4, o.getImagen());
			ps.setInt(5, o.getIdTipologiaSexo());
			ps.setString(6, o.getDni());
			ps.setString(7, o.getDireccion());
			ps.setString(8, o.getEmail());
			ps.setString(9, o.getTelefono());
			ps.setString(10, o.getColorPreferido());
			ps.setInt(11, o.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminacion(int idActual) {
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("delete from " + nombreTabla
					+ " where id = ?");
			
			ps.setInt(1, idActual);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Estudiante getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Estudiante o = null;
		if (rs.next()) {
			o = new Estudiante();
			o.setId(rs.getInt("id"));
			o.setNombre(rs.getString("nombre"));
			o.setApellido1(rs.getString("apellido1"));
			o.setApellido2(rs.getString("apellido2"));
			o.setIdTipologiaSexo(rs.getInt("idTipologiaSexo"));
			o.setImagen(rs.getBytes("imagen"));
			o.setDni(rs.getString("dni"));
			o.setDireccion(rs.getString("direccion"));
			o.setEmail(rs.getString("email"));
			o.setTelefono(rs.getString("telefono"));
			o.setColorPreferido(rs.getString("colorPreferido"));
			
		}
		return o;
	}
	
	private static Estudiante getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Estudiante o = new Estudiante();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		o.setApellido1(rs.getString("apellido1"));
		o.setApellido2(rs.getString("apellido2"));
		o.setImagen(rs.getBytes("imagen"));
		o.setIdTipologiaSexo(rs.getInt("idTipologiaSexo"));
		o.setDni(rs.getString("dni"));
		o.setDireccion(rs.getString("direccion"));
		o.setEmail(rs.getString("email"));
		o.setTelefono(rs.getString("telefono"));
		o.setColorPreferido(rs.getString("colorPreferido"));
		return o;
	}
	
	public static List<Estudiante> getTodos(){
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Estudiante o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;	
	}

}
