<%-- 
    Document   : scriptAñadirCarrito
    Created on : 18 feb 2023, 0:29:30
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Script para tener el tipo de usuario y el id de el usuario -->
<% try {
        session = request.getSession();
        if (session.getAttribute("rol") == null) {
            session.setAttribute("rol", 0);
        }
    } catch (Exception e) {
    }
    int idUsuario = 0;
    int tipoUsuario = (int) session.getAttribute("rol");
    if (tipoUsuario != 0) {
        idUsuario = (int) session.getAttribute("id");
    }
%>

<!-- Script para gestionar el boton de los productos de la tienda -->
<%
    if (tipoUsuario == 0){
        session.setAttribute("errorTitulo", "Login no realizado");
        session.setAttribute("errorMensaje", "Para poder añadir un articulo a el carrito primero hay que haber iniciado sesion.");
        response.sendRedirect("mensajePlantilla.jsp");
    } else {
    
    if (request.getParameter("productoId") != null && tipoUsuario != 0) {
        int idProducto = Integer.valueOf(request.getParameter("productoId"));
        //Si el cliente ya tien su producto aumento la cantidad en uno
        if (Clases.Query.estaElProductoEnElCarrito(idUsuario, idProducto)) {
            Clases.Query.aumentarCantidadProducto(idUsuario, idProducto);
        } else {
            //Si el cliente no tiene su producto en el carrtio hago un insert en la tabla productos
            Clases.Query.añadirProductoCarrito(idUsuario, idProducto);
        }
    }
    response.sendRedirect("tienda.jsp");
    
    }
%>
