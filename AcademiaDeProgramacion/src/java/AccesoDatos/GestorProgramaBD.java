package AccesoDatos;

import Modelo.Alumno;
import Modelo.Programa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorProgramaBD {

    public void insertar(Programa p) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Programas (idAlumno,descripcion,nombrePrograma,estado) VALUES (?,?,?,?)");
            pstmt.setInt(1, p.getAlumno().getIdAlumno());
            pstmt.setString(2, p.getDescripcion());
            pstmt.setString(3, p.getNombrePrograma());
            pstmt.setInt(4, p.getEstado());

            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList listadoProgramaHabilitado() {
        ArrayList<Programa> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Programas WHERE estado = 1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idPrograma = rs.getInt("idPrograma");
                int idAlumno = rs.getInt("idAlumno");
                String descripcion = rs.getString("descripcion");
                String nombrePrograma = rs.getString("nombrePrograma");
                int estado = rs.getInt("estado");

                Alumno alumno = BuscarIdAlumno(idAlumno);
                lista.add(new Programa(idPrograma, alumno, descripcion, nombrePrograma, estado));

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

    public ArrayList listadoProgramaDesabilitado() {
        ArrayList<Programa> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Programas WHERE estado = 0");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idPrograma = rs.getInt("idPrograma");
                int idAlumno = rs.getInt("idAlumno");
                String descripcion = rs.getString("descripcion");
                String nombrePrograma = rs.getString("nombrePrograma");
                int estado = rs.getInt("estado");

                Alumno alumno = BuscarIdAlumno(idAlumno);
                lista.add(new Programa(idPrograma, alumno, descripcion, nombrePrograma, estado));

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

    public boolean desabilitar(Programa p) {
        boolean desabilitar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Programas SET estado=0 WHERE idPrograma=?");

            pstmt.setInt(1, p.getIdPrograma());

            pstmt.executeUpdate();
            desabilitar = true;
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desabilitar;
    }

    public boolean habilitar(Programa p) {
        boolean habilitar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Programas SET estado=1 WHERE idPrograma=?");

            pstmt.setInt(1, p.getIdPrograma());

            pstmt.executeUpdate();
            habilitar = true;
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return habilitar;
    }

    public Programa BuscarIdPrograma(int idPrograma) {
        Programa p = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Programas WHERE idPrograma=?");
            pstmt.setInt(1, idPrograma);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int idAlumno = rs.getInt("idAlumno");
                String descripcion = rs.getString("descripcion");
                String nombrePrograma = rs.getString("nombrePrograma");
                int estado = rs.getInt("estado");

                Alumno alumno = BuscarIdAlumno(idAlumno);
                p = new Programa(alumno, descripcion, nombrePrograma, estado);

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
}
