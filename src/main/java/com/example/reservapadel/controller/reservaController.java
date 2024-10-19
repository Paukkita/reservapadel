package com.example.reservapadel.controller;

import com.example.reservapadel.DTO.ReservaDTO;
import com.example.reservapadel.model.Reserva;
import com.example.reservapadel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class reservaController {
    @Autowired
    private ReservaService servicioReserva;

    /*
    Ejemplo para ejecutar el POST en POSTMAN correctamente
   http://localhost:8080/reservas

   {
       "usuarioEmail": "pau@example.com",
       "pistaNombre": "Pista 2",
       "fechaReserva": "2024-10-10",
       "horaInicio": "09:00",
       "horaFin": "10:30"
   }
  */
    // Método para manejar las solicitudes POST a "/reservas"
    @PostMapping
    public Reserva crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            LocalTime horaInicio = LocalTime.parse(reservaDTO.getHoraInicio(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime horaFin = LocalTime.parse(reservaDTO.getHoraFin(), DateTimeFormatter.ofPattern("HH:mm"));

            return servicioReserva.crearReserva(
                    reservaDTO.getUsuarioEmail(),
                    reservaDTO.getPistaNombre(),
                    reservaDTO.getFechaReserva(),
                    horaInicio,
                    horaFin
            );
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de hora inválido: " + e.getMessage());
        }
    }

    /*
        Ejemplo para ejecutar el GET en POSTMAN correctamente
        http://localhost:8080/reservas/pista/Pista 2?fecha=2024-10-10
       */

    // Método para manejar las solicitudes POST a "/reservas/pista/Pista 2?fecha=2024-10-10"
    @GetMapping("/pista/{pistaNombre}")
    public List<Reserva> obtenerReservasPorPistaYFecha(@PathVariable String pistaNombre, @RequestParam String fecha) {
        LocalDate fechaReserva = LocalDate.parse(fecha);
        return servicioReserva.obtenerReservasPorPistaYFecha(pistaNombre, fechaReserva);
    }
}
