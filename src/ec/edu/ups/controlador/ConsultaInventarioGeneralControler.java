package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.ejb.ProductoFacade;

import java.util.ArrayList;
import java.util.List;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped

public class ConsultaInventarioGeneralControler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	private List<Producto> listProducto;
	
	
	@PostConstruct
	public void cargarLista() {
		listProducto = new ArrayList<Producto>();
		listProducto = ejbProductoFacade.productosOrdenadosAlfabeticamente();
	}
	
	
    public String salir() {
    	return "inicioa";
    }


	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}


	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}


	public List<Producto> getListProducto() {
		return listProducto;
	}


	public void setListProducto(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

    
}


