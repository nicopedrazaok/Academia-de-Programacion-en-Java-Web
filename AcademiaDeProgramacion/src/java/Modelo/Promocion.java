package Modelo;

public class Promocion {
private int idPromocion;
private String nombrePromocion;
private float descuento;

    public Promocion(int idPromocion, String nombrepromocion, float descuento) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrepromocion;
        this.descuento = descuento;
    }

    public Promocion(String nombrepromocion, float descuento) {
        this.nombrePromocion = nombrepromocion;
        this.descuento = descuento;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrepromocion) {
        this.nombrePromocion = nombrepromocion;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", nombrepromocion=" + nombrePromocion + ", descuento=" + descuento + '}';
    }
}
