package com.espe.dao;

import java.util.List;

import com.espe.model.TipoUsuario;

public interface TipoUsuarioDao {

	// Guardar tipoUsuario
	public void guardarTipoUsuario(TipoUsuario tipoUsuario);

	// Editar tipoUsuario
	public void editarTipoUsuario(TipoUsuario tipoUsuario);

	// Buscar tipoUsuario
	public TipoUsuario buscarTipoUsuario(int id);

	// Obtener todos los tipoUsuario
	public List<TipoUsuario> obtenerTipoUsuario();

	// Eliminar tipoUsuario
	public void eliminarTipoUsuario(int id);
}
