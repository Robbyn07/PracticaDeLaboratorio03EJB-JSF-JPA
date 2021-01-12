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
	
	public List<Producto> buscarProductoPorCategoriaYNombre (String categoriaNombre, String productoNombre) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.nombre='" + categoriaNombre + "' AND pro.nombre='"+productoNombre+"'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	public List<Producto> buscarProductoPorCategoriaNombreUnico (String categoriaNombre) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.categoria.nombre='"+categoriaNombre+"' GROUP BY pro.nombre";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	
	public List<Producto> productosOrdenadosAlfabeticamente(){
		String jpql = "SELECT pro FROM Producto pro ORDER BY pro.nombre ASC";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	
	
	
	public List<Producto> buscarProductoPorNombre (String producto) {
		String jpql = "SELECT pro FROM Producto pro WHERE pro.estado != 'E' AND pro.nombre LIKE '" + producto + "%'";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	
	
}
