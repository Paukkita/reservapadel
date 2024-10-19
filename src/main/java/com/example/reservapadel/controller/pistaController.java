package com.example.reservapadel.controller;

import com.example.reservapadel.model.Pista;
import com.example.reservapadel.service.PistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Indica que esta clase es un controlador REST, que maneja solicitudes HTTP.
@RestController
@RequestMapping("/pistas")
public class pistaController {
    // Permite la inyección automática de dependencias en Spring.
    @Autowired
    private PistaService servicioPista;

    /*
     Ejemplo para ejecutar el GET en POSTMAN correctamente
    http://localhost:8080/pistas
  */
    // Método para manejar las solicitudes GET a "/pistas"
    @GetMapping
    public List<Pista> listaPistas() {
        return servicioPista.listarPistas();
    }

    /*
   Ejemplo para ejecutar el POST en POSTMAN correctamente
  http://localhost:8080/pistas
 {
  "nombre": "Pista 1",
  "ubicacion": "Complejo Deportivo A",
  "tipo": "Pádel"
}*/
    // Método para manejar las solicitudes POST a "/pistas"
    @PostMapping
    // El anotador @RequestBody indica que el objeto pista debe ser tomado del cuerpo de la petición HTTP.
    public Pista agregaPista(@RequestBody Pista pista) {
        servicioPista.crearPista(pista);
        return pista;
    }

}
