package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Categoria;

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

}
