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

/**
 * Servlet implementation class TiposPrendas
 */
@WebServlet({ "/TiposPrendas", "/tiposprendas", "/tiposPrendas" })
public class TiposPrendas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiposPrendas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataTipoPrenda dtp = new DataTipoPrenda();
		
		if(request.getParameter("delTp") != null) {
			TipoPrenda delTp = new TipoPrenda();
			delTp.setCodTipoPrenda(Integer.parseInt(request.getParameter("delTp")));
			TipoPrenda deletedTipoPrenda = dtp.getById(delTp);
			dtp.remove(deletedTipoPrenda);	
		}
		
		LinkedList<TipoPrenda> tiposprendas = dtp.getAll();
		request.setAttribute("listaTiposPrendas", tiposprendas);
		
		request.getRequestDispatcher("WEB-INF/TipoPrendaManagement.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TipoPrenda tp = new TipoPrenda();
		DataTipoPrenda dtp = new DataTipoPrenda();
		
		String descripcion = request.getParameter("descripcion");
		
		tp.setDescTipoPrenda(descripcion);
		
		dtp.add(tp);
		
		LinkedList<TipoPrenda> tiposprendas = dtp.getAll();
		
		request.setAttribute("listaTiposPrendas", tiposprendas);
		
		request.getRequestDispatcher("WEB-INF/TipoPrendaManagement.jsp").forward(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
