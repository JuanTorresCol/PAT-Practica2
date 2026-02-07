package edu.icai.pat.practica2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModeloArticulo(

        @NotBlank(message="Debe rellenar el id")
        String idArticulo,
        @NotNull(message="Debe rellenar la descripción")
        String descripcion,
        @NotNull(message="La cantidad no puede ser nula")
        Integer cantidad,
        @NotNull(message="El precio no puede ser nulo")
        Integer precioUnidad,

        Integer precioTotal
) {

    public ModeloArticulo {
        if (precioTotal == null) {
            precioTotal = cantidad * precioUnidad;
        }
    }
}
