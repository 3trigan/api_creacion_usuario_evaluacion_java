package cl.rreyes.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TelefonoBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private UsuarioBean relListaTelefonos;
	@Column
	private String phone;
	@Column
	private String citycode;
	@Column
	private String contrycode;

	
	/*public TelefonoBean(UsuarioBean relListaTelefonos, String phone, String citycode, String contrycode) {
		this.relListaTelefonos = relListaTelefonos;
		this.phone = phone;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public UsuarioBean getRelListaTelefonos() {
		return relListaTelefonos;
	}

	public void setRelListaTelefonos(UsuarioBean relListaTelefonos) {
		this.relListaTelefonos = relListaTelefonos;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

}
