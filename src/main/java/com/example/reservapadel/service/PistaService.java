package com.example.reservapadel.service;

import com.example.reservapadel.model.Pista;
import com.example.reservapadel.repository.PistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta clase es un servicio de Spring
@Service
public class PistaService {
    // Inyección automática de la dependencia PistaRepository
    @Autowired
    private PistaRepository repositorioPista;

    // Marca el método como transaccional
    @Transactional
    public void crearPista(Pista pista) {
        repositorioPista.save(pista);
    }

    public List<Pista> listarPistas() {
        return repositorioPista.findAll();
    }

    // Marca el método como transaccional
    @Transactional
    public void eliminarPista(String nombre) {
        repositorioPista.deleteById(nombre);
    }
    // Busca una pista por su ID (email) y devuelve un Optional para manejar el caso de que no se encuentre
    public Optional<Pista> buscarPista(String email) {
        return repositorioPista.findById(email);
    }
}
