<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Modificar Nota</title>
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
            <h1>Modificar Nota</h1>
        </div>       
        <form method="POST" action="/AcademiaDeProgramacion/ModificarNota"> 
            <input type="hidden" name="txtIdNota" value="${notadto.nota.idNota}" />                        
            <div class="container">
                <div class="form-group col-md-6">
                    <label for="cboInscripcion">Inscripto: </label>
                    <select name="cboInscripcion" class="form-control">
                        <c:forEach var="inscripcion" items="${notadto.listaInscripcion}">
                            <option value="${inscripcion.idInscripcion}" <c:if test="${inscripcion.idInscripcion == notadto.nota.inscripcion.idInscripcion}">so. selected</c:if>>${inscripcion.alumno.nombre} ${inscripcion.alumno.apellido} ${inscripcion.legajo} Curso: ${inscripcion.curso.nombreCurso}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group col-md-6">
                    <label for="txtNombreNota">Nombre del nota: </label> 
                    <input type="text" name="txtNombreNota" id="txtNombreNota" class="form-control" value="${notadto.nota.nombreNota}"/>
                </div>


                <div class="form-group col-md-6">
                    <label for="txtNota">Nota </label>
                    <input type="text" name="txtNota" class="form-control" value="${notadto.nota.nota}"/>
                </div>

                <input type="submit" value="Modificar" class="btn btn-warning" />
            </div>        
        </form>
    </body>
</html>
