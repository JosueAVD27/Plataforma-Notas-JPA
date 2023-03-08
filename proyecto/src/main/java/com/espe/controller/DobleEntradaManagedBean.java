package com.espe.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "dobleEntradaManagedBean")
@ViewScoped
public class DobleEntradaManagedBean {
	
	@ManagedProperty(value = "#{materiaManagedBean}")
	private MateriaManagedBean materiaManagedBean;

	@ManagedProperty(value = "#{usuarioManagedBean}")
	private UsuarioManagedBean usuarioManagedBean;

	// Agregar getter y setter para materiaManagedBean
	public MateriaManagedBean getMateriaManagedBean() {
	    return materiaManagedBean;
	}

	public void setMateriaManagedBean(MateriaManagedBean materiaManagedBean) {
	    this.materiaManagedBean = materiaManagedBean;
	}

	// Agregar getter y setter para usuarioManagedBean
	public UsuarioManagedBean getUsuarioManagedBean() {
	    return usuarioManagedBean;
	}

	public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
	    this.usuarioManagedBean = usuarioManagedBean;
	}

	// ...

	public String sendData() {
	    materiaManagedBean.nuevoMateria();
	    usuarioManagedBean.obtenerUsuario();
	    return null;
	}
}
