package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.NotasDao;
import com.espe.idao.NotasDaoImpl;
import com.espe.model.Notas;

@ManagedBean(name = "notasManagedBean")
@RequestScoped
public class NotasManagedBean {

	NotasDao notasDAO = new NotasDaoImpl();
	
	public List<Notas> obtenerNota() {
		return notasDAO.obtenerNota();
	}
	
	public String editarNota(int id) {
		Notas oNotas = new Notas();
		oNotas = notasDAO.buscarNota(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("notas", oNotas);
		return "/faces/editar.xhtml";
	}
	
	public String actualizarNota(Notas notas) {
		notasDAO.editarNota(notas);
		return "/faces/index.xhtml";
	}
	
	public String eliminarNota(int id) {
		notasDAO.eliminarNota(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevoNota() {
		Notas oNotas = new Notas();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("notas", oNotas);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardarNota(Notas notas) {
		notasDAO.guardarNota(notas);
		return "/faces/index.xhtml";
	}
}
