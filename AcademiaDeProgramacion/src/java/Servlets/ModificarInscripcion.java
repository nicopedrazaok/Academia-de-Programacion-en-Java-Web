
package Servlets;

import AccesoDatos.GestorInscripcionBD;
import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Inscripcion;
import Modelo.InscripcionDTO;
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
@WebServlet(name = "ModificarInscripcion", urlPatterns = {"/ModificarInscripcion"})
public class ModificarInscripcion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarInscripcion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarInscripcion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        GestorInscripcionBD gestor = new GestorInscripcionBD();
        String idIncripcion = (String)request.getParameter("idInscripcion");
        int id = Integer.parseInt(idIncripcion);

        InscripcionDTO ViewModel = new InscripcionDTO();

        ViewModel.inscripcion = gestor.BuscarIdInscripcion(id);
        ViewModel.listaAlumno = gestor.listadoAlumno();
        ViewModel.listaCurso = gestor.listadoCurso();
        ViewModel.listaTurno = gestor.listadoTurno();
        ViewModel.listaPromocion = gestor.listadoPromocion();
        request.setAttribute("inscripciondto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarInscripcion.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorInscripcionBD gestor = new GestorInscripcionBD();

        int idInscripcion = Integer.parseInt((String) request.getParameter("txtIdInscripcion"));
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
        gestor.modificar(new Inscripcion(idInscripcion,alumno, curso, fechaInscripcion,legajo,turno, promocion, precioTotal));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoInscripcion");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
