package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataLocal;
import entities.Local;
import utils.DataAccessException;

/**
 * Servlet implementation class EditLocal
 */
@WebServlet({ "/EditLocal", "/editlocal" })
public class EditLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataLocal dl = new DataLocal();
		Local updLoc = new Local();
		
		try {
			LinkedList<Local> locales = dl.getAll();
			request.setAttribute("listaLocales", locales);
			updLoc.setCodLocal(Integer.parseInt(request.getParameter("updLoc")));
			Local updateLocal = dl.getByIdLocal(updLoc);
			request.setAttribute("updateLocal", updateLocal);
			request.getRequestDispatcher("WEB-INF/EditLocalManagement.jsp").forward(request, response);
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
		Local loc = new Local();
		DataLocal dl = new DataLocal();
		
		String codLocal = request.getParameter("codLocal");
		String descripcion = request.getParameter("descLocal");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		loc.setCodLocal(Integer.parseInt(codLocal));
		loc.setDescLocal(descripcion);
		loc.setDireccionLocal(direccion);
		loc.setTelefonoLocal(Integer.parseInt(telefono));
		
		try {
			dl.update(loc);
			
			LinkedList<Local> locales = dl.getAll();
			
			request.setAttribute("listaLocales", locales);
			
			request.getRequestDispatcher("WEB-INF/LocalManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
