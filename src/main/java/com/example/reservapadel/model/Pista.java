package com.example.reservapadel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

// Entidad JPA que representa la tabla "pistas" en la base de datos
@Entity
@Table(name="pistas")
public class Pista {
    //Defino ID nombre
    @Id
    private String nombre;

    //Defino variables de clase
    private String ubicacion;
    private String tipo;

    //Genero el constructor con los atributos
    public Pista(String nombre, String ubicacion, String tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }
    //Genero un constructor vacio
    public Pista() {}

    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //Conecta una pista con varias reservas, borra/cambia todo junto, y evita bucles infinitos al convertir a JSON.
    @OneToMany(mappedBy = "pista", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Reserva> reservas;

    // Getter para acceder a las reservas
    public List<Reserva> getReservas() { // Asegúrate de tener este método
        return reservas;
    }

    // Setter para modificar las reservas
    public void setReservas(List<Reserva> reservas) { // Asegúrate de tener este método
        this.reservas = reservas;
    }


}
