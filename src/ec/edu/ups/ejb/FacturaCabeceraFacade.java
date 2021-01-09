package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Persona;

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
	
	public List<FacturaCabecera> buscarPorCliente(Persona persona) {
		String jpql = "SELECT fc FROM FacturaCabecera fc WHERE fc.persona.id=" + persona.getId() + " AND fc.estado != 'A'";
		//A = estado anulado
		//H = estado habilitado
		List<FacturaCabecera> facturasCabecera = em.createQuery(jpql).getResultList();
		return facturasCabecera;
	}
	
	
}
