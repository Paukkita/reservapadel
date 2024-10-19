package com.example.reservapadel.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private String usuarioEmail;
    private String pistaNombre;
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;

//Constructor
    public ReservaDTO(String usuarioEmail, String pistaNombre, LocalDate fechaReserva, LocalTime horaInicio, LocalTime horaFin) {
        this.usuarioEmail = usuarioEmail;
        this.pistaNombre = pistaNombre;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    // Getters y Setters
    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getPistaNombre() {
        return pistaNombre;
    }

    public void setPistaNombre(String pistaNombre) {
        this.pistaNombre = pistaNombre;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }


}
