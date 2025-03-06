package com.example.demo.service;

import java.util.*;

import com.example.demo.controller.dto.ListaCompraResponseDTO;
import com.example.demo.controller.dto.ListasComprasResponseDTO;
import com.example.demo.controller.dto.ProductoDTO;
import com.example.demo.model.*;
import com.example.demo.repository.ListaCompraDetalleRepository;
import com.example.demo.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.ListaComprasRequestDTO;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.repository.ListaCompraRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListaComprasServiceImpl implements ListaComprasService {
	
	private final ClientesRepository clientesrepository;
	
	private final ListaCompraRepository listaCompraRepository;

	private final ProductoRepository productoRepository;

	private final ListaCompraDetalleRepository listaCompraDetalleRepository;

	@Override
	@Transactional
	public void create(ListaComprasRequestDTO request) {
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

		Date now = new Date();
		ListaCompra listaCompra = new ListaCompra();
		listaCompra.setCliente(clienteEncontrado);
		listaCompra.setNombre(request.getNombreLista());
		listaCompra.setFechaRegistro(now);
		listaCompra.setFechaUltimaActualizacion(now);
		listaCompra.setActivo(true);
		this.listaCompraRepository.save(listaCompra);

		// No es lo mejor ni lo más optimo, lo que se busca es terminar el flujo.
		for(var productoRequest : request.getProductos()) {
			var productoEncontrado = this.productoRepository.findById(productoRequest.getIdProducto()).orElse(null);
			if (productoEncontrado == null) {
				this.productoRepository.insert(productoRequest.getIdProducto());
				productoEncontrado = new Producto();
				productoEncontrado.setId(productoRequest.getIdProducto());
			}

			ListaCompraDetalle detalle = new ListaCompraDetalle();
			detalle.setIdListaCompra(listaCompra);
			detalle.setIdCodigoProducto(productoEncontrado);
			detalle.setCantidad(productoRequest.getCantidad());
			this.listaCompraDetalleRepository.save(detalle);
		}

	}

	@Override
	public ListasComprasResponseDTO findById(Integer clientId) {
		Optional<Cliente> opCclienteEncontrado = this.clientesrepository.findById(clientId);
		Cliente clienteEncontrado = opCclienteEncontrado.orElse(null);
		if (clienteEncontrado == null) {
			return null;
		}
		ListasComprasResponseDTO response = new ListasComprasResponseDTO();
		response.setCliente(clienteEncontrado.getIdCliente());
		response.setListas(new LinkedList<>());
			
		var listasDeCompra = this.listaCompraRepository.findByClienteAndActivo(clienteEncontrado, true);

		for (var listaCompra: listasDeCompra) {
			var productos = new LinkedList<ProductoDTO>();
			var detalles = listaCompra.getDetalles();

			for (var detalle : detalles) {
				productos.add(new ProductoDTO(detalle.getIdCodigoProducto().getId(), detalle.getCantidad()));
			}

			response.getListas().add(new ListaCompraResponseDTO(
					listaCompra.getId(),
					listaCompra.getNombre(),
					productos
			));
		}

		return response;
	}

	@Override
	public void eliminarListaComprasPorId(Integer listaComprasId) {
		var opListaCompra = this.listaCompraRepository.findById(listaComprasId);
		var listaCompra = opListaCompra.orElseGet(null);
		if (listaCompra != null) {
			listaCompra.setActivo(false);
			this.listaCompraRepository.save(listaCompra);
		}
	}

}
