package entities;

public class Local {
	private int codLocal;
	private String descLocal;
	private String direccionLocal;
	
	
	public int getCodLocal() {
		return codLocal;
	}
	public void setCodLocal(int codLocal) {
		this.codLocal = codLocal;
	}
	public String getDescLocal() {
		return descLocal;
	}
	public void setDescLocal(String descLocal) {
		this.descLocal = descLocal;
	}
	public String getDireccionLocal() {
		return direccionLocal;
	}
	public void setDireccionLocal(String direccionLocal) {
		this.direccionLocal = direccionLocal;
	}
	
	@Override
	public String toString() {
		
		return "Local [Codigo=" + codLocal + ", Nombre=" + descLocal + ", Dirección=" + direccionLocal
				+ "]\n";
	}
	
}