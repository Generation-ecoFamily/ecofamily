package com.generation.ecofamily.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter

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
	
	
	
	

}
