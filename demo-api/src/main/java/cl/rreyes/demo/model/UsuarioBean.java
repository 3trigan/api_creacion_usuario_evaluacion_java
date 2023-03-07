package cl.rreyes.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class UsuarioBean {

	@Id
	@Column
	private String id;
	@Column
	private Date tsCreacion;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Boolean estado;
	@Column
	private String tokenAcceso;
	@Column
	private Date ultimaConexion;
	@Column
	private Date tsModificacion;
	
	@OneToMany(mappedBy = "relListaTelefonos")
	public List<TelefonoBean> listaTelefonos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTsCreacion() {
		return tsCreacion;
	}

	public void setTsCreacion(Date tsCreacion) {
		this.tsCreacion = tsCreacion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getTsModificacion() {
		return tsModificacion;
	}

	public void setTsModificacion(Date tsModificacion) {
		this.tsModificacion = tsModificacion;
	}

	public String getTokenAcceso() {
		return tokenAcceso;
	}

	public void setTokenAcceso(String tokenAcceso) {
		this.tokenAcceso = tokenAcceso;
	}

	public Date getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(Date ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public List<TelefonoBean> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<TelefonoBean> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

}
