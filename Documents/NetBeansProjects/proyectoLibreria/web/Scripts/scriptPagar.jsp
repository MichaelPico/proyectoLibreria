<%-- 
    Document   : scriptPagar.jsp
    Created on : 18 feb 2023, 2:44:36
    Author     : Michael
--%>

<%@page import="Clases.Query"%>
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

<%
    if (Query.haySaldoSuficiente(idUsuario)) {
        Query.añadirPedidoHistorial(idUsuario);
        Query.actualizarSaldo(idUsuario);
        String a = "Estimado/a usuario, Le agradecemos sinceramente por su reciente compra en nuestro "
                + "sitio web. Queríamos informarle que su pedido está actualmente en proceso y pronto recibirá una "
                + "notificación con todos los detalles de la compra, incluyendo la confirmación del pedido y el número de "
                + "seguimiento correspondiente en su correo electronico.<br><br>"
                + "Nos complace mucho tenerlo como nuestro cliente y queremos asegurarnos de que tenga una experiencia de compra "
                + "satisfactoria con nosotros. Si tiene alguna pregunta o inquietud, no dude en ponerse en contacto con nuestro"
                + " ! Esperamos que disfrute de su producto"
                + "/servicio.<br><br> Atentamente, Libreria Alpes.<br>";
        Query.borrarCarrito(idUsuario);
        session.setAttribute("errorTitulo", "Compra Realizada");
        session.setAttribute("errorMensaje", a);
        response.sendRedirect("../mensajePlantilla.jsp");
    } else {
        
        session.setAttribute("errorTitulo", "Saldo Insuficiente");
        session.setAttribute("errorMensaje", "No tienes saldo suficiente para poder realizar esta compra. Te recomendamos ir a el banco mas cercano y realizar una transferencia a la cuenta ES65-4543-4535-2342 poniendo tu correo como concepto para asi tener mas saldo en tu cuenta.");
        response.sendRedirect("../mensajePlantilla.jsp");
    }
%>
