package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.*;
import entities.*;
import utils.DataAccessException;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/signin" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("usuario") != null) {
			
			DataUsuario duaux = new DataUsuario();
			Usuario usu = (Usuario)session.getAttribute("usuario");
			
			try {
				Usuario usuaux = duaux.getByIdUsuario(usu);
				
				if(usuaux != null) {
					if ("cliente".equals(usuaux.getTipoUsuario())){
						request.getRequestDispatcher("WEB-INF/MenuUsuario.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("WEB-INF/Menu.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("error", "Ocurrió un error. Por favor, vuelva a iniciar sesión.");
					request.getRequestDispatcher("error.html").forward(request, response);
				}
				
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Usuario usu = new Usuario();
		DataUsuario du = new DataUsuario();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		usu.setEmail(email);
		usu.setContraseña(password);
		
		try {
			Usuario usuarioSearch = du.getByEmail(usu);
			if (usuarioSearch == null) {
		        response.sendRedirect("index.html?error=El usuario no existe.");
		    } else {
		        if (!usuarioSearch.getContraseña().equals(password)) {
		        	request.setCharacterEncoding("UTF-8");
		            response.sendRedirect("index.html?error=Contraseña incorrecta.");
		        } else {
		            HttpSession session = request.getSession();
		            session.setAttribute("usuario", usuarioSearch);

		            if ("empleado".equals(usuarioSearch.getTipoUsuario())) {
		                request.getRequestDispatcher("WEB-INF/Menu.jsp").forward(request, response);
		            } else {
		                request.getRequestDispatcher("WEB-INF/MenuUsuario.jsp").forward(request, response);
		            }
		        }
			}
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
