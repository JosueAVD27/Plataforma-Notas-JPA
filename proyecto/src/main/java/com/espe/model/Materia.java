package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMateria;
	@Column
	private int nrc;
	@Column
	private String nombreMateria;
	@Column
	private int idUsuario;
	@Column
	private int idEstado;
	
	
	public Materia() {
		super();
	}


	public int getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}


	public int getNrc() {
		return nrc;
	}


	public void setNrc(int nrc) {
		this.nrc = nrc;
	}


	public String getNombreMateria() {
		return nombreMateria;
	}


	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}


	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", nrc=" + nrc + ", nombreMateria=" + nombreMateria + ", idUsuario="
				+ idUsuario + ", idEstado=" + idEstado + "]";
	}
}
