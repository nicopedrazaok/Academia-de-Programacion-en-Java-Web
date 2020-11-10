
package Servlets;

import AccesoDatos.GestorReportesBD;
import Modelo.ReporteUno;
import java.io.IOException;
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
@WebServlet(name = "ListadoReporteUno", urlPatterns = {"/ListadoReporteUno"})
public class ListadoReporteUno extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          GestorReportesBD gestor = new GestorReportesBD();
        ArrayList<ReporteUno> reporteuno = gestor.listadoFacturacionTotalPorCurso();

        request.setAttribute("lista", reporteuno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteUno.jsp");
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
