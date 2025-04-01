package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataCliente {
	
	public LinkedList<Cliente> getAll() throws DataAccessException{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Cliente> clientes= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario where tipoUsuario='cliente'");
			if(rs!=null) {
				while(rs.next()) {
					Cliente c=new Cliente();
					c.setIdUsuario(rs.getInt("idUsuario"));
					c.setNomUsuario(rs.getString("nomUsuario"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setDireccion(rs.getString("direccion"));
					c.setEmail(rs.getString("email"));
					c.setLocalidad(rs.getString("localidad"));
					c.setCodigoPostal(rs.getInt("codigoPostal"));
					clientes.add(c);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la lista de clientes.", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return clientes;
	}
	
	public Cliente getByIdUsuario(Cliente ClienteToSearch) throws DataAccessException{
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=? and tipoUsuario=? "
					);
			stmt.setInt(1, ClienteToSearch.getIdUsuario());
			stmt.setString(2, "cliente");
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Cliente();
				c.setIdUsuario(rs.getInt("idUsuario"));
				c.setNomUsuario(rs.getString("nomUsuario"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDireccion(rs.getString("direccion"));
				c.setEmail(rs.getString("email"));
				c.setLocalidad(rs.getString("localidad"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el cliente especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return c;
	}
	
	public Cliente getByIdUsuario(Usuario ClienteToSearch) throws DataAccessException{
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=? and tipoUsuario=? "
					);
			stmt.setInt(1, ClienteToSearch.getIdUsuario());
			stmt.setString(2, "cliente");
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Cliente();
				c.setIdUsuario(rs.getInt("idUsuario"));
				c.setNomUsuario(rs.getString("nomUsuario"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDireccion(rs.getString("direccion"));
				c.setEmail(rs.getString("email"));
				c.setLocalidad(rs.getString("localidad"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el cliente especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return c;
	}
	
	public Cliente getByNomUsuario(Cliente ClienteToSearch) throws DataAccessException{
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where nomUsuario=?"
					);
			stmt.setInt(1, ClienteToSearch.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Cliente();
				c.setIdUsuario(rs.getInt("idUsuario"));
				c.setNomUsuario(rs.getString("nomUsuario"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDireccion(rs.getString("direccion"));
				c.setEmail(rs.getString("email"));
				c.setLocalidad(rs.getString("localidad"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el cliente especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return c;
	}
	
	public Usuario getByEmail(Cliente ClienteToSearch) throws DataAccessException{
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where email=?"
					);
			stmt.setString(1, ClienteToSearch.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Cliente();
				c.setIdUsuario(rs.getInt("idUsuario"));
				c.setContraseña(rs.getString("contraseña"));
				c.setNomUsuario(rs.getString("nomUsuario"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setDireccion(rs.getString("direccion"));
				c.setEmail(rs.getString("email"));
				c.setLocalidad(rs.getString("localidad"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
				c.setTipoUsuario(rs.getString("tipoUsuario"));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el cliente especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return c;
	}
	
	public void setVenta(Venta ven) throws DataAccessException{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select usuario.* "
					+ "from usuario "
					+ "inner join venta "
					+ "on usuario.idUsuario = venta.idCliente "
					+ "where nroVenta=? and tipoUsuario=?"
					);
			stmt.setInt(1, ven.getNroVenta());
			stmt.setString(2, "cliente");
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Cliente cli = new Cliente();
					cli.setIdUsuario(rs.getInt("idUsuario"));
					cli.setNomUsuario(rs.getString("nomUsuario"));
					cli.setNombre(rs.getString("nombre"));
					cli.setApellido(rs.getString("apellido"));
					cli.setDireccion(rs.getString("direccion"));
					cli.setEmail(rs.getString("email"));
					cli.setLocalidad(rs.getString("localidad"));
					cli.setCodigoPostal(rs.getInt("codigoPostal"));
					ven.set_cliente(cli);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al establecer la venta.", e);
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

	public void add(Cliente cliente) throws DataAccessException{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into usuario(nomUsuario,nombre,apellido,direccion,email,localidad, codigoPostal) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, cliente.getNomUsuario());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellido());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getLocalidad());
			stmt.setInt(7, cliente.getCodigoPostal());

			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                cliente.setIdUsuario(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("Error al agregar el cliente.", e);
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
	
	public void update(Cliente cliente) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update usuario set nomUsuario=?,nombre=?,apellido=?,direccion=?,email=?,localidad=?, codigoPostal=? where idUsuario=?");
			stmt.setString(1, cliente.getNomUsuario());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellido());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getLocalidad());
			stmt.setInt(7, cliente.getCodigoPostal());
			stmt.setInt(8, cliente.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al editar el cliente.", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Cliente cliente) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from usuario where idUsuario=?");
			stmt.setInt(1, cliente.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al eliminar el cliente.", e);
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
