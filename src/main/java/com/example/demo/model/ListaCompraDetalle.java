package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaCompraDetalle")
@IdClass(ListaCompraDetalleId.class)
public class ListaCompraDetalle {

    //@EmbeddedId
    //private ListaCompraDetalleId id;

    @Id
    @ManyToOne
    //@MapsId("idListaCompra")
    @JoinColumn(name = "idListaCompra", nullable = false)
    private ListaCompra idListaCompra;

    @Id
    @ManyToOne
    //@MapsId("idCodigoProducto")
    @JoinColumn(name = "idCodigoProducto", nullable = false)
    private Producto idCodigoProducto;

    @Column(name = "cantidad")
    private Integer cantidad;
    
}
