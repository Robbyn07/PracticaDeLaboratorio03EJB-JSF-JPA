package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Producto;

@Stateless
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
		String jpql = "SELECT pro FROM Producto pro WHERE pro.bodegas.id=" + bodega_id + " AND pro.estado != 'E'";
		//E = producto eliminado
		//H = producto habilitado
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	public Producto buscarPorNombreBodega (String nombre, int bodega_id) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.bodega.id=" + bodega_id + " AND pro.estado != 'E'"
				+ " AND pro.nombre='" + nombre + "'";
		Producto pro = (Producto) em.createQuery(jpql).getSingleResult();
		return pro;
	}
	
	
}
