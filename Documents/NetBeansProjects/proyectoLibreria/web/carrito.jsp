<%-- 
    Document   : carrito
    Created on : 16 feb 2023, 10:15:14
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Script para tener como variables el id de el usuario y el tipo -->
<% try {
        session = request.getSession();
        if(session.getAttribute("rol") == null){
            session.setAttribute("rol", 0);
        } 
    } catch (Exception e) {
    }
    int idUsuario = 0;
    int tipoUsuario = (int)session.getAttribute("rol");
    if (tipoUsuario != 0){
        idUsuario = (int)session.getAttribute("id");
    }
%>
<!DOCTYPE html>
<html>
    <% Clases.Generador generadorCodigo = new Clases.Generador();%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="styles/carrito.css" rel="stylesheet" type="text/css">
        <title>Carrito | Libreria Alpes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    </head>

    <body>
        <%
            String navBar = "";
            if (tipoUsuario > 0 ) {
                navBar = generadorCodigo.generarNavBar(tipoUsuario, (int) session.getAttribute("id"));
            } else {
                navBar = generadorCodigo.generarNavBar(tipoUsuario);
            }
        %>
        <%= navBar%>
        <!-- Carrito -->
        <section class="shopping-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2>Carrito de la compra</h2>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-12 col-lg-8">
                            <!-- Productos -->
                            <div class="items">
                                <% String productos = Clases.Query.dibujarProductosCarrito(idUsuario);%>
                                <%= productos %>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-4">
                            <% String resumenPedido = Clases.Query.dibujarResumenCarrito(idUsuario);%>
                            <%= resumenPedido%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" style=""></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
    </body>

</html>
