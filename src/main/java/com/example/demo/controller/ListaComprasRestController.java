package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.request.ListaComprasRequest;
import com.example.demo.service.ListaComprasService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
public class ListaComprasRestController {
	
	private final ListaComprasService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ListaComprasRequest request) {
		this.service.create(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/cliente/{clientId}")
	public ResponseEntity<ListaComprasRequest> findById(@PathVariable Integer clientId) {
		return ResponseEntity.ok(this.service.findById(clientId));
	}

}
