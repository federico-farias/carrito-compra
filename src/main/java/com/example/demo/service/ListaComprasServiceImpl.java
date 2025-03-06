package com.example.demo.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.controller.dto.ListaCompraResponse;
import com.example.demo.controller.dto.ListasComprasResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.ListaComprasRequest;
import com.example.demo.model.Cliente;
import com.example.demo.model.ListaCompra;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.repository.ListaCompraRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListaComprasServiceImpl implements ListaComprasService {
	
	private final ClientesRepository clientesrepository;
	
	private final ListaCompraRepository listaCompraRepository;

	@Override
	@Transactional
	public void create(ListaComprasRequest request) {		
		Integer clienteId = request.getCliente();
		String nombreCliente = UUID.randomUUID().toString();
		
		Optional<Cliente> opCclienteEncontrado = this.clientesrepository.findById(clienteId);
		Cliente clienteEncontrado = opCclienteEncontrado.orElse(null);
		if (clienteEncontrado == null) {
			this.clientesrepository.newClient(clienteId, nombreCliente);
			clienteEncontrado = new Cliente();
			clienteEncontrado.setIdCliente(clienteId);
			clienteEncontrado.setNombre(nombreCliente);
		}
		
		ListaCompra listaCompra = new ListaCompra();
		listaCompra.setCliente(clienteEncontrado);
		listaCompra.setNombre(request.getNombreLista());
		
		Date now = new Date();
		listaCompra.setFechaRegistro(now);
		listaCompra.setFechaUltimaActualizacion(now);
		this.listaCompraRepository.save(listaCompra);
	}

	@Override
	public ListasComprasResponse findById(Integer clientId) {
		Optional<Cliente> opCclienteEncontrado = this.clientesrepository.findById(clientId);
		Cliente clienteEncontrado = opCclienteEncontrado.orElse(null);
		if (clienteEncontrado == null) {
			return null;
		}
		ListasComprasResponse response = new ListasComprasResponse();
		response.setCliente(clienteEncontrado.getIdCliente());
		response.setListas(new LinkedList<>());
			
		var listasDeCompra = this.listaCompraRepository.findBycliente(clienteEncontrado);
		for (var listaCompra: listasDeCompra) {
			response.getListas().add(new ListaCompraResponse(
					listaCompra.getNombre(),
					new LinkedList<>()
			));
		}

		return response;
	}

}
