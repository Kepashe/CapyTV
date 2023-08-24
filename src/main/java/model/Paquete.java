package model;

import java.util.ArrayList;
import java.util.List;

public class Paquete {

    // ATRIBUTOS
    private int id;
    private String nombrePaquete;
    private ArrayList<Produccion> producciones = new ArrayList<>();
    private double descuento;

    // CONSTRUCTOR
    public Paquete(int id, String nombrePaquete, double descuento){
        this.id = id;
        this.nombrePaquete = nombrePaquete;
        this.descuento = descuento;
        this.producciones = new ArrayList<>();
    }

    public Paquete() {
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // Métodos


}
