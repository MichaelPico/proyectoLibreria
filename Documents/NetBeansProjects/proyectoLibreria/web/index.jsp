<%-- 
    Document   : pruebas
    Created on : 16 feb 2023, 8:58:16
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Clases.Generador generadorCodigo = new Clases.Generador();%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inicio | Libreria Alpes</title>
        <link href="carrito.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    </head>
    <body>
        <%= generadorCodigo.generarNavBar(0)%>

        <!-- Imagen de encabezado -->
        <div class="py-5 text-center text-white h-100 align-items-center d-flex" style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;">
            <div class="container py-5">
                <div class="row">
                    <div class="mx-auto col-lg-8 col-md-10">
                        <h1 class="display-3 mb-4">Libreria Alpes</h1>
                        <p class="lead mb-5">Vendiendo libros desde 1850 para educar a las nuevas generaciones</p> <a href="login.jsp" class="btn btn-lg btn-primary mx-1">Log in</a> <a class="btn btn-lg mx-1 btn-outline-primary" href="tienda.jsp">Tienda</a>
                    </div>
                </div>
            </div>
        </div>
        <!-<!-- Lista de 3 productos -->
        <div class="py-3 text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h1>Productos y Servicios</h1>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-4 p-4"> <i class="d-block fa fa-circle fa-3x mb-2 text-muted"></i>
                        <h4> <b>Uno</b></h4>
                        <p>Vendemos libros de multiples generos que consideramos aportan a la sociedad</p>
                    </div>
                    <div class="col-md-4 col-6 p-4"> <i class="d-block fa fa-stop-circle-o fa-3x mb-2 text-muted"></i>
                        <h4> <b>Dos</b></h4>
                        <p style="">Ofrecemos el servicio de lectura de libros online por el cual podras leer todos los libros de nuestro catalogo por un precio fijo</p>
                    </div>
                    <div class="col-md-4 col-6 p-4"> <i class="d-block fa fa-circle-o fa-3x mb-2 text-muted"></i>
                        <h4> <b>Tres</b></h4>
                        <p style="">Ofrecemos el servicio de retirada de libros donde un empleado ira a tu casa y se llevara todos los libros que no quieras para asi donarlos</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" style=""></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
    </body>

</html>
