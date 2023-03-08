package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.MateriaDao;
import com.espe.idao.MateriaDaoImpl;
import com.espe.model.Materia;
import com.espe.model.Usuario;

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
		return "/faces/administrador/materia/editar.xhtml";
	}

	public String actualizarMateria(Materia materia) {

		try {
			if (materia.getNrc() == 0 || materia.getNombreMateria() == "" || materia.getIdUsuario() == 0) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hay campos vacios"));
				return null;
			} else {
				materiaDAO.editarMateria(materia);
				return "/faces/administrador/materia/materias.xhtml";
			}
		} catch (Exception e) {
			// Manejar la excepción aquí
			e.printStackTrace();
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No existe el Docente"));
			return null;
		}
	}

	public String eliminarMateria(int id) {
		materiaDAO.eliminarMateria(id);
		return "/faces/administrador/materia/materias.xhtml";
	}

	public String nuevoMateria() {
		Materia oMateria = new Materia();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("materia", oMateria);
		return "/faces/administrador/materia/nuevo.xhtml";
	}

	public String guardarMateria(Materia materia) {

		Usuario usuario = new Usuario();
		try {
			if (materia.getNrc() == 0 || materia.getNombreMateria() == "" || materia.getIdUsuario() == 0) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hay campos vacios"));
				return null;
			} else if (usuario.getIdUsuario() == materia.getIdUsuario() && usuario.getIdTipo() != 2) {

				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario no es Docente"));
				return null;

			} else {
				materiaDAO.guardarMateria(materia);
				return "/faces/administrador/materia/materias.xhtml";
			}
		} catch (Exception e) {
			// Manejar la excepción aquí
			e.printStackTrace();
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No existe el Docente"));
			return null;
		}
	}
}
