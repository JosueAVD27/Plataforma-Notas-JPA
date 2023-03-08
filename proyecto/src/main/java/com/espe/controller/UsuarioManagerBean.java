package com.espe.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.espe.dao.UsuarioDao;
import com.espe.idao.UsuarioDaoImpl;
import com.espe.model.Usuario;

@ManagedBean(name = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagerBean {

	UsuarioDao usuarioDAO = new UsuarioDaoImpl();

	public List<Usuario> obtenerUsuario() {
		return usuarioDAO.obtenerUsuario();
	}
	
	public String editarUsuario(int id) {
		Usuario oUsuario = new Usuario();
		oUsuario = usuarioDAO.buscarUsuario(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/editar.xhtml";
	}
	
	public String actualizarUsuario(Usuario usuario) {
		usuarioDAO.editarUsuario(usuario);
		return "/faces/index.xhtml";
	}
	
	public String eliminarUsuario(int id) {
		usuarioDAO.eliminarUsuario(id);
		return "/faces/index.xhtml";
	}
	
	public String nuevoUsuario() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardarUsuario(Usuario usuario) {
		usuarioDAO.guardarUsuario(usuario);
		return "/faces/index.xhtml";
	}
}
