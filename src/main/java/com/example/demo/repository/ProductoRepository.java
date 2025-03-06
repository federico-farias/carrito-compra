package com.example.demo.repository;

import com.example.demo.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into Producto (id) values (:id)")
    void insert(@Param("id") Integer id);

}
