
package Servlets;

import AccesoDatos.GestorNotaBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarNota", urlPatterns = {"/EliminarNota"})
public class EliminarNota extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idNota = (String) request.getParameter("idNota");
        int id = Integer.parseInt(idNota);

        GestorNotaBD gestor = new GestorNotaBD();
        gestor.eliminar(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoNota");
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
