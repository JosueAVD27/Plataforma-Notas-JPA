package com.espe.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.espe.dao.TipoUsuarioDao;
import com.espe.model.JPAUtil;
import com.espe.model.TipoUsuario;

public class TipoUsuarioDaoImpl implements TipoUsuarioDao{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardarTipoUsuario(TipoUsuario tipoUsuario) {
		entity.getTransaction().begin();
		entity.persist(tipoUsuario);
		entity.getTransaction().commit();
	}

	@Override
	public void editarTipoUsuario(TipoUsuario tipoUsuario) {
		entity.getTransaction().begin();
		entity.merge(tipoUsuario);
		entity.getTransaction().commit();
	}

	@Override
	public TipoUsuario buscarTipoUsuario(int id) {
		TipoUsuario oTipoUsuario = new TipoUsuario();
		oTipoUsuario = entity.find(TipoUsuario.class, id);
		return oTipoUsuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoUsuario> obtenerTipoUsuario() {
		List<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();
		Query q = entity.createQuery("SELECT c from TipoUsuario c");
		listaTipoUsuario = q.getResultList();
		return listaTipoUsuario;
	}

	@Override
	public void eliminarTipoUsuario(int id) {
		TipoUsuario c = new TipoUsuario();
		c = entity.find(TipoUsuario.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

}
