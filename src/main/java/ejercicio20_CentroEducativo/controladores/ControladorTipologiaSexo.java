package ejercicio20_CentroEducativo.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import capitulo08.ejemploCentroEducativo.entidades.TipologiaSexo;

public class ControladorTipologiaSexo extends SuperControlador{

	private static String nombreTabla = "centroeducativo.tipologiaSexo";
	
	public static List<TipologiaSexo> findAll() {
		List<TipologiaSexo> l = new ArrayList<TipologiaSexo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			
			ResultSet rs = conn.createStatement()
					.executeQuery("Select * from " + nombreTabla);
			
			while (rs.next()) {
				TipologiaSexo o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	
	private static TipologiaSexo getEntidadFromResultSet (ResultSet rs) 
			throws SQLException {
		TipologiaSexo o = new TipologiaSexo();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));
		return o;
	}	
	
}
