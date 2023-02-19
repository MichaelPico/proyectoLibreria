<%-- 
    Document   : scriptDarDeAltaProducto
    Created on : 19 feb 2023, 0:05:27
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String titulo = request.getParameter("tituloAlta");
    String categoria = request.getParameter("correoAlta");
    double precio = Double.valueOf(request.getParameter("precioAlta"));
    int valoracion = Integer.valueOf(request.getParameter("valoracionAlta"));
    String imagen = request.getParameter("imagenAlta");
    
    Clases.Query.crearProducto(titulo, categoria, precio, valoracion, imagen);
    session.setAttribute("errorTitulo", "Producto añadido");
    session.setAttribute("errorMensaje", "El producto ha sido añadido");
    response.sendRedirect("../mensajePlantilla.jsp");
    
%>
