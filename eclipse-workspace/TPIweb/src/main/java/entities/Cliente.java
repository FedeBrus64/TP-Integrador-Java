package entities;

public class Cliente extends Usuario {
	private int codigoPostal;
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Override
	public String toString() {
		
		return "User [id=" + super.getIdUsuario() + ", Nombre de usuario=" + super.getNomUsuario() + ", nombre=" + super.getNombre() 
				+ ", apellido=" + super.getApellido() + ", email="+ super.getEmail() + ", localidad=" + super.getLocalidad()
				+ ", direccion=" + super.getDireccion()
				+ ", Codigo postal=" + codigoPostal
				+ "]\n";
	}

}