
package Servlets;

import AccesoDatos.GestorCursoBD;
import Modelo.Curso;
import Modelo.Turno;
import Modelo.Docente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AltaCurso", urlPatterns = {"/AltaCurso"})
public class AltaCurso extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorCursoBD gestor = new GestorCursoBD();

        String nombre = request.getParameter("txtNombreCurso");
        String idDocente = request.getParameter("cboDocente");
        String duracion = request.getParameter("txtDuracion");
        String modalidad = request.getParameter("txtModalidad");
        Double precio = Double.parseDouble(request.getParameter("txtPrecio"));

       
        Docente docente = gestor.BuscarIdDocente(Integer.parseInt(idDocente));
        gestor.insertar(new Curso(nombre, docente,duracion,modalidad, precio));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoCurso");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
