package com.generation.ecofamily.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String token;
}
