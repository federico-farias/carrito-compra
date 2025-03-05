package com.example.demo.controller.request;

import java.util.List;

import lombok.Data;

@Data
public class ListaComprasRequest {
	
	private Integer cliente;
	
	private String nombreLista;
	
	private List<Producto> productos;

}
