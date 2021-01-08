package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Persona;

public class PersonaFacade extends AbstractFacade<Persona>{

	public PersonaFacade() {
		super(Persona.class);
	}

	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Persona verificarUsuario(String usuario, String contrasena) {
		String jpql = "SELECT per FROM Persona per WHERE per.persona ='" + usuario + "' AND per.contrasena='" + contrasena + "'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		return per;
	}
	
	public Persona buscarCliente (int cedula) {
		String jpql = "SELECT per FROM Persona per WHERE per.cedula=" + cedula;
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		return per;
	}

}
