package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataUsuario {
	
	public LinkedList<Usuario> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Usuario> usuarios= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario");
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
					usuarios.add(u);
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
		
		
		return usuarios;
	}
	
	public Usuario getByIdUsuario(Usuario UsuarioToSearch) {
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
		
		return u;
	}
	
	public Usuario getByNomUsuario(Usuario UsuarioToSearch) {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where nomUsuario=?"
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
		
		return u;
	}

	public void add(Usuario usuario) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into Usuario(nomUsuario,nombre,apellido,direccion,email,localidad) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, usuario.getNomUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getDireccion());
			stmt.setString(5, usuario.getEmail());
			stmt.setString(6, usuario.getLocalidad());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                usuario.setIdUsuario(keyResultSet.getInt(1));
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
	
	public void update(Usuario usuario) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update usuario set nomUsuario=?,nombre=?,apellido=?,direccion=?,email=?,localidad=? where idUsuario=?");
			stmt.setString(1, usuario.getNomUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getDireccion());
			stmt.setString(5, usuario.getEmail());
			stmt.setString(6, usuario.getLocalidad());
			stmt.setInt(7, usuario.getIdUsuario());
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
	
	public void remove(Usuario Usuario) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from Usuario where idUsuario=?");
			stmt.setInt(1, Usuario.getIdUsuario());
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
