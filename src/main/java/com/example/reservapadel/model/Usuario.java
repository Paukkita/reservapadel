package com.example.reservapadel.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

// Entidad JPA que representa la tabla "usuarios" en la base de datos
@Entity
@Table(name="usuarios")
public class Usuario {

    //Defino ID email
    @Id
    private String email;

    //Defino variables de clase
    private String nombre;
    private String password;
    private LocalDate fechaRegistro;

    //Constructor
    public Usuario(String email, String nombre, String password, LocalDate fechaRegistro) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }

    //Constructor vacio
    public Usuario() {}
    //Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    //Conecta un usuario con varias reservas, borra/cambia todo junto, y evita bucles infinitos al convertir a JSON.
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
