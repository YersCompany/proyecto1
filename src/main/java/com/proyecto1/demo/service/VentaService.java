package com.proyecto1.demo.service;


import org.springframework.stereotype.Service;

import com.proyecto1.demo.entity.Producto;
import com.proyecto1.demo.entity.Venta;
import com.proyecto1.demo.repository.ProductoRepository;
import com.proyecto1.demo.repository.VentaRepository;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    public VentaService(VentaRepository ventaRepository, ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }

    public Venta registrarVenta(Long productoId, Integer cantidad) {
        // 1. Buscar el producto
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 2. Verificar stock
        if (producto.getStock() < cantidad) {
            throw new RuntimeException("No hay suficiente stock de este producto");
        }

        // 3. Descontar stock y actualizar
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);

        // 4. Calcular total
        double total = producto.getPrecio() * cantidad;

        // 5. Crear y guardar la venta
        Venta nuevaVenta = new Venta();
        nuevaVenta.setProducto(producto);
        nuevaVenta.setCantidadVendida(cantidad);
        nuevaVenta.setTotalPagar(total);

        return ventaRepository.save(nuevaVenta);
    }
}
