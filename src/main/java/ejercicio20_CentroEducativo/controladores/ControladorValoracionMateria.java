package ejercicio20_CentroEducativo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import capitulo08.ejemploCentroEducativo.entidades.Curso;
import capitulo08.ejemploCentroEducativo.entidades.Materia;
import capitulo08.ejemploCentroEducativo.entidades.ValoracionMateria;


public class ControladorValoracionMateria extends SuperControlador{
	
	private static String nombreTabla = "valoracionmateria";
	
	
	public static ValoracionMateria findByIdMateriaAndIdProfesorAndIdEstudiante(
			int idMateria, int idProfesor, int idEstudiante){

		ValoracionMateria v = null;
		
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"Select * from " + nombreTabla + 
					" where idProfesor = ? and idMateria = ? "
					+ "and idEstudiante = ? limit 1 ");
			
			ps.setInt(1, idProfesor);
			ps.setInt(2, idMateria);
			ps.setInt(3, idEstudiante);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				v = getEntidadFromResultSet(rs);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;	
	}
	

	
	
	public static int insercion (ValoracionMateria o) {
		try {
			int nuevoId = nextIdEnTabla("valoracionmateria");
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(""
					+ "insert into valoracionmateria (id, valoracion) "
					+ "values (?, ?)");
			ps.setInt(1, nuevoId);
			ps.setFloat(2, o.getValoracion());
			
			ps.executeUpdate();
			return nuevoId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void modificacion (ValoracionMateria o) {
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(""
					+ "update " + nombreTabla + " set valoracion = ? "
					+ "where idMateria = ? and idProfesor = ? and idEstudiante = ?");
			ps.setFloat(1, o.getValoracion());
			ps.setInt(2, o.getIdMateria());
			ps.setInt(3, o.getIdProfesor());
			ps.setInt(4, o.getIdEstudiante());
			
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


	private static ValoracionMateria getEntidadFromResultSet(ResultSet rs) throws SQLException {
		ValoracionMateria o = new ValoracionMateria();
		o.setId(rs.getInt("id"));
		o.setIdEstudiante(rs.getInt("idEstudiante"));
		o.setIdMateria(rs.getInt("idMateria"));
		o.setIdProfesor(rs.getInt("idProfesor"));
		o.setValoracion(rs.getFloat("valoracion"));
		return o;
	}
	
}
