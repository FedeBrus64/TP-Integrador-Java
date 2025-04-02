package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;
import entities.*;
import utils.DataAccessException;

/**
 * Servlet implementation class EditUsuario
 */
@WebServlet({ "/EditUsuario", "/editusuario" })
public class EditUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataUsuario du = new DataUsuario();
		Usuario updUsu = new Usuario();
		
		try {
			LinkedList<Usuario> usuarios = du.getAll();
			request.setAttribute("listaUsuarios", usuarios);
			
			updUsu.setIdUsuario(Integer.parseInt(request.getParameter("updUsu")));
			Usuario updateUsuario = du.getByIdUsuario(updUsu);
			request.setAttribute("updateUsuario", updateUsuario);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/EditUsuarioManagement.jsp").forward(request, response);
			
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
		
		String idUsuario = request.getParameter("idUsuario");
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String tipoUsuario = request.getParameter("tipoUsuario");
		
		usu.setIdUsuario(Integer.parseInt(idUsuario));
		usu.setNomUsuario(nomUsuario);
		usu.setContraseña(password);
		usu.setNombre(nombre);
		usu.setApellido(apellido);
		usu.setEmail(email);
		usu.setDireccion(direccion);
		usu.setLocalidad(localidad);
		usu.setTipoUsuario(tipoUsuario);
		
		try {
			du.update(usu);
			
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

}
