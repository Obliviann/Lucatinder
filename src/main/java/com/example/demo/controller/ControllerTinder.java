package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;

/**
 * Clase controller para ejecutar la aplicación en MVC
 * 
 * @author grupo3
 * 
 */

@Controller
public class ControllerTinder {
	@Autowired
	private UsuarioService usuarioService;

	private static final Logger logger = LoggerFactory.getLogger(ControllerTinder.class);

	/**
	 * Método mapeado para ser la pantalla de inicio de la aplicación, con las
	 * opciones de login o alta de usuario
	 * 
	 * @author
	 * @param model
	 * @return página de inicio de la app
	 */
	@GetMapping("/")
	public String inicio(ModelMap model) {
		logger.info(" --- En INICIO ");
		model.addAttribute("user", new Usuario());
		return "inicio";
	}

	/**
	 * Método para mostrar el listado de usuarios en la pantalla de bienvenida.
	 * Recibe el id del usuario que inició sesión como parámetro
	 * 
	 * @param id
	 * @param model
	 * @return página de bienvenida
	 */
	@RequestMapping("/listado")
	public String listado(@RequestParam("id") int id, ModelMap model) {
		logger.info("En el listado");
		model.addAttribute("user", usuarioService.findById(id));
		model.addAttribute("listado", usuarioService.findContactos(id));
		return "bienvenida";
	}

	/**
	 * Método mapeado para dar de alta un Usuario recibido por parámetro en la BBDD
	 * 
	 * @param user
	 * @param model
	 * @return redirect a la página /listado
	 */
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Usuario user, ModelMap model) {
		logger.info("RegistroUsuario");
		model.addAttribute("user", user);
		usuarioService.create(user);
		return "redirect:/listado";
	}

	/**
	 * Método mapeado para loguear un Usuario en caso de que esté registrado en la
	 * base de datos
	 * 
	 * @param user
	 * @param model
	 * @return página de bienvenida si el Usuario está registrado
	 * @return página de inicio si el Usuario no está registrado
	 */
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") Usuario user, ModelMap model) {
		if (usuarioService.findById(user.getIdusuario()) != null) {
			model.addAttribute("user", usuarioService.findById(user.getIdusuario()));
			model.addAttribute("listado", usuarioService.findContactos(user.getIdusuario()));
			return "bienvenida";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * Método mapeado para dar like a un usuario de un listado en pantalla. El
	 * usuario se elimina de la vista una vez que se le da like
	 * 
	 * @param id1
	 * @param id2
	 * @param model
	 * @return página de bienvenida actualizada
	 */
	@PostMapping("/like")
	public String like(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
		logger.info("----- Ejecutando query en el Controller -----");
		logger.info("id1 que recibe el REST: " + id1 + " -- | -- id2 que recibe el REST: " + id2);
		usuarioService.like(id1, id2);
		model.addAttribute("user", usuarioService.findById(id1));
		model.addAttribute("listado", usuarioService.findContactos(id1));
		return "bienvenida";
	}

	/**
	 * Método mapeado para dar disLike a un usuario de un listado en pantalla. El
	 * usuario se elimina de la vista una vez que se le da disLike
	 * 
	 * @param id1
	 * @param id2
	 * @param model
	 * @return página de bienvenida actualizada
	 */
	@PostMapping("/dislike")
	public String dislike(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
		logger.info("----- Ejecutando query en el Controller -----");
		logger.info("id1 que recibe el REST: " + id1 + " -- | -- id2 que recibe el REST: " + id2);
		usuarioService.dislike(id1, id2);
		model.addAttribute("user", usuarioService.findById(id1));
		model.addAttribute("listado", usuarioService.findContactos(id1));
		return "bienvenida";
	}

	/**
	 * Método mapeado para mostrar en pantalla el listado de matches del usuario con
	 * sesión iniciada
	 * 
	 * @param id
	 * @param model
	 * @return página de matches
	 */
	@PostMapping("/matches")
	public String verMatches(@RequestParam("id") int id, ModelMap model) {
		logger.info("-----------En MATCHES");
		model.addAttribute("user", usuarioService.findById(id));
		model.addAttribute("matches", usuarioService.verMatches(id));
		return "matches";
	}

	/**
	 * Método mapeado para mostrar en pantalla el perfil completo del usuario con
	 * sesión iniciada
	 * 
	 * @param id
	 * @param model
	 * @return página del perfil
	 */
	@PostMapping("/perfil")
	public String verPerfil(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("user", usuarioService.findById(id));
		return "perfil";
	}

	/**
	 * Método mapeado para cerrar sesión en la aplicación
	 * 
	 * @return página de inicio de la aplicación
	 */
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/";
	}

}
