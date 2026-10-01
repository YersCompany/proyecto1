package com.proyecto1.demo.controller;




import org.springframework.web.bind.annotation.*;

import com.proyecto1.demo.entity.Venta;
import com.proyecto1.demo.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public Venta crearVenta(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return ventaService.registrarVenta(productoId, cantidad);
    }
}