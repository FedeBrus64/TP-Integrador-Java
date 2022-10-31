package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataCliente {
	
	public LinkedList<Cliente> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Cliente> clientes= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario where informacionPago is not null");
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
					c.setInformacionPago(rs.getString("informacionPago"));
					clientes.add(c);
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
		
		
		return clientes;
	}
	
	public Cliente getByIdUsuario(Cliente ClienteToSearch) {
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=? and informacionPago is not null"
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
				c.setInformacionPago(rs.getString("informacionPago"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
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
		
		return c;
	}
	
	public Cliente getByNomUsuario(Cliente ClienteToSearch) {
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
				c.setInformacionPago(rs.getString("informacionPago"));
				c.setCodigoPostal(rs.getInt("codigoPostal"));
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
		
		return c;
	}
	
	public void setVenta(Venta ven) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select usuario.* "
					+ "from usuario "
					+ "inner join venta "
					+ "on usuario.idUsuario = venta.idCliente "
					+ "where nroVenta=? and informacionPago is not null"
					);
			stmt.setInt(1, ven.getNroVenta());
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
					cli.setInformacionPago(rs.getString("informacionPago"));
					cli.setCodigoPostal(rs.getInt("codigoPostal"));
					ven.set_cliente(cli);
				}
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
	}

	public void add(Cliente cliente) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into usuario(nomUsuario,nombre,apellido,direccion,email,localidad, informacionPago, codigoPostal) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, cliente.getNomUsuario());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellido());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getLocalidad());
			stmt.setString(7, cliente.getInformacionPago());
			stmt.setInt(8, cliente.getCodigoPostal());

			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                cliente.setIdUsuario(keyResultSet.getInt(1));
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
	
	public void update(Cliente cliente) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update usuario set nomUsuario=?,nombre=?,apellido=?,direccion=?,email=?,localidad=?, informacionPago=?, codigoPostal=? where idUsuario=?");
			stmt.setString(1, cliente.getNomUsuario());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellido());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getLocalidad());
			stmt.setString(7, cliente.getInformacionPago());
			stmt.setInt(8, cliente.getCodigoPostal());
			stmt.setInt(9, cliente.getIdUsuario());
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
	
	public void remove(Cliente cliente) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from usuario where idUsuario=?");
			stmt.setInt(1, cliente.getIdUsuario());
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
