package views;

import java.time.*;
import java.time.format.DateTimeFormatter;
/*import java.time.temporal.TemporalAccessor;*/
import java.util.Scanner;

/*import com.mysql.cj.result.LocalDateTimeValueFactory;*/

import data.DataEmpleado;
import entities.*;

public class ViewsEmpleado {
	final private String dateFormat="dd/MM/yyyy";
	final private String timeFormat="HH:mm:ss";
	final private String dateTimeFormat=dateFormat+" "+timeFormat;
	Scanner s=null;
	private DataEmpleado de = new DataEmpleado();
	

	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			listEmpleados();
			break;
		case "search":
			searchEmpleado();
			break;
		case "new":
			newEmpleado();
			break;
		case "edit":
			updateEmpleado();
			break;
		case "delete":
			deleteEmpleado();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los empleados");
		System.out.println("find\t\tbuscar por nombre de usuario");
		System.out.println("search\t\tlistar por id"); 
		System.out.println("new\t\tcrea un nuevo empleado");
		System.out.println("edit\t\tbusca por id y actualiza datos");
		System.out.println("delete\t\tborra por id");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updateEmpleado() {
		Empleado updEmp = new Empleado();
		System.out.print("Ingrese el ID del empleado a modificar: ");
		updEmp.setIdUsuario(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(de.getByIdUsuario(updEmp));
		
		loadDataEmpleado(updEmp);
		
		de.update(updEmp);
		
	}

	private void deleteEmpleado() {
		Empleado delEmp = new Empleado();
		System.out.println("Empleados actuales:");
		de.getAll();
		System.out.print("Ingrese el ID del Empleado a eliminar: ");
		delEmp.setIdUsuario(Integer.parseInt(s.nextLine()));
		de.remove(delEmp);
	}

	private void newEmpleado() {
		Empleado newEmp= new Empleado();
		
		System.out.println("Ingrese los datos del empleado:");
		
		loadDataEmpleado(newEmp);
		
		de.add(newEmp);
		
		System.out.println("El ID del Empleado es: " + newEmp.getIdUsuario());
		
	}

	private void loadDataEmpleado(Empleado emp) {
		System.out.print("Nombre de usuario: ");
		emp.setNomUsuario(s.nextLine());
		
		System.out.print("Contraseña: ");
		emp.setContraseña(s.nextLine());
		
		System.out.print("Nombre: ");
		emp.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		emp.setApellido(s.nextLine());
		
		System.out.print("Email: ");
		emp.setEmail(s.nextLine());
		
		System.out.print("Localidad: ");
		emp.setLocalidad(s.nextLine());
		
		System.out.print("Direccion: ");
		emp.setDireccion(s.nextLine());
		
		System.out.print("Fecha de ingreso: ");
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		emp.setFechaIngreso(LocalDateTime.parse(s.nextLine(),dtFormat));;
		
	}
	
	private void listEmpleados() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(de.getAll());
	}
	
	private void searchEmpleado() {
		Empleado em = new Empleado();
		System.out.print("Input search id: ");
		em.setIdUsuario(Integer.parseInt(s.nextLine()));
		Empleado emp=de.getByIdUsuario(em);
		if(emp!=null) {
			System.out.println(emp);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
