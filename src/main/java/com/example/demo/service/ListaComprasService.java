package com.example.demo.service;

import com.example.demo.controller.dto.ListaComprasRequest;
import com.example.demo.controller.dto.ListasComprasResponse;

public interface ListaComprasService {
	
	void create(ListaComprasRequest request);

	ListasComprasResponse findById(Integer clientId);

}
