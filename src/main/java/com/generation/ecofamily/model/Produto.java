package com.generation.ecofamily.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres ")
	private String nome;
	
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O preço é obrigatório.")
	@Positive(message = "O preço deve ser maior que zero.")
	private BigDecimal preco;
	
	@NotNull(message = "A quantidade é obrigatória.")
	@PositiveOrZero(message = "A quantidade deve ser igual ou maior que zero.")
	private Integer quantidade;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

	@UpdateTimestamp
	private LocalDateTime data;

	public Produto(String nome, String descricao, BigDecimal preco, Integer quantidade, String foto, Categoria categoria, Usuario usuario) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.foto = foto;
		this.categoria = categoria;
		this.usuario = usuario;
	}
}
