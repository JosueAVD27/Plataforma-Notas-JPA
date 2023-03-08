package com.espe.dao;

import java.util.List;

import com.espe.model.Estados;

public interface EstadosDao {

	// Guardar estado
	public void guardarEstado(Estados estado);

	// Editar estado
	public void editarEstado(Estados estado);

	// Buscar estado
	public Estados buscarEstado(int id);

	// Obtener todos los estados
	public List<Estados> obtenerEstado();

	// Eliminar estado
	public void eliminarEstado(int id);
}
