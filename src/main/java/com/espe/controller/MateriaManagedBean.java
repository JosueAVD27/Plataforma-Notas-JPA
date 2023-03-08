package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.MateriaDao;
import com.espe.idao.MateriaDaoImpl;
import com.espe.model.Materia;

@ManagedBean(name = "materiaManagedBean")
@RequestScoped
public class MateriaManagedBean {

	MateriaDao materiaDAO = new MateriaDaoImpl();
	
	public List<Materia> obtenerMateria() {
		return materiaDAO.obtenerMateria();
	}
	
	public String editarMateria(int id) {
		Materia oMateria = new Materia();
		oMateria = materiaDAO.buscarMateria(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("materia", oMateria);
		return "/faces/editar.xhtml";
	}
	
	public String actualizarMateria(Materia materia) {
		materiaDAO.editarMateria(materia);
		return "/faces/index.xhtml";
	}
	
	public String eliminarMateria(int id) {
		materiaDAO.eliminarMateria(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevoMateria() {
		Materia oMateria = new Materia();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("materia", oMateria);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardarMateria(Materia materia) {
		materiaDAO.guardarMateria(materia);
		return "/faces/index.xhtml";
	}
}
