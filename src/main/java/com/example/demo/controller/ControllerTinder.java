package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;


@Controller
public class ControllerTinder {
    @Autowired
    private UsuarioService usuarioService;
    
    private static final Logger logger = LoggerFactory.getLogger(ControllerTinder.class);
    
    @GetMapping("/")
    public String inicio(ModelMap model) {
        logger.info(" --- En INICIO ");
        model.addAttribute("user", new Usuario());
        return "inicio";
    }
    
    @RequestMapping("/listado")
    public String listado(@ModelAttribute("user") Usuario user ,ModelMap model) {
        logger.info("En el listado");
        model.addAttribute("user", user);
        model.addAttribute("listado", usuarioService.findContactos(user.getIdusuario()));
        return "bienvenida";
    }
    
    @PostMapping("/save")
    public String saveUser(@ModelAttribute Usuario user, ModelMap model) {
        logger.info("RegistroUsuario");
        model.addAttribute("user", user);
        usuarioService.create(user);
        return "redirect:/listado";
    }
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute ("user") Usuario user, ModelMap model) {
        if(usuarioService.findById(user.getIdusuario())!=null) {
            model.addAttribute("user", usuarioService.findById(user.getIdusuario()));
            model.addAttribute("listado", usuarioService.findContactos(user.getIdusuario()));
            return "bienvenida";
        }else{
            return "redirect:/";
        }
    }
    
    /* HECHO EL 01/07/2019 */
    @PostMapping("/like")
    public String like(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
        logger.info("----- Ejecutando query en el Controller -----");
        logger.info("id1 que recibe el REST: "+id1+" -- | -- id2 que recibe el REST: "+id2);
        usuarioService.like(id1, id2);
        model.addAttribute("user", usuarioService.findById(id1));
        model.addAttribute("listado", usuarioService.findContactos(id1));
        return "bienvenida";
    } 
    
    @PostMapping("/dislike")
    public String dislike(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
        logger.info("----- Ejecutando query en el Controller -----");
        logger.info("id1 que recibe el REST: "+id1+" -- | -- id2 que recibe el REST: "+id2);
        usuarioService.dislike(id1, id2);
        model.addAttribute("user", usuarioService.findById(id1));
        model.addAttribute("listado", usuarioService.findContactos(id1));
        return "bienvenida";
    }
    
    @GetMapping ("/matches")
    public String verMatches() {
    	return "matches";
    }
    
}
