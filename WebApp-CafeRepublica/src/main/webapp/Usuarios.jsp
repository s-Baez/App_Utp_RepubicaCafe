<%--
  Created by IntelliJ IDEA.
  User: sadit
  Time: 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.UsuarioData" %>
<%@ page import="DAO.UsuarioDataDAO" %>
<%@ page import="Controller.ListaUsuariosControl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="Model.Usuario" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    Usuario usuario1 = null;
    if (session != null) {
        usuario1 = (Usuario) session.getAttribute("usuario");
    }
    if (usuario1 == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<%

    UsuarioDataDAO usuarioDataDAO = new UsuarioDataDAO();
    List<UsuarioData> usuariosLista = UsuarioDataDAO.listarUsuarios();
%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Usuarios</title>
    <link href="vendor/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="vendor/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="icon" href="images/homeware.png" type="image/x-icon">
</head>

<body id="page-top">

<div id="wrapper">

    <!---------------------------------- Barra de Accesos ------------------------------>
    <ul style="background-color: #a32626;" class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar">
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="inicio.jsp">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Gestor</div>
        </a>
        <hr class="sidebar-divider my-0">
        <li class="nav-item">
            <a class="nav-link" href="Inicio.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Inicio</span>
            </a>
        </li>

        <hr class="sidebar-divider">

        <div class="sidebar-heading">
            Trabajador
        </div>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVentas"
               aria-expanded="true" aria-controls="collapseVentas">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Ventas</span>
            </a>
            <div id="collapseVentas" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>

                    <a class="collapse-item" href="Ventas.jsp">Lista de Ventas</a>
                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Proveedores</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>
                    <a class="collapse-item" href="ProveedorNuevo.jsp">Nuevo Proveedor</a>
                    <a class="collapse-item" href="Proveedores.jsp">Lista de Proveedores</a>
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Ingresos</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>
                    <a class="collapse-item" href="IngresoNuevo.jsp">Nuevo Ingreso</a>
                    <a class="collapse-item" href="Ingreso.jsp">Lista de Ingresos</a>
                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseproducts"
               aria-expanded="true" aria-controls="collapseproducts">
                <i class="fas fa-fw fa-table"></i>
                <span>Productos</span>
            </a>
            <div id="collapseproducts" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>
                    <a class="collapse-item" href="productoNuevo.jsp">Nuevo Producto</a>
                    <a class="collapse-item" href="productoslista.jsp">Lista de Productos</a>
                </div>
            </div>
        </li>
        <hr class="sidebar-divider">
        <div class="sidebar-heading">
            Administrador
        </div>
        <li class="nav-item active">
            <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
               aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>Exportar</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>
                    <%
            if ("Administrador".equals(usuario1.getRol())) {
          %>
          <a class="collapse-item" href="archivos.jsp">Archivos</a>
          <%
          } else {
          %>
          <a class="collapse-item" href="SinAcceso.jsp">Archivos</a>
          <%
            }
          %>
                </div>
            </div>
        </li>
        <li class="nav-item active">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseuser"
               aria-expanded="true" aria-controls="collapseuser">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Usuarios</span>
            </a>
            <div id="collapseuser" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Acciones:</h6>
                    <%

            if (usuario1 != null) {
              if ("Administrador".equals(usuario1.getRol())) {
          %>
          <a class="collapse-item" href="UsuarioNuevo.jsp">Nuevo Usuario</a>
          <a class="collapse-item" href="Usuarios.jsp">Lista de usuarios</a>
          <%
          } else {
          %>

          <a class="collapse-item" href="SinAcceso.jsp">Nuevo Usuario</a>
          <a class="collapse-item" href="SinAcceso.jsp">Lista de usuarios</a>
          <%
            }
          } else {
          %>

          <a class="collapse-item" href="SinAcceso.jsp">Nuevo Usuario</a>
          <a class="collapse-item" href="SinAcceso.jsp">Lista de usuarios</a>
          <%
            }
          %>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- Fin de Accesos barra azul  -->


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow" style="border-bottom: 3px solid #a32626;">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>
                <div class="text-center" style="position: relative">
                    <img src="images/republicalogo.png" alt="Descripción de la imagen" class="mb-4" style="width: 200px; height: auto;margin-left: 360px;">
                </div>
                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">0</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 12, 2019</div>
                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 7, 2019</div>
                                    $290.29 has been deposited into your account!
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 2, 2019</div>
                                    Spending Alert: We've noticed unusually high spending for your account.
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter">0</span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Message Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="images/undraw_profile_1.svg"
                                         alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div class="font-weight-bold">
                                    <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                        problem I've been having.</div>
                                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="images/undraw_profile_2.svg"
                                         alt="...">
                                    <div class="status-indicator"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">I have the photos that you ordered last month, how
                                        would you like them sent to you?</div>
                                    <div class="small text-gray-500">Jae Chun · 1d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="images/undraw_profile_3.svg"
                                         alt="...">
                                    <div class="status-indicator bg-warning"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Last month's report looks great, I am very happy with
                                        the progress so far, keep up the good work!</div>
                                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                         alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                        told me that people say this to all dogs, even if they aren't good...</div>
                                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%
                                Usuario usuarioSesion = (Usuario) session.getAttribute("usuario");
                                if (usuarioSesion != null) {
                            %>
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                 <%= usuarioSesion.getNombre() %> <%= usuarioSesion.getApellido() %>
                            </span>
                            <%
                                }
                            %>

                            <img class="img-profile rounded-circle"
                                 src="images/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Perfil
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Configuración
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Actividades
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Salir
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!---------------------------------- Fin de Barra de Accesos ------------------------------>
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="card shadow mb-4" style="border-radius: 28px;">
                    <div class="card-header py-3" style="
    height: 54px;
    background-color: #b75b5b;
    color: #5a7777;
    font-family: cursive;
">
                        <h4 class="m-0 font-weight-bold text-primary">Tabla de Usuarios</h4>
                    </div>
                    <div class="card-body" style="font-family: cursive; display: flex; align-items: center;">
                        <div style="flex: 1;">
                            <p>Esta sección presenta a los usuarios que tienen acceso al gestor de inventarios de Republica Café . Cada usuario registrado cuenta con permisos específicos para gestionar, actualizar y consultar el inventario, asegurando que solo las personas autorizadas puedan realizar modificaciones. La correcta administración de estos accesos es clave para mantener la seguridad y el control dentro del sistema, evitando errores y accesos no deseados.</p>
                        </div>
                        <div style="margin-left: 20px;">
                            <img src="images/8.png" alt="Descripción de la imagen" style="width: 200px; height: auto;">
                        </div>
                    </div>
                </div>
                <!-- div de concepto -->

                <div class="card shadow mb-4" style="border-radius: 28px;">
                    <div class="card-header py-3" style="
    height: 54px;
    background-color: #b75b5b;
    color: #5a7777;
    font-family: cursive;
">
                        <h6 class="m-0 font-weight-bold text-primary">Lista de Usuarios</h6>
                    </div>
                    <div class="card-body" style="
    background-color: #ebacad;
">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>DNI</th>
                                    <th>Email</th>
                                    <th>Rol</th>
                                    <th>Fecha Creación</th>
                                    <th>Acciones</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    if (usuariosLista == null || usuariosLista.isEmpty()) {
                                %>
                                <tr>
                                    <td colspan="8">No hay usuarios disponibles</td>
                                </tr>
                                <%
                                } else {
                                    for (UsuarioData usuario : usuariosLista) {
                                %>
                                <tr>
                                    <td><%= usuario.getId() %></td>
                                    <td><%= usuario.getNombre() %></td>
                                    <td><%= usuario.getApellido() %></td>
                                    <td><%= usuario.getDni() %></td>
                                    <td><%= usuario.getEmail() %></td>
                                    <td><%= usuario.getRol() %></td>
                                    <td><%= usuario.getFechacreacion() != null ? usuario.getFechacreacion() : "N/A" %></td>
                                    <td>
                                        <div class="action" style="display: flex; justify-content: space-between; align-items: center; gap: 10px;">
                                            <a class="btnac" href="#" title="Editar">
                                                <i class="fas fa-pencil-alt fa-sm"></i>
                                            </a>
                                            <a class="btnac" href="javascript:void(0);" title="Eliminar"
                                               onclick="eliminarUsuario('<%= URLEncoder.encode(String.valueOf(usuario.getId()), "UTF-8") %>');">
                                                <i class="fas fa-trash-alt fa-sm"></i>
                                            </a>

                                            <script>
                                                function eliminarUsuario(idUsuario) {
                                                    const encodedId = encodeURIComponent(idUsuario);
                                                    const deleteUrl = `EliminarUsuarioControl?id=${encodedId}`;

                                                    if (confirm('¿Está seguro de que desea eliminar este usuario?')) {
                                                        window.location.href = deleteUrl;
                                                    }
                                                }
                                            </script>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                }
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright  2024</span>
                </div>
            </div>
        </footer>
    </div>
</div>
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">¿Seguro que deseas salir?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Selecciona "Cerrar sesión" abajo si estás listo para terminar tu sesión actual.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

                <form action="CerrarSesionServlet" method="POST">
                    <button type="submit" class="btn btn-primary">Cerrar sesión</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="vendor/jquery.min.js"></script>



<script src="vendor/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>

<script src="vendor/datatables/jquery.dataTables.min.js"></script>

<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
<script src="js/datatables-demo.js"></script>
</body>
</html>

