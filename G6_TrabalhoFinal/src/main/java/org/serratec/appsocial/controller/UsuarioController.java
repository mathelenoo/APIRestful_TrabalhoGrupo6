package org.serratec.appsocial.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.appsocial.model.Usuario;
import org.serratec.appsocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping // Método para Listar todos os Usuários | localhost:8080/usuarios
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/{id}") // Método para listar usuário por ID | localhost:8080/usuarios/id
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		Optional<Usuario> livroOpt = usuarioRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping // Método para criar um novo usuário
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario createLivro(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/{id}") // Método para atualizar um usuário
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		if (!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(id);
		usuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}") // Método para deletar um usuário do banco
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
