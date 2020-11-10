
package Servlets;

import AccesoDatos.GestorNotaBD;
import Modelo.Inscripcion;
import Modelo.Nota;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AltaNota", urlPatterns = {"/AltaNota"})
public class AltaNota extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaNota</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaNota at " + request.getContextPath() + "</h1>");
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
     
        GestorNotaBD gestor = new GestorNotaBD();

        String idInscripcion = request.getParameter("cboInscripcion");
        String nombreNota = request.getParameter("txtNombreNota");        
        int nota = Integer.parseInt(request.getParameter("txtNota"));
       
        Inscripcion inscripcion = gestor.BuscarIdInscripcion(Integer.parseInt(idInscripcion));
        gestor.insertar(new Nota(inscripcion, nombreNota,nota));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoNota");
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
