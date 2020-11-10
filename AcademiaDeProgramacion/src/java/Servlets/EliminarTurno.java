
package Servlets;

import AccesoDatos.GestorTurnoBD;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminarTurno", urlPatterns = {"/EliminarTurno"})
public class EliminarTurno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String idTurno = (String) request.getParameter("idTurno");
        int id = Integer.parseInt(idTurno);

        GestorTurnoBD gestor = new GestorTurnoBD();
        gestor.eliminar(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoTurno");
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
