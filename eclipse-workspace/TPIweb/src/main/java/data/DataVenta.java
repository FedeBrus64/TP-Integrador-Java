package data;

import java.time.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;

public class DataVenta {
	public LinkedList<Venta> getAll() throws DataAccessException{
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
					v.setFormaPago(rs.getString("formaPago"));
					v.setEstado(rs.getString("estado"));
					v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
					v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
					dc.setVenta(v);
					dp.setVenta(v);
					ventas.add(v);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener la lista de ventas", e);
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return ventas;
	}
	
	public LinkedList<Venta> getVentasDeUsuario(int idUsuario) throws DataAccessException{
		DataCliente dc = new DataCliente();
		DataPrenda dp = new DataPrenda();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Venta> ventas= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from venta v\r\n"
					+ "inner join usuario u on v.idCliente = u.idUsuario\r\n"
					+ "inner join prenda p on v.idPrenda=p.codPrenda\r\n"
					+ "where u.idUsuario = ?"
					);
			stmt.setInt(1, idUsuario);
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Venta v=new Venta();
					v.set_cliente(new Cliente());
					v.set_prenda(new Prenda());
					v.setNroVenta(rs.getInt("nroVenta"));
					v.setFechaVenta(rs.getObject("fechaVenta",LocalDateTime.class));
					v.setImporteTotal(rs.getDouble("importeTotal"));
					v.setEstado(rs.getString("estado"));
					v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
					v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
					v.setFormaPago(rs.getString("formaPago"));
					dc.setVenta(v);
					dp.setVenta(v);
					ventas.add(v);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo recuperar la lista de compras del usuario", e);
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return ventas;
	}
	
	
	public Venta getByNroVenta(Venta VentaToSearch) throws DataAccessException {
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
				v.setFormaPago(rs.getString("formaPago"));
				v.setEstado(rs.getString("estado"));
				v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
				v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener la/s venta/s especificadas", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return v;
	}
	
	public Venta getByIdCliente(Venta VentaToSearch) throws DataAccessException {
		Venta v=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from venta where idCliente=?"
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
				v.setFormaPago(rs.getString("formaPago"));
				v.setEstado(rs.getString("estado"));
				v.get_cliente().setIdUsuario(rs.getInt("idCliente"));
				v.get_prenda().setCodPrenda(rs.getInt("idPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener la/s venta/s especificadas", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return v;
	}
	
	
	
	public void add(Venta venta) throws DataAccessException {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into venta(fechaVenta, importeTotal, formaPago, estado, idPrenda, idCliente) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setObject(1, venta.getFechaVenta());
			stmt.setDouble(2, venta.getImporteTotal());
			stmt.setString(3, venta.getFormaPago());
			stmt.setString(4, venta.getEstado());
			stmt.setInt(5, venta.get_prenda().getCodPrenda());
			stmt.setInt(6, venta.get_cliente().getIdUsuario());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                venta.setNroVenta(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo agregar la venta", e);
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}

	}
	
	public void update(Venta venta) throws DataAccessException {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update venta set fechaVenta=?, importeTotal=?, formaPago=?, estado=?, idPrenda=?, idCliente=? where nroVenta=?");
			stmt.setObject(1, venta.getFechaVenta());
			stmt.setDouble(2, venta.getImporteTotal());
			stmt.setString(3, venta.getFormaPago());
			stmt.setString(4, venta.getEstado());
			stmt.setInt(5, venta.get_prenda().getCodPrenda());
			stmt.setInt(6, venta.get_cliente().getIdUsuario());
			stmt.setInt(7, venta.getNroVenta());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo editar la venta", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Venta venta) throws DataAccessException {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from venta where nroVenta=?");
			stmt.setInt(1, venta.getNroVenta());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo eliminar la venta", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
}
