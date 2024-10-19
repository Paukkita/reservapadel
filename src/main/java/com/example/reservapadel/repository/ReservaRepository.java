package com.example.reservapadel.repository;

import com.example.reservapadel.model.Reserva;
import com.example.reservapadel.model.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

//Interfaz para operaciones CRUD de la entidad Reserva, incluyendo la búsqueda de reservas por nombre de pista y fecha.
public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {
    List<Reserva> findAllByPistaNombreAndFechaReserva(String pistaNombre, LocalDate fecha);
}
