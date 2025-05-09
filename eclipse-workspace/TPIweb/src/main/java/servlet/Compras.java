package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.*;
import data.*;
import utils.DataAccessException;

/**
 * Servlet implementation class Ventas
 */
@WebServlet({ "/Compras", "/compras" })
public class Compras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DataVenta dv = new DataVenta();
		HttpSession session = request.getSession();
		Usuario usu= (Usuario)session.getAttribute("usuario");
		if(request.getParameter("delCom") != null) {
			Venta delVen = new Venta();
			delVen.setNroVenta(Integer.parseInt(request.getParameter("delCom")));
			try {
				Venta deletedVenta = dv.getByNroVenta(delVen);
				dv.remove(deletedVenta);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		}
		
		try {
			LinkedList<Venta> ventas = dv.getVentasDeUsuario(usu.getIdUsuario());
			request.setAttribute("listaVentas", ventas);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/ComprasManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("WEB-INF/ComprasManagement.jsp").forward(request, response);
	}

}