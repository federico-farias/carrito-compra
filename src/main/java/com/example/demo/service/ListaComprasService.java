package com.example.demo.service;

import com.example.demo.controller.dto.ListaComprasRequestDTO;
import com.example.demo.controller.dto.ListasComprasResponseDTO;

public interface ListaComprasService {
	
	void create(ListaComprasRequestDTO request);

	ListasComprasResponseDTO findById(Integer clientId);

	void eliminarListaComprasPorId(Integer listaComprasId);
}
