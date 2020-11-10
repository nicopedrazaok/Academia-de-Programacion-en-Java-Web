
package Servlets;

import AccesoDatos.GestorCursoBD;
import Modelo.Curso;
import Modelo.CursoDTO;
import Modelo.Docente;
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
@WebServlet(name = "ModificarCurso", urlPatterns = {"/ModificarCurso"})
public class ModificarCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarCurso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarCurso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorCursoBD gestor = new GestorCursoBD();

        String idCurso = (String) request.getParameter("idCurso");
        int id = Integer.parseInt(idCurso);

        CursoDTO ViewModel = new CursoDTO();

        ViewModel.curso = gestor.BuscarIdCurso(id);
        ViewModel.listaDocente = gestor.listadoDocente();
        request.setAttribute("cursodto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorCursoBD gestor = new GestorCursoBD();

        int idCurso = Integer.parseInt((String) request.getParameter("txtIdCurso"));
        String nombre = request.getParameter("txtNombreCurso");
        String idDocente = request.getParameter("cboDocente");
        String duracion = request.getParameter("txtDuracion");
        String modalidad = request.getParameter("txtModalidad");
        Double precio = Double.parseDouble(request.getParameter("txtPrecio"));

       
        Docente docente = gestor.BuscarIdDocente(Integer.parseInt(idDocente));
        gestor.modificar(new Curso(idCurso,nombre, docente,duracion,modalidad, precio));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoCurso");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
