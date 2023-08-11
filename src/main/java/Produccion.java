public abstract class Produccion {

    //Atributos
    private int id;
    private String nombre;
    private String descripción;
    private double duracion;
    private double precioPorHora;

    //Constructor

    public Produccion(int id, String nombre, String descripción, double duracion, double precioPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.duracion = duracion;
        this.precioPorHora = precioPorHora;
    }

    //Métodos

    String getInfo(){
        String inf = "" + nombre + "  $ " + calcularPrecio() + "\n";
        return inf;
    }

    double calcularPrecio(){
        double precio = duracion * precioPorHora;
        return precio;
    }

    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

}
