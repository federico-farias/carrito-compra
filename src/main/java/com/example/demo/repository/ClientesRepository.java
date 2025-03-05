package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

import jakarta.transaction.Transactional;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
	
	@Modifying
    @Transactional
	@Query(value = "insert into Cliente (idCliente, nombre) values (:idCliente, :nombre)")
	void newClient(@Param("idCliente") Integer id, @Param("nombre") String name);

}
