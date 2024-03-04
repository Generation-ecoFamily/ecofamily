package com.generation.ecofamily.dto;

import com.generation.ecofamily.model.Produto;
import com.generation.ecofamily.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionDTO {

    @NotNull
    private Usuario comprador;

    @NotNull
    private Produto produto;

    @NotNull
    private int quantidade;
}
