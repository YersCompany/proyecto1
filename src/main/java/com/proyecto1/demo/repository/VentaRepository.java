package com.proyecto1.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto1.demo.entity.Venta;


public interface VentaRepository extends JpaRepository<Venta, Long> {
}
