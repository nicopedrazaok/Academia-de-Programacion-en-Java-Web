
package Servlets;

import AccesoDatos.GestorProgramaBD;
import Modelo.Programa;
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
@WebServlet(name = "ListadoProgramaDesabilitado", urlPatterns = {"/ListadoProgramaDesabilitado"})
public class ListadoProgramaDesabilitado extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestorProgramaBD gestor = new GestorProgramaBD();
        ArrayList<Programa> programa = gestor.listadoProgramaDesabilitado();

        request.setAttribute("lista", programa);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoProgramaDesabilitado.jsp");
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
