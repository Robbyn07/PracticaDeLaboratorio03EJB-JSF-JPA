package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class GestionProductoPorBodegaControler implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	
	private List<Producto> productos = new ArrayList<Producto>();
	private List<String> opciones = new ArrayList<String>();
	
//	private List<Categoria> Categorias = new ArrayList<Categoria>();
	private List<String> opcionesCategorias = new ArrayList<String>();
	
	private List<String> opcionesBodegas = new ArrayList<String>();
	
//	private List<String> test = new ArrayList<String>();
	
	public static String opcion = "";
	private String opcionCategoria = "";
	
	private Producto producto = null;
	
	private String nombreA="";
	private String precioA="";
	private String stockA="";
	
	private Bodega bode = null;
	
//	private Categoria cat0 = null;
	
	@PostConstruct
	public void constructor() {
		
		//productos = new ArrayList<Producto>();
		
		nombreA="";
		precioA="";
		stockA="";
		
		char estado = 72;
		
		opciones = new ArrayList<String>();
		for(int i=0; i<ejbBodegaFacade.findAll().size(); i++) {
			opciones.add(ejbBodegaFacade.findAll().get(i).getNombre());
		
		}
		
		
		
		
		//productos = productosBodega("Bodega ");
		
		//opciones.add("General");
		
		//opciones.add("Bodega Cuencanito");
		//opciones.add("Bodega Zamborondeno");
		
		//opciones.add("Categoria");
		
		
		
		//System.out.println("count de list categoria : " + opcionesCategorias.size());
		
		/*
		if(opcionesCategorias.size() == 0 ) {
			for(int i=0; i<ejbCategoriaFacade.findAll().size(); i++) {
				opcionesCategorias.add(ejbCategoriaFacade.findAll().get(i).getNombre());
			}
		}else {
			System.out.println("count de list categoria : " + opcionesCategorias.size());
		}
		*/
		
		
		
		//productos = new ArrayList<Producto>();
		//productos = ejbProductoFacade.findAll();
		
		System.out.println("verrr : " + opcion);
		System.out.println("TAMAÑO LISTA PRODUCTOS : " + productos.size());

		/*
		for(int i=0; i<ejbBodegaFacade.findAll().size(); i++) {
			opcionesBodegas.add(ejbBodegaFacade.findAll().get(i).getNombre());
		}
		*/
		
		
		if(opcion == "") {
			
				productos = new ArrayList<Producto>();
				Bodega bodegas = ejbBodegaFacade.buscarBodega("Bodega Cuencanito");
				for(int i=0; i<bodegas.getProductos().size(); i++) {
					if (bodegas.getProductos().get(i).getEstado() == estado) {
						productos.add(bodegas.getProductos().get(i));
					}
				}
				
			
			
			
		}else {
				//System.out.println("opcion elejida : " + opcion);
				productos = new ArrayList<Producto>();
				Bodega bodegas = ejbBodegaFacade.buscarBodega(opcion);
				for(int i=0; i<bodegas.getProductos().size(); i++) {
					if (bodegas.getProductos().get(i).getEstado() == estado) {
						productos.add(bodegas.getProductos().get(i));
					}
					
				}
				
		}
		
		
	}
	
	
	public void eleccion() {
		System.out.println("ver opcion elejida  : " + opcion);
		//this.productosBodega(opcion);
		
		/*
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
		*/
	}
	
	
	/*
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
	*/
	
	
	
	public void productosBodega() {
		
		/*
		
		System.out.println("ver opcion elejida  : " + opcion);
		productos = new ArrayList<Producto>();
		Bodega bodegas = ejbBodegaFacade.buscarBodega(opcion);
		for(int i=0; i<bodegas.getProductos().size(); i++) {
			productos.add(bodegas.getProductos().get(i));
		}
		*/
		
		
		constructor();
	}

	
	
	public void Eliminar(Producto pro) {
		try {
			producto = pro;
			producto.setEstado('E');
			ejbProductoFacade.edit(producto);
			constructor();
		} catch (Exception e) {
			System.out.println("error en eliminar producto");
			constructor();
		}	
			
		
	}
	
	public void Editar(Producto pro2) {
		
		System.out.println("llega 1");
		
		try {
			System.out.println("llega a NOMBRE : " + pro2.getNombre());
			System.out.println("llega a PRECIO : " + pro2.getPrecio());
			System.out.println("llega a STOCK  : " + pro2.getStock());
			ejbProductoFacade.edit(pro2);
			constructor();
			
		} catch (Exception e) {
			System.out.println("error en editar producto");
			constructor();
		}
	}
	
	
	public String agregar() {
		
		System.out.println("NOMBRE : " + nombreA);
		System.out.println("PRECIO : " + precioA);
		System.out.println("STOCK  : " + stockA);
		
		Producto comprobar = null;
		try {
			comprobar = ejbProductoFacade.buscarProductoPorNombreUnico(nombreA);
			if(comprobar == null) {
				
				System.out.println("VER CATEGORIA ELEGIDA : " + opcionCategoria);
				
				Categoria cat = ejbCategoriaFacade.obtenerCategoria(opcionCategoria);
				System.out.println("NOMBRE CATEGORIA  : " + cat.getNombre());
				int stockP  = Integer.parseInt(stockA);   
				float precioP = Float.parseFloat( precioA);  
				
				Producto pro = new Producto(0, nombreA, precioP, stockP, 'H', cat);
				ejbProductoFacade.create(pro);
				
				//Bodega bode = new Bodega();
				bode = ejbBodegaFacade.buscarBodega(opcion);
				bode.addProductos(pro);
				
				ejbBodegaFacade.edit(bode);
				
			}
			return "gestionp";
			
		} catch (Exception e) {
			System.out.println("error en agregar producto");
			return "gestionp";
		}
		
	}
	
	
	
	public String salir() {
		return "inicioa";
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


	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}


	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}


	public CategoriaFacade getEjbCategoriaFacade() {
		return ejbCategoriaFacade;
	}


	public void setEjbCategoriaFacade(CategoriaFacade ejbCategoriaFacade) {
		this.ejbCategoriaFacade = ejbCategoriaFacade;
	}


	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}


	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getOpcionCategoria() {
		return opcionCategoria;
	}


	public void setOpcionCategoria(String opcionCategoria) {
		this.opcionCategoria = opcionCategoria;
	}


	public String getNombreA() {
		return nombreA;
	}


	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}


	public String getPrecioA() {
		return precioA;
	}


	public void setPrecioA(String precioA) {
		this.precioA = precioA;
	}


	public String getStockA() {
		return stockA;
	}


	public void setStockA(String stockA) {
		this.stockA = stockA;
	}


	public List<String> getOpcionesCategorias() {
		return opcionesCategorias;
	}


	public void setOpcionesCategorias(List<String> opcionesCategorias) {
		this.opcionesCategorias = opcionesCategorias;
	}


	public Bodega getBode() {
		return bode;
	}


	public void setBode(Bodega bode) {
		this.bode = bode;
	}


	public List<String> getOpcionesBodegas() {
		return opcionesBodegas;
	}


	public void setOpcionesBodegas(List<String> opcionesBodegas) {
		this.opcionesBodegas = opcionesBodegas;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	
}

