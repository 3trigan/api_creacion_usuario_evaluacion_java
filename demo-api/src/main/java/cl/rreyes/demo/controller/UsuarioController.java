package cl.rreyes.demo.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.rreyes.demo.model.TelefonoBean;
import cl.rreyes.demo.model.UsuarioBean;
import cl.rreyes.demo.repository.UsuarioModRepository;
import cl.rreyes.demo.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UsuarioModRepository<UsuarioBean, String> modRepository;

	private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	@GetMapping("/usuario")
	private List<UsuarioBean> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@GetMapping("/usuario/{id}")
	private UsuarioBean getUsuarioById(@PathVariable("id") String id) {
		return usuarioService.getUsuarioById(id);
	}

	@DeleteMapping("/usuario/{id}")
	private void deleteUsuario(@PathVariable("id") String id) {
		usuarioService.deleteUsuario(id);
	}

	@PostMapping("/usuarioNew")
	private String saveUsuarioCheck(@RequestBody UsuarioBean usuario) {
		UsuarioBean u, u2 = new UsuarioBean();
		String mensaje, mod, est, m = "";
		Boolean expEmail, expClave = false;
		u2 = getUsuarioByEmail(usuario.getEmail());
		expEmail = validaEmail(usuario.getEmail());
		expClave = validaClave(usuario.getPassword());
		if (u2 == null && expEmail && expClave) {
			usuarioService.saveOrUpdate(usuario);
			u = usuarioService.getUsuarioById(usuario.getId());
			mod = u.getTsModificacion() != null ? u.getTsModificacion().toString() : u.getTsCreacion().toString();
			est = u.getEstado() == true ? "Active" : "Inactoive";
			m = "Mensaje: Usuario creado exitosamente, id:" + u.getId() + ", created: " + u.getTsCreacion().toString()
					+ ", modificado: " + mod + ", isactive: " + est;
		} else {
			if (u2 != null) {
				m = "Mensaje: El Correo ya esta registrado";
			}
			if (u2 == null && !expEmail) {
				m = "Mensaje: El correo es invalido";
			}
			if (u2 == null && !expClave) {
				m = "Mensaje: La clave es invalida";
			}
		}
		mensaje = m;
		return mensaje;
	}

	public UsuarioBean getUsuarioByEmail(String email) {
		UsuarioBean u = new UsuarioBean();
		u = modRepository.findByEmail(email);
		return u;
	}

	public static Boolean validaEmail(String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static Boolean validaClave(String clave) {
		if (PASSWORD_PATTERN.matcher(clave).matches()) {
			return true;
		} else {
			return false;
		}
	}
}