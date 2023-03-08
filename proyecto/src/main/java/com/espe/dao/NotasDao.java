package com.espe.dao;

import java.util.List;

import com.espe.model.Notas;
import com.espe.model.registroNotas;

public interface NotasDao {
	// Guardar notas
	public void guardarNota(registroNotas registroNotas);

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
