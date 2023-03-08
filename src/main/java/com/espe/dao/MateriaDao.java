package com.espe.dao;

import java.util.List;

import com.espe.model.Materia;

public interface MateriaDao {
	// Guardar materia
	public void guardarMateria(Materia materia);

	// Editar materia
	public void editarMateria(Materia materia);

	// Buscar materia
	public Materia buscarMateria(int id);

	// Obtener todas las materias
	public List<Materia> obtenerMateria();

	// Eliminar materia
	public void eliminarMateria(int id);
}
