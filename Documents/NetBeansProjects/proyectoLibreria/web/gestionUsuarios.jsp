<%-- 
    Document   : usuarios
    Created on : 16 feb 2023, 11:38:26
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
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gestion Usuarios | Libreria Alpes</title>
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
    </body>
    <div class="pt-5 pb-1">
        <div class="container">
            <div class="row">
                <div class="px-5 col-md-8 text-center mx-auto" style="">º
                    <h3 class="text-primary display-4"> <b>Libreria Alpes</b></h3>
                    <h2 class="my-3">Gestion de usuarios</h2>
                    <h5 class="text-center">Elije el tipo de accion que quieres realizar en funcion de el formulario, al final de la pagina hay una tabla de usuarios la cual te puede ser util para realizar las acciones.</h5>
                </div>
            </div>
        </div>
    </div>
    <div class="py-5">
        <div class="container">
            <h2 > Dar de alta Usuario</h2>
            <div class="row">
                <div class="col-md-12">
                    <form action="Scripts/scriptDarDeAlta.jsp">
                        <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">E-mail</label>
                            <div class="col-10">
                                <input type="email" class="form-control" id="inputmailh" placeholder="mail@example.com" name="correoAlta"> </div>
                        </div>
                        <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">Contraseña</label>
                            <div class="col-10">
                                <input type="password" class="form-control" id="inputpasswordh" placeholder="Password" name="passAlta"> </div>
                        </div>
                        <div class="form-group row"> <label class="col-2 col-form-label">Saldo</label>
                            <div class="col-10">
                                <input type="number" step="0.01" class="form-control" placeholder="45,08" name="saldoAlta" > </div>
                        </div>
                        <div class="form-group row"> <label class="col-2 col-form-label">Tipo</label>
                            <div class="col-10">
                                <input type="text" class="form-control" placeholder="1. Normal, 2. Gestor, 3. Administrador" name="tipoAlta"> </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Dar de alta</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="py-5">
        <div class="container">
            <h2 > Actualizar Usuario </h2>
            <div class="row">
                <div class="col-md-12">
                    <form action="Scripts/scriptActualizarUsuario.jsp">
                        <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">ID</label>
                            <div class="col-10">
                                <input type="text" class="form-control" placeholder="4" name="idUpdate"> </div>
                        </div>
                        <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">E-mail</label>
                            <div class="col-10">
                                <input type="email" class="form-control" id="inputmailh" placeholder="mail@example.com" name="correoUpdate"> </div>
                        </div>
                        <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label">Contraseña</label>
                            <div class="col-10">
                                <input type="password" class="form-control" id="inputpasswordh" placeholder="Password" name="passUpdate"> </div>
                        </div>
                        <div class="form-group row"> <label class="col-2 col-form-label">Saldo</label>
                            <div class="col-10">
                                <input type="number" step="0.01" class="form-control" placeholder="45,08"  name="saldoUpdate"> </div>
                        </div>
                        <div class="form-group row"> <label class="col-2 col-form-label">Tipo</label>
                            <div class="col-10">
                                <input type="text" class="form-control" placeholder="1. Normal, 2. Gestor, 3. Administrador" name="tipoUpdate"> </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Actualizar valores de el Usuario</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="py-5">
        <div class="container">
            <h2 > Dar de baja Usuario</h2>
            <div class="row">
                <div class="col-md-12">
                    <form action="Scripts/scriptDarBaja.jsp">
                        <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label">ID</label>
                            <div class="col-10">
                                <input type="number" class="form-control" id="inputmailh" placeholder="4" name="idBaja"> </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Dar de baja</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="py-2">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                </div>
            </div>
        </div>
    </div>

    <%
        String usuarios = "";
        usuarios = generadorCodigo.generarListaUsuarios(Clases.Query.getUsuariosLista());
    %>
    <%= usuarios%>
    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" style=""></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
</body>

</html>
