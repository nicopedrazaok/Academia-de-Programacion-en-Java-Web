
package Servlets;

import AccesoDatos.GestorReportesBD;
import Modelo.Inscripcion;
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
@WebServlet(name = "ListadoReporteTres", urlPatterns = {"/ListadoReporteTres"})
public class ListadoReporteTres extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorReportesBD gestor = new GestorReportesBD();
        ArrayList<Inscripcion> inscripcion = gestor.listadoAlumnoCurso();

        request.setAttribute("lista", inscripcion);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteTres.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorReportesBD gestor = new GestorReportesBD();
        ArrayList<Inscripcion> Inscripcion = gestor.listadoAlumnoCurso();

        request.setAttribute("lista", Inscripcion);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteTres.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorReportesBD gestor = new GestorReportesBD();
        String textoBuscar = request.getParameter("cboCurso");
        ArrayList<Inscripcion> inscripcion = gestor.BuscarPorCurso(textoBuscar);
        request.setAttribute("lista", inscripcion);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoReporteTres.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
