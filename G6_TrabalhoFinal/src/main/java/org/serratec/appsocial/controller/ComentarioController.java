package org.serratec.appsocial.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.appsocial.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/comentarios")
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	GetMapping 
	public ResponseEntity<List<Comentario>> listar() {
		return ResponseEntity.ok(comentarioRepository.findAll());
	}

	@GetMapping("/{id}") 
	public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
		Optional<Comentario> livroOpt = comentarioRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Comentario createLivro(@Valid @RequestBody Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	@PutMapping("/{id}") 
	public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @Valid @RequestBody Comentario comentario) {
		if (!comentarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		comentario.setId(id);
		comentario = comentarioRepository.save(comentario);
		return ResponseEntity.ok(comentario);
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!comentarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		comentarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
