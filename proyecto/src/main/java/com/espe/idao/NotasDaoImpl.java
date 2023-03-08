package com.espe.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.espe.dao.NotasDao;
import com.espe.model.JPAUtil;
import com.espe.model.Notas;
import com.espe.model.registroNotas;

public class NotasDaoImpl implements NotasDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void guardarNota(registroNotas registroNotas) {
		entity.getTransaction().begin();
		registroNotas.setNota1(0);
		registroNotas.setNota2(0);
		registroNotas.setNota3(0);
		entity.persist(registroNotas);
		entity.getTransaction().commit();
	}

	@Override
	public void editarNota(Notas notas) {
		entity.getTransaction().begin();
		entity.merge(notas);
		entity.getTransaction().commit();
	}
	
	@Override
	public void editarNotaDocente(Notas notas) {
		entity.getTransaction().begin();
		entity.merge(notas);
		entity.getTransaction().commit();
	}

	@Override
	public Notas buscarNota(int id) {
		Notas oNotas = new Notas();
		oNotas = entity.find(Notas.class, id);
		return oNotas;
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Notas> obtenerNota() {
	    List<Notas> listaNotas = new ArrayList<Notas>();
	    Query q = entity.createQuery("SELECT c from Notas c JOIN FETCH c.usuario");
	    listaNotas = q.getResultList();
	    return listaNotas;
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<registroNotas> obtenerNotaPorId() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario u = (Usuario) sessionMap.get("usuarioSession");
				
		int variable = u.getIdUsuario();
		
	    List<registroNotas> listaNotas = new ArrayList<registroNotas>();
	    Query q = entity.createQuery("SELECT c from Notas c JOIN FETCH c.usuario u JOIN FETCH c.materia m WHERE m.idUsuario = :variable");
	    q.setParameter("variable", variable);
	    listaNotas = q.getResultList();
	    return listaNotas;
	}
	 */

	@Override
	public void eliminarNota(int id) {
		Notas c = new Notas();
		c = entity.find(Notas.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

}
