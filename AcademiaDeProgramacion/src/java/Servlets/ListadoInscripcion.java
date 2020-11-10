
package Servlets;

import AccesoDatos.GestorInscripcionBD;
import Modelo.Inscripcion;
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
@WebServlet(name = "ListadoInscripcion", urlPatterns = {"/ListadoInscripcion"})
public class ListadoInscripcion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       GestorInscripcionBD gestor = new GestorInscripcionBD();
        ArrayList<Inscripcion> inscripcion = gestor.listado();

        request.setAttribute("lista", inscripcion);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoInscripcion.jsp");
        rd.forward(request, response);
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
