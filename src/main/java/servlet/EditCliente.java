package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataCliente;
import entities.Cliente;
import utils.DataAccessException;

/**
 * Servlet implementation class EditCliente
 */
@WebServlet({ "/EditCliente", "/editcliente" })
public class EditCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataCliente dc = new DataCliente();
		Cliente updCli = new Cliente();
		
		try {
			LinkedList<Cliente> clientes = dc.getAll();
			request.setAttribute("listaClientes", clientes);
			
			updCli.setIdUsuario(Integer.parseInt(request.getParameter("updCli")));
			Cliente updateCliente = dc.getByIdUsuario(updCli);
			request.setAttribute("updateCliente", updateCliente);
			
			request.getRequestDispatcher("WEB-INF/EditClienteManagement.jsp").forward(request, response);
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
		Cliente cli = new Cliente();
		DataCliente dc = new DataCliente();
		
		String idUsuario = request.getParameter("idUsuario");
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String informacionPago = request.getParameter("informacionPago");
		String codigoPostal = request.getParameter("codigoPostal");
		
		cli.setIdUsuario(Integer.parseInt(idUsuario));
		cli.setNomUsuario(nomUsuario);
		cli.setContraseña(password);
		cli.setNombre(nombre);
		cli.setApellido(apellido);
		cli.setEmail(email);
		cli.setDireccion(direccion);
		cli.setLocalidad(localidad);
		cli.setInformacionPago(informacionPago);
		cli.setCodigoPostal(Integer.parseInt(codigoPostal));
		
		try {
			dc.update(cli);
			
			LinkedList<Cliente> clientes = dc.getAll();
			
			request.setAttribute("listaClientes", clientes);
			
			request.getRequestDispatcher("WEB-INF/ClienteManagement.jsp").forward(request, response);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
