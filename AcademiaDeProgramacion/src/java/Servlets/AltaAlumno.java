
package Servlets;

import AccesoDatos.GestorAlumnoBD;
import Modelo.Alumno;
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
@WebServlet(name = "AltaAlumno", urlPatterns = {"/AltaAlumno"})
public class AltaAlumno extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaAlumno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaAlumno at " + request.getContextPath() + "</h1>");
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
        GestorAlumnoBD gestor = new GestorAlumnoBD();

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String sexo = request.getParameter("cboSexo");
        String fechaNacimiento = request.getParameter("txtFechaNacimiento");
        String tipoDocumento = request.getParameter("cboTipoDocumento");
        String documento = request.getParameter("txtDocumento");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");

        gestor.insertar(new Alumno(nombre, apellido, sexo, fechaNacimiento, tipoDocumento, documento, direccion, telefono, email));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoAlumno");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
