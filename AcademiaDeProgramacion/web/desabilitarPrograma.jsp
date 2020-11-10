<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Desabilitar Programa</h1>

        <form method="POST" action="/AcademiaDeProgramacion/DesabilitarPrograma"> 
            
            <input type="hidden" name="txtIdPrograma" id="txtIdPrograma" value="${programadto.programa.idPrograma}" />                        
            
              <label for="cboAlumno">Alumno </label>
            <select name="cboAlumno" >
                <c:forEach var="alumno" items="${programadto.listaAlumno}">
                    <option value="${alumno.idAlumno}" <c:if test="${alumno.idAlumno == programadto.programa.alumno.idAlumno}">so. selected</c:if>>${alumno.nombre} ${alumno.apellido}</option>
                </c:forEach>
            </select>
            
            <label>Descripcion: </label> 
            <input type="text" name="txtDescripcion" value="${programadto.programa.descripcion}"/>
            
            
            <label >Nombre del Programa: </label> 
            <input type="text" name="fileName" value="${programadto.programa.nombrePrograma}"/>
          
            <label for="rbtEstado">Estado: </label>
             
             <input type="radio" name="rbtEstado" id="rbtEstado" value=0 />Desabilitar<br><br> 


            <input type="submit" value="Enviar" />
    </body>
</html>
