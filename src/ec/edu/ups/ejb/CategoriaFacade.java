package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

public class CategoriaFacade extends AbstractFacade<Categoria>{

	public CategoriaFacade() {
		super(Categoria.class);
	}

	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public int obtenerCategoriaId(Producto producto) {
		String jpql = "SELECT cat.id FROM Categoria cat WHERE cat.producto.id=" + producto.getId();
		int categoria_id = (int) em.createQuery(jpql).getSingleResult();
		return categoria_id;
	}
}
