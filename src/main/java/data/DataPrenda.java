package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataPrenda {
	public LinkedList<Prenda> getAll(){
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
					dtp.setPrendas(p);
					prendas.add(p);
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
		
		
		return prendas;
	}
	
	public Prenda getByCodPrenda(Prenda PrendaToSearch) {
		Prenda p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from prenda where codPrenda=?"
					);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Prenda();
				p.set_tipoPrenda(new TipoPrenda());
				p.setCodPrenda(rs.getInt("codPrenda"));
				p.setNombrePrenda(rs.getString("nombrePrenda"));
				p.setColor(rs.getString("color"));
				p.setMarca(rs.getString("marca"));
				p.setTalle(rs.getString("talle"));
				p.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
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
		
		return p;
	}
	
	public Prenda getByNombrePrenda(Prenda PrendaToSearch) {
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
				p.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
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
		
		return p;
	}
	
	public void setVenta(Venta ven) {
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
					pre.setCodPrenda(rs.getInt("codPrenda"));
					pre.setNombrePrenda(rs.getString("nombrePrenda"));
					pre.setColor(rs.getString("color"));
					pre.setMarca(rs.getString("marca"));
					pre.setTalle(rs.getString("talle"));
					pre.get_tipoPrenda().setCodTipoPrenda(rs.getInt("codTipoPrenda"));
					ven.set_prenda(pre);
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

	public void add(Prenda prenda) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into prenda(nombrePrenda, color, marca, talle, codTipoPrenda) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, prenda.getNombrePrenda());
			stmt.setString(2, prenda.getColor());
			stmt.setString(3, prenda.getMarca());
			stmt.setString(4, prenda.getTalle());
			stmt.setInt(5, prenda.get_tipoPrenda().getCodTipoPrenda());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                prenda.setCodPrenda(keyResultSet.getInt(1));
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
	
	public void update(Prenda prenda) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update prenda set nombrePrenda=?,color=?,marca=?,talle=?,codTipoPrenda=? where codPrenda=?");
			stmt.setString(1, prenda.getNombrePrenda());
			stmt.setString(2, prenda.getColor());
			stmt.setString(3, prenda.getMarca());
			stmt.setString(4, prenda.getTalle());
			stmt.setInt(5, prenda.get_tipoPrenda().getCodTipoPrenda());
			stmt.setInt(6, prenda.getCodPrenda());
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
	
	public void remove(Prenda prenda) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from prenda where codPrenda=?");
			stmt.setInt(1, prenda.getCodPrenda());
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
