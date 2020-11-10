
package Servlets;

import AccesoDatos.GestorInscripcionBD;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarInscripcion", urlPatterns = {"/EliminarInscripcion"})
public class EliminarInscripcion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idInscripcion = (String) request.getParameter("idInscripcion");
        int id = Integer.parseInt(idInscripcion);

        GestorInscripcionBD gestor = new GestorInscripcionBD();
        gestor.eliminar(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoInscripcion");
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
