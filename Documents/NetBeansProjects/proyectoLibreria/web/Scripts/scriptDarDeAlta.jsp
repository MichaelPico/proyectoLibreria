<%-- 
    Document   : scriptDarDeAlta
    Created on : 18 feb 2023, 18:26:33
    Author     : Michael
--%>

<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String correo = request.getParameter("correoAlta");
    String pass = request.getParameter("passAlta");
    double saldo = Double.valueOf(request.getParameter("saldoAlta"));
    int tipo = Integer.valueOf(request.getParameter("tipoAlta"));

    if (Query.existeUsuario(correo)) {
        session.setAttribute("errorTitulo", "Usuario existente");
        session.setAttribute("errorMensaje", "El usuario no se puede crear ya que existe un usuario con el mismo correo");
        response.sendRedirect("../mensajePlantilla.jsp");
    } else {
        Query.insertUsuario(correo, pass, saldo, tipo);
        session.setAttribute("errorTitulo", "Alta exitosa");
        session.setAttribute("errorMensaje", "El usuario ha sido creado");
        response.sendRedirect("../mensajePlantilla.jsp");
    }

%>
