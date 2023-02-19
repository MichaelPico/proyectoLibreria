<%-- 
    Document   : scriptDarDeBajaProducto
    Created on : 19 feb 2023, 0:21:25
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<% 
    String titulo = request.getParameter("tituloAlta");
    
    Clases.Query.borrarProducto(titulo);
    session.setAttribute("errorTitulo", "Producto borrado");
    session.setAttribute("errorMensaje", "El producto ha sido borrado");
    response.sendRedirect("mensajePlantilla.jsp");
    
%>
