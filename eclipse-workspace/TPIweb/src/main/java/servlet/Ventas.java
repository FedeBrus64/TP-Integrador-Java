package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import utils.DataAccessException;
import data.*;

/**
 * Servlet implementation class Ventas
 */
@WebServlet({ "/Ventas", "/ventas" })
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataVenta dv = new DataVenta();
		
		if(request.getParameter("delVen") != null) {
			Venta delVen = new Venta();
			delVen.setNroVenta(Integer.parseInt(request.getParameter("delVen")));
			try {
				Venta deletedVenta = dv.getByNroVenta(delVen);
				dv.remove(deletedVenta);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		}
		
		try {
			LinkedList<Venta> ventas = dv.getAll();
			request.setAttribute("listaVentas", ventas);
			request.getRequestDispatcher("WEB-INF/VentaManagement.jsp").forward(request, response);
		} catch (DataAccessException e){
			 request.setAttribute("error", e.getMessage());
			 request.getRequestDispatcher("error.html").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Prenda pre = new Prenda();
		Venta ven = new Venta();
		Cliente cli = new Cliente();
		DataPrenda dp = new DataPrenda();
		DataVenta dv = new DataVenta();
		DataCliente dc = new DataCliente();
		
		String importeTotal = request.getParameter("importeTotal");
		String fechaVenta = request.getParameter("fechaVenta") + "T00:00:00";
		String formaPago = request.getParameter("formaPago");
		String estado = request.getParameter("estado");
		
		try {
			pre.setCodPrenda(Integer.parseInt(request.getParameter("prenda")));
			Prenda prenda = dp.getByCodPrenda(pre);
			
			cli.setIdUsuario(Integer.parseInt(request.getParameter("cliente")));
			Cliente cliente = dc.getByIdUsuario(cli);
			ven.setImporteTotal(Double.parseDouble(importeTotal));
			ven.setFechaVenta(LocalDateTime.parse(fechaVenta));
			ven.set_cliente(cliente);
			ven.set_prenda(prenda);
			ven.setFormaPago(formaPago);
			ven.setEstado(estado);
			dv.add(ven);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
		try {
			LinkedList<Venta> ventas = dv.getAll();
			request.setAttribute("listaVentas", ventas);
			request.getRequestDispatcher("WEB-INF/VentaManagement.jsp").forward(request, response);
		} catch (DataAccessException e){
			 request.setAttribute("error", e.getMessage());
			 request.getRequestDispatcher("error.html").forward(request, response);
		}	
		
	}

}
