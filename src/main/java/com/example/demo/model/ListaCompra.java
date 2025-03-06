package com.example.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaCompra")
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLista")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Cliente cliente;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "fechaUltimaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "idListaCompra")
    private List<ListaCompraDetalle> detalles;

}
