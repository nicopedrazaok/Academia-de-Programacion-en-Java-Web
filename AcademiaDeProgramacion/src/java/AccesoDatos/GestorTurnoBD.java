package AccesoDatos;

import Modelo.Turno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorTurnoBD {

    public void insertar(Turno t) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Turnos (nombreTurno,horario) VALUES (?,?)");
            pstmt.setString(1, t.getNombreTurno());
            pstmt.setString(2,t.getHorario());
            pstmt.executeUpdate();
            pstmt.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idTurno) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM Turnos WHERE idTurno = ?");
            pstmt.setInt(1, idTurno);
            pstmt.executeUpdate();

            pstmt.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar(Turno t) {
        boolean modificar = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Turnos SET nombreTurno=?, horario=? WHERE idTurno=?");
            pstmt.setString(1, t.getNombreTurno());
            pstmt.setString(2,t.getHorario());
            pstmt.setInt(3, t.getIdTurno());

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

    public Turno BuscarIdTurno(int idTurno) {
        Turno t = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Turnos WHERE idTurno=?");
            pstmt.setInt(1, idTurno);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
              
                String nombreTurno = rs.getString("nombreTurno");
                String horario = rs.getString("horario");

                t = new Turno(idTurno, nombreTurno,horario);
                pstmt.close();
                conexion.close();
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAlumnoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public ArrayList listado() {
        ArrayList<Turno> lista = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=AcademiaDeProgramacion", "sa", "nico123");
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Turnos");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idTurno = rs.getInt("idTurno");
                String nombreTurno = rs.getString("nombreTurno");
                String horario = rs.getString("horario");
                
                lista.add(new Turno(idTurno, nombreTurno,horario));

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
