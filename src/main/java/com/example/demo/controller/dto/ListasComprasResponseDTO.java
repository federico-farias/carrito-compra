package com.example.demo.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListasComprasResponseDTO {

    private Integer cliente;

    private List<ListaCompraResponseDTO> listas;

}
