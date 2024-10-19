package com.example.reservapadel.controller;

import com.example.reservapadel.DTO.ReservaDTO;
import com.example.reservapadel.model.Reserva;
import com.example.reservapadel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Indica que esta clase es un controlador REST, que maneja solicitudes HTTP.
@RestController
@RequestMapping("/reservas")
public class reservaController {
    // Permite la inyección automática de dependencias en Spring.
    @Autowired
    private ReservaService servicioReserva;


    /*
    Ejemplo para ejecutar el POST en POSTMAN correctamente
   http://localhost:8080/reservas
    {
 "usuarioEmail": "pau@example.com",
 "pistaNombre": "Pista 2",
 "fecha": "2024-10-10",
 "horaInicio": "09:00",
 "horaFin": "10:30"
 }*/
    // Método para manejar las solicitudes POST a "/reservas"
    @PostMapping
    // El anotador @RequestBody indica que el objeto reservaDT0 debe ser tomado del cuerpo de la petición HTTP.
    public Reserva crearReserva(@RequestBody ReservaDTO reservaDTO) {
        // Llama al servicio para crear la reserva utilizando los datos del objeto
        return servicioReserva.crearReserva(
                reservaDTO.getUsuarioEmail(),
                reservaDTO.getPistaNombre(),
                reservaDTO.getFechaReserva(),
                reservaDTO.getHoraInicio(),
                reservaDTO.getHoraFin()
        );
    }

    // Método para manejar las solicitudes GET a "/reservas/pista/{pistaNombre}"
    @GetMapping("/pista/{pistaNombre}")
    public List<Reserva> obtenerReservasPorPistaYFecha(
            @PathVariable String pistaNombre,
            @RequestParam String fecha) {

        // Convertir el String fecha a LocalDate
        LocalDate fechaReserva = LocalDate.parse(fecha);

        // Llamar al servicio para obtener las reservas
        return servicioReserva.obtenerReservasPorPistaYFecha(pistaNombre, fechaReserva);
    }

}
