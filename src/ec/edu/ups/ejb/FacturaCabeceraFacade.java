package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaCabecera;

public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{

	public FacturaCabeceraFacade() {
		super(FacturaCabecera.class);
	}

	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	

}
