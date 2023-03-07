package cl.rreyes.demo.repository;

import org.springframework.data.repository.CrudRepository;

import cl.rreyes.demo.model.TelefonoBean;

public interface TelefonoRepository
		extends CrudRepository<TelefonoBean, String> {

	
}
