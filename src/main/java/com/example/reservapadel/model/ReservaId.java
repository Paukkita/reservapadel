package com.example.reservapadel.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//Clase embebible que representa la clave primaria compuesta de la entidad Reserva
@Embeddable
public class ReservaId  implements Serializable {
    private String usuarioEmail;  // o el campo correspondiente
    private String pistaNombre;

    // Constructor con parámetros
    public ReservaId(String usuarioEmail, String pistaNombre) {
        this.usuarioEmail = usuarioEmail;
        this.pistaNombre = pistaNombre;
    }

    // Constructor vacío
    public ReservaId() {}

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


    // Métodos equals y hashCode para garantizar la correcta comparación y funcionamiento en colecciones
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservaId)) return false;
        ReservaId reservaId = (ReservaId) o;
        return Objects.equals(usuarioEmail, reservaId.usuarioEmail) &&
                Objects.equals(pistaNombre, reservaId.pistaNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioEmail, pistaNombre);
    }
}
