package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.controller.request.ListaComprasRequest;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClientesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListaComprasServiceImpl implements ListaComprasService {
	
	private final ClientesRepository clientesrepository;

	@Override
	public void create(ListaComprasRequest request) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(request.getCliente());
		
		Integer clienteId = request.getCliente();
		
		Optional<Cliente> opCclienteEncontrado = this.clientesrepository.findById(clienteId);
		Cliente clienteEncontrado = opCclienteEncontrado.orElse(null);
		if (clienteEncontrado == null) {
			this.clientesrepository.newClient(cliente.getIdCliente(), UUID.randomUUID().toString());
		}
	}

	@Override
	public ListaComprasRequest findById(Integer clientId) {
		var all = this.clientesrepository.findAll();
		System.out.println(all);
		Optional<Cliente> opCclienteEncontrado = this.clientesrepository.findById(clientId);
		Cliente clienteEncontrado = opCclienteEncontrado.orElse(null);
		if (clienteEncontrado == null) {
			return null;
		}
		ListaComprasRequest response = new ListaComprasRequest();
		response.setCliente(clienteEncontrado.getIdCliente());
		return response;
	}

}
