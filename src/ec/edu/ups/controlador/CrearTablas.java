package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.ProvinciaFacade;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Provincia;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CrearTablas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	@EJB
	private PersonaFacade ejbPersonaFacade;
	
	@EJB
	private ProvinciaFacade ejbProvinciaFacade;
	
	@EJB
	private CiudadFacade ejbCiudadFacade;
	
	public void agregarDatos() {
		System.out.println("jeeeelp");
		ejbCategoriaFacade.create(new Categoria(0,"Despensa"));
		ejbCategoriaFacade.create(new Categoria(0,"Aseo Hogar"));
		ejbCategoriaFacade.create(new Categoria(0,"Vinos y Licores"));
		ejbCategoriaFacade.create(new Categoria(0,"Cuidado Personal"));
		ejbCategoriaFacade.create(new Categoria(0,"Menajes del Hogar"));
		ejbCategoriaFacade.create(new Categoria(0,"Electrodomesticos"));
		ejbCategoriaFacade.create(new Categoria(0,"Herramientas"));
		ejbCategoriaFacade.create(new Categoria(0,"Reposteria"));
	
		ejbPersonaFacade.create(new Persona(0, "Pablo", "Loja", "0107137408", "Cuenca", "0998476387", "plojam@est.ups.edu.ec", "ploja",'E','H'));
		ejbPersonaFacade.create(new Persona(0, "John", "Macao", "01", "Cuenca", "0989449535", "jmacaog@est.ups.edu.ec", "jmacao", 'A' ,'H'));
		ejbPersonaFacade.create(new Persona(0, "Robbyn", "Reyes", "1900848886", "Zamora", "0969784090", "rreyesd@est.ups.edu.ec", "rreyes", 'C', 'H'));
		
		Provincia prov1 = new Provincia(0, "Azuay");
		Provincia prov2 = new Provincia(0, "Zamora Chinchipe");
		Provincia prov3 = new Provincia(0, "Loja");
		
		ejbProvinciaFacade.create(prov1);
		ejbProvinciaFacade.create(prov2);
		ejbProvinciaFacade.create(prov3);
		
		ejbCiudadFacade.create(new Ciudad(0, "Cuenca", prov1));
		ejbCiudadFacade.create(new Ciudad(0, "Zamora", prov2));
		ejbCiudadFacade.create(new Ciudad(0, "Loja", prov3));
	}
	
	public CategoriaFacade getEjbCategoriaFacade() {
		return ejbCategoriaFacade;
	}

	public void setEjbCategoriaFacade(CategoriaFacade ejbCategoriaFacade) {
		this.ejbCategoriaFacade = ejbCategoriaFacade;
	}
}
