package entities;

import java.time.LocalDateTime;

public class Venta {
	private int nroVenta;
	private LocalDateTime fechaVenta;
	private double importeTotal;
	private Cliente _cliente;
	private Prenda _prenda;
	public int getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public Cliente get_cliente() {
		return _cliente;
	}
	public void set_cliente(Cliente _cliente) {
		this._cliente = _cliente;
	}
	public Prenda get_prenda() {
		return _prenda;
	}
	public void set_prenda(Prenda _prenda) {
		this._prenda = _prenda;
	}
	
	@Override
	public String toString() {
		
		return "Venta [Numero=" + nroVenta + ", Fecha=" + fechaVenta + ", Importe total=" + importeTotal 
				+"\nDatos del cliente:\n" + "nombre de usuario: " + _cliente.getNomUsuario() + ", nombre: "
				+ _cliente.getNombre() + ", apellido: " + _cliente.getApellido() + ", informacion de pago: " + _cliente.getInformacionPago()
				+"\nDatos de la prenda:\n" + "nombre de la prenda: " + _prenda.getNombrePrenda() 
				+ ", color: " + _prenda.getColor() + ", marca: " + _prenda.getMarca()
				+ ", talle: " + _prenda.getTalle()
				+ "]\n";
	}
	
}
