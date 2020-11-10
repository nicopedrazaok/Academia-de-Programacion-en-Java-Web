
package Modelo;

public class Nota {
    private int idNota;
    private Inscripcion inscripcion;
    private String nombreNota;
    private int nota;

    public Nota(int idNota, Inscripcion inscripcion, String nombreNota, int nota) {
        this.idNota = idNota;
        this.inscripcion = inscripcion;
        this.nombreNota = nombreNota;
        this.nota = nota;
    }

    public Nota(Inscripcion inscripcion, String nombreNota, int nota) {
        this.inscripcion = inscripcion;
        this.nombreNota = nombreNota;
        this.nota = nota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", inscripcion=" + inscripcion + ", nombreNota=" + nombreNota + ", nota=" + nota + '}';
    }

}
