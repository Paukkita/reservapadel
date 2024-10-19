package com.example.reservapadel.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;

//Defino una entidad
@Entity
public class Reserva {
    // Clave primaria compuesta para la entidad Reserva
    @EmbeddedId
    private ReservaId reservaId;
    //Defino variables de clase
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // Relación ManyToOne con la entidad Usuario, clave foránea 'usuarioEmail' (no insertable ni actualizable)
    @ManyToOne
    @JoinColumn(name = "usuarioEmail", insertable = false, updatable = false)
    private Usuario usuario;

    // Relación ManyToOne con la entidad Pista, clave foránea 'pistaNombre' (no insertable ni actualizable)
    @ManyToOne
    @JoinColumn(name = "pistaNombre", insertable = false, updatable = false)
    private Pista pista;

    // Getters y Setters
    public ReservaId getReservaId() {
        return reservaId;
    }

    public void setReservaId(ReservaId reservaId) {
        this.reservaId = reservaId;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }
}
