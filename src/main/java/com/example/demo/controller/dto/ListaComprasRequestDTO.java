package com.example.demo.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class ListaComprasRequestDTO {
	
	private Integer cliente;
	
	private String nombreLista;
	
	private List<ProductoDTO> productos;

}
