package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPrenda;
import entities.Prenda;
import utils.DataAccessException;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Comprar", "/comprar" })
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataPrenda dp = new DataPrenda();
		
		try {
			LinkedList<Prenda> prendas = dp.getAll();
			request.setAttribute("listaPrendas", prendas);
			
			request.getRequestDispatcher("WEB-INF/ComprarPrendaManagement.jsp").forward(request, response);
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
		request.getRequestDispatcher("WEB-INF/Menu.jsp").forward(request, response);
	}

}
