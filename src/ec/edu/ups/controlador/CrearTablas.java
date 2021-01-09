package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.modelo.Categoria;

@Named
@SessionScoped
public class CrearTablas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	public CrearTablas() {
	}
	
	public void agregarDatos() {
		ejbCategoriaFacade.create(new Categoria(0,"Primera"));
		ejbCategoriaFacade.create(new Categoria(0,"Segunda"));
	}
}
