package AccesoDatos;

import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Docente;
import Modelo.Inscripcion;
import Modelo.Nota;
import Modelo.Promocion;
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

public class GestorNotaBD {

    public void insertar(Nota n) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Notas(idInscripcion,nombreNota,nota) VALUES (?,?,?)");
            pstmt.setInt(1, n.getInscripcion().getIdInscripcion());
            pstmt.setString(2, n.getNombreNota());
            pstmt.setInt(3, n.getNota());

            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idNota) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Notas WHERE idNota = ?");
            pstmt.setInt(1, idNota);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Nota n) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Notas SET idInscripcion=?,nombreNota=?,nota=? WHERE idNota=?");
            pstmt.setInt(1, n.getInscripcion().getIdInscripcion());
            pstmt.setString(2, n.getNombreNota());
            pstmt.setInt(3, n.getNota());
            pstmt.setInt(4, n.getIdNota());

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
        ArrayList<Nota> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Notas");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idNota = rs.getInt("idNota");
                int idInscripcion = rs.getInt("idInscripcion");
                String nombreNota = rs.getString("nombreNota");
                int nota = rs.getInt("nota");

                Inscripcion inscripcion = BuscarIdInscripcion(idInscripcion);
                lista.add(new Nota(idNota, inscripcion, nombreNota, nota));

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

    public Nota BuscarIdNota(int idNota) {
        Nota n = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Notas WHERE idNota=?");
            pstmt.setInt(1, idNota);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int idInscripcion = rs.getInt("idInscripcion");
                String nombreNota = rs.getString("nombreNota");
                int nota = rs.getInt("nota");

                Inscripcion inscripcion = BuscarIdInscripcion(idInscripcion);

                n = new Nota(idNota, inscripcion, nombreNota, nota);

            }
            pstmt.close();
            conexion.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Inscripcion BuscarIdInscripcion(int idInscripcion) {
        Inscripcion i = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Inscripcion WHERE idInscripcion=?");
            pstmt.setInt(1, idInscripcion);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

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
                i = new Inscripcion(idInscripcion, alumno, curso, fechaInscripcion, legajo, turno, promocion, precioTotal);

            }
            pstmt.close();
            conexion.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
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

    public ArrayList listadoInscripcion() {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Inscripcion");
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
}
