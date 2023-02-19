<%-- 
    Document   : scriptDarBaja
    Created on : 18 feb 2023, 19:25:50
    Author     : Michael
--%>

<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int id = Integer.valueOf(request.getParameter("idBaja"));

    if (!Query.existeUsuario(id)) {
        session.setAttribute("errorTitulo", "Usuario no existe");
        session.setAttribute("errorMensaje", "El usuario no se puede borrar ya que no existe un usuario con el mismo id");
        response.sendRedirect("../mensajePlantilla.jsp");
    } else {
        Query.dropUsuario(id);
        session.setAttribute("errorTitulo", "Borrado exitoso");
        session.setAttribute("errorMensaje", "El usuario ha sido borrado");
        response.sendRedirect("../mensajePlantilla.jsp");
    }

%>
