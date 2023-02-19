<%-- 
    Document   : scriptActualizarSaldoUsuario
    Created on : 19 feb 2023, 0:29:29
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    int id = Integer.valueOf(request.getParameter("idUpdateSaldo"));
    double saldo = Double.valueOf(request.getParameter("saldoUpdateSaldo"));

    Clases.Query.actualizarSaldo(id, saldo);
    session.setAttribute("errorTitulo", "Saldo Actualizado");
    session.setAttribute("errorMensaje", "El saldo ha sido actualizado");
    response.sendRedirect("mensajePlantilla.jsp");

%>
