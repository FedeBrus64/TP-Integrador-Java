package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import entities.*;
import utils.DataAccessException;


/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Checkout", "/checkout" })
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DataPrenda dp = new DataPrenda();
		Prenda prendaComprar = new Prenda();
		
		try {
			prendaComprar.setCodPrenda(Integer.parseInt(request.getParameter("prenda")));
			Prenda checkoutPrenda = dp.getByCodPrenda(prendaComprar);
			request.setAttribute("checkoutPrenda", checkoutPrenda);
			session.setAttribute("prenda", checkoutPrenda);
			
			request.getRequestDispatcher("WEB-INF/CheckoutManagement.jsp").forward(request, response);
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
		Venta ven = new Venta();
		DataPrenda dp = new DataPrenda();
		DataVenta dv = new DataVenta();
		DataCliente dc = new DataCliente();
		HttpSession session = request.getSession();
		Usuario usu= (Usuario)session.getAttribute("usuario");
		Prenda pre = (Prenda)session.getAttribute("prenda");
		String formaPago= request.getParameter("metodoPago");
		
		try {
			Prenda prenda = dp.getByCodPrenda(pre);
			
			Cliente cliente = dc.getByIdUsuario(usu);
			
			ven.setImporteTotal(pre.getPrecioUnitario());
			ven.setFechaVenta(LocalDateTime.now());
			ven.set_cliente(cliente);
			ven.set_prenda(prenda);
			ven.setFormaPago(formaPago);
			
			dv.add(ven);
			
			request.getRequestDispatcher("exito.html").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}