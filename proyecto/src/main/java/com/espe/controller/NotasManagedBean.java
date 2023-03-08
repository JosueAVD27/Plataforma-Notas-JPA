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
import com.espe.model.registroNotas;

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

	public String editarNotaDocente(int id) {
		Notas oNotas = new Notas();
		oNotas = notasDAO.buscarNota(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("notas", oNotas);
		return "/faces/docente/calificaciones/editar.xhtml";
	}

	public String actualizarNota(Notas notas) {

		try {
			if (notas.getUsuario().getIdUsuario() == 0 || notas.getMateria().getIdMateria() == 0) {
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

	public String actualizarNotaDocente(Notas notas) {

		try {

			if (!(String.valueOf(notas.getNota1()).matches("(10(\\.0)?)|([0-9](\\.[0-9])?)"))
					|| !(String.valueOf(notas.getNota2()).matches("(10(\\.0)?)|([0-9](\\.[0-9])?)"))
					|| !(String.valueOf(notas.getNota3()).matches("(10(\\.0)?)|([0-9](\\.[0-9])?)"))) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingrese una nota valida"));
				return null;
			} else {
				notasDAO.editarNotaDocente(notas);
				return "/faces/docente/calificaciones/notas.xhtml";
			}

		} catch (Exception e) {
			// Manejar la excepción aquí
			e.printStackTrace();
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existen problemas"));
			return null;
		}

	}

	public String eliminarNota(int id) {
		notasDAO.eliminarNota(id);
		return "/faces/administrador/matricula/matriculas.xhtml";
	}

	public String nuevoNota() {
		registroNotas oRegistroNotas = new registroNotas();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("registroNotas", oRegistroNotas);
		return "/faces/administrador/matricula/nuevo.xhtml";
	}
	
	
	
	public String guardarNota(registroNotas registroNotas) {
		try {
			if (registroNotas.getIdUsuario() == 0 || registroNotas.getIdMateria() == 0) {
				// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hay campos vacios"));
				return null;
			} else {
				notasDAO.guardarNota(registroNotas);
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
