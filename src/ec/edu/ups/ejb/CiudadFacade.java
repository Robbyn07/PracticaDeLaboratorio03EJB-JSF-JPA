package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Ciudad;

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

}
