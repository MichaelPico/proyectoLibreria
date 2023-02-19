<%-- 
    Document   : scriptActualizarUsuario
    Created on : 18 feb 2023, 19:12:53
    Author     : Michael
--%>

<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int id = Integer.valueOf(request.getParameter("idUpdate"));
    String correo = request.getParameter("correoUpdate");
    String pass = request.getParameter("passUpdate");
    double saldo = Double.valueOf(request.getParameter("saldoUpdate"));
    int tipo = Integer.valueOf(request.getParameter("tipoUpdate"));

    if (!Query.existeUsuario(id)) {
        session.setAttribute("errorTitulo", "Usuario no existe");
        session.setAttribute("errorMensaje", "El usuario no se puede actualizar ya que no existe un usuario con el mismo id");
        response.sendRedirect("mensajePlantilla.jsp");
    } else {
        Query.updateUsuario(id, correo, pass, saldo, tipo);
        session.setAttribute("errorTitulo", "Update exitosa");
        session.setAttribute("errorMensaje", "El usuario ha sido actualizado");
        response.sendRedirect("mensajePlantilla.jsp");
    }

%>