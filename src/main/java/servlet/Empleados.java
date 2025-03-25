package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.time.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import data.*;
import utils.DataAccessException;

/**
 * Servlet implementation class Empleados
 */
@WebServlet({ "/Empleados", "/empleados" })
public class Empleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataEmpleado de = new DataEmpleado();
		
		if(request.getParameter("delEmp") != null) {
			Empleado delEmp = new Empleado();
			delEmp.setIdUsuario(Integer.parseInt(request.getParameter("delEmp")));
			try {
				Empleado deletedEmpleado = de.getByIdUsuario(delEmp);
				de.remove(deletedEmpleado);
			} catch (DataAccessException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("error.html").forward(request, response);
			}
			
		}
		
		try {
			LinkedList<Empleado> empleados = de.getAll();
			request.setAttribute("listaEmpleados", empleados);
			
			request.getRequestDispatcher("WEB-INF/EmpleadoManagement.jsp").forward(request, response);
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
		
		
		Empleado emp = new Empleado();
		DataEmpleado de = new DataEmpleado();
		
		String nomUsuario = request.getParameter("nomUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String password = request.getParameter("password");
		String fechaIngreso = request.getParameter("fechaIngreso") + "T00:00:00";
		
		
		emp.setNomUsuario(nomUsuario);
		emp.setContraseña(password);
		emp.setNombre(nombre);
		emp.setApellido(apellido);
		emp.setEmail(email);
		emp.setDireccion(direccion);
		emp.setLocalidad(localidad);
		emp.setFechaIngreso(LocalDateTime.parse(fechaIngreso));
		emp.setTipoUsuario("empleado");
		
		try {
			de.add(emp);
			
			LinkedList<Empleado> empleados = de.getAll();
			
			request.setAttribute("listaEmpleados", empleados);
			
			request.getRequestDispatcher("WEB-INF/EmpleadoManagement.jsp").forward(request, response);
			
		} catch (DataAccessException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

}
