package com.example.demo.service;

import com.example.demo.controller.request.ListaComprasRequest;

public interface ListaComprasService {
	
	public void create(ListaComprasRequest request);

	public ListaComprasRequest findById(Integer clientId);

}
