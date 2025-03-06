package com.example.demo.repository;

import com.example.demo.model.ListaCompraDetalle;
import com.example.demo.model.ListaCompraDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaCompraDetalleRepository extends JpaRepository<ListaCompraDetalle, ListaCompraDetalleId> {


}
