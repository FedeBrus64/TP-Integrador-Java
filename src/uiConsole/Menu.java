package uiConsole;

import java.util.Scanner;
import data.*;

import entities.*;
import views.*;

public class Menu {
	Scanner s=null;
	private ViewsCliente vc = new ViewsCliente();
	private	ViewsEmpleado ve = new ViewsEmpleado();
	private ViewsPrenda vp = new ViewsPrenda();
	private	ViewsTipoPrenda vtp = new ViewsTipoPrenda();
	private	ViewsUsuario vu = new ViewsUsuario();
	private ViewsVenta vv = new ViewsVenta();
	

	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "cliente":
			vc.start();
			break;
		case "empleado":
			ve.start();
			break;
		case "prenda":
			vp.start();
			break;
		case "tipoprenda":
			vtp.start();
			break;
		case "usuario":
			vu.start();
			break;
		case "venta":
			vv.start();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("cliente\t\tmenu de clientes");
		System.out.println("empleado\t\tmenu de empleados"); //solo debe devolver 1
		System.out.println("prenda\t\tmenu de prendas"); //puede devolver varios
		System.out.println("tipoprenda\t\tmenu de tipos de prenda");
		System.out.println("usuario\t\tmenu de usuarios");
		System.out.println("venta\t\tmenu de ventas");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
}