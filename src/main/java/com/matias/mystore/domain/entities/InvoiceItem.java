package com.matias.mystore.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factura_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Invoice invoice;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer cantidad, Producto producto, Invoice invoice) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.invoice = invoice;
    }

    public Double getImporte() {
        return this.producto.getPrecio() * this.cantidad;
    }

}
