package org.serratec.appsocial.controller;

import java.util.List;
import java.util.Optional;

public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping // Método para Listar todos os Usuários
	public ResponseEntity<List<Postagem>> listar() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping("/{id}") // Método para listar usuário por ID
	public ResponseEntity<Postagem> buscar(@PathVariable Long id) {
		Optional<Postagem> livroOpt = postagemRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping // Método para criar um novo usuário
	@ResponseStatus(HttpStatus.CREATED)
	public Postagem createLivro(@Valid @RequestBody Postagem postagem) {
		return postagemRepository.save(postagem);
	}

	@PutMapping("/{id}") // Método para atualizar um usuário
	public ResponseEntity<Postagem> atualizar(@PathVariable Long id, @Valid @RequestBody Postagem postagem) {
		if (!postagemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		postagem.setId(id);
		postagem = postagemRepository.save(postagem);
		return ResponseEntity.ok(postagem);
	}

	@DeleteMapping("/{id}") // Método para deletar um usuário do banco
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!postagemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		postagemRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
