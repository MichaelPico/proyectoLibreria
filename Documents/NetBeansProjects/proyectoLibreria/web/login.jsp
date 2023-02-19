    <%-- 
    Document   : login
    Created on : 16 feb 2023, 11:24:26
    Author     : Michael
--%>

<%@page import="Clases.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Clases.Generador generadorCodigo = new Clases.Generador();
    Clases.Query queryMaster = new Clases.Query();
    String correo = request.getParameter("correo");
    String pass = request.getParameter("pass");
    String error = "";
    if (request.getParameter("pass") == null && request.getParameter("correo") == null) {
        // nada 
    } else {
        if ((request.getParameter("pass") != null && request.getParameter("correo") == null) || (request.getParameter("pass") == null && request.getParameter("correo") != null)) {
            error += "Hay que rellenar los dos campos.\n";
        }
        if (pass.contains(" ") || correo.contains(" ")) {
            error += "El correo o la contraseña no pueden contener espacios en blanco.\n";
        }
        if (error.equals("")) {
            if (queryMaster.existeUsuario(correo)) {
                if (queryMaster.contraseñaCorrecta(correo, pass)) {
                    int rol = queryMaster.getTipoUsuario(correo);
                    int id = queryMaster.getIdUsuario(correo);
                    session.setAttribute("rol", rol);
                    session.setAttribute("id", id);
                    response.sendRedirect("index.jsp");
                }
            } else {
                error = "El usuario o la contraseña son incorrectos";
            }
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login | Libreria Alpes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    </head>

    <body>
        <%= generadorCodigo.generarNavBar(0)%>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="login.jsp">
                            <div class="form-group"> <label>Correo</label> <input type="email" class="form-control" name="correo" placeholder="Introduce tu correo"> </div>
                            <div class="form-group"> <label>Contraseña</label> <input type="password" class="form-control" name="pass" placeholder="Contraseña"> </div>
                                <%= generadorCodigo.generarError(error)%>
                            <button type="submit" class="btn btn-primary">Log in</button>

                        </form>
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
