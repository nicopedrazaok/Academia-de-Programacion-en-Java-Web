
package Servlets;

import AccesoDatos.GestorDocenteBD;
import Modelo.Docente;
import Modelo.DocenteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModificarDocente", urlPatterns = {"/ModificarDocente"})
public class ModificarDocente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarDocente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarDocente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorDocenteBD gestor = new GestorDocenteBD();

        String idDocente = (String) request.getParameter("idDocente");
        int id = Integer.parseInt(idDocente);

        DocenteDTO ViewModel = new DocenteDTO();

        ViewModel.docente = gestor.BuscarIdDocente(id);

        request.setAttribute("docentedto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarDocente.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      GestorDocenteBD gestor = new GestorDocenteBD();
        int idDocente = Integer.parseInt((String) request.getParameter("txtIdDocente"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String legajo = request.getParameter("txtLegajo");
        String correoInstitucional = request.getParameter("txtCorreoInstitucional");

        gestor.modificar(new Docente(idDocente, nombre, apellido, legajo, correoInstitucional));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDocente");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
