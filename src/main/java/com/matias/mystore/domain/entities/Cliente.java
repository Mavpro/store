package com.matias.mystore.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> facturas;

    public Cliente() {
    }

    public Cliente(String nombre, String correoElectronico, String telefono,List<Invoice> facturas) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.facturas=facturas;
    }


}