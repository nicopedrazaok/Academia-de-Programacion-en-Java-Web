<%@page import="AccesoDatos.GestorInscripcionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Alta Inscripcion</title>
    </head>
    <body>
        <jsp:useBean id="gestor" scope="request" class="AccesoDatos.GestorInscripcionBD"/>
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
            <h1>Alta de Inscripcion</h1>
        </div>

        <form method="POST" action="/AcademiaDeProgramacion/AltaInscripcion"> 
            <div class="container">
                <div class="form-group col-md-6">
                    <label for="cboAlumno">Alumno: </label>
                    <select name="cboAlumno" class="form-control">
                        <c:forEach var="alumno" items="${gestor.listadoAlumno()}">
                            <option value="${alumno.idAlumno}">${alumno.apellido}, ${alumno.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="cboCurso">Curso: </label>
                    <select name="cboCurso" class="form-control">
                        <c:forEach var="curso" items="${gestor.listadoCurso()}">
                            <option value="${curso.idCurso}">${curso.nombreCurso} Precio: ${curso.precio}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="txtFechaInscripcion">Fecha de Inscripcion: </label>
                    <input type="text" name="txtFechaInscripcion" id="txtFechaInscripcion" class="form-control"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="txtLegajo">Legajo: </label>
                    <input type="text" name="txtLegajo" id="txtLegajo" class="form-control"/>
                </div>

                <div class="form-group col-md-6">
                    <label for="cboTurno" >Turno: </label>
                    <select name="cboTurno" class="form-control">
                        <c:forEach var="turno" items="${gestor.listadoTurno()}">
                            <option value="${turno.idTurno}">${turno.nombreTurno} Horario: ${turno.horario}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="cboPromocion">Promocion: </label>
                    <select name="cboPromocion"  class="form-control">
                        <c:forEach var="promocion" items="${gestor.listadoPromocion()}">
                            <option value="${promocion.idPromocion}">${promocion.nombrePromocion} ${promocion.descuento}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="txtPrecioTotal">Precio total: </label>
                    <input type="text" name="txtPrecioTotal" id="txtPrecioTotal" class="form-control" />
                </div>

                <input type="submit" value="Registrar" class="btn btn-success" />
            </div>
        </form>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
