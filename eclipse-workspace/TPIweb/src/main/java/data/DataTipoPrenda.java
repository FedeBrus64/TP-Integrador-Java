package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataTipoPrenda {

	public LinkedList<TipoPrenda> getAll() throws DataAccessException{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<TipoPrenda> tipoprenda= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tipoprenda");
			if(rs!=null) {
				while(rs.next()) {
					TipoPrenda tp=new TipoPrenda();
					tp.setCodTipoPrenda(rs.getInt("codTipoPrenda"));
					tp.setDescTipoPrenda(rs.getString("descTipoPrenda"));
					tipoprenda.add(tp);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener la lista de tipos de prenda", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return tipoprenda;
	}
	
	public TipoPrenda getById(TipoPrenda TipoPrendaToSearch) throws DataAccessException {
		TipoPrenda tp=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from tipoprenda where codTipoPrenda=?"
					);
			stmt.setInt(1, TipoPrendaToSearch.getCodTipoPrenda());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				tp=new TipoPrenda();
				tp.setCodTipoPrenda(rs.getInt("codTipoPrenda"));
				tp.setDescTipoPrenda(rs.getString("descTipoPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los tipo/s de prenda", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return tp;
	}
	
	public TipoPrenda getByDesc(TipoPrenda TipoPrendaToSearch) throws DataAccessException{
		TipoPrenda tp=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from tipoprenda where descTipoPrenda=?"
					);
			stmt.setString(1, TipoPrendaToSearch.getDescTipoPrenda());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				tp=new TipoPrenda();
				tp.setCodTipoPrenda(rs.getInt("codTipoPrenda"));
				tp.setDescTipoPrenda(rs.getString("descTipoPrenda"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los tipo/s de prenda", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return tp;
	}
	
	public void setPrendas(Prenda pre) throws DataAccessException{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select tipoPrenda.* "
					+ "from tipoPrenda "
					+ "inner join prenda "
					+ "on tipoPrenda.codTipoPrenda=prenda.codTipoPrenda "
					+ "where codPrenda=?"
					);
			stmt.setInt(1, pre.getCodPrenda());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					TipoPrenda tp=new TipoPrenda();
					tp.setCodTipoPrenda(rs.getInt("codTipoPrenda"));
					tp.setDescTipoPrenda(rs.getString("descTipoPrenda"));
					pre.set_tipoPrenda(tp);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los tipo/s de prenda y sus prendas correspondientes", e);
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
	
	public void add(TipoPrenda TipoPrenda) throws DataAccessException {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into tipoprenda(descTipoPrenda) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, TipoPrenda.getDescTipoPrenda());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                TipoPrenda.setCodTipoPrenda(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo agregar el tipo de prenda", e);
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
	
	public void update(TipoPrenda TipoPrenda) throws DataAccessException {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update tipoprenda set descTipoPrenda=? where codTipoPrenda=?");
			stmt.setString(1, TipoPrenda.getDescTipoPrenda());
			stmt.setInt(2, TipoPrenda.getCodTipoPrenda());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo editar el tipo de prenda", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(TipoPrenda TipoPrenda) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from tipoprenda where codTipoPrenda=?");
			stmt.setInt(1, TipoPrenda.getCodTipoPrenda());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo eliminar el tipo de prenda", e);
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
