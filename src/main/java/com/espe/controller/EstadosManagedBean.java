package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.EstadosDao;
import com.espe.idao.EstadosDaoImpl;
import com.espe.model.Estados;

@ManagedBean(name = "estadosManagedBean")
@RequestScoped
public class EstadosManagedBean {

	EstadosDao estadosDAO = new EstadosDaoImpl();

	public List<Estados> obtenerEstado() {
		return estadosDAO.obtenerEstado();
	}
	
	public String editarEstado(int id) {
		Estados oEstado = new Estados();
		oEstado = estadosDAO.buscarEstado(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("estado", oEstado);
		return "/faces/editar.xhtml";
	}
	
	public String actualizarEstado(Estados estado) {
		estadosDAO.editarEstado(estado);
		return "/faces/index.xhtml";
	}
	
	public String eliminarEstado(int id) {
		estadosDAO.eliminarEstado(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevoUsuario() {
		Estados oEstado = new Estados();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("estado", oEstado);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardarEstado(Estados estados) {
		estadosDAO.guardarEstado(estados);
		return "/faces/index.xhtml";
	}
}
