package entities;

public class Cliente extends Usuario {
	private String informacionPago;
	private int codigoPostal;
	public String getInformacionPago() {
		return informacionPago;
	}
	public void setInformacionPago(String informacionPago) {
		this.informacionPago = informacionPago;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	

}