package com.generation.ecofamily.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres ")
	private String nome;

	private String sobrenome;

	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O email é obrigatório.")
	private String email;

	@NotBlank(message = "A senha é obrigatória.")
	private String senha;

	private String foto;

	@NotNull(message = "O tipo é obrigatório")
	@Min(0)
	@Max(1)
	private int tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos;

	public Usuario(Long id, String nome, String sobrenome, String email, String senha, String foto, int tipo) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
	}

	public Usuario() {

	}

}
