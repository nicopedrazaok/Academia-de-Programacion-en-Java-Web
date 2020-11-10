
package Servlets;

import AccesoDatos.GestorReportesBD;
import Modelo.ReporteCinco;
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
@WebServlet(name = "ListadoReporteCinco", urlPatterns = {"/ListadoReporteCinco"})
public class ListadoReporteCinco extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       GestorReportesBD gestor = new GestorReportesBD();
        ArrayList<ReporteCinco> reportecinco = gestor.listadoDescuentoTotalDeLosAlumnos();

        request.setAttribute("lista", reportecinco);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteCinco.jsp");
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
