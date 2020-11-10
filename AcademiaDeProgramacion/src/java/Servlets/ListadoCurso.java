
package Servlets;

import AccesoDatos.GestorCursoBD;
import Modelo.Curso;
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
@WebServlet(name = "ListadoCurso", urlPatterns = {"/ListadoCurso"})
public class ListadoCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorCursoBD gestor = new GestorCursoBD();
        ArrayList<Curso> curso = gestor.listado();

        request.setAttribute("lista", curso);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoCurso.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorCursoBD gestor = new GestorCursoBD();
        ArrayList<Curso> curso = gestor.listado();

        request.setAttribute("lista", curso);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoCurso.jsp");
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
