
package Servlets;

import AccesoDatos.GestorProgramaBD;
import Modelo.Programa;
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
@WebServlet(name = "HabilitarPrograma", urlPatterns = {"/HabilitarPrograma"})
public class HabilitarPrograma extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String idPrograma = (String) request.getParameter("idPrograma");
        int id = Integer.parseInt(idPrograma);
        GestorProgramaBD gestor = new GestorProgramaBD();

        gestor.habilitar(new Programa(id));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoProgramaHabilitado");
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
