package ec.edu.ups.controlador;

import java.util.List;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Producto;

public class borrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoFacade pf = new ProductoFacade();
		List<Producto> pro = pf.buscarProductosGeneral();
	}

}
