package cl.rreyes.demo.repository;

import org.springframework.data.repository.CrudRepository;

import cl.rreyes.demo.model.UsuarioBean;

public interface UsuarioRepository
		extends CrudRepository<UsuarioBean, String>, UsuarioModRepository<UsuarioBean, String> {

	
}
