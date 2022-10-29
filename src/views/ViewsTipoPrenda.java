package views;

import java.util.Scanner;

import data.DataTipoPrenda;
import entities.*;

public class ViewsTipoPrenda {
	Scanner s=null;
	private DataTipoPrenda dtp = new DataTipoPrenda();
	

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
			listTipoPrenda();
			break;
		case "search":
			searchTipoPrenda();
			break;
		case "new":
			newTipoPrenda();
			break;
		case "edit":
			updateTipoPrenda();
			break;
		case "delete":
			deleteTipoPrenda();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los tipos de prenda");
		System.out.println("search\t\tbuscar por codigo de tipo de prenda"); 
		System.out.println("new\t\tcrea un nuevo tipo de prenda");
		System.out.println("edit\t\tbusca por codigo de tipo de prenda y actualiza todos los datos");
		System.out.println("delete\t\tborra por codigo de tipo de prenda");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updateTipoPrenda() {
		TipoPrenda updTp = new TipoPrenda();
		System.out.print("Ingrese el ID del tipo de prenda a modificar: ");
		updTp.setCodTipoPrenda(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(dtp.getById(updTp));
		
		loadDataTipoPrenda(updTp);
		
		dtp.update(updTp);
		
	}

	private void deleteTipoPrenda() {
		TipoPrenda delTp = new TipoPrenda();
		System.out.println("Tipos de prenda actuales:");
		dtp.getAll();
		System.out.print("Ingrese el ID del tipo de prenda a eliminar: ");
		delTp.setCodTipoPrenda(Integer.parseInt(s.nextLine()));
		dtp.remove(delTp);
	}

	private void newTipoPrenda() {
		TipoPrenda newTp= new TipoPrenda();
		
		System.out.println("Ingrese los datos del tipo de prenda:");
		
		loadDataTipoPrenda(newTp);
		
		dtp.add(newTp);
		
		System.out.println("El ID del tipo de prenda es: " + newTp.getCodTipoPrenda());
		
	}

	private void loadDataTipoPrenda(TipoPrenda tp) {
		System.out.print("Descripcion del tipo de prenda: ");
		tp.setDescTipoPrenda(s.nextLine());
		
	}
	
	private void listTipoPrenda() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(dtp.getAll());
	}
	
	private void searchTipoPrenda() {
		TipoPrenda tp = new TipoPrenda();
		System.out.print("Input search id: ");
		tp.setCodTipoPrenda(Integer.parseInt(s.nextLine()));
		TipoPrenda tipp=dtp.getById(tp);
		if(tipp!=null) {
			System.out.println(tipp);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
