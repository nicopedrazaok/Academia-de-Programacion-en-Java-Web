package AccesoDatos;

import Modelo.Curso;
import Modelo.Alumno;
import Modelo.Docente;
import Modelo.Promocion;
import Modelo.Inscripcion;
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

public class GestorInscripcionBD {

    public void insertar(Inscripcion i) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Inscripcion (idAlumno,idCurso,fechaInscripcion,legajo,idTurno,idPromocion,precioTotal) VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, i.getAlumno().getIdAlumno());
            pstmt.setInt(2, i.getCurso().getIdCurso());
            pstmt.setString(3, i.getFechaInscripcion());
            pstmt.setString(4, i.getLegajo());
            pstmt.setInt(5, i.getTurno().getIdTurno());
            pstmt.setInt(6, i.getPromocion().getIdPromocion());
            pstmt.setDouble(7, i.getPrecioTotal());

            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idInscripcion) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Inscripcion WHERE idInscripcion = ?");
            pstmt.setInt(1, idInscripcion);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Inscripcion i) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Inscripcion SET idAlumno=?, idCurso=?, fechaInscripcion=?,legajo=?,idTurno=?,idPromocion=?, precioTotal=? WHERE idInscripcion=?");
            pstmt.setInt(1, i.getAlumno().getIdAlumno());
            pstmt.setInt(2, i.getCurso().getIdCurso());
            pstmt.setString(3, i.getFechaInscripcion());
            pstmt.setString(4, i.getLegajo());
            pstmt.setInt(5, i.getTurno().getIdTurno());
            pstmt.setInt(6, i.getPromocion().getIdPromocion());
            pstmt.setDouble(7, i.getPrecioTotal());
            pstmt.setInt(8, i.getIdInscripcion());

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
                //int idAlumno = rs.getInt("idAlumno");
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

    public ArrayList<Turno> listadoTurno() {
        ArrayList<Turno> lista = new ArrayList<Turno>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Turnos");
            while (rs.next()) {
                int idTurno = rs.getInt("idTurno");
                String nombreTurno = rs.getString("nombreTurno");
                String horario = rs.getString("horario");

                lista.add(new Turno(idTurno, nombreTurno, horario));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorCursoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList listadoPromocion() {
        ArrayList<Promocion> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Promociones");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idPromocion = rs.getInt("idPromocion");
                String nombrePromocion = rs.getString("nombrePromocion");
                float descuento = rs.getFloat("descuento");

                lista.add(new Promocion(idPromocion, nombrePromocion, descuento));
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

    public ArrayList listadoAlumno() {
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Alumnos");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String sexo = rs.getString("sexo");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String tipoDocumento = rs.getString("tipoDocumento");
                String documento = rs.getString("documento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                lista.add(new Alumno(idAlumno, nombre, apellido, sexo, fechaNacimiento, tipoDocumento, documento, direccion, telefono, email));

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
}
