
package Servlets;

import AccesoDatos.GestorCursoBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarCurso", urlPatterns = {"/EliminarCurso"})
public class EliminarCurso extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCurso = (String) request.getParameter("idCurso");
        int id = Integer.parseInt(idCurso);

        GestorCursoBD gestor = new GestorCursoBD();
        gestor.eliminar(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoCurso");
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
