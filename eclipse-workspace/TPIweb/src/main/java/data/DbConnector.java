package data;

import java.sql.*;
import utils.DataAccessException;


public class DbConnector {

	private static DbConnector instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String password="morena";
	private String db="tienda_ropa";
	private int conectados=0;
	private Connection conn=null;
	
	private DbConnector() throws DataAccessException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Error al encontrar el driver para la conexión.", e);
		}
	}
	
	public static DbConnector getInstancia() throws DataAccessException{
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn() throws DataAccessException{
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al obtener la conexión.", e);
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() throws DataAccessException{
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DataAccessException("Error al cerrar la conexión.", e);
		}
	}
}
