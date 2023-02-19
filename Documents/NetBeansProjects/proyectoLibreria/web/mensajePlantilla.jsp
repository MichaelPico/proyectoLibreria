<%-- 
    Document   : mensajeSaldoInsuficiente
    Created on : 18 feb 2023, 2:55:24
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Clases.Generador generadorCodigo = new Clases.Generador();%>
<!-- Script para tener como variables el id de el usuario y el tipo -->
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
<!DOCTY
    <!DOCTYPE html>
    <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Mensaje | Libreria Alpes</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
            <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
        </head>

        <body>
            <%
                String navBar = "";
                if (tipoUsuario > 0) {
                    navBar = generadorCodigo.generarNavBar(tipoUsuario, (int) session.getAttribute("id"));
                } else {
                    navBar = generadorCodigo.generarNavBar(tipoUsuario);
                }
            %>
            <%= navBar%>
            <%
                String titulo = "<h2 class=\"my-3\">&titulo&</h2>";
                String mensaje = "<p class=\"mb-3\" >&mensaje&</p>";
                if (session.getAttribute("errorTitulo") != null) {

                    titulo = titulo.replace("&titulo&", (String)session.getAttribute("errorTitulo"));
                }

                if (session.getAttribute("errorMensaje") != null) {

                    mensaje = mensaje.replace("&mensaje&", (String)session.getAttribute("errorMensaje"));
                }
            %>
            <div class="py-5">
                <div class="container">
                    <div class="row">
                        <div class="px-5 col-md-8 text-center mx-auto" style="">
                            <h3 class="text-primary display-4"> <b>Libreria Alpes</b></h3>
                            <%= titulo %>
                            <%= mensaje %>
                            <a href="index.jsp" class="btn btn-primary">Inicio</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Scripts -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" style=""></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
        </body>

    </html>