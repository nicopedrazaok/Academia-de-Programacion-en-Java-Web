<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Alta Promocion</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Academia de Programacion</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Alumnos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoAlumno">Listado de Alumnos</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/altaAlumno.jsp">Registrar Alumno</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Cursos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoCurso">Listado de Cursos</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/altaCurso.jsp">Registrar Curso</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoDocente">Docentes</a> 
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Inscripcion
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoInscripcion">Listado de los Inscriptos</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/altaInscripcion.jsp">Alta Inscripcion</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoTurno">Turnos</a> 
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Programas de los Alumnos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoProgramaHabilitado">Listado de Programas</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/altaPrograma.jsp">Alta Programa</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoProgramaDesabilitado">Listado de Programas Desabilitados</a> 
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Notas
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoNota">Listado de las Notas</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/altaNota.jsp">Registrar Nota</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Reportes
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoReporteUno">Total Facurado por Curso</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoReporteDos">Total de Descuento Realizado</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoReporteTres">Listado de Alumnos con su curso</a>
                            <a class="dropdown-item" href="/AcademiaDeProgramacion/ListadoReporteCinco">Listado de los descuento del alumno</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <ul class="navbar-nav mr-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="/AcademiaDeProgramacion/ListadoPromocion">Promociones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/AcademiaDeProgramacion/index.jsp">Salir</a>
                        </li>
                    </ul>
                </form>
            </div>
        </nav>
        <br>  
        <div class="container">
            <h1>Registrar Promocion</h1>
        </div>
        <form method="POST" action="/AcademiaDeProgramacion/AltaPromocion"> 
            <div class="container">
                <div class="form-group col-md-6">
                    <label for="txtNombrePromocion">Nombre de la Promocion: </label>
                    <input type="text" name="txtNombrePromocion" class="form-control" id="txtNombrePromocion"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="txtDescuento">Descuento: </label>
                <input type="text" name="txtDescuento" class="form-control" id="txtDescuento"/>
                </div>            

                <input type="submit" value="Registrar" class=" btn btn-success" />
            </div>
        </form>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>