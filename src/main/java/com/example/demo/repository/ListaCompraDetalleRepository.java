package com.example.demo.repository;

import com.example.demo.model.ListaCompraDetalle;
import com.example.demo.model.ListaCompraDetalleId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaCompraDetalleRepository extends JpaRepository<ListaCompraDetalle, ListaCompraDetalleId> {

    @Modifying
    @Transactional
    @Query(value = "insert into ListaCompraDetalle (id.idListaCompra, id.idCodigoProducto, cantidad) values (:idListaCompra, :idCodigoProducto, :cantidad)")
    void insert(@Param("idListaCompra") Integer idListaCompra, @Param("idCodigoProducto") Integer idCodigoProducto, @Param("cantidad") Integer cantidad);

}
