package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaDetalle;

public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle>{

	public FacturaDetalleFacade() {
		super(FacturaDetalle.class);
	}

	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
