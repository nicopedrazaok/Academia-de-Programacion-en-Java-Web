
package Servlets;

import AccesoDatos.GestorLogin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        
        GestorLogin login = new GestorLogin();
        
        int ca = login.autenticacion(usuario, clave);
        if (ca > 0) {
            response.sendRedirect("/AcademiaDeProgramacion/menuPrincipal.jsp");
        } else {
            response.sendRedirect("/AcademiaDeProgramacion/index.jsp");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
