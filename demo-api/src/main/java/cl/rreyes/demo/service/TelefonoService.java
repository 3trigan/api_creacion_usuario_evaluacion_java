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
public class TelefonoService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TelefonoRepository telefonoRepository;

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
