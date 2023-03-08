package com.espe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.espe.dao.UsuarioDao;
import com.espe.idao.UsuarioDaoImpl;
import com.espe.model.Usuario;

@ManagedBean(name = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean {

	// Variables de session
	private String correoUsuario;
	private String claveUsuario;

	// Variable para autenticar el redireccionamiento
	// General
	private boolean isAuthenticated = false;

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	// Administrador
	private boolean isAuthenticatedAdmin = false;

	public boolean isAuthenticatedAdmin() {
		return isAuthenticatedAdmin;
	}

	public void setAuthenticatedAdmin(boolean isAuthenticated) {
		this.isAuthenticatedAdmin = isAuthenticated;
	}

	// Docente
	private boolean isAuthenticatedDocente = false;

	public boolean isAuthenticatedDocente() {
		return isAuthenticatedDocente;
	}

	public void setAuthenticatedDocente(boolean isAuthenticated) {
		this.isAuthenticatedDocente = isAuthenticated;
	}

	// Docente
	private boolean isAuthenticatedEstudiante = false;

	public boolean isAuthenticatedEstudiante() {
		return isAuthenticatedEstudiante;
	}

	public void setAuthenticatedEstudiante(boolean isAuthenticated) {
		this.isAuthenticatedEstudiante = isAuthenticated;
	}

	// ======================================================================

	UsuarioDao usuarioDAO = new UsuarioDaoImpl();

	// Login
	private Map<String, String> users = new HashMap<>();

	public Usuario autenticarUsuario(String correoUsuario, String claveUsuario) {
		Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correoUsuario);

		if (usuario != null && usuario.getClaveUsuario().equals(claveUsuario)) {
			// Si el usuario existe y la contraseña es correcta, lo guardamos en la lista de
			// usuarios conectados
			users.put(correoUsuario, claveUsuario);
			return usuario;
		}
		// Si no, devolvemos null
		return null;
	}

	public String iniciarSesion() {
		Usuario usuario = autenticarUsuario(correoUsuario, claveUsuario);

		if (usuario != null) {
			// Si el usuario se autenticó correctamente, redirigimos a la página de
			// bienvenida
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("usuarioSession", usuario);

			isAuthenticated = true;

			if (usuario.getIdTipo() == 1) {
				isAuthenticatedEstudiante = true;
				return "/faces/estudiante/inicio.xhtml";
			} else if (usuario.getIdTipo() == 2) {
				isAuthenticatedDocente = true;
				return "/faces/docente/inicio.xhtml";
			} else {
				isAuthenticatedAdmin = true;
				return "/faces/administrador/inicio.xhtml";
			}

		} else {
			// Si la autenticación falló, mostramos un mensaje de error y no redirigimos
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Nombre de usuario o contraseña incorrectos"));
			return null;
		}
	}

	// Cerrar Session
	public String cerrarSesion() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.invalidateSession(); // Invalidamos la sesión actual
		return "/faces/views/login.xhtml";
	}

	// Autenticar la redireccion
	// General
	public void checkAuthentication() throws IOException {
		if (!isAuthenticated) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect("/proyecto/faces/index.xhtml");
		}
	}

	// Administrador
	public void checkAuthenticationAdmin() throws IOException {
		if (!isAuthenticatedAdmin) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect("/proyecto/faces/restriction.xhtml");
		}
	}

	// Docente
	public void checkAuthenticationDocente() throws IOException {
		if (!isAuthenticatedDocente) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect("/proyecto/faces/restriction.xhtml");
		}
	}

	// Estudiante
	public void checkAuthenticationEstudiante() throws IOException {
		if (!isAuthenticatedEstudiante) {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect("/proyecto/faces/restriction.xhtml");
		}
	}

	// ======================================================================

	// Metodos
	public List<Usuario> obtenerUsuario() {
		return usuarioDAO.obtenerUsuario();
	}

	public String editarUsuario(int id) {
		Usuario oUsuario = new Usuario();
		oUsuario = usuarioDAO.buscarUsuario(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/administrador/usuario/editar.xhtml";
	}

	public String actualizarUsuario(Usuario usuario) {
		usuarioDAO.editarUsuario(usuario);
		return "/faces/administrador/usuario/usuarios.xhtml";
	}

	public String eliminarUsuario(int id) {
		usuarioDAO.eliminarUsuario(id);
		return "/faces/administrador/usuario/usuarios.xhtml";
	}

	public String guardarUsuario(Usuario usuario) {
		usuarioDAO.guardarUsuario(usuario);
		return "/faces/views/login.xhtml";
	}

	public String guardarUsuarioAdmin(Usuario usuario) {
		usuarioDAO.guardarUsuario(usuario);
		return "/faces/index.xhtml";
	}

	// ======================================================================

	// Direccionamiento de la restriccion al inicio
	public String restriccionInicio() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		
		if(isAuthenticatedEstudiante == true) {
			return "/faces/estudiante/inicio.xhtml";
		}else if(isAuthenticatedDocente == true) {
			return "/faces/docente/inicio.xhtml";
		}else {
			return "/faces/administrador/inicio.xhtml";
		}
		
	}
	
	
	
	// Direccionamiento al index (Plataforma)
	public String irIndex() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/index.xhtml";
	}

	// Direccionamiento al formulario de login
	public String irLogin() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/views/login.xhtml";
	}

	// Direccionamiento al formulario de registro
	public String irRegistro() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/views/registro.xhtml";
	}

	// Direccionamiento al inicio estudiante
	public String irInicio() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/estudiante/inicio.xhtml";
	}

	// Direccionamiento al inicio Administrador
	public String irInicioAdmin() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);

		return "/faces/administrador/inicio.xhtml";
	}

	// Direccionamiento a la lista de usuarios de Administrador
	public String irListaUsuariosAdmin() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/administrador/usuario/usuarios.xhtml";
	}

	// Direccionamiento al inicio Docente
	public String irInicioDocente() {
		Usuario oUsuario = new Usuario();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("usuario", oUsuario);
		return "/faces/docente/inicio.xhtml";
	}

	// ======================================================================

	// Metodos Getters and Setters
	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

}
