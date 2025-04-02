package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataUsuario {
	
	public LinkedList<Usuario> getAll() throws DataAccessException{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Usuario> usuarios= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario where tipoUsuario <> 'admin'");
			if(rs!=null) {
				while(rs.next()) {
					Usuario u=new Usuario();
					u.setIdUsuario(rs.getInt("idUsuario"));
					u.setNomUsuario(rs.getString("nomUsuario"));
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellido"));
					u.setDireccion(rs.getString("direccion"));
					u.setEmail(rs.getString("email"));
					u.setLocalidad(rs.getString("localidad"));
					u.setTipoUsuario(rs.getString("tipoUsuario"));
					usuarios.add(u);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener la lista de usuarios.", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return usuarios;
	}
	
	public Usuario getByIdUsuario(Usuario UsuarioToSearch) throws DataAccessException {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=?"
					);
			stmt.setInt(1, UsuarioToSearch.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new Usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setNomUsuario(rs.getString("nomUsuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDireccion(rs.getString("direccion"));
				u.setEmail(rs.getString("email"));
				u.setLocalidad(rs.getString("localidad"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los usuario/s", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return u;
	}
	
	public Usuario getByEmail(Usuario UsuarioToSearch) throws DataAccessException {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where email=?"
					);
			stmt.setString(1, UsuarioToSearch.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new Usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setContraseña(rs.getString("contraseña"));
				u.setNomUsuario(rs.getString("nomUsuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDireccion(rs.getString("direccion"));
				u.setEmail(rs.getString("email"));
				u.setLocalidad(rs.getString("localidad"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los usuario/s", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return u;
	}
	
	public Usuario getByEmailContraseña(Usuario UsuarioToSearch) throws DataAccessException {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where email=? and contraseña=?"
					);
			stmt.setString(1, UsuarioToSearch.getEmail());
			stmt.setString(2, UsuarioToSearch.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new Usuario();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setNomUsuario(rs.getString("nomUsuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setDireccion(rs.getString("direccion"));
				u.setEmail(rs.getString("email"));
				u.setLocalidad(rs.getString("localidad"));
				u.setTipoUsuario(rs.getString("tipoUsuario"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("No se pudo obtener el/los usuario/s", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return u;
	}

	public void add(Usuario usuario) throws DataAccessException{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into usuario(nomUsuario,nombre,apellido,direccion,email,localidad,contraseña,tipoUsuario) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, usuario.getNomUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getDireccion());
			stmt.setString(5, usuario.getEmail());
			stmt.setString(6, usuario.getLocalidad());
			stmt.setString(7, usuario.getContraseña());
			stmt.setString(8, usuario.getTipoUsuario());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                usuario.setIdUsuario(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("Error al agregar el usuario.", e);
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
	
	public void update(Usuario usuario) throws DataAccessException {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update usuario set nomUsuario=?,nombre=?,apellido=?,direccion=?,email=?,localidad=?,tipoUsuario=? where idUsuario=?");
			stmt.setString(1, usuario.getNomUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getDireccion());
			stmt.setString(5, usuario.getEmail());
			stmt.setString(6, usuario.getLocalidad());
			stmt.setString(7, usuario.getTipoUsuario());
			stmt.setInt(8, usuario.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al editar el Usuario.", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Usuario Usuario) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from usuario where idUsuario=?");
			stmt.setInt(1, Usuario.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al eliminar el Usuario.", e);
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
