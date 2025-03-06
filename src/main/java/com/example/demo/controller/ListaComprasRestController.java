package com.example.demo.controller;

import com.example.demo.controller.dto.ListasComprasResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.dto.ListaComprasRequestDTO;
import com.example.demo.service.ListaComprasService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class ListaComprasRestController {
	
	private final ListaComprasService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ListaComprasRequestDTO request) {
		this.service.create(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/cliente/{clientId}")
	public ResponseEntity<ListasComprasResponseDTO> findById(@PathVariable Integer clientId) {
		return ResponseEntity.ok(this.service.findById(clientId));
	}

	@DeleteMapping("/{listaComprasId}")
	public ResponseEntity<?> delete(@PathVariable Integer listaComprasId) {
		this.service.eliminarListaComprasPorId(listaComprasId);
		return ResponseEntity.noContent().build();
	}

}
