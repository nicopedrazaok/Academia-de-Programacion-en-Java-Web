
package Servlets;

import AccesoDatos.GestorTurnoBD;
import Modelo.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AltaTurno", urlPatterns = {"/AltaTurno"})
public class AltaTurno extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaTurno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaTurno at " + request.getContextPath() + "</h1>");
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
        GestorTurnoBD gestor = new GestorTurnoBD();
        String nombreTurno = request.getParameter("txtNombreTurno");
        String horario = request.getParameter("txtHorario");

        gestor.insertar(new Turno(nombreTurno, horario));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoTurno");
        rd.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
