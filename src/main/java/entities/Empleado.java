package entities;

import java.time.LocalDateTime;

public class Empleado extends Usuario {
	private LocalDateTime fechaIngreso;

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Override
	public String toString() {
		
		return "User [id=" + super.getIdUsuario() + ", Nombre de usuario=" + super.getNomUsuario() + ", nombre=" + super.getNombre() 
				+ ", apellido=" + super.getApellido() + ", email="+ super.getEmail() + ", localidad=" + super.getLocalidad()
				+ ", direccion=" + super.getDireccion() + ", fecha de ingreso=" + fechaIngreso
				+ "]\n";
	}
}
