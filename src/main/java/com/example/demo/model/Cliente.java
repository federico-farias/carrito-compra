package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column
	private String nombre;
	
	@Column
	private Integer activo;
	
	@OneToMany(mappedBy = "cliente")
    private List<ListaCompra> listasCompra;

}
