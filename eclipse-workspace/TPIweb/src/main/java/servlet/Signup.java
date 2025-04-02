package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;
import entities.*;
import utils.DataAccessException;


/**
 * Servlet implementation class Signup
 */
@WebServlet({ "/Signup", "/signup" })
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/SignUpManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		DataCliente dc = new DataCliente();
		
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String codigoPostal = request.getParameter("codigoPostal");
		String tipoUsuario = "cliente";
		

		cli.setNomUsuario(nomUsuario);
		cli.setContraseña(password);
		cli.setNombre(nombre);
		cli.setApellido(apellido);
		cli.setEmail(email);
		cli.setDireccion(direccion);
		cli.setLocalidad(localidad);
		cli.setTipoUsuario(tipoUsuario);
		cli.setCodigoPostal(Integer.parseInt(codigoPostal));
		
		Usuario usuarioValidar = new Cliente();
		
		try {
			usuarioValidar = dc.getByEmail(cli);
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
		
		if(usuarioValidar == null) {
			try {
				dc.add(cli);
				request.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("index.html").forward(request, response);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				e.printStackTrace();
				request.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		} else {
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("SignUpManagement.jsp?error=El Email ingresado ya existe. Por favor, ingrese otro Email");
		}
		
		
	}

}