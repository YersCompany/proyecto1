package com.proyecto1.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto1.demo.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
