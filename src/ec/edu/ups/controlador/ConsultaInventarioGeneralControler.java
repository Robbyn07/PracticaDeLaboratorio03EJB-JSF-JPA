package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.ejb.CategoriaFacade;
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
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	private List<Producto> listProducto;
	private List<Categoria> listCategoria;
	private Categoria categoria;
	private Producto producto;
	
	
	@PostConstruct
	public void cargarLista() {
		listProducto = new ArrayList<Producto>();
		listCategoria = new ArrayList<Categoria>();
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


