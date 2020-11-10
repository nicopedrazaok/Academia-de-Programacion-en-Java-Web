
package Servlets;

import AccesoDatos.GestorPromocionBD;
import Modelo.PromocionDTO;
import Modelo.Promocion;
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
@WebServlet(name = "ModificarPromocion", urlPatterns = {"/ModificarPromocion"})
public class ModificarPromocion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarPromocion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarPromocion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      GestorPromocionBD gestor = new GestorPromocionBD();

        String idPromocion = (String) request.getParameter("idPromocion");
        int id = Integer.parseInt(idPromocion);

        PromocionDTO ViewModel = new PromocionDTO();

        ViewModel.promocion = gestor.BuscarIdPromocion(id);

        request.setAttribute("promociondto", ViewModel);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarPromocion.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       GestorPromocionBD gestor = new GestorPromocionBD();
      
        int idPromocion = Integer.parseInt((String)request.getParameter("txtIdPromocion"));
        String nombrePromocion = request.getParameter("txtNombrePromocion");
        float descuento = Float.parseFloat(request.getParameter("txtDescuento"));

        gestor.modificar(new Promocion(idPromocion, nombrePromocion, descuento));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoPromocion");
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
