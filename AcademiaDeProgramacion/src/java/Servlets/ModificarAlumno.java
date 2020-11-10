
package Servlets;

import AccesoDatos.GestorAlumnoBD;
import Modelo.Alumno;
import Modelo.AlumnoDTO;
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
@WebServlet(name = "ModificarAlumno", urlPatterns = {"/ModificarAlumno"})
public class ModificarAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarAlumno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarAlumno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnoBD gestor = new GestorAlumnoBD();

        String idAlumno = (String) request.getParameter("idAlumno");
        int id = Integer.parseInt(idAlumno);

        AlumnoDTO ViewModel = new AlumnoDTO();

        ViewModel.alumno = gestor.BuscarIdAlumno(id);

        request.setAttribute("alumnodto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnoBD gestor = new GestorAlumnoBD();
        
        int idAlumno = Integer.parseInt((String) request.getParameter("txtIdAlumno"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String sexo = request.getParameter("cboSexo");
        String fechaNacimiento = request.getParameter("txtFechaNacimiento");
        String tipoDocumento = request.getParameter("cboTipoDocumento");
        String documento = request.getParameter("txtDocumento");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");

        gestor.modificar(new Alumno(idAlumno, nombre, apellido, sexo, fechaNacimiento, tipoDocumento, documento, direccion, telefono, email));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoAlumno");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
