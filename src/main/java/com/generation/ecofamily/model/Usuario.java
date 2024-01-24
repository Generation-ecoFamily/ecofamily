package com.generation.ecofamily.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	@NotBlank(message = "O sobrenome é obrigatório.")
	@Size(min = 3, message = "O sobrenome deve ter no mínimo 3 caracteres ")
	private String sobrenome;
	
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

}
