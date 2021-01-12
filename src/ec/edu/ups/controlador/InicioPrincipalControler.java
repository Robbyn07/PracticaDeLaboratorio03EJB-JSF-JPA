package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class InicioPrincipalControler implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	
	public static List<Producto> productos = new ArrayList<Producto>();
	private List<String> opciones = new ArrayList<String>();
	private String opcion = "";
	
	@PostConstruct
	public void constructor() {
		opciones = new ArrayList<String>();
		opciones.add("General");
		opciones.add("Bodega Cuencanito");
		opciones.add("Bodega Zamborondeno");
		opciones.add("Categoria");
	}
	
	
	public String redirigir(String pagina) {
		return pagina;
	}
	
	public void eleccion() {
		switch(opcion) {
		case "General":
			this.productosGeneral();
			break;
		case "Bodega Cuencanito":
			this.productosBodega("Bodega Cuencanito");
			break;
		case "Bodega Zamborondeno":
			this.productosBodega("Bodega Zamborondeno");
			break;
		case "Categoria":
			this.productosCategoria();
			break;
		}
	}
	
	
	public void productosGeneral() {
		productos = new ArrayList<Producto>();
		productos = ejbProductoFacade.buscarProductosGeneral();
	}
	
	public void productosCategoria() {
		productos = new ArrayList<Producto>();
		List<Categoria> categorias = ejbCategoriaFacade.findAll();
		for(int i=0; i<categorias.size(); i++) {
			for(int j=0; j<categorias.get(i).getProductos().size(); j++) {
				productos.add(categorias.get(i).getProductos().get(j));
			}
		}
		productos = ejbProductoFacade.buscarProductoPorCategoriaGeneral();
	}
	
	public void productosBodega(String bodegaNombre) {
		productos = new ArrayList<Producto>();
		Bodega bodegas = ejbBodegaFacade.buscarBodega(bodegaNombre);
		for(int i=0; i<bodegas.getProductos().size(); i++) {
			productos.add(bodegas.getProductos().get(i));
		}
	}
	
	
	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		InicioPrincipalControler.productos = productos;
	}


	public List<String> getOpciones() {
		return opciones;
	}


	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}


	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	
	
}
