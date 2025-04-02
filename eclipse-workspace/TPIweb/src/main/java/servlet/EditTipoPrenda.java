package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataTipoPrenda;
import entities.TipoPrenda;
import utils.DataAccessException;

/**
 * Servlet implementation class EditTipoPrenda
 */
@WebServlet({ "/EditTipoPrenda", "/edittipoprenda" })
public class EditTipoPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTipoPrenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataTipoPrenda dtp = new DataTipoPrenda();
		TipoPrenda updTp = new TipoPrenda();
		
		try {
			LinkedList<TipoPrenda> tiposprendas = dtp.getAll();
			request.setAttribute("listaTiposPrendas", tiposprendas);
			updTp.setCodTipoPrenda(Integer.parseInt(request.getParameter("updTp")));
			TipoPrenda updateTipoPrenda = dtp.getById(updTp);
			request.setAttribute("updateTipoPrenda", updateTipoPrenda);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/EditTipoPrendaManagement.jsp").forward(request, response);
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
		TipoPrenda tp = new TipoPrenda();
		DataTipoPrenda dtp = new DataTipoPrenda();
		
		String codtipoprenda = request.getParameter("codtipoprenda");
		String descripcion = request.getParameter("descripcion");
		
		tp.setCodTipoPrenda(Integer.parseInt(codtipoprenda));
		tp.setDescTipoPrenda(descripcion);
		
		try {
			dtp.update(tp);
			
			LinkedList<TipoPrenda> tiposprendas = dtp.getAll();
			
			request.setAttribute("listaTiposPrendas", tiposprendas);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/TipoPrendaManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
