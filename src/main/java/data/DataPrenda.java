package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataPrenda {
	public LinkedList<Prenda> getAll() throws DataAccessException{
		DataTipoPrenda dtp = new DataTipoPrenda();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Prenda> prendas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from prenda");
			if(rs!=null) {
				while(rs.next()) {
					Prenda p=new Prenda();
					p.set_tipoPrenda(new TipoPrenda());
					p.setCodPrenda(rs.getInt("codPrenda"));
					p.setNombrePrenda(rs.getString("nombrePrenda"));
					p.setColor(rs.getString("color"));
					p.setMarca(rs.getString("marca"));
					p.setTalle(rs.getString("talle"));
					p.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
					p.setPrecioUnitario(rs.getDouble("precioUnitario"));
					dtp.setPrendas(p);
					prendas.add(p);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la lista de prendas.", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return prendas;
	}
	
	public Prenda getByCodPrenda(Prenda PrendaToSearch) throws DataAccessException{
		Prenda p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from prenda where codPrenda=?"
					);
			stmt.setInt(1, PrendaToSearch.getCodPrenda());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Prenda();
				p.set_tipoPrenda(new TipoPrenda());
				p.setCodPrenda(rs.getInt("codPrenda"));
				p.setNombrePrenda(rs.getString("nombrePrenda"));
				p.setColor(rs.getString("color"));
				p.setMarca(rs.getString("marca"));
				p.setTalle(rs.getString("talle"));
				p.setPrecioUnitario(rs.getDouble("precioUnitario"));
				p.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la/las prenda/s", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return p;
	}
	
	public Prenda getByNombrePrenda(Prenda PrendaToSearch) throws DataAccessException{
		Prenda p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from prenda where nombrePrenda=?"
					);
			stmt.setString(1, PrendaToSearch.getNombrePrenda());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Prenda();
				p.setCodPrenda(rs.getInt("codPrenda"));
				p.setNombrePrenda(rs.getString("nombrePrenda"));
				p.setColor(rs.getString("color"));
				p.setMarca(rs.getString("marca"));
				p.setTalle(rs.getString("talle"));
				p.setPrecioUnitario(rs.getDouble("precioUnitario"));
				p.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la/las prenda/s", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return p;
	}
	
	public void setVenta(Venta ven) throws DataAccessException {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select prenda.* "
					+ "from prenda "
					+ "inner join venta "
					+ "on prenda.codPrenda = venta.idPrenda "
					+ "where nroVenta=?"
					);
			stmt.setInt(1, ven.getNroVenta());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Prenda pre = new Prenda();
					pre.set_tipoPrenda(new TipoPrenda());
					pre.setCodPrenda(rs.getInt("codPrenda"));
					pre.setNombrePrenda(rs.getString("nombrePrenda"));
					pre.setColor(rs.getString("color"));
					pre.setMarca(rs.getString("marca"));
					pre.setTalle(rs.getString("talle"));
					pre.setPrecioUnitario(rs.getDouble("precioUnitario"));
					pre.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
					ven.set_prenda(pre);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al establecer la venta en la prenda designada.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
	}

	public void add(Prenda prenda) throws DataAccessException{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into prenda(nombrePrenda, color, marca, talle, codTipoPrenda, precioUnitario) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, prenda.getNombrePrenda());
			stmt.setString(2, prenda.getColor());
			stmt.setString(3, prenda.getMarca());
			stmt.setString(4, prenda.getTalle());
			stmt.setInt(5, prenda.get_tipoPrenda().getCodTipoPrenda());
			stmt.setDouble(6, prenda.getPrecioUnitario());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                prenda.setCodPrenda(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("Error al agregar la prenda", e);
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
	
	public void update(Prenda prenda) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update prenda set nombrePrenda=?,color=?,marca=?,talle=?,codTipoPrenda=?,precioUnitario=? where codPrenda=?");
			stmt.setString(1, prenda.getNombrePrenda());
			stmt.setString(2, prenda.getColor());
			stmt.setString(3, prenda.getMarca());
			stmt.setString(4, prenda.getTalle());
			stmt.setInt(5, prenda.get_tipoPrenda().getCodTipoPrenda());
			stmt.setDouble(6, prenda.getPrecioUnitario());
			stmt.setInt(7, prenda.getCodPrenda());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al editar la prenda.", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Prenda prenda) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from prenda where codPrenda=?");
			stmt.setInt(1, prenda.getCodPrenda());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al eliminar la prenda.", e);
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
