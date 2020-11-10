
package Servlets;

import AccesoDatos.GestorDocenteBD;
import Modelo.Docente;
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
@WebServlet(name = "ListadoDocente", urlPatterns = {"/ListadoDocente"})
public class ListadoDocente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDocenteBD g = new GestorDocenteBD();
        ArrayList<Docente> docente = g.listado();

        request.setAttribute("lista", docente);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoDocente.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDocenteBD g = new GestorDocenteBD();
        ArrayList<Docente> docente = g.listado();

        request.setAttribute("lista", docente);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoDocente.jsp");
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
