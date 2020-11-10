
package Modelo;


public class ReporteDos {
    private float descuentoTotalRealizado;

    public ReporteDos(float descuentoTotalRealizado) {
        this.descuentoTotalRealizado = descuentoTotalRealizado;
    }

    public float getDescuentoTotalRealizado() {
        return descuentoTotalRealizado;
    }

    public void setDescuentoTotalRealizado(float descuentoTotalRealizado) {
        this.descuentoTotalRealizado = descuentoTotalRealizado;
    }

    @Override
    public String toString() {
        return "ReporteDos{" + "descuentoTotalRealizado=" + descuentoTotalRealizado + '}';
    }
}
