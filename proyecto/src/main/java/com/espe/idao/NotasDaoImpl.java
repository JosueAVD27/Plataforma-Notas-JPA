package com.espe.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.espe.dao.NotasDao;
import com.espe.model.JPAUtil;
import com.espe.model.Materia;
import com.espe.model.Notas;
import com.espe.model.Usuario;

public class NotasDaoImpl implements NotasDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardarNota(Notas notas) {
		entity.getTransaction().begin();
		notas.setNota1(0);
		notas.setNota2(0);
		notas.setNota3(0);
		entity.persist(notas);
		entity.getTransaction().commit();
	}

	@Override
	public void editarNota(Notas notas) {
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
		Query q = entity.createQuery("SELECT c from Notas c");
		listaNotas = q.getResultList();
		return listaNotas;
	}

	@Override
	public void eliminarNota(int id) {
		Notas c = new Notas();
		c = entity.find(Notas.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

}
