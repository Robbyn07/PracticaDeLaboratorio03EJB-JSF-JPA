package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class InicioAdministradorControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String agregarCliente() {
		return "agregarc";
	}
	
	public String editarCliente() {
		return "editarc";
	}
	
	public String eliminarCliente() {
		return "eliminarc";
	}
	
	public String generarFactura() {
		return "generarf";
	}
	
	public String anularFactura() {
		return "anularf";
	}
	
	public String buscarFactura() {
		return "buscarf";
	}
	
	public String salir() {
		return "salir";
	}
	
}
