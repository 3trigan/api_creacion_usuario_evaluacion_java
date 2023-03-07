package cl.rreyes.demo.repository;

import cl.rreyes.demo.model.UsuarioBean;

public interface UsuarioModRepository<T, S> {
	public UsuarioBean findByEmail(String email);
}
