package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.TipoUsuarioDao;
import com.espe.idao.TipoUsuarioDaoImpl;
import com.espe.model.TipoUsuario;

@ManagedBean(name = "tipoUsuarioManagedBean")
@RequestScoped
public class TipoUsuarioManagedBean {
	
	TipoUsuarioDao tipoUsuarioDAO = new TipoUsuarioDaoImpl();
	
	public List<TipoUsuario> obtenerTipoUsuario() {
		return tipoUsuarioDAO.obtenerTipoUsuario();
	}
	
	public String editarTipoUsuario(int id) {
		TipoUsuario oTipoUsuario = new TipoUsuario();
		oTipoUsuario = tipoUsuarioDAO.buscarTipoUsuario(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("tipoUsuario", oTipoUsuario);
		return "/faces/editar.xhtml";
	}
	
	public String actualizarTipoUsuario(TipoUsuario tipoUsuario) {
		tipoUsuarioDAO.editarTipoUsuario(tipoUsuario);
		return "/faces/index.xhtml";
	}
	
	public String eliminarTipoUsuario(int id) {
		tipoUsuarioDAO.eliminarTipoUsuario(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevoTipoUsuario() {
		TipoUsuario oTipoUsuario = new TipoUsuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("tipoUsuario", oTipoUsuario);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardarTipoUsuario(TipoUsuario tipoUsuario) {
		tipoUsuarioDAO.guardarTipoUsuario(tipoUsuario);
		return "/faces/index.xhtml";
	}

}
