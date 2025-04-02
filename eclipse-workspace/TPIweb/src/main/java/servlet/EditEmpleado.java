package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataEmpleado;
import entities.Empleado;
import utils.DataAccessException;

/**
 * Servlet implementation class EditEmpleado
 */
@WebServlet({ "/EditEmpleado", "/editempleado" })
public class EditEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataEmpleado de = new DataEmpleado();
		Empleado updEmp = new Empleado();
		
		try {
			LinkedList<Empleado> empleados = de.getAll();
			request.setAttribute("listaEmpleados", empleados);
			
			updEmp.setIdUsuario(Integer.parseInt(request.getParameter("updEmp")));
			Empleado updateEmpleado = de.getByIdUsuario(updEmp);
			request.setAttribute("updateEmpleado", updateEmpleado);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/EditEmpleadoManagement.jsp").forward(request, response);
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
		Empleado emp = new Empleado();
		DataEmpleado de = new DataEmpleado();
		
		String idUsuario = request.getParameter("idUsuario");
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String fechaIngreso = request.getParameter("fechaIngreso") + "T00:00:00";
		
		
		emp.setIdUsuario(Integer.parseInt(idUsuario));
		emp.setNomUsuario(nomUsuario);
		emp.setContraseña(password);
		emp.setNombre(nombre);
		emp.setApellido(apellido);
		emp.setEmail(email);
		emp.setDireccion(direccion);
		emp.setLocalidad(localidad);
		emp.setFechaIngreso(LocalDateTime.parse(fechaIngreso));
		
		try {
			de.update(emp);
			
			LinkedList<Empleado> empleados = de.getAll();
			
			request.setAttribute("listaEmpleados", empleados);
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("WEB-INF/EmpleadoManagement.jsp").forward(request, response);
			
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
