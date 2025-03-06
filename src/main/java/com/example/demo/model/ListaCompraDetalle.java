package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaCompraDetalle")
public class ListaCompraDetalle {

    @EmbeddedId
    private ListaCompraDetalleId id;

    @ManyToOne
    @MapsId("idListaCompra")
    @JoinColumn(name = "idListaCompra", nullable = false)
    private ListaCompra listaCompra;

    @ManyToOne
    @MapsId("idCodigoProducto")
    @JoinColumn(name = "idCodigoProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;
    
}
