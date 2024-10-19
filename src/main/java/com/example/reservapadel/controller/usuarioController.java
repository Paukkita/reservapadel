package com.example.reservapadel.controller;

import com.example.reservapadel.model.Usuario;
import com.example.reservapadel.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Indica que esta clase es un controlador REST, que maneja solicitudes HTTP.
@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    // Permite la inyección automática de dependencias en Spring.
    @Autowired
    private UsuarioService servicioUsuario;


   /*
    Ejemplo para ejecutar el POST en POSTMAN correctamente
   http://localhost:8080/usuarios/registro
    {
        "nombre": "Pau",
            "email": "Pau@example.com",
            "password": "contraseña123"
    }
    */
    // Método para manejar las solicitudes POST a "/usuarios"
    @PostMapping("/registro")
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        servicioUsuario.crearUsuario(usuario);
        return usuario;
    }


   /*
    Ejemplo para ejecutar el GET en POSTMAN correctamente
   http://localhost:8080/usuarios
   */

    // Método para manejar las solicitudes GET a "/obtenerLista"
    @GetMapping()
    public List<Usuario> listarUsuarios() {
        return servicioUsuario.obtenerTodosLosUsuarios();
    }


}
