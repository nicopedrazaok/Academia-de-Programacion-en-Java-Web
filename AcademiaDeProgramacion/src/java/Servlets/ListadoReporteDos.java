
package Servlets;

import AccesoDatos.GestorReportesBD;
import Modelo.ReporteDos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListadoReporteDos", urlPatterns = {"/ListadoReporteDos"})
public class ListadoReporteDos extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorReportesBD gestor = new GestorReportesBD();
        ArrayList<ReporteDos> reportedos = gestor.listadoDescuentoTotalRealizado();

        request.setAttribute("lista", reportedos);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteDos.jsp");
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
