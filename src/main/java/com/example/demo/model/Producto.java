package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer id;

    @Column(name = "clave", length = 15)
    private String clave;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "idCodigoProducto")
    private List<ListaCompraDetalle> detalles;

}
