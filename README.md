# PAT-Practica2
# API - ModeloContador

API REST para gestionar artículos de un carrito de la compra.

## Modelo de datos

### `ModeloContador`

| Campo | Tipo | Obligatorio | Descripción |
|------|------|-------------|-------------|
| idArticulo | String | Sí | Identificador del artículo |
| descripcion | String | Sí | Descripción del artículo |
| cantidad | Integer | Sí | Cantidad del artículo |
| precioUnidad | Integer | Sí | Precio por unidad |
| precioTotal | Integer | Sí | Total calculado (`cantidad * precioUnidad`) |

---

## Endpoints

> Base URL: `/api`

| Método | Ruta | Cuerpo | Descripción | Respuestas posibles |
|-------:|------|--------|-------------|---------------------|
| GET | `/carrito/{idArticulo}` | — | Obtiene un artículo por su id | `200 OK`, `404 Not Found`|
| POST | `/carrito` | JSON `ModeloContador` (sin `precioTotal` o con `null`) | Crea un nuevo artículo | `201 Created`, `400 Bad Request`, `409 Conflict`|
| PUT | `/carrito/{idArticulo}/incremento/{incremento}` | JSON `ModeloContador` | Actualiza la cantidad de artículos existentes del artículo con ese id | `200 OK`, `400 Bad Request`, `404 Not Found`|
| DELETE | `/carrito/borrar/{nombre}` | — | Elimina un artículo por id | `204 No Content`, `404 Not Found`|

---

## Ejemplos de petición

### Crear artículo (POST `http://localhost:8080/api/carrito`)

{
    "idArticulo": "carrito1",
    "descripcion": "carrito prueba",
    "cantidad" : 2,
    "precioUnidad" : 1
}

### return

{
    "idArticulo": "carrito1",
    "descripcion": "carrito prueba",
    "cantidad": 2,
    "precioUnidad": 1,
    "precioTotal": 2
}

### Incrementar artículo (PUT `http://localhost:8080/api/carrito/carrito1/incremento/2`)

{
    "idArticulo": "carrito1",
    "descripcion": "carrito prueba",
    "cantidad": 3,
    "precioUnidad": 1,
    "precioTotal": 3
}
