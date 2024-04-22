package ejercicio20_CentroEducativo.controladores;

import javax.persistence.EntityManager;
import ejercicio20_CentroEducativo.entities.Estudiante;

public class ControladorEstudiante extends SuperControlador {
	
	public ControladorEstudiante() {
		super("estudiante", Estudiante.class);
	}

	private static ControladorEstudiante instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorEstudiante getInstance() {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertEstudiante(Estudiante e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void updateEstudiante(Estudiante e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteEstudiante(int id) {
		EntityManager em = getEntityManager();
		
		Estudiante e = (Estudiante) findById(id);
		
		em.getTransaction().begin();
		// Volvemos a enlazar nuestra entidad con nuestro manager.
		e = em.merge(e);
		em.remove(e);
		em.getTransaction().commit();
	}
	
}