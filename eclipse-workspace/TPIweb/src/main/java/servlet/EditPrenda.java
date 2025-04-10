package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPrenda;
import data.DataTipoPrenda;
import data.DataLocal;
import entities.Prenda;
import entities.TipoPrenda;
import entities.Local;
import utils.DataAccessException;

/**
 * Servlet implementation class EditPrenda
 */
@WebServlet({ "/EditPrenda", "/editprenda" })
public class EditPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPrenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataPrenda dp = new DataPrenda();
		Prenda updPre = new Prenda();
		
		try {
			LinkedList<Prenda> prendas = dp.getAll();
			request.setAttribute("listaPrendas", prendas);
			
			updPre.setCodPrenda(Integer.parseInt(request.getParameter("updPre")));
			Prenda updatePrenda = dp.getByCodPrenda(updPre);
			request.setAttribute("updatePrenda", updatePrenda);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/EditPrendaManagement.jsp").forward(request, response);
			
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
		Prenda pre = new Prenda();
		TipoPrenda tp = new TipoPrenda();
		Local l = new Local();
		DataPrenda dp = new DataPrenda();
		DataLocal dl = new DataLocal();
		DataTipoPrenda dtp = new DataTipoPrenda();
		
		String codPrenda = request.getParameter("codPrenda");
		String nombrePrenda = request.getParameter("nombrePrenda");
		String talle = request.getParameter("talle");
		String color = request.getParameter("color");
		String marca = request.getParameter("marca");
		String precioUnitario = request.getParameter("precioUnitario");
		
		tp.setCodTipoPrenda(Integer.parseInt(request.getParameter("tipoPrenda")));
		l.setCodLocal(Integer.parseInt(request.getParameter("local")));
		
		try {
			TipoPrenda tipoPrenda = dtp.getById(tp);
			Local local = dl.getByIdLocal(l);
			
			pre.setCodPrenda(Integer.parseInt(codPrenda));
			pre.setNombrePrenda(nombrePrenda);
			pre.setTalle(talle);
			pre.setColor(color);
			pre.setMarca(marca);
			pre.set_tipoPrenda(tipoPrenda);
			pre.set_local(local);
			pre.setPrecioUnitario(Double.parseDouble(precioUnitario));
			
			dp.update(pre);
			
			LinkedList<Prenda> prendas = dp.getAll();
			
			request.setAttribute("listaPrendas", prendas);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/PrendaManagement.jsp").forward(request, response);
			
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
