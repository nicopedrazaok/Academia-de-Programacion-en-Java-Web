package Modelo;


public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido;
    private String sexo;
    private String fechaNacimiento;
    private String tipoDocumento;
    private String documento;
    private String direccion;
    private String telefono;
    private String email;

    public Alumno(int idAlumno, String nombre, String apellido, String sexo, String fechaNacimiento, String tipoDocumento, String documento, String direccion, String telefono, String email) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
 public Alumno(String nombre, String apellido, String sexo, String fechaNacimiento, String tipoDocumento, String documento, String direccion, String telefono, String email) {
       
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    public Alumno() {
       
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
}
