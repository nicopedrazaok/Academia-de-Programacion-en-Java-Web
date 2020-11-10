
<%@page import="Modelo.Turno"%>
<%@page import="AccesoDatos.GestorTurnoBD"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Listado de Turnos</title>
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
                    <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
                </form>
            </div>
        </nav>
                <br>  
        <h1>Listados de turnos</h1>
        <br>
        <a href="/AcademiaDeProgramacion/altaTurno.jsp" class="btn btn-primary"/>Nuevo</a>
        <table class="table table-bordered table-primary ">
            <thead>
            <th scope="row">Nombre del Turno</th>
            <th scope="row">Horario del Turno</th>
            </thead>           
            <tbody>
            <c:forEach var="turno" items="${lista}">
				<tr>
					
                                        <td>${turno.nombreTurno}</td>
					<td>${turno.horario}</td>
					<td><a href="/AcademiaDeProgramacion/ModificarTurno?idTurno=${turno.idTurno}" class="btn btn-warning">Modificar</a></td>
					<td><a href="/AcademiaDeProgramacion/EliminarTurno?idTurno=${turno.idTurno}" class="btn btn-danger">Eliminar</a></td>
				</tr>
	   </c:forEach>
            </tbody>
        </table>
    </body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>