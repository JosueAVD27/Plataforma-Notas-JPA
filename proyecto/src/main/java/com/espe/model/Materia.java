package com.espe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuarioD;
	
	@Column
	private int idEstado;
	
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notas> notas = new ArrayList<>();
	
	public Materia() {
		super();
	}

	

	public List<Notas> getNotas() {
		return notas;
	}



	public void setNotas(List<Notas> notas) {
		this.notas = notas;
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


	public Usuario getUsuarioD() {
		return usuarioD;
	}



	public void setUsuarioD(Usuario usuarioD) {
		this.usuarioD = usuarioD;
	}



	public int getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

}
