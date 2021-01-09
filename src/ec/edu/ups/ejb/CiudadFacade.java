package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Provincia;

public class CiudadFacade extends AbstractFacade<Ciudad>{

	public CiudadFacade() {
		super(Ciudad.class);
	}
	
	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Ciudad buscarCiudad(String nombre) {
		String jpql = "SELECT c FROM Ciudad c WHERE c.nombre=" + nombre;
		Ciudad ciu = (Ciudad) em.createQuery(jpql).getSingleResult();
		return ciu;
	}
	
	public List<Ciudad> buscarCiudadesPorProvincia (Provincia provincia) {
		String jpql = "SELECT c FROM Ciudad c WHERE c.provincia.id=" + provincia.getId();
		List<Ciudad> ciu = em.createQuery(jpql).getResultList();
		return ciu;
	}
}
