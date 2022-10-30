package views;

import java.util.Scanner;

import data.DataUsuario;
import entities.Usuario;

public class ViewsUsuario {
	Scanner s=null;
	private DataUsuario du = new DataUsuario();

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
			listUsuarios();
			break;
		case "search":
			searchUsuario();
			break;
		case "new":
			newUsuario();
			break;
		case "edit":
			updateUsuario();
			break;
		case "delete":
			deleteUsuario();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los usuarios");
		System.out.println("search\t\tbuscar por id"); 
		System.out.println("new\t\tcrea un nuevo Usuario");
		System.out.println("edit\t\tbusca por id y actualiza todos los datos");
		System.out.println("delete\t\tborra por id");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updateUsuario() {
		Usuario updUsu = new Usuario();
		System.out.print("Ingrese el ID del usuario a modificar: ");
		updUsu.setIdUsuario(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(du.getByIdUsuario(updUsu));
		
		loadDataUsuario(updUsu);
		
		du.update(updUsu);
		
	}

	private void deleteUsuario() {
		Usuario delUsu = new Usuario();
		System.out.println("Usuarios actuales:");
		du.getAll();
		System.out.print("Ingrese el ID del Usuario a eliminar: ");
		delUsu.setIdUsuario(Integer.parseInt(s.nextLine()));
		du.remove(delUsu);
	}

	private void newUsuario() {
		Usuario newUsu= new Usuario();
		
		System.out.println("Ingrese los datos del usuario:");
		
		loadDataUsuario(newUsu);
		
		du.add(newUsu);
		
		System.out.println("El ID del Usuario es: " + newUsu.getIdUsuario());
		
	}

	private void loadDataUsuario(Usuario usu) {
		System.out.print("Nombre de usuario: ");
		usu.setNomUsuario(s.nextLine());
		
		System.out.print("Contraseña: ");
		usu.setContraseña(s.nextLine());
		
		System.out.print("Nombre: ");
		usu.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		usu.setApellido(s.nextLine());
		
		System.out.print("Email: ");
		usu.setEmail(s.nextLine());
		
		System.out.print("Localidad: ");
		usu.setLocalidad(s.nextLine());
		
		System.out.print("Direccion: ");
		usu.setDireccion(s.nextLine());
		
	}
	
	private void listUsuarios() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(du.getAll());
	}
	
	private void searchUsuario() {
		Usuario u = new Usuario();
		System.out.print("Input search id: ");
		u.setIdUsuario(Integer.parseInt(s.nextLine()));
		Usuario usu=du.getByIdUsuario(u);
		if(usu!=null) {
			System.out.println(usu);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
