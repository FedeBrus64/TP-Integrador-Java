package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataLocal {
	
	public LinkedList<Local> getAll() throws DataAccessException{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Local> locales= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from local");
			if(rs!=null) {
				while(rs.next()) {
					Local loc=new Local();
					loc.setCodLocal(rs.getInt("codLocal"));
					loc.setDescLocal(rs.getString("descLocal"));
					loc.setDireccionLocal(rs.getString("direccion"));
					loc.setTelefonoLocal(rs.getInt("telefono"));
					locales.add(loc);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la lista de locales.", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		return locales;
	}
	
	public Local getByIdLocal(Local LocalToSearch) throws DataAccessException{
		Local l=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from local where codLocal=?"
					);
			stmt.setInt(1, LocalToSearch.getCodLocal());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				l=new Local();
				l.setCodLocal(rs.getInt("codLocal"));
				l.setDescLocal(rs.getString("descLocal"));
				l.setDireccionLocal(rs.getString("direccion"));
				l.setTelefonoLocal(rs.getInt("telefono"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el local especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return l;
	}
	
	public void setPrendas(Prenda pre) throws DataAccessException{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select local.* "
					+ "from local "
					+ "inner join prenda "
					+ "on local.codLocal=prenda.codLocal "
					+ "where codPrenda=?"
					);
			stmt.setInt(1, pre.getCodPrenda());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Local loc = new Local();
					loc.setCodLocal(rs.getInt("codLocal"));
					loc.setDescLocal(rs.getString("descLocal"));
					loc.setDireccionLocal(rs.getString("direccion"));
					loc.setTelefonoLocal(rs.getInt("telefono"));
					pre.set_local(loc);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los local/es y sus prendas correspondientes", e);
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
	
	public void add(Local Local) throws DataAccessException{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into local(descLocal, direccion, telefono) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, Local.getDescLocal());
			stmt.setString(2, Local.getDireccionLocal());
			stmt.setInt(3, Local.getTelefonoLocal());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                Local.setCodLocal(keyResultSet.getInt(1));
            }

		} catch (SQLException e) {
			throw new DataAccessException("Error al agregar el local.", e);
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
	
	public void update(Local Local) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update local set descLocal=?, direccion=?, telefono=? where codLocal=?");
			stmt.setString(1, Local.getDescLocal());
			stmt.setString(2, Local.getDireccionLocal());
			stmt.setInt(3, Local.getTelefonoLocal());
			stmt.setInt(4, Local.getCodLocal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al editar el local.", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Local Local) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from local where codLocal=?");
			stmt.setInt(1, Local.getCodLocal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al eliminar el local.", e);
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