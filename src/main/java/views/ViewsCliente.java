package views;

import java.util.Scanner;

import data.DataCliente;
import entities.*;

public class ViewsCliente {
	Scanner s=null;
	private DataCliente dc = new DataCliente();
	

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
			listClientes();
			break;
		case "search":
			searchCliente();
			break;
		case "new":
			newCliente();
			break;
		case "edit":
			updateCliente();
			break;
		case "delete":
			deleteCliente();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los clientes");
		System.out.println("find\t\tbuscar por nombre de usuario"); 
		System.out.println("search\t\tlistar por id"); 
		System.out.println("new\t\tcrea un nuevo cliente");
		System.out.println("edit\t\tbusca por id y actualiza datos");
		System.out.println("delete\t\tborra por id");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updateCliente() {
		Cliente updCli = new Cliente();
		System.out.print("Ingrese el ID del cliente a modificar: ");
		updCli.setIdUsuario(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(dc.getByIdUsuario(updCli));
		
		loadDataCliente(updCli);
		
		dc.update(updCli);
		
	}

	private void deleteCliente() {
		Cliente delCli = new Cliente();
		System.out.println("Clientes actuales:");
		dc.getAll();
		System.out.print("Ingrese el ID del Cliente a eliminar: ");
		delCli.setIdUsuario(Integer.parseInt(s.nextLine()));
		dc.remove(delCli);
	}

	private void newCliente() {
		Cliente newCli= new Cliente();
		
		System.out.println("Ingrese los datos del cliente:");
		
		loadDataCliente(newCli);
		
		dc.add(newCli);
		
		System.out.println("El ID del Cliente es: " + newCli.getIdUsuario());
		
	}

	private void loadDataCliente(Cliente cli) {
		System.out.print("Nombre de usuario: ");
		cli.setNomUsuario(s.nextLine());
		
		System.out.print("Contraseña: ");
		cli.setContraseña(s.nextLine());
		
		System.out.print("Nombre: ");
		cli.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		cli.setApellido(s.nextLine());
		
		System.out.print("Email: ");
		cli.setEmail(s.nextLine());
		
		System.out.print("Localidad: ");
		cli.setLocalidad(s.nextLine());
		
		System.out.print("Direccion: ");
		cli.setDireccion(s.nextLine());
		
		System.out.print("Informacion de pago: ");
		cli.setInformacionPago(s.nextLine());
		
		System.out.print("Codigo postal: ");
		cli.setCodigoPostal(Integer.parseInt(s.nextLine()));
		
	}
	
	private void listClientes() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(dc.getAll());
	}
	
	private void searchCliente() {
		Cliente c = new Cliente();
		System.out.print("Input search id: ");
		c.setIdUsuario(Integer.parseInt(s.nextLine()));
		Cliente cli=dc.getByIdUsuario(c);
		if(cli!=null) {
			System.out.println(cli);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
