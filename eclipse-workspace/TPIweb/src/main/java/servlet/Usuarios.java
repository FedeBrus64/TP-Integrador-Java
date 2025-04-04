package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import entities.*;
import data.*;
import utils.DataAccessException;


/**
 * Servlet implementation class Usuarios
 */
@WebServlet({ "/Usuarios", "/usuarios" })
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DataUsuario du = new DataUsuario();
		
		if(request.getParameter("delUsu") != null) {
			Usuario delUsu = new Usuario();
			delUsu.setIdUsuario(Integer.parseInt(request.getParameter("delUsu")));
			try {
				Usuario deletedUsuario = du.getByIdUsuario(delUsu);
				du.remove(deletedUsuario);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.setCharacterEncoding("UTF-8");
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
		try {
			LinkedList<Usuario> usuarios = du.getAll();
			
			request.setAttribute("listaUsuarios", usuarios);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/UsuarioManagement.jsp").forward(request, response);
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
		Usuario usu = new Usuario();
		DataUsuario du = new DataUsuario();
		
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String tipoUsuario = request.getParameter("tipoUsuario");
		
		usu.setNomUsuario(nomUsuario);
		usu.setContraseña(password);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setEmail(email);
		usu.setDireccion(direccion);
		usu.setLocalidad(localidad);
		usu.setTipoUsuario(tipoUsuario);
		
		try {
			du.add(usu);
			LinkedList<Usuario> usuarios = du.getAll();
			
			request.setAttribute("listaUsuarios", usuarios);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/UsuarioManagement.jsp").forward(request, response);
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
