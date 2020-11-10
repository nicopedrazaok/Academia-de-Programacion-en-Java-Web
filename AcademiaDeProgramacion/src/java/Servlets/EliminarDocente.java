
package Servlets;

import AccesoDatos.GestorDocenteBD;
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
@WebServlet(name = "EliminarDocente", urlPatterns = {"/EliminarDocente"})
public class EliminarDocente extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDocente = (String) request.getParameter("idDocente");
        int id = Integer.parseInt(idDocente);

        GestorDocenteBD gestor = new GestorDocenteBD();
        gestor.eliminar(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDocente");
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
