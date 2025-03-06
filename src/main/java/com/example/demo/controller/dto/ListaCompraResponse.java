package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListaCompraResponse {

    private String nombreLista;
    private List<Producto> productos;

}
