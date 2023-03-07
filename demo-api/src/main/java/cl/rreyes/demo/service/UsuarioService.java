package cl.rreyes.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.rreyes.demo.model.TelefonoBean;
import cl.rreyes.demo.model.UsuarioBean;
import cl.rreyes.demo.repository.TelefonoRepository;
import cl.rreyes.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TelefonoRepository telefonoRepository;

	public List<UsuarioBean> getAllUsuarios() {
		List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
		usuarioRepository.findAll().forEach(UsuarioBean -> usuarios.add(UsuarioBean));
		return usuarios;
	}

	public UsuarioBean getUsuarioById(String id) {
		return usuarioRepository.findById(id).get();
	}

	public void saveOrUpdate(UsuarioBean usuario) {
		UUID uuid = UUID.randomUUID();
		UUID uutoken = UUID.randomUUID();
		Date tsCreacion = new Date();

		usuario.setId(uuid.toString());
		usuario.setTsCreacion(tsCreacion);
		usuario.setTokenAcceso(uutoken.toString());
		usuarioRepository.save(usuario);
		TelefonoBean tnew;
		for (TelefonoBean t : usuario.getListaTelefonos()) {
			tnew = new TelefonoBean();
			tnew.setRelListaTelefonos(usuario);
			tnew.setPhone(t.getPhone());
			tnew.setCitycode(t.getCitycode());
			tnew.setContrycode(t.getContrycode());
			telefonoRepository.save(tnew);
		}

	}

	public void deleteUsuario(String id) {
		usuarioRepository.deleteById(id);
	}

	public UsuarioBean findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public List<TelefonoBean> getAllTelefonos() {
		List<TelefonoBean> telefonos = new ArrayList<TelefonoBean>();
		telefonoRepository.findAll().forEach(TelefonoBean -> telefonos.add(TelefonoBean));
		return telefonos;
	}

	public TelefonoBean getTelefonoById(String id) {
		return telefonoRepository.findById(id).get();
	}

	public void saveOrUpdate(TelefonoBean telefono) {
		telefonoRepository.save(telefono);
	}

	public void deleteTelefono(String id) {
		telefonoRepository.deleteById(id);
	}

}
