package com.espe.idao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.espe.dao.UsuarioDao;
import com.espe.model.Usuario;
import com.espe.model.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		entity.getTransaction().begin();
		usuario.setIdTipo(1);
		usuario.setIdEstado(1);
		entity.persist(usuario);
		entity.getTransaction().commit();
	}
	
	@Override
	public void guardarUsuarioAdmin(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
	}

	@Override
	public Usuario buscarUsuario(int id) {
		Usuario oUsuario = new Usuario();
		oUsuario = entity.find(Usuario.class, id);
		return oUsuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuario() {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		Query q = entity.createQuery("SELECT c from Usuario c");
		listaUsuario = q.getResultList();
		return listaUsuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuarioDocente() {
		List<Usuario> listaUsuarioDocente = new ArrayList<Usuario>();
		Query q = entity.createQuery("SELECT c from Usuario c WHERE idTipo=2");
		listaUsuarioDocente = q.getResultList();
		return listaUsuarioDocente;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuarioEstudiante() {
		List<Usuario> listaUsuarioEstudiante = new ArrayList<Usuario>();
		Query q = entity.createQuery("SELECT c from Usuario c WHERE idTipo=1");
		listaUsuarioEstudiante = q.getResultList();
		return listaUsuarioEstudiante;
	}

	@Override
	public void eliminarUsuario(int id) {
		Usuario c = new Usuario();
		c = entity.find(Usuario.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	@Override
	public Usuario buscarUsuarioPorCorreo(String correoUsuario) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	    Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.correoUsuario = :correoUsuario");
	    query.setParameter("correoUsuario", correoUsuario);
	    Usuario usuario = null;

	    try {
	        usuario = (Usuario) query.getSingleResult();
	    } catch (NoResultException ex) {
	        // El usuario no existe
	    }

	    return usuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> prueba() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario u = (Usuario) sessionMap.get("usuarioSession");
				
		int variable = u.getIdTipo();
		
		List<Usuario> listaUsuarioEstudiante = new ArrayList<Usuario>();
		Query q = entity.createQuery("SELECT c from Usuario c WHERE c.idTipo = :variable");
		q.setParameter("variable", variable);
		listaUsuarioEstudiante = q.getResultList();
		return listaUsuarioEstudiante;
	}
	
	/*@Override
	public List<Notas> obtenerNotaPorId() {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Usuario u = (Usuario) sessionMap.get("usuarioSession");

	    int variable = u.getIdUsuario();

	    Query q = entity.createQuery("SELECT n FROM Notas n JOIN FETCH n.usuario u JOIN FETCH n.materia m WHERE u.idUsuario = :variable AND m.idUsuario = :variable");
	    q.setParameter("variable", variable);

	    return q.getResultList();
	}
	
	@Override
	public List<Notas> obtenerNotaPorId() {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Usuario u = (Usuario) sessionMap.get("usuarioSession");

	    int variable = u.getIdUsuario();

	    Query q = entity.createQuery("SELECT n FROM Notas n JOIN FETCH n.usuario u JOIN FETCH n.materia m WHERE u.idUsuario = :variable AND m.usuario.idUsuario = :variable");
	    q.setParameter("variable", variable);

	    return q.getResultList();
	}*/
}
