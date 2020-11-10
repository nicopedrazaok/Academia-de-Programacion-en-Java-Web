package AccesoDatos;

import Modelo.Curso;
import Modelo.Docente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorCursoBD {

    public void insertar(Curso c) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Cursos(nombreCurso,idDocente,duracion,modalidad,precio) VALUES (?,?,?,?,?)");
            pstmt.setString(1, c.getNombreCurso());
            pstmt.setInt(2, c.getDocente().getIdDocente());
            pstmt.setString(3, c.getDuracion());
            pstmt.setString(4, c.getModalidad());
            pstmt.setDouble(5, c.getPrecio());

            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idCurso) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Cursos WHERE idCurso = ?");
            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Curso c) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Cursos SET nombreCurso=?,idDocente=?,duracion=?, modalidad=?,precio=? WHERE idCurso=?");
            pstmt.setString(1, c.getNombreCurso());
            pstmt.setInt(2, c.getDocente().getIdDocente());
            pstmt.setString(3, c.getDuracion());
            pstmt.setString(4, c.getModalidad());
            pstmt.setDouble(5, c.getPrecio());
            pstmt.setInt(6, c.getIdCurso());

            pstmt.executeUpdate();
            modificar = true;
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modificar;
    }

    public ArrayList listado() {
        ArrayList<Curso> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Cursos");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String nombreCurso = rs.getString("nombreCurso");
                int idDocente = rs.getInt("idDocente");
                String duracion = rs.getString("duracion");
                String modalidad = rs.getString("modalidad");
                double precio = rs.getDouble("precio");
               
                Docente docente = BuscarIdDocente(idDocente);
                lista.add(new Curso(idCurso, nombreCurso, docente,duracion,modalidad,precio));

            }
            conexion.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Curso BuscarIdCurso(int idCurso) {
        Curso c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Cursos WHERE idCurso=?");
            pstmt.setInt(1, idCurso);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String nombreCurso = rs.getString("nombreCurso");
                int idDocente = rs.getInt("idDocente");
                String duracion = rs.getString("duracion");
                String modalidad = rs.getString("modalidad");
                double precio = rs.getDouble("precio");
                
                Docente docente = BuscarIdDocente(idDocente);
                c = new Curso(idCurso, nombreCurso,docente,duracion,modalidad,precio);

            }
            pstmt.close();
            conexion.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public Docente BuscarIdDocente(int idDocente) {
        Docente d = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Docentes WHERE idDocente=?");
            pstmt.setInt(1, idDocente);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String legajo = rs.getString("legajo");
                String correoInstitucional = rs.getString("correoInstitucional");

                d = new Docente(idDocente, nombre, apellido, legajo, correoInstitucional);

            }
            pstmt.close();
            conexion.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public ArrayList listadoDocente() {
        ArrayList<Docente> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Docentes");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idDocente = rs.getInt("idDocente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String legajo = rs.getString("legajo");
                String correoInstitucional = rs.getString("correoInstitucional");

                lista.add(new Docente(idDocente, nombre, apellido, legajo, correoInstitucional));

            }
            conexion.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}

