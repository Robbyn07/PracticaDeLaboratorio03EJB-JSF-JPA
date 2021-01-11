package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.ProvinciaFacade;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

@Named
@RequestScoped
public class GenerarFacturaControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private CategoriaFacade ejbCategoriaFacade;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	
	@EJB
	private CiudadFacade ejbCiudadFacadw;
	
	@EJB
	private ProvinciaFacade ejbProvinciaFacade;
	
	@EJB
	private PersonaFacade ejbPersonaFacade;
	
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabecera;
	
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	private List<String> listCategoria = new ArrayList<String>();
	private List<String> listProducto = new ArrayList<String>();
	private String categoria="";
	private String producto="";
	
	public static List<Producto> productosEscoger = new ArrayList<Producto>();
	public static List<FacturaDetalle> detalle = new ArrayList<FacturaDetalle>();
	private Persona persona = new Persona();
	public static FacturaCabecera cabecera = new FacturaCabecera();
	private String nombre="";
	private String apellido="";
	private String cedula="";
    private String direccion="";
    private String telefono="";
    private String correo="";
	
	@PostConstruct
	public void datos() {
		categorias = ejbCategoriaFacade.findAll();
		
		productos = ejbProductoFacade.findAll();
		
		//productosEscoger = ejbProductoFacade.findAll();
		
		stringCategoria(categorias);
		stringProducto(productos);
		
		categoria = listCategoria.get(0);
			
		
	}
	
	public void filtrar() {
		productosEscoger = ejbProductoFacade.buscarProductoPorCategoriaYNombre(categoria,producto);
	}
	
	public void buscarPersona() {
		persona = ejbPersonaFacade.buscarCliente(cedula);
		this.setCedula(persona.getCedula());
		this.setNombre(persona.getNombre());
		this.setApellido(persona.getApellido());
		this.setDireccion(persona.getDireccion());
		this.setCorreo(persona.getCorreo());
		this.setTelefono(persona.getTelefono());
	}
	
	
	public void agregarDetalle(Producto productoDetalle) {
		buscarPersona();
		datos();
		Producto producto = ejbProductoFacade.find(productoDetalle.getId());
		if(producto.getStock()>=productoDetalle.getStock()) {
			FacturaDetalle det = new FacturaDetalle(0, productoDetalle.getStock(), producto.getPrecio()*productoDetalle.getStock(), cabecera, producto);
			cabecera.setSubtotal(cabecera.getSubtotal()+producto.getPrecio()*productoDetalle.getStock());
			cabecera.setIva((float)0.12);
			cabecera.setTotal(cabecera.getSubtotal()*cabecera.getIva()+cabecera.getSubtotal());
			detalle.add(det);
		}else {
			System.out.println("no entra a la condicion");
		}
		
	}
	
	public String salir() {
		detalle = new ArrayList<FacturaDetalle>();
		cabecera = new FacturaCabecera();
		productosEscoger = new ArrayList<Producto>();
		return "inicioe";
	}
	
	public String enviarFactura() {
		
		try {
			persona = ejbPersonaFacade.buscarCliente(cedula);
			
			cabecera.setId(0);
			cabecera.setFecha(new Date());
			cabecera.setEstado('H');
			cabecera.setPersona(persona);
			cabecera.setFacturasDetalle(detalle);
			
			for(int i=0; i<detalle.size(); i++) {
				Producto produActualizar = ejbProductoFacade.find(detalle.get(i).getProducto().getId());
				produActualizar.setStock(produActualizar.getStock()-detalle.get(i).getCantidad());
				ejbProductoFacade.edit(produActualizar);
			}
			
			ejbFacturaCabecera.create(cabecera);
			

			detalle = new ArrayList<FacturaDetalle>();
			cabecera = new FacturaCabecera();
			productosEscoger = new ArrayList<Producto>();
			
			return "inicioe";
			
		} catch (Exception e) {
			detalle = new ArrayList<FacturaDetalle>();
			cabecera = new FacturaCabecera();
			return "generarf";
		}
		
		
		
		
	}
	
	
	private void stringCategoria(List<Categoria> cat) {
		listCategoria = new ArrayList<String>();
		for(int i=0; i<cat.size(); i++) {
			listCategoria.add(cat.get(i).getNombre());
		}
	}
	
	private void stringProducto(List<Producto> pro) {
		listProducto = new ArrayList<String>();
		for(int i=0; i<pro.size(); i++) {
			listProducto.add(pro.get(i).getNombre());
		}
	}
	
	

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public List<String> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<String> listCategoria) {
		this.listCategoria = listCategoria;
	}

	public List<String> getListProducto() {
		return listProducto;
	}

	public void setListProducto(List<String> listProducto) {
		this.listProducto = listProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		productos = ejbProductoFacade.buscarProductoPorCategoriaNombreUnico(categoria);
		stringProducto(productos);
		this.categoria = categoria;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Producto> getProductosEscoger() {
		return productosEscoger;
	}

	public void setProductosEscoger(List<Producto> productosEscoger) {
		this.productosEscoger = productosEscoger;
	}

	public List<FacturaDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<FacturaDetalle> detalle) {
		this.detalle = detalle;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public FacturaCabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(FacturaCabecera cabecera) {
		this.cabecera = cabecera;
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
	
	
	
	
	
	
	
	
	
}
