package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Producto;

public class BodegaFacade extends AbstractFacade<Bodega>{

	public BodegaFacade() {
		super(Bodega.class);
	}
	
	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Bodega buscarBodega (String nombre) {
		String jpql = "SELECT b FROM Bodega b WHERE b.nombre=" + nombre;
		Bodega bod = (Bodega) em.createQuery(jpql).getSingleResult();
		return bod;
	}
	
	public List<Bodega> buscarBodegaPorCiudad (int ciudad_id) {
		String jpql = "SELECT b FROM Bodega b WHERE b.ciudad.id=" + ciudad_id;
		List<Bodega> bodegas = em.createQuery(jpql).getResultList();
		return bodegas;
	}
}
