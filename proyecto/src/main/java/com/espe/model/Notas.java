package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notas")
public class Notas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNotas;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMateria")
    private Materia materia;
	
	@Column
	private double nota1;
	@Column
	private double nota2;
	@Column
	private double nota3;
	

	public Notas() {
		super();
	}


	public int getIdNotas() {
		return idNotas;
	}


	public void setIdNotas(int idNotas) {
		this.idNotas = idNotas;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
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
		return "Notas [idNotas=" + idNotas + ", usuario=" + usuario + ", materia=" + materia + ", nota1=" + nota1
				+ ", nota2=" + nota2 + ", nota3=" + nota3 + "]";
	}
	
}
