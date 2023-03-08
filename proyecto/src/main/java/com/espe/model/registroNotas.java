package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notas")
public class registroNotas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNotas;
	@Column
	private int idUsuario;
	@Column
	private int idMateria;
	@Column
	private double nota1;
	@Column
	private double nota2;
	@Column
	private double nota3;
	
	
	public registroNotas() {
		super();
	}


	public int getIdNotas() {
		return idNotas;
	}


	public void setIdNotas(int idNotas) {
		this.idNotas = idNotas;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}


	public double getNota1() {
		return nota1;
	}


	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}


	public double getNota2() {
		return nota2;
	}


	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}


	public double getNota3() {
		return nota3;
	}


	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}


	@Override
	public String toString() {
		return "registroNotas [idNotas=" + idNotas + ", idUsuario=" + idUsuario + ", idMateria=" + idMateria
				+ ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + "]";
	}
	

	
	
	
}
