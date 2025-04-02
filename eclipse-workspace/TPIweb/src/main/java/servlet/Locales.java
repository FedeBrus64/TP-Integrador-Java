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
 * Servlet implementation class TiposPrendas
 */
@WebServlet({ "/Locales", "/locales"})
public class Locales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Locales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataLocal dl = new DataLocal();
		
		if(request.getParameter("delLoc") != null) {
			Local delLoc = new Local();
			delLoc.setCodLocal(Integer.parseInt(request.getParameter("delLoc")));
			try {
				Local deletedLocal = dl.getByIdLocal(delLoc);
				dl.remove(deletedLocal);	
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
		
		try {
			LinkedList<Local> locales = dl.getAll();
			request.setAttribute("listaLocales", locales);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/LocalManagement.jsp").forward(request, response);
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
		Local l= new Local();
		DataLocal dl = new DataLocal();
		
		String descLocal = request.getParameter("descLocal");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		l.setDescLocal(descLocal);
		l.setDireccionLocal(direccion);
		l.setTelefonoLocal(Integer.parseInt(telefono));
		
		try {
			dl.add(l);
			
			LinkedList<Local> locales = dl.getAll();
			
			request.setAttribute("listaLocales", locales);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/LocalManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
