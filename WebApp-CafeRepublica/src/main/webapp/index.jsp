<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Ingreso Café Republica</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="icon" href="images/homeware.png" type="image/x-icon">
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
    }
    @media (min-width: 1024px) {
        body {
            background-image: url('images/republicafondo.png');
        }
    }
    @media (min-width: 768px) and (max-width: 1023px) {
        body {
            background-image: url('images/republicafondo.png');
        }
    }
    @media (max-width: 767px) {
        body {
            background-image: url('images/republicafondo.png');
        }
    }
</style>
<body class="bg-gradient-primary" style="background-image: url('images/republicafondo.png');" >
<div class="container" style="padding-right: 4.5rem;width: 620px;">
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9" style="margin-left: 37px;">

            <div class="card o-hidden border-0 shadow-lg my-5" style="border-radius: 42px;">
                <div class="card-body p-0">
                    <div class="row1" style="width: 700px;">

                        <div class="col-lg-6">
                            <div class="p-5" style="width: 400px;margin-left: 0px;" >
                                <div class="text-center">
                                    <img src="images/republicalogo.png" alt="logo" class="mb-4" style="width: 200px; height: auto;margin-bottom: 0rem !important;">
                                </div>
                                <hr style="background-color: #a32626;height: 2px;">
                                <hr style="background-color: #a32626;height: 2px;">
                                <a href="https://accounts.google.com" style="background-color:#31302b;;border-color: #31302b;border-radius: 23px;margin-bottom: 12px;" class="btn btn-primary btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Iniciar sesión con Google
                                </a>
                                <form class="user" action="IngresoControl" method="POST">
                                    <div class="form-group">
                                        <input type="email" name="email" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Correo Electrónico" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Contraseña" required>
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheck">
                                            <label class="custom-control-label" for="customCheck">Recordarme</label>
                                        </div>
                                    </div>
                                    <button type="submit" style="background-color: #a32626;" class="btn btn-primary btn-user btn-block">
                                        Iniciar Sesión
                                    </button>
                                </form>

                                <div class="text-center">
                                    <a class="small" href="Inicio.jsp">Olvidaste tu contraseña?</a>
                                    <hr>
                                    <a class="small" >¿No tienes una cuenta?</a>
                                    <a href="registro.jsp" style="background-color: #31302b;;border-radius: 23px;" class="btn btn-primary btn-user btn-block">
                                         Crear Cuenta
                                    </a>
                                </div>
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