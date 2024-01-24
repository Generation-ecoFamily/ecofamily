package com.generation.ecofamily.repository;

import com.generation.ecofamily.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository {

    public Optional<Usuario> findByEmail(String email);

}
