package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Persona;

@Stateless
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

	public Persona verificarUsuario(String correo, String contrasena) {
		String jpql = "SELECT per FROM Persona per WHERE per.correo ='" + correo + "' AND per.contrasena='" + contrasena + "'";
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		return per;
	}
	
	public Persona buscarCliente(String cedula) {
		String jpql = "SELECT per FROM Persona per WHERE per.cedula=" + cedula;
		Persona per = (Persona) em.createQuery(jpql).getSingleResult();
		return per;
	}

	
}
