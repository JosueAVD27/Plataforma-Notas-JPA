package com.espe.dao;

import java.util.List;

import com.espe.model.Notas;

public interface NotasDao {
	// Guardar notas
	public void guardarNota(Notas notas);

	// Editar notas
	public void editarNota(Notas notas);
	public void editarNotaDocente(Notas notas);

	// Buscar notas
	public Notas buscarNota(int id);

	// Obtener todas las notas
	public List<Notas> obtenerNota();

	// Eliminar nota
	public void eliminarNota(int id);
}
