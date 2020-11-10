
package Servlets;

import AccesoDatos.GestorTurnoBD;
import Modelo.Turno;
import Modelo.TurnoDTO;
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
@WebServlet(name = "ModificarTurno", urlPatterns = {"/ModificarTurno"})
public class ModificarTurno extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarTurno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarTurno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       GestorTurnoBD gestor = new GestorTurnoBD();

        String idTurno = (String) request.getParameter("idTurno");
        int id = Integer.parseInt(idTurno);

        TurnoDTO ViewModel = new TurnoDTO();

        ViewModel.turno = gestor.BuscarIdTurno(id);

        request.setAttribute("turnodto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarTurno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorTurnoBD gestor = new GestorTurnoBD();
        int idTurno = Integer.parseInt((String) request.getParameter("txtIdTurno"));
        String nombreTurno = request.getParameter("txtNombreTurno");
        String horario = request.getParameter("txtHorario");

        gestor.modificar(new Turno(idTurno, nombreTurno, horario));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoTurno");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
