package views;

import java.util.Scanner;

import data.DataPrenda;
import data.DataTipoPrenda;
import entities.*;

public class ViewsPrenda {
	Scanner s=null;
	private DataPrenda dp = new DataPrenda();
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
			listPrendas();
			break;
		case "search":
			searchPrenda();
			break;
		case "new":
			newPrenda();
			break;
		case "edit":
			updatePrenda();
			break;
		case "delete":
			deletePrenda();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todas las prendas");
		System.out.println("search\t\tbuscar por codigo de prenda"); 
		System.out.println("new\t\tcrea una nueva prenda");
		System.out.println("edit\t\tbusca por codigo de prenda y actualiza todos los datos");
		System.out.println("delete\t\tborra por codigo de prenda");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updatePrenda() {
		Prenda updPre = new Prenda();
		System.out.print("Ingrese el ID de la prenda a modificar: ");
		updPre.setCodPrenda(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(dp.getByCodPrenda(updPre));
		
		loadDataPrenda(updPre);
		
		dp.update(updPre);
		
	}

	private void deletePrenda() {
		Prenda delPre = new Prenda();
		System.out.println("Prendas actuales:");
		dp.getAll();
		System.out.print("Ingrese el ID de la prenda a eliminar: ");
		delPre.setCodPrenda(Integer.parseInt(s.nextLine()));
		dp.remove(delPre);
	}

	private void newPrenda() {
		Prenda newPre= new Prenda();
		
		System.out.println("Ingrese los datos de la prenda:");
		
		loadDataPrenda(newPre);
		
		dp.add(newPre);
		
		System.out.println("El ID de la prenda es: " + newPre.getCodPrenda());
		
	}

	private void loadDataPrenda(Prenda pre) {
		System.out.print("Nombre de la prenda: ");
		pre.setNombrePrenda(s.nextLine());
		
		System.out.print("Talle: ");
		pre.setTalle(s.nextLine());
		
		System.out.print("Color: ");
		pre.setColor(s.nextLine());
		
		System.out.print("Marca: ");
		pre.setMarca(s.nextLine());
		
		System.out.println(dtp.getAll());
		System.out.println("Ingrese el codigo del tipo de prenda: ");
		TipoPrenda tp = new TipoPrenda();
		tp.setCodTipoPrenda(Integer.parseInt(s.nextLine()));
		TipoPrenda tpre=dtp.getById(tp);
		
		pre.set_tipoPrenda(tpre);
		

		
	}
	private void listPrendas() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(dp.getAll());
	}
	
	private void searchPrenda() {
		Prenda p = new Prenda();
		System.out.print("Input search id: ");
		p.setCodPrenda(Integer.parseInt(s.nextLine()));
		Prenda pre=dp.getByCodPrenda(p);
		if(pre!=null) {
			System.out.println(pre);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
