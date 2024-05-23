package org.serratec.appsocial.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "autor")
	private List<Postagem> postagens;

	@OneToMany(mappedBy = "seguidor")
	private List<Relacionamento> seguidores;

	@OneToMany(mappedBy = "seguido")
	private List<Relacionamento> seguindo;

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public List<Relacionamento> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Relacionamento> seguidores) {
		this.seguidores = seguidores;
	}

	public List<Relacionamento> getSeguindo() {
		return seguindo;
	}

	public void setSeguindo(List<Relacionamento> seguindo) {
		this.seguindo = seguindo;
	}

	// Métodos da interface UserDetails

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Retorne as autoridades do usuário (roles/perfis)
		return null; // substituir por sua lógica
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return senha;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true; // substituir por sua lógica, se necessário
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true; // substituir por sua lógica, se necessário
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true; // substituir por sua lógica, se necessário
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true; // substituir por sua lógica, se necessário
	}

	@Override
	public String toString() {
		return "* Código: " + id + "\n* Nome: " + nome + "\n* Email: " + email;
	};
}
