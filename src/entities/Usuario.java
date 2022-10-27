package entities;

import java.util.HashMap;

public class Usuario {
	private int idUsuario;
	private String nomUsuario;
	private String contraseña;
	private String nombre;
	private String apellido;
	private String email;
	private String localidad;
	private String direccion;
	private HashMap<Integer, Rol> roles;
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Usuario() {
		this.roles=new HashMap<>();
	}
	
	public void addRol(Rol rolToBeAdded) {
		this.roles.put(rolToBeAdded.getIdRol(), rolToBeAdded);
	}
	
	public void removeRol(Rol rolToBeRemoved) {
		this.roles.remove(rolToBeRemoved.getIdRol());
	}
	
	public boolean hasRol(Rol rolToCheck) {
		return this.roles.containsKey(rolToCheck.getIdRol());
	}
	
	@Override
	public String toString() {
		
		return "Product [id=" + idUsuario + ", Nombre de usuario=" + nomUsuario + ", nombre=" + nombre 
				+ ", apellido=" + apellido + ", email="+ email + ", localidad=" + localidad
				+ ", direccion=" + direccion
				+ "]\n";
	}

}


