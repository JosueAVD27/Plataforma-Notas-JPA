package com.espe.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.espe.dao.EstadosDao;
import com.espe.model.Estados;
import com.espe.model.JPAUtil;

public class EstadosDaoImpl implements EstadosDao{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardarEstado(Estados estado) {
		entity.getTransaction().begin();
		entity.persist(estado);
		entity.getTransaction().commit();
	}

	@Override
	public void editarEstado(Estados estado) {
		entity.getTransaction().begin();
		entity.merge(estado);
		entity.getTransaction().commit();
	}

	@Override
	public Estados buscarEstado(int id) {
		Estados oEstado = new Estados();
		oEstado = entity.find(Estados.class, id);
		return oEstado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estados> obtenerEstado() {
		List<Estados> listaEstado = new ArrayList<Estados>();
		Query q = entity.createQuery("SELECT c from Estados c");
		listaEstado = q.getResultList();
		return listaEstado;
	}

	@Override
	public void eliminarEstado(int id) {
		Estados c = new Estados();
		c = entity.find(Estados.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
}
