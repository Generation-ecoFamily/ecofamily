package com.generation.ecofamily.repository;

import com.generation.ecofamily.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository {

    public Optional<Usuario> findByUsuario(String usuario);

}
