package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import AccesoDatos.GestorProgramaBD;
import Modelo.Programa;
import Modelo.Alumno;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;

@WebServlet(name = "AltaPrograma", urlPatterns = {"/AltaPrograma"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "C:\\Users\\nicol\\OneDrive\\Escritorio\\AcademiaDeProgramacion\\web\\Programas"
)
public class AltaPrograma extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaPrograma</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaPrograma at " + request.getContextPath() + "</h1>");
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
        GestorProgramaBD gestor = new GestorProgramaBD();
        
        String idAlumno = request.getParameter("cboAlumno");
        String descripcion = request.getParameter("txtDescripcion");
        int estado = Integer.parseInt(request.getParameter("rbtEstado"));
        Alumno alumno = gestor.BuscarIdAlumno(Integer.parseInt(idAlumno));
        for (Part part : request.getParts()) {
             String fileName = getFileName(part);
            if(!fileName.isEmpty()){
               part.write(fileName);    
        gestor.insertar(new Programa(alumno,descripcion,fileName, estado));   
            }      
        } 
        
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoProgramaHabilitado");
        rd.forward(request, response);
}
     private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }


@Override
        public String getServletInfo() {
        return "Short description";
    }

}
