
package Servlets;

import AccesoDatos.GestorNotaBD;
import Modelo.Nota;
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
@WebServlet(name = "ListadoNota", urlPatterns = {"/ListadoNota"})
public class ListadoNota extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorNotaBD gestor = new GestorNotaBD();
        ArrayList<Nota> nota = gestor.listado();

        request.setAttribute("lista", nota);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoNota.jsp");
        rd.forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorNotaBD gestor = new GestorNotaBD();
        ArrayList<Nota> nota = gestor.listado();

        request.setAttribute("lista", nota);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoNota.jsp");
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
