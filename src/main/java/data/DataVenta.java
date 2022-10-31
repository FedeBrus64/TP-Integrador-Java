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
		DataCliente dc = new DataCliente();
		DataPrenda dp = new DataPrenda();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Venta> ventas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from venta");
			if(rs!=null) {
				while(rs.next()) {
					Venta v=new Venta();
					v.set_cliente(new Cliente());
					v.set_prenda(new Prenda());
					v.setNroVenta(rs.getInt("nroVenta"));
					v.setFechaVenta(rs.getObject("fechaVenta",LocalDateTime.class));
					v.setImporteTotal(rs.getDouble("importeTotal"));
					v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
					v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
					dc.setVenta(v);
					dp.setVenta(v);
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
	
	public Venta getByNroVenta(Venta VentaToSearch) {
		Venta v=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from venta where nroVenta=?"
					);
			stmt.setInt(1, VentaToSearch.getNroVenta());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				v=new Venta();
				v.set_cliente(new Cliente());
				v.set_prenda(new Prenda());
				v.setNroVenta(rs.getInt("nroVenta"));
				v.setFechaVenta(rs.getObject("fechaVenta",LocalDateTime.class));
				v.setImporteTotal(rs.getDouble("importeTotal"));
				v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
				v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return v;
	}
	
	
	
	public void add(Venta venta) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into venta(fechaVenta, importeTotal, idPrenda, idCliente) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setObject(1, venta.getFechaVenta());
			stmt.setDouble(2, venta.getImporteTotal());
			stmt.setInt(3, venta.get_prenda().getCodPrenda());
			stmt.setInt(4, venta.get_cliente().getIdUsuario());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                venta.setNroVenta(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}

	}
	
	public void update(Venta venta) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update venta set fechaVenta=?, importeTotal=?, idPrenda=?, idCliente=? where nroVenta=?");
			stmt.setObject(1, venta.getFechaVenta());
			stmt.setDouble(2, venta.getImporteTotal());
			stmt.setInt(3, venta.get_prenda().getCodPrenda());
			stmt.setInt(4, venta.get_cliente().getIdUsuario());
			stmt.setInt(5, venta.getNroVenta());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public void remove(Venta venta) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from venta where nroVenta=?");
			stmt.setInt(1, venta.getNroVenta());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
}
