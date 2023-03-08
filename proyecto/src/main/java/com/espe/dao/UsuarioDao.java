package com.espe.dao;

import java.util.List;

import com.espe.model.Usuario;


public interface UsuarioDao {

	// Guardar usuario
	public void guardarUsuario(Usuario usuario);
	public void guardarUsuarioAdmin(Usuario usuario);

	// Editar usuario
	public void editarUsuario(Usuario usuario);

	// Buscar usuario
	public Usuario buscarUsuario(int id);
	public Usuario buscarUsuarioPorCorreo(String correoUsuario);

	// Obtener todos los usuarios
	public List<Usuario> obtenerUsuario();
	public List<Usuario> obtenerUsuarioDocente();
	public List<Usuario> obtenerUsuarioEstudiante();

	public List<Usuario> prueba();

	// Eliminar usuario
	public void eliminarUsuario(int id);
}
