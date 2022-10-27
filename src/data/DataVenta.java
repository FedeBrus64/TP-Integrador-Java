package data;

import java.time.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataVenta {
	public LinkedList<Venta> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Venta> ventas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from venta");
			if(rs!=null) {
				while(rs.next()) {
					Venta v=new Venta();
					v.setNroVenta(rs.getInt("nroVenta"));
					v.setFechaVenta(rs.getObject("fechaVenta",LocalDateTime.class));
					v.setImporteTotal(rs.getDouble("importeTotal"));
					v.get_cliente().setIdUsuario(rs.getInt("marca"));
					v.get_prenda().setCodPrenda(rs.getInt("codPrenda"));
					ventas.add(v);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return ventas;
	}
}
