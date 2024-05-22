package org.serratec.appsocial.controller;

import org.serratec.appsocial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/usuarios")
public class ComentarioController {
	
	@Autowired
	private UsuarioService usuarioService;

}
