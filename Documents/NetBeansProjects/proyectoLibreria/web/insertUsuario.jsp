<%-- 
    Document   : insertUsuario
    Created on : 19 feb 2023, 3:04:23
    Author     : Michael
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Entity"%>
<%@page import="javax.persistence.GeneratedValue"%>
<%@page import="javax.persistence.GenerationType"%>
<%@page import="javax.persistence.Id"%>
<%@page import="javax.persistence.Table"%>
<%@page import="javax.persistence.Column"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.persistence.Column"%>
<%@page import="Clases.Usuario"%>>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Usuario usuario = new Usuario();
%>