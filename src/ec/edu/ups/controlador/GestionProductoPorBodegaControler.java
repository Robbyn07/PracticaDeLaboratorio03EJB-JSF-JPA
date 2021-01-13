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
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

@Named
@RequestScoped
public class GestionProductoPorBodegaControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BodegaFacade ejbBodegaFacade;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	
	private List<Bodega> bodegas = new ArrayList<Bodega>();
	
	private List<String> listBodegas = new ArrayList<String>();
	private String bodega="";
	
	private Bodega bo;
	
	
	public static List<Producto> listProductosBodega = new ArrayList<Producto>();
	
	
	@PostConstruct
	public void cargarLista() {
		
		bodegas = ejbBodegaFacade.findAll();
		stringBodega(bodegas);
		bodega = listBodegas.get(0);
		
	}
	
	public void consultar() {
		System.out.println("llega consultar ");
		bo = new Bodega();
		bo = ejbBodegaFacade.buscarBodega(bodega);
		System.out.println("bodega ID : " + bo.getId());
		
		
		//listProductosBodega = ejbProductoFacade.buscarProductoPorBodega(bo.getId());
		//System.out.println("lista tamaño : " + listProductosBodega.size());
		
		
	}
	
	private void stringBodega(List<Bodega> bode) {
		listBodegas = new ArrayList<String>();
		for(int i=0; i<bode.size(); i++) {
			listBodegas.add(bode.get(i).getNombre());
		}
	}

	
	

	
    public String salir() {
    	System.out.println("entra salir");
    	return "inicioa";
    }

	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}


	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}


	public List<Bodega> getBodegas() {
		return bodegas;
	}


	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}


	public List<String> getListBodegas() {
		return listBodegas;
	}


	public void setListBodegas(List<String> listBodegas) {
		this.listBodegas = listBodegas;
	}


	public String getBodega() {
		return bodega;
	}


	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public Bodega getBo() {
		return bo;
	}

	public void setBo(Bodega bo) {
		this.bo = bo;
	}

	public List<Producto> getListProductosBodega() {
		return listProductosBodega;
	}

	public void setListProductosBodega(List<Producto> listProductosBodega) {
		this.listProductosBodega = listProductosBodega;
	}

	
	
	


}
