package com.example.demo.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListasComprasResponse {

    private Integer cliente;

    private List<ListaCompraResponse> listas;

}
