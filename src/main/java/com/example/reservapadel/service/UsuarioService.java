package com.example.reservapadel.service;

import com.example.reservapadel.model.Usuario;
import com.example.reservapadel.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Indica que esta clase es un servicio de Spring
@Service
public class UsuarioService {
    // Inyección automática de la dependencia UsuarioRepository
    @Autowired
    private UsuarioRepository repositorioUsuario;

    // Marca el método como transaccional
    @Transactional
    //Metodo para crear usuario
    public void crearUsuario(Usuario usuario) {
        if (repositorioUsuario.existsById(usuario.getEmail())){
            throw new RuntimeException("El usuario con este email ya existe");
        }
        usuario.setFechaRegistro(LocalDate.now());
        repositorioUsuario.save(usuario);
    }

    // Busca un usuario por su email y devuelve un Optional.
    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return repositorioUsuario.findById(email);
    }

    // Devuelve una lista de todos los usuarios.
    public List<Usuario> obtenerTodosLosUsuarios() {
        return repositorioUsuario.findAll();
    }

    // Busca el usuario existente por email.
    public Usuario actualizarUsuario(String email, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioQueExiste = repositorioUsuario.findById(email);

        if (usuarioQueExiste.isPresent()) {
            Usuario Usuario = usuarioQueExiste.get();
            Usuario.setNombre(usuarioActualizado.getNombre());
            Usuario.setPassword(usuarioActualizado.getPassword());
            return repositorioUsuario.save(Usuario);
        } else {
            throw new IllegalArgumentException("El usuario con email " + email + " no existe.");
        }

    }
    // Elimina el usuario si existe, lanza excepción si no.
    public void eliminarUsuario(String email) {
        if (!repositorioUsuario.existsById(email)) {
            throw new IllegalArgumentException("El usuario con email " + email + " no existe.");
        } else {
            repositorioUsuario.deleteById(email);
        }
    }


}
