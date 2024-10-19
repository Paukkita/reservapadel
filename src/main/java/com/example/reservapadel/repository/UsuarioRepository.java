package com.example.reservapadel.repository;

import com.example.reservapadel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para la entidad Usuario
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
