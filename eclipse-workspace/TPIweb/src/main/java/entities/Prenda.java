package entities;

public class Prenda {
	private int codPrenda;
	private String nombrePrenda;
	private String talle;
	private String color;
	private String marca;
	private TipoPrenda _tipoPrenda;
	private double precioUnitario;
	public int getCodPrenda() {
		return codPrenda;
	}
	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}
	public String getNombrePrenda() {
		return nombrePrenda;
	}
	public void setNombrePrenda(String nombrePrenda) {
		this.nombrePrenda = nombrePrenda;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public TipoPrenda get_tipoPrenda() {
		return _tipoPrenda;
	}
	public void set_tipoPrenda(TipoPrenda _tipoPrenda) {
		this._tipoPrenda = _tipoPrenda;
	}
	
	@Override
	public String toString() {
		
		return "Prenda [Codigo=" + codPrenda + ", Nombre=" + nombrePrenda + ", Talle=" + talle
				+ ", Color=" + color + ", Marca=" + marca +", Precio Unitario?" + precioUnitario +"\nDatos del tipo de prenda:\n" +
				"codigo=" + _tipoPrenda.getCodTipoPrenda() + ", descripcion=" + _tipoPrenda.getDescTipoPrenda()
				+ "]\n";
	}
}