package com.example.reservapadel.repository;

import com.example.reservapadel.model.Pista;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para la entidad Pista
public interface PistaRepository extends JpaRepository<Pista,String> {
}
