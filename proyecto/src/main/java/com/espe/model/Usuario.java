package com.espe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	@Column
	private String username;
	@Column
	private String nombreUsuario;
	@Column
	private String apellidoUsuario;
	@Column
	private String claveUsuario;
	@Column
	private String cedulaUsuario;
	@Column
	private String telefonoUsuario;
	@Column
	private String correoUsuario;
	@Column
	private String fotoUsuario;
	@Column
	private int idTipo;
	@Column
	private int idEstado;
	
	public Usuario() {
		super();
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getFotoUsuario() {
		return fotoUsuario;
	}

	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", nombreUsuario=" + nombreUsuario
				+ ", apellidoUsuario=" + apellidoUsuario + ", claveUsuario=" + claveUsuario + ", cedulaUsuario="
				+ cedulaUsuario + ", telefonoUsuario=" + telefonoUsuario + ", correoUsuario=" + correoUsuario
				+ ", fotoUsuario=" + fotoUsuario + ", idTipo=" + idTipo + ", idEstado=" + idEstado + "]";
	}
}
