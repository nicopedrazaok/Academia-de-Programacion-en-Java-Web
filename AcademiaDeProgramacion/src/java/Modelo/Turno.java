package Modelo;

public class Turno {

    private int idTurno;
    private String nombreTurno;
    private String horario;

    public Turno(int idTurno, String nombreTurno, String horario) {
        this.idTurno = idTurno;
        this.nombreTurno = nombreTurno;
        this.horario = horario;
    }

    public Turno(String nombreTurno, String horario) {
        this.nombreTurno = nombreTurno;
        this.horario = horario;
    }

    public Turno() {
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turno{" + "idTurno=" + idTurno + ", nombreTurno=" + nombreTurno + ", horario=" + horario + '}';
    }

}
