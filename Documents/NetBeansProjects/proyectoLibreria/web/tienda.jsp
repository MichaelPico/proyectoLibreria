<%-- 
    Document   : tienda
    Created on : 16 feb 2023, 10:00:11
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Clases.Generador generadorCodigo = new Clases.Generador();%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tienda | Libreria Alpes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="tienda.css" type="text/css">
        <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    </head>

    <body>
        <%= generadorCodigo.generarNavBar(3)%>
        <!-- Titulo -->
        <div class="text-center pt-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>Productos</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin de el titulo -->
        <!-- Seccion para filtrar y buscar productos -->
        <div class="py-0 pt-5">
            <div class="container">
                <div class="row">
                    <!-- Columna 1 -->
                    <!-- Barra de busqueda -->
                    <div class="col-md-4">
                        <label for="nombre-buscar" class="form-label">Nombre de el producto</label>
                        <input type="text" class="form-control" id="nombre-buscar" placeholder="Secretos de la sombra">
                    </div>
                    <!-- Columna 2 -->
                    <!-- Select de categoria -->
                    <div class="col-md-4">
                        <label for="categoria-buscar" class="form-label">Categoria de el producto</label>
                        <select class="form-select" aria-label="Categoria" id="categoria-buscar">
                            <option selected="" value="Todas">Todas</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <!-- Columna 3 -->
                    <!-- Precio maximo de la busqueda -->
                    <div class="col-md-4">
                        <label for="precio-buscar" class="form-label">Precio Maximo</label>
                        <div class="input-group mb-3">
                            <span class="input-group-text">$</span>
                            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                        </div>
                    </div>
                </div>
                <!-- Fila 2 -->
                <!-- Boton de buscar  -->
                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Seccion de los productos -->
        <div class="container d-flex justify-content-center mt-50 mb-50">
            <div class="row">
                <!-- Productos -->
                <% String[] datosProducto = new String[]{"https://res.cloudinary.com/dxfq3iotg/image/upload/v1562074043/234.png", "Toshiba Notebook with 500GB HDD &amp; 8GB RAM", "Laptops &amp; Notebooks", "250.99€", "3", "1"};%>
                <%= generadorCodigo.generarProductoTienda(datosProducto)%>
                <%= generadorCodigo.generarProductoTienda(datosProducto)%>
                <%= generadorCodigo.generarProductoTienda(datosProducto)%>
            </div>
        </div>
        <!-- Fin de la seecion de el producto -->

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" style=""></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
    </body>

</html>
