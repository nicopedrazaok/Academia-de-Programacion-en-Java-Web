package AccesoDatos;

import Modelo.Promocion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorPromocionBD {

    public void insertar(Promocion p) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Promociones (nombrePromocion,descuento) VALUES (?,?)");
            pstmt.setString(1, p.getNombrePromocion());
            pstmt.setFloat(2, p.getDescuento());
            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idPromocion) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Promociones WHERE idPromocion = ?");
            pstmt.setInt(1, idPromocion);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Promocion p) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Promociones SET nombrePromocion=?, descuento=? WHERE idPromocion=?");
            pstmt.setString(1, p.getNombrePromocion());
            pstmt.setFloat(2, p.getDescuento());
            pstmt.setInt(3, p.getIdPromocion());

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

    public ArrayList listado() {
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

}
