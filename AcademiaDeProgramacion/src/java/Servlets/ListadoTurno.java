
package Servlets;

import AccesoDatos.GestorTurnoBD;
import Modelo.Turno;
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
@WebServlet(name = "ListadoTurno", urlPatterns = {"/ListadoTurno"})
public class ListadoTurno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorTurnoBD g = new GestorTurnoBD();
        ArrayList<Turno> turno = g.listado();

        request.setAttribute("lista", turno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoTurno.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorTurnoBD g = new GestorTurnoBD();
        ArrayList<Turno> turno = g.listado();

        request.setAttribute("lista", turno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoTurno.jsp");
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
