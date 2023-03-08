package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estados {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstado;
	@Column
	private String estado;
	
	
	public Estados() {
		super();
	}


	public int getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Estados [idEstado=" + idEstado + ", estado=" + estado + "]";
	}
}
