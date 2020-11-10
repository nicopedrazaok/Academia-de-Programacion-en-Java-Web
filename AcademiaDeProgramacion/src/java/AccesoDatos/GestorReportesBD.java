package AccesoDatos;

import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Docente;
import Modelo.Inscripcion;
import Modelo.Promocion;
import Modelo.ReporteCinco;
import Modelo.ReporteDos;
import Modelo.ReporteUno;
import Modelo.Turno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorReportesBD {

    public ArrayList listadoFacturacionTotalPorCurso() {
        ArrayList<ReporteUno> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select c.nombreCurso AS Curso,sum(i.precioTotal) AS FacturacionTotal\n"
                    + "from inscripcion i join cursos c on i.idcurso = c.idcurso \n"
                    + "group by c.nombreCurso");
            while (rs.next()) {
                String Curso = rs.getString("Curso");
                float FacturacionTotal = rs.getFloat("FacturacionTotal");

                lista.add(new ReporteUno(Curso, FacturacionTotal));

            }
            conexion.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList listadoDescuentoTotalRealizado() {
        ArrayList<ReporteDos> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select  sum(p.descuento) as DescuentoTotal\n"
                    + "from inscripcion i join promociones p on i.idPromocion = p.idPromocion");
            while (rs.next()) {

                float descuentoTotalRealizado = rs.getFloat("DescuentoTotal");

                lista.add(new ReporteDos(descuentoTotalRealizado));

            }
            conexion.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList listadoDescuentoTotalDeLosAlumnos() {
        ArrayList<ReporteCinco> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select a.nombre + ' , ' + a.apellido AS Alumno,sum(p.descuento) AS TotalDescuento\n"
                    + "from Inscripcion i join Alumnos a on i.idAlumno=a.idAlumno join\n"
                    + "Promociones p on i.idPromocion=p.idPromocion \n"
                    + "join cursos c on i.idCurso =c.idCurso\n"
                    + "where p.nombrePromocion not like 'Ninguna'\n"
                    + "group by a.nombre + ' , ' + a.apellido");
            while (rs.next()) {

                String alumno = rs.getString("Alumno");
                float totalDescuento = rs.getFloat("TotalDescuento");

                lista.add(new ReporteCinco(alumno, totalDescuento));

            }
            conexion.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList BuscarPorCurso(String texto) {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM inscripcion i JOIN cursos c ON i.idCurso = c.idCurso WHERE c.nombreCurso LIKE '%" + texto + "%'or c.idCurso like '%" + texto + "%'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idInscripcion = rs.getInt("idInscripcion");
                int idAlumno = rs.getInt("idAlumno");
                int idCurso = rs.getInt("idCurso");
                String fechaInscripcion = rs.getString("fechaInscripcion");
                String legajo = rs.getString("legajo");
                int idTurno = rs.getInt("idTurno");
                int idPromocion = rs.getInt("idPromocion");
                double precioTotal = rs.getDouble("precioTotal");

                Alumno alumno = BuscarIdAlumno(idAlumno);
                Curso curso = BuscarIdCurso(idCurso);
                Turno turno = BuscarIdTurno(idTurno);
                Promocion promocion = BuscarIdPromocion(idPromocion);

                lista.add(new Inscripcion(idInscripcion, alumno, curso, fechaInscripcion, legajo, turno, promocion, precioTotal));

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

    public ArrayList listadoAlumnoCurso() {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Inscripcion");
            while (rs.next()) {

                int idInscripcion = rs.getInt("idInscripcion");
                int idAlumno = rs.getInt("idAlumno");
                int idCurso = rs.getInt("idCurso");
                String fechaInscripcion = rs.getString("fechaInscripcion");
                String legajo = rs.getString("legajo");
                int idTurno = rs.getInt("idTurno");
                int idPromocion = rs.getInt("idPromocion");
                double precioTotal = rs.getDouble("precioTotal");

                Alumno alumno = BuscarIdAlumno(idAlumno);
                Curso curso = BuscarIdCurso(idCurso);
                Turno turno = BuscarIdTurno(idTurno);
                Promocion promocion = BuscarIdPromocion(idPromocion);

                lista.add(new Inscripcion(idInscripcion, alumno, curso, fechaInscripcion, legajo, turno, promocion, precioTotal));

            }
            conexion.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }


    public ArrayList listadoCurso() {
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
                lista.add(new Curso(idCurso, nombreCurso, docente, duracion, modalidad, precio));

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

    public Alumno BuscarIdAlumno(int idAlumno) {
        Alumno a = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Alumnos WHERE idAlumno=?");
            pstmt.setInt(1, idAlumno);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String sexo = rs.getString("sexo");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String tipoDocumento = rs.getString("tipoDocumento");
                String documento = rs.getString("documento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                a = new Alumno(idAlumno, nombre, apellido, sexo, fechaNacimiento, tipoDocumento, documento, direccion, telefono, email);
                pstmt.close();
                conexion.close();
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
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
                c = new Curso(idCurso, nombreCurso, docente, duracion, modalidad, precio);

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

    public Promocion BuscarIdPromocion(int idPromocion) {
        Promocion p = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Promociones WHERE idPromocion=?");
            pstmt.setInt(1, idPromocion);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String nombrePromocion = rs.getString("nombrePromocion");
                float descuento = rs.getFloat("descuento");

                p = new Promocion(idPromocion, nombrePromocion, descuento);

            }
            pstmt.close();
            conexion.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
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

    public Turno BuscarIdTurno(int idTurno) {
        Turno resultado = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Turnos WHERE idTurno=?");
            pstmt.setInt(1, idTurno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String nombreTurno = rs.getString("nombreTurno");
                String horario = rs.getString("horario");
                resultado = new Turno(idTurno, nombreTurno, horario);
            }
            conexion.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorCursoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
