import java.util.ArrayList;
import java.util.List;

public class Paquete {

    // ATRIBUTOS
    private int id;
    private String nombrePaquete;
    private List<Produccion> producciones;
    private double descuento;

    // CONSTRUCTOR
    public Paquete(int id, String nombrePaquete, double descuento){
        this.id = id;
        this.nombrePaquete = nombrePaquete;
        this.descuento = descuento;
        this.producciones = new ArrayList<>();
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public List<Produccion> getProducciones() {
        return producciones;
    }

    public double getDescuento() {
        return descuento;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public void setProducciones(Produccion produccion) {
        producciones.add(produccion);
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Métodos

    String getInfo(){
        String inf = "" + nombrePaquete + "  $ " + precioTotal() + "/n";
        return inf;
    }

    // Suponemos que el descuento es un porcentaje del 1% al 100%
    public double precioTotal() {
        double valor = 0;
        for (Produccion produccion: producciones) {
            valor += produccion.calcularPrecio();
        }
        double desc = valor * (descuento/100);
        valor = valor - desc;
        return valor;
    }
}
