<%-- 
    Document   : scriptActualizarEstadoPedido
    Created on : 19 feb 2023, 9:12:46
    Author     : Michael
--%>


<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int idUsuario = Integer.valueOf(request.getParameter("idUsuarioPedidoUpdate"));
    int idPedido = Integer.valueOf(request.getParameter("idPedidoUpdate"));
    String estado = request.getParameter("estadoPedidoUpdate");
    
    Clases.Query.actualizarEstadoPedido(idUsuario, idPedido, estado);

        session.setAttribute("errorTitulo", "Pedido Actualizado");
        session.setAttribute("errorMensaje", "El estado de el pedido ha sido actualizado");
        response.sendRedirect("../mensajePlantilla.jsp");
    

%>
