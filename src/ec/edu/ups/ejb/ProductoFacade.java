package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

public class ProductoFacade extends AbstractFacade<Producto>{

	public ProductoFacade() {
		super(Producto.class);
	}
	
	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Producto> buscarProductoPorCategoria (int categoria_id) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.id=" + categoria_id;
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	public List<Producto> buscarProductoPorBodega (int bodega_id) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.bodegas.id=" + bodega_id;
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
}
