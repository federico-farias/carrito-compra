package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ListaCompraDetalleId {

    @Column(name = "idListaCompra")
    private Integer idListaCompra;

    @Column(name = "idCodigoProducto")
    private Integer idCodigoProducto;

    public ListaCompraDetalleId() {}

    public ListaCompraDetalleId(Integer idListaCompra, Integer idCodigoProducto) {
        this.idListaCompra = idListaCompra;
        this.idCodigoProducto = idCodigoProducto;
    }

}
