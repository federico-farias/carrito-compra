package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.ListaCompra;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaCompra, Integer>{
	
	List<ListaCompra> findBycliente(Cliente cliente);

}
