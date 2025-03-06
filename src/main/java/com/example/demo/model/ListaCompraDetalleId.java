package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ListaCompraDetalleId {

    @Column(name = "idListaCompra")
    private Integer idListaCompra;

    @Column(name = "idCodigoProducto")
    private Integer idCodigoProducto;

}
