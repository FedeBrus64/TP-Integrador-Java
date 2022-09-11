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
}
