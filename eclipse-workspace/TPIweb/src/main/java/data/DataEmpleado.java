package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import entities.*;
import utils.DataAccessException;


public class DataEmpleado {
	
	public LinkedList<Empleado> getAll() throws DataAccessException{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Empleado> empleados= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuario where tipoUsuario='empleado'");
			if(rs!=null) {
				while(rs.next()) {
					Empleado emp=new Empleado();
					emp.setIdUsuario(rs.getInt("idUsuario"));
					emp.setNomUsuario(rs.getString("nomUsuario"));
					emp.setNombre(rs.getString("nombre"));
					emp.setApellido(rs.getString("apellido"));
					emp.setDireccion(rs.getString("direccion"));
					emp.setEmail(rs.getString("email"));
					emp.setLocalidad(rs.getString("localidad"));
					emp.setFechaIngreso(rs.getObject("fechaIngreso",LocalDateTime.class));
					empleados.add(emp);
				}
			}
			
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la lista de empleados.", e);
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		
		return empleados;
	}
	
	public Empleado getByIdUsuario(Empleado EmpleadoToSearch) throws DataAccessException{
		Empleado emp=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=?"
					);
			stmt.setInt(1, EmpleadoToSearch.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				emp=new Empleado();
				emp.setIdUsuario(rs.getInt("idUsuario"));
				emp.setNomUsuario(rs.getString("nomUsuario"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setDireccion(rs.getString("direccion"));
				emp.setEmail(rs.getString("email"));
				emp.setLocalidad(rs.getString("localidad"));
				emp.setFechaIngreso(rs.getObject("fechaIngreso",LocalDateTime.class));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el empleado especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return emp;
	}
	
	public Empleado getByIdUsuario(Usuario EmpleadoToSearch) throws DataAccessException{
		Empleado emp=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where idUsuario=?"
					);
			stmt.setInt(1, EmpleadoToSearch.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				emp=new Empleado();
				emp.setIdUsuario(rs.getInt("idUsuario"));
				emp.setNomUsuario(rs.getString("nomUsuario"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setDireccion(rs.getString("direccion"));
				emp.setEmail(rs.getString("email"));
				emp.setLocalidad(rs.getString("localidad"));
				emp.setFechaIngreso(rs.getObject("fechaIngreso",LocalDateTime.class));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el empleado especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return emp;
	}
	
	public Empleado getByNomUsuario(Empleado EmpleadoToSearch) throws DataAccessException{
		Empleado emp=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from usuario where nomUsuario=?"
					);
			stmt.setInt(1, EmpleadoToSearch.getIdUsuario());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				emp=new Empleado();
				emp.setIdUsuario(rs.getInt("idUsuario"));
				emp.setNomUsuario(rs.getString("nomUsuario"));
				emp.setNombre(rs.getString("nombre"));
				emp.setApellido(rs.getString("apellido"));
				emp.setDireccion(rs.getString("direccion"));
				emp.setEmail(rs.getString("email"));
				emp.setLocalidad(rs.getString("localidad"));
				emp.setFechaIngreso(rs.getObject("fechaIngreso",LocalDateTime.class));
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener el empleado especificado.", e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new DataAccessException("Error al cerrar la conexión.", e);
			}
		}
		
		return emp;
	}

	public void add(Empleado empleado) throws DataAccessException{
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into usuario(nomUsuario,nombre,apellido,direccion,email,localidad,fechaIngreso, contraseña, tipoUsuario) values(?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, empleado.getNomUsuario());
			stmt.setString(2, empleado.getNombre());
			stmt.setString(3, empleado.getApellido());
			stmt.setString(4, empleado.getDireccion());
			stmt.setString(5, empleado.getEmail());
			stmt.setString(6, empleado.getLocalidad());
			stmt.setObject(7, empleado.getFechaIngreso());
			stmt.setString(8, empleado.getContraseña());
			stmt.setString(9, empleado.getTipoUsuario());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                empleado.setIdUsuario(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
			throw new DataAccessException("Error al agregar el empleado.", e);
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
	
	public void update(Empleado empleado) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update usuario set nomUsuario=?,nombre=?,apellido=?,direccion=?,email=?,localidad=?,fechaIngreso=?,contraseña=? where idUsuario=?");
			stmt.setString(1, empleado.getNomUsuario());
			stmt.setString(2, empleado.getNombre());
			stmt.setString(3, empleado.getApellido());
			stmt.setString(4, empleado.getDireccion());
			stmt.setString(5, empleado.getEmail());
			stmt.setString(6, empleado.getLocalidad());
			stmt.setObject(7, empleado.getFechaIngreso());
			stmt.setString(8, empleado.getContraseña());
			stmt.setInt(9, empleado.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al editar el empleado.", e);
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw new DataAccessException("Error al cerrar la conexión.", e);
            }
		}
	}
	
	public void remove(Empleado Empleado) throws DataAccessException{
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from usuario where idUsuario=?");
			stmt.setInt(1, Empleado.getIdUsuario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Error al eliminar el empleado.", e);
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
