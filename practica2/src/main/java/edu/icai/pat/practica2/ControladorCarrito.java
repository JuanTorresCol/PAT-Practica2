package edu.icai.pat.practica2;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ControladorCarrito {
    private final Map<String, ModeloArticulo> carritos = new HashMap<>();

    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloArticulo crea(@Valid @RequestBody ModeloArticulo articuloNuevo, BindingResult bindingResult) {
        carritos.put(articuloNuevo.idArticulo(), articuloNuevo);
        return articuloNuevo;
    }

    @GetMapping("/api/carrito/{idCarrito}")
    public ModeloArticulo articulo(@PathVariable String idCarrito) {
        if (carritos.get(idCarrito) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return carritos.get(idCarrito);
    }

    @PutMapping("/api/carrito/{idCarrito}/incremento/{incremento}")
    public ModeloArticulo incrementa(@PathVariable String idCarrito,
                                     @PathVariable Integer incremento) {
        if (carritos.get(idCarrito) == null) {
            // Si no existe
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ModeloArticulo articuloActual = carritos.get(idCarrito);
        ModeloArticulo articuloIncrementado =
                new ModeloArticulo(idCarrito, articuloActual.descripcion(),articuloActual.cantidad()+1,articuloActual.precioUnidad(), null);
        carritos.put(idCarrito, articuloIncrementado);
        return articuloIncrementado;
    }

    @DeleteMapping("/api/carrito/borrar/{nombre}")
    public void borrar(@PathVariable String nombre) {
        carritos.remove(nombre);
        return;
    }
}

