<%--
  Created by IntelliJ IDEA.
  User: sadit
  Date: 30/10/2024
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registro Republica Café</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="icon" href="images/homeware.png" type="image/x-icon">
</head>
<style>
    .form-rol {
        font-size: .8rem;
        border-radius: 10rem;
        height: 47px;
    }
</style>
<body class="bg-gradient-primary" style="background-image: url('images/republicafondo.png');">
<div class="container" style="padding-right: 4.5rem;width: 620px;padding-left: 50px;">
    <div class="col-xl-10 col-lg-12 col-md-9" style="margin-left: 37px;">
    <div class="card o-hidden border-0 shadow-lg my-5" style="border-radius: 42px;width: 420px;">
        <div class="card-body p-0">
            <div class="row1" style="width: 700px;">
                <div class="col-lg-7">
                    <div class="p-5" style="width: 400px;margin-left: 0px;" >
                        <div class="text-center">
                            <img src="images/republicalogo.png" alt="Descripción de la imagen" class="mb-4" style="width: 200px; height: auto;">
                        </div>
                        <hr style="background-color: #a32626;height: 2px;">
                        <hr style="background-color: #a32626;height: 2px;">
                        <form class="user" action="RegistroControl" method="post">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">

                                    <input type="text" id="nombre" class="form-control form-control-user" name="nombre" placeholder="Nombre" required>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">

                                    <input type="text" id="apellido" class="form-control form-control-user" name="apellido" placeholder="Apellido" required>
                                </div>
                            </div>
                            <div class="form-group">

                                <input type="email" id="email" class="form-control form-control-user" name="email" placeholder="Correo Electrónico" required>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">

                                    <select class="form-control form-rol" id="rol" name="rol" required>
                                        <option value="" disabled selected>Selecciona un rol</option>
                                        <option value="Administrador">Administrador</option>
                                        <option value="Trabajador">Trabajador</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">

                                    <input type="text" id="dni" class="form-control form-control-user" name="dni" placeholder="DNI" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">

                                    <input type="password" id="password" class="form-control form-control-user" name="password" placeholder="Contraseña" required>
                                </div>
                            </div>
                            <button type="submit" style="background-color: #a32626;" class="btn btn-primary btn-user btn-block">
                                Registrar Cuenta
                            </button>
                            <hr>
                            <a href="https://accounts.google.com" style="background-color: #31302b;;border-color: #31302b;border-radius: 23px;margin-bottom: 12px;" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Registrarse con Google
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="index.jsp">Ya tienes una cuenta? Inicia Sesion!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>
</body>
</html>
