package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
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
		return "/faces/administrador/matricula/editar.xhtml";
	}

	public String actualizarNota(Notas notas) {

		try {
			if (notas.getIdUsuario() == 0 || notas.getIdMateria() == 0) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hay campos vacios"));
				return null;
			} else {
				notasDAO.editarNota(notas);
				return "/faces/administrador/matricula/matriculas.xhtml";
			}
		} catch (Exception e) {
			// Manejar la excepción aquí
			e.printStackTrace();
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No existe el Estudiante o la Materia"));
			return null;
		}

	}

	public String eliminarNota(int id) {
		notasDAO.eliminarNota(id);
		return "/faces/administrador/matricula/matriculas.xhtml";
	}

	public String nuevoNota() {
		Notas oNotas = new Notas();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("notas", oNotas);
		return "/faces/administrador/matricula/nuevo.xhtml";
	}

	public String guardarNota(Notas notas) {
		try {
			if (notas.getIdUsuario() == 0 || notas.getIdMateria() == 0) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Hay campos vacios"));
				return null;
			} else {
				notasDAO.guardarNota(notas);
				return "/faces/administrador/matricula/matriculas.xhtml";
			}
		} catch (Exception e) {
			// Manejar la excepción aquí
			e.printStackTrace();
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No existe el Estudiante o la Materia"));
			return null;
		}
	}
}
