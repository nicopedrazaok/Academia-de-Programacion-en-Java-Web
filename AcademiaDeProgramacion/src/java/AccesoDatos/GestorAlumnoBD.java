package AccesoDatos;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorAlumnoBD {

    public void insertar(Alumno a) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Alumnos (nombre,apellido,sexo,fechaNacimiento,tipoDocumento,documento,direccion,telefono,email) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getApellido());
            pstmt.setString(3, a.getSexo());
            pstmt.setString(4, a.getFechaNacimiento());
            pstmt.setString(5, a.getTipoDocumento());
            pstmt.setString(6, a.getDocumento());
            pstmt.setString(7, a.getDireccion());
            pstmt.setString(8, a.getTelefono());
            pstmt.setString(9, a.getEmail());

            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idAlumno) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Alumnos WHERE idAlumno = ?");
            pstmt.setInt(1, idAlumno);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Alumno a) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Alumnos SET nombre=?, apellido=?, sexo=?,fechaNacimiento=?, tipoDocumento=?, documento=?,direccion=?, telefono=?, email=? WHERE idAlumno=?");
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getApellido());
            pstmt.setString(3, a.getSexo());
            pstmt.setString(4, a.getFechaNacimiento());
            pstmt.setString(5, a.getTipoDocumento());
            pstmt.setString(6, a.getDocumento());
            pstmt.setString(7, a.getDireccion());
            pstmt.setString(8, a.getTelefono());
            pstmt.setString(9, a.getEmail());
            pstmt.setInt(10, a.getIdAlumno());

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

    public ArrayList listado() {
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
