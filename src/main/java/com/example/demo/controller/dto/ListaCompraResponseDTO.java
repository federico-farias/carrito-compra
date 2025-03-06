package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListaCompraResponseDTO {

    private Integer id;
    private String nombreLista;
    private List<ProductoDTO> productos;

}
