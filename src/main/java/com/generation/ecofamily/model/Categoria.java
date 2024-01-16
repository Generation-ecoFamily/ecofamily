package com.generation.ecofamily.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categorias")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é um campo obrigatório!")
    @Size(min = 4, message = "O tamanho mínimo da descrição é de 4 caracteres!")
    private String descricao;

    @NotNull
    private boolean perecivel;
}
