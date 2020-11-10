package Servlets;

import AccesoDatos.GestorAlumnoBD;
import Modelo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicol
 */
@WebServlet(name = "ListadoAlumno", urlPatterns = {"/ListadoAlumno"})
public class ListadoAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnoBD g = new GestorAlumnoBD();
        ArrayList<Alumno> alumno = g.listado();

        request.setAttribute("lista", alumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnoBD g = new GestorAlumnoBD();
        ArrayList<Alumno> alumno = g.listado();

        request.setAttribute("lista", alumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
