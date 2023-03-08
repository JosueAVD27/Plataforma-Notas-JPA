package com.espe.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.espe.dao.MateriaDao;
import com.espe.model.JPAUtil;
import com.espe.model.Materia;

public class MateriaDaoImpl implements MateriaDao{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void guardarMateria(Materia materia) {
		entity.getTransaction().begin();
		materia.setIdEstado(1);
		entity.persist(materia);
		entity.getTransaction().commit();
	}

	@Override
	public void editarMateria(Materia materia) {
		entity.getTransaction().begin();
		entity.merge(materia);
		entity.getTransaction().commit();
	}

	@Override
	public Materia buscarMateria(int id) {
		Materia oMateria = new Materia();
		oMateria = entity.find(Materia.class, id);
		return oMateria;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materia> obtenerMateria() {
		List<Materia> listaMateria = new ArrayList<Materia>();
		Query q = entity.createQuery("SELECT c from Materia c");
		listaMateria = q.getResultList();
		return listaMateria;
	}

	@Override
	public void eliminarMateria(int id) {
		Materia c = new Materia();
		c = entity.find(Materia.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

}
