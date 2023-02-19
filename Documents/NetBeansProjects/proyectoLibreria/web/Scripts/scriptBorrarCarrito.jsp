<%-- 
    Document   : scriptBorrarCarrito
    Created on : 18 feb 2023, 2:32:03
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

<!-- Script para borrar todos los productos de el carrito de la tineda -->
<%
    Clases.Query.borrarCarrito(idUsuario);
    response.sendRedirect("../carrito.jsp");
%>
