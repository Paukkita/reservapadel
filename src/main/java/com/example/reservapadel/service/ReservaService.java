package com.example.reservapadel.service;

import com.example.reservapadel.model.Pista;
import com.example.reservapadel.model.Reserva;
import com.example.reservapadel.model.ReservaId;
import com.example.reservapadel.model.Usuario;
import com.example.reservapadel.repository.PistaRepository;
import com.example.reservapadel.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// Indica que esta clase es un servicio de Spring
@Service
public class ReservaService {
    // Inyección automática de la dependencia PistaRepository
    @Autowired
    private PistaRepository repositorioPista;
    // Inyección automática de la dependencia ReservaRepository
    @Autowired
    private ReservaRepository repositorioReserva;
    // Inyección automática de la dependencia UsuarioService
    @Autowired
    private UsuarioService servicioUsuario;

    //Metodo para obtener las reservas por pista y por fecha
    public List<Reserva> obtenerReservasPorPistaYFecha(String pistaNombre, LocalDate fechaReserva) {
        return repositorioReserva.findAllByPistaNombreAndFechaReserva(pistaNombre, fechaReserva);
    }

    // Marca el método como transaccional
    @Transactional
    public Reserva crearReserva(String usuarioEmail, String pistaNombre, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        // Verificar si el usuario existe
        Usuario usuario = servicioUsuario.buscarUsuarioPorEmail(usuarioEmail)
                .orElseThrow(() -> new IllegalArgumentException("El usuario no existe: " + usuarioEmail));

        // Verificar si la pista existe
        Pista pista = repositorioPista.findById(pistaNombre)
                .orElseThrow(() -> new IllegalArgumentException("La pista no existe: " + pistaNombre));

        // Verificar si ya hay reservas en la misma pista y fecha
        boolean existeConflicto = repositorioReserva.findAllByPistaNombreAndFechaReserva(pistaNombre, fecha)
                .stream()
                .anyMatch(reserva -> (horaInicio.isBefore(reserva.getHoraFin()) && horaFin.isAfter(reserva.getHoraInicio())));

        if (existeConflicto) {
            throw new IllegalArgumentException("Ya existe una reserva en esta pista para el horario solicitado.");
        }

        // Validar que la duración de la reserva sea de 1 hora y media
        long PeriodoEnMinutos = Duration.between(horaInicio, horaFin).toMinutes();
        if (PeriodoEnMinutos != 90) {
            throw new IllegalArgumentException("La duración de la reserva debe ser de 1 hora y 30 minutos.");
        }

        // Crear una nueva reserva
        Reserva reserva = new Reserva();

        // Crear y asignar el ID compuesto
        ReservaId reservaId = new ReservaId();
        reservaId.setUsuarioEmail(usuarioEmail);
        reservaId.setPistaNombre(pistaNombre);
        reserva.setReservaId(reservaId);

        reserva.setFechaReserva(fecha);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFin(horaFin);

        reserva.setUsuario(usuario);
        reserva.setPista(pista);

        // Guardar la reserva en el repositorio
        return repositorioReserva.save(reserva);
    }
}
