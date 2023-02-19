<%-- 
    Document   : scriptRegistro
    Created on : 19 feb 2023, 19:04:03
    Author     : Michael
--%>

<%@page import="java.io.File"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="Clases.Usuarios"%>
<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SessionFactory factorio = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
    Session miSesion = factorio.openSession();
    String correo = request.getParameter("correo");
    String pass1 = request.getParameter("pass1");
    String pass2 = request.getParameter("pass2");
    String error = "";
    boolean mensa = true;

    if (!pass1.equals(pass2)) {
        error = "Las contraseñas no coinciden";
    } else {
        if (Query.existeUsuario(correo)) {
            error = "Ya hay un usuario con ese correo";
        } else {
            try {

                Usuarios cliente1 = new Usuarios(correo, pass1, new BigDecimal(0), 1);
                miSesion.beginTransaction();
                //Con esta acción se debería guardar además del cliente la info relacionada.
                miSesion.persist(cliente1);

                miSesion.getTransaction().commit();
                Query.insertUsuario(correo, pass1, 0, 0);
                response.sendRedirect("../login.jsp");
                mensa = false;

            } catch (Exception e) {

                session.setAttribute("errorTitulo", "Error registro");
                session.setAttribute("errorMensaje", e.getMessage());
                response.sendRedirect("../mensajePlantilla.jsp");
            }
        }
    }

    if (mensa) {
        session.setAttribute("errorTitulo", "Error registro");
        session.setAttribute("errorMensaje", error);
        response.sendRedirect("../mensajePlantilla.jsp");
    }
%>


