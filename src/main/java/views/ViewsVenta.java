package views;

import java.time.*;
import java.time.format.DateTimeFormatter;
/*import java.time.temporal.TemporalAccessor;*/
import java.util.Scanner;

/*import com.mysql.cj.result.LocalDateTimeValueFactory;*/


import data.DataVenta;
import data.DataCliente;
import data.DataPrenda;
import entities.*;

public class ViewsVenta {
	final private String dateFormat="dd/MM/yyyy";
	final private String timeFormat="HH:mm:ss";
	final private String dateTimeFormat=dateFormat+" "+timeFormat;
	Scanner s=null;
	private DataVenta dv = new DataVenta();
	private DataCliente dc = new DataCliente();
	private DataPrenda dp = new DataPrenda();
	

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
			listVentas();
			break;
		case "search":
			searchVenta();
			break;
		case "new":
			newVenta();
			break;
		case "edit":
			updateVenta();
			break;
		case "delete":
			deleteVenta();
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todas las ventas");
		System.out.println("search\t\tbuscar por numero de venta"); 
		System.out.println("new\t\tregistrar una venta");
		System.out.println("edit\t\tbusca por numero de venta y actualiza todos los datos");
		System.out.println("delete\t\tborra por numero de venta");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void updateVenta() {
		Venta updVen = new Venta();
		System.out.print("Ingrese el numero de la venta a modificar: ");
		updVen.setNroVenta(Integer.parseInt(s.nextLine()));
		
		System.out.println("Current data: ");
		System.out.println(dv.getByNroVenta(updVen));
		
		loadDataVenta(updVen);
		
		dv.update(updVen);
		
	}

	private void deleteVenta() {
		Venta delVen = new Venta();
		System.out.println("Ventas actuales:");
		dv.getAll();
		System.out.print("Ingrese el numero de la venta a eliminar: ");
		delVen.setNroVenta(Integer.parseInt(s.nextLine()));
		dv.remove(delVen);
	}

	private void newVenta() {
		Venta newVen= new Venta();
		
		System.out.println("Ingrese los datos de la venta:");
		
		loadDataVenta(newVen);
		
		dv.add(newVen);
		
		System.out.println("El numero de la venta es: " + newVen.getNroVenta());
		
	}

	private void loadDataVenta(Venta ven) {
		
		System.out.print("Fecha de la venta: ");
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		ven.setFechaVenta(LocalDateTime.parse(s.nextLine(),dtFormat));;
		
		System.out.print("Importe total: ");
		ven.setImporteTotal(Double.parseDouble(s.nextLine()));
		
		System.out.println(dc.getAll());
		System.out.println("Ingrese el codigo del cliente: ");
		Cliente c = new Cliente();
		c.setIdUsuario(Integer.parseInt(s.nextLine()));
		Cliente cli=dc.getByIdUsuario(c);
		
		ven.set_cliente(cli);
		
		System.out.println(dp.getAll());
		System.out.println("Ingrese el codigo de la prenda: ");
		Prenda p = new Prenda();
		p.setCodPrenda(Integer.parseInt(s.nextLine()));
		Prenda pre=dp.getByCodPrenda(p);
		
		ven.set_prenda(pre);
		
		
	}
	
	private void listVentas() {
//		for(Product p: db.list()) {
//			System.out.println(p);
//		}
		System.out.println(dv.getAll());
	}
	
	private void searchVenta() {
		Venta v = new Venta();
		System.out.print("Input search id: ");
		v.setNroVenta(Integer.parseInt(s.nextLine()));
		Venta ven=dv.getByNroVenta(v);
		if(ven!=null) {
			System.out.println(ven);
		}else {
			System.out.println("404 - Not found");
		}
	}
}
