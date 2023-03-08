package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipousuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipo;
	@Column
	private String tipo;
	
	
	public TipoUsuario() {
		super();
	}


	public int getIdTipo() {
		return idTipo;
	}


	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "TipoUsuario [idTipo=" + idTipo + ", tipo=" + tipo + "]";
	}
}
