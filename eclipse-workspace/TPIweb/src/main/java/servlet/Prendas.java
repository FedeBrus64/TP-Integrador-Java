package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import data.*;
import utils.DataAccessException;

/**
 * Servlet implementation class Prendas
 */
@WebServlet({ "/Prendas", "/prendas" })
public class Prendas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prendas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataPrenda dp = new DataPrenda();
		
		if(request.getParameter("delPre") != null) {
			Prenda delPre = new Prenda();
			delPre.setCodPrenda(Integer.parseInt(request.getParameter("delPre")));
			try {
				Prenda deletedPrenda = dp.getByCodPrenda(delPre);
				dp.remove(deletedPrenda);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
		
		try {
			LinkedList<Prenda> prendas = dp.getAll();
			request.setAttribute("listaPrendas", prendas);
			request.getRequestDispatcher("WEB-INF/PrendaManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
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
		TipoPrenda tp = new TipoPrenda();
		DataPrenda dp = new DataPrenda();
		DataTipoPrenda dtp = new DataTipoPrenda();
		request.setCharacterEncoding("UTF-8");
		
		String nombrePrenda = request.getParameter("nombrePrenda");
		String talle = request.getParameter("talle");
		String color = request.getParameter("color");
		String marca = request.getParameter("marca");
		String precioUnitario= request.getParameter("precioUnitario");
		
		tp.setCodTipoPrenda(Integer.parseInt(request.getParameter("tipoPrenda")));
		
		try {
			TipoPrenda tipoPrenda = dtp.getById(tp);
			
			pre.setNombrePrenda(nombrePrenda);
			pre.setTalle(talle);
			pre.setColor(color);
			pre.setMarca(marca);
			pre.set_tipoPrenda(tipoPrenda);
			pre.setPrecioUnitario(Double.parseDouble(precioUnitario));
			
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
			
		try {
			dp.add(pre);
			
			LinkedList<Prenda> prendas = dp.getAll();
			
			request.setAttribute("listaPrendas", prendas);
			
			request.getRequestDispatcher("WEB-INF/PrendaManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
