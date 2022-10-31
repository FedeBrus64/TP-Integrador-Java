package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCliente;
import data.DataPrenda;
import data.DataVenta;
import entities.Cliente;
import entities.Prenda;
import entities.Venta;

/**
 * Servlet implementation class EditVenta
 */
@WebServlet({ "/EditVenta", "/editventa" })
public class EditVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataVenta dv = new DataVenta();
		Venta updVen = new Venta();
		
		LinkedList<Venta> ventas = dv.getAll();
		request.setAttribute("listaVentas", ventas);
		
		updVen.setNroVenta(Integer.parseInt(request.getParameter("updVen")));
		Venta updateVenta = dv.getByNroVenta(updVen);
		request.setAttribute("updateVenta", updateVenta);
		
		request.getRequestDispatcher("WEB-INF/EditVentaManagement.jsp").forward(request, response);
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
		
		String nroVenta = request.getParameter("nroVenta");
		String importeTotal = request.getParameter("importeTotal");
		String fechaVenta = request.getParameter("fechaVenta") + "T00:00:00";
		
		pre.setCodPrenda(Integer.parseInt(request.getParameter("prenda")));
		Prenda prenda = dp.getByCodPrenda(pre);
		
		cli.setIdUsuario(Integer.parseInt(request.getParameter("cliente")));
		Cliente cliente = dc.getByIdUsuario(cli);
		
		ven.setNroVenta(Integer.parseInt(nroVenta));
		ven.setImporteTotal(Double.parseDouble(importeTotal));
		ven.setFechaVenta(LocalDateTime.parse(fechaVenta));
		ven.set_cliente(cliente);
		ven.set_prenda(prenda);
		
		dv.update(ven);
		
		LinkedList<Venta> ventas = dv.getAll();
		
		request.setAttribute("listaVentas", ventas);
		
		request.getRequestDispatcher("WEB-INF/VentaManagement.jsp").forward(request, response);
	}

}
