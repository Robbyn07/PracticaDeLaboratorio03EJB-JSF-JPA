package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String contrasena;
    private char rol;
    private char estado;
	
    public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<FacturaCabecera> facturasCab= new ArrayList<FacturaCabecera>();
    
    public Persona(int id, String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String contrasena, char rol) {
    	this.setId(id);
    	this.setNombre(nombre);
    	this.setApellido(apellido);
    	this.setCedula(cedula);
    	this.setDireccion(direccion);
    	this.setTelefono(telefono);
    	this.setCorreo(correo);
    	this.setContrasena(contrasena);
    	this.setRol(rol);
    }
    
	public Persona() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	public List<FacturaCabecera> getFacturasCab() {
		return facturasCab;
	}

	public void setFacturasCab(List<FacturaCabecera> facturasCab) {
		this.facturasCab = facturasCab;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		    return true;
		if (obj == null)
		    return false;
		if (getClass() != obj.getClass())
		    return false;
		Persona other = (Persona) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
