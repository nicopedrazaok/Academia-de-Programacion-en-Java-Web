
package Servlets;

import AccesoDatos.GestorInscripcionBD;
import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Inscripcion;
import Modelo.Promocion;
import Modelo.Turno;
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
@WebServlet(name = "AltaInscripcion", urlPatterns = {"/AltaInscripcion"})
public class AltaInscripcion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaInscripcion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaInscripcion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorInscripcionBD gestor = new GestorInscripcionBD();
        String idAlumno = request.getParameter("cboAlumno");
        String idCurso = request.getParameter("cboCurso");
        String fechaInscripcion = request.getParameter("txtFechaInscripcion");
        String legajo = request.getParameter("txtLegajo");
        String idTurno = request.getParameter("cboTurno");
        String idPromocion = request.getParameter("cboPromocion");
        Double precioTotal = Double.parseDouble(request.getParameter("txtPrecioTotal"));

        Alumno alumno = gestor.BuscarIdAlumno(Integer.parseInt(idAlumno));
        Curso curso = gestor.BuscarIdCurso(Integer.parseInt(idCurso));
        Turno turno = gestor.BuscarIdTurno(Integer.parseInt(idTurno));
        Promocion promocion = gestor.BuscarIdPromocion(Integer.parseInt(idPromocion));
        gestor.insertar(new Inscripcion(alumno,curso,fechaInscripcion,legajo,turno,promocion,precioTotal));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoInscripcion");
        rd.forward(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
