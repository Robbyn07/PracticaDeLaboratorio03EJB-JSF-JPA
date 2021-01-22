package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidoDetalleFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.ProvinciaFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.PedidoDetalle;
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
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	
	@EJB
	private PedidoCabeceraFacade ejbPedidoCabeceraFacade;
	
	@EJB
	private PedidoDetalleFacade ejbPedidoDetalleFacade;
	
	public void agregarDatos() {
		
		//Categorias
		Categoria cat1 = new Categoria(0,"Despensa");
		Categoria cat2 = new Categoria(0,"Vinos y Licores");
		Categoria cat3 = new Categoria(0,"Cuidado Personal");
		Categoria cat4 = new Categoria(0,"Menajes del Hogar");
		Categoria cat5 = new Categoria(0,"Aseo Hogar");
		Categoria cat6 = new Categoria(0,"Electrodomesticos");
		Categoria cat7 = new Categoria(0,"Herramientas");
		Categoria cat8 = new Categoria(0,"Reposteria");
		
		ejbCategoriaFacade.create(cat1);
		ejbCategoriaFacade.create(cat2);
		ejbCategoriaFacade.create(cat3);
		ejbCategoriaFacade.create(cat4);
		ejbCategoriaFacade.create(cat5);
		ejbCategoriaFacade.create(cat6);
		ejbCategoriaFacade.create(cat7);
		ejbCategoriaFacade.create(cat8);
	
		//Usuarios
		ejbPersonaFacade.create(new Persona(0, "Pablo", "Loja", "0107137408", "Cuenca", "0998476387", "plojam@est.ups.edu.ec", "ploja",'E','H'));
		ejbPersonaFacade.create(new Persona(0, "John", "Macao", "0105824478", "Cuenca", "0989449535", "jmacaog@est.ups.edu.ec", "jmacao", 'A' ,'H'));
		ejbPersonaFacade.create(new Persona(0, "Robbyn", "Reyes", "1900848886", "Zamora", "0969784090", "rreyesd@est.ups.edu.ec", "rreyes", 'C', 'H'));
		
		//Provincias
		Provincia prov1 = new Provincia(0, "Azuay");
		Provincia prov2 = new Provincia(0, "Zamora Chinchipe");
		Provincia prov3 = new Provincia(0, "Loja");
		
		ejbProvinciaFacade.create(prov1);
		ejbProvinciaFacade.create(prov2);
		ejbProvinciaFacade.create(prov3);
		
		//Ciudades
		Ciudad ciu1 = new Ciudad(0, "Cuenca", prov1);
		Ciudad ciu2 = new Ciudad(0, "Zamora", prov2);
		Ciudad ciu3 = new Ciudad(0, "Loja", prov3);
		
		ejbCiudadFacade.create(ciu1);
		ejbCiudadFacade.create(ciu2);
		ejbCiudadFacade.create(ciu3);
		
		//Productos
		Producto prod1 = new Producto(0, "Aceite 1L", (float) 1.5, 50, 'H', cat1);
		Producto prod2 = new Producto(0, "Vino Barato", (float) 10, 50, 'H', cat2);
		Producto prod3 = new Producto(0, "Cepillo Dental", (float) 0.75, 50, 'H', cat3);
		Producto prod4 = new Producto(0, "Tazon de Cristal", (float) 3, 50, 'H', cat4);
		Producto prod5 = new Producto(0, "Fabuloso 1L", (float) 1.5, 50, 'H', cat5);
		Producto prod6 = new Producto(0, "Licuadora Oster", (float) 55, 50, 'H', cat6);
		Producto prod7 = new Producto(0, "Martillo", (float) 14, 50, 'H', cat7);
		Producto prod8 = new Producto(0, "Escencia de Vainilla", (float) 1.3, 50, 'H', cat8);
		
		//Bodegas
		Bodega bod1 = new Bodega(0, "Bodega Cuencanito", "Calle na ", ciu1);
		Bodega bod2 = new Bodega(0, "Bodega Zamborondeno", "Via a Jamboe", ciu2);
		
		bod1.addProductos(prod1);
		bod1.addProductos(prod3);
		bod1.addProductos(prod5);
		bod1.addProductos(prod7);
		
		bod2.addProductos(prod2);
		bod2.addProductos(prod4);
		bod2.addProductos(prod6);
		bod2.addProductos(prod7);
		bod2.addProductos(prod8);
		
		ejbBodegaFacade.create(bod1);
		ejbBodegaFacade.create(bod2);
		
		/*
		ejbProductoFacade.create(prod1);
		ejbProductoFacade.create(prod2);
		ejbProductoFacade.create(prod3);
		ejbProductoFacade.create(prod4);
		ejbProductoFacade.create(prod5);
		ejbProductoFacade.create(prod6);
		ejbProductoFacade.create(prod7);
		ejbProductoFacade.create(prod8);
		*/
		

		
		List<Producto> prods = ejbProductoFacade.findAll();
		Persona per = ejbPersonaFacade.buscarCliente("1900848886");
		
		List<PedidoDetalle> pedDet = new ArrayList<PedidoDetalle>();
		PedidoCabecera pedCab = new PedidoCabecera(0, "Enviado", "Receptado", per);

		
		pedDet.add(new PedidoDetalle(0, 12, prods.get(0), pedCab));
		pedDet.add(new PedidoDetalle(0, 15, prods.get(1), pedCab));
		
		pedCab.setPedidoDetalle(pedDet);
		
		ejbPedidoCabeceraFacade.create(pedCab);
		
	}

	
	public void lsitarBodegas() {
		 List<Producto> sta = ejbBodegaFacade.find(1).getProductos();

	        for (Producto producto : sta) {
	            System.out.println(producto.getNombre());
	        }
	}
	
}
