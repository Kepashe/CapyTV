package model;

public class Serie extends Produccion{

    public Serie() {
    }

    public Serie(int id, String nombre, String descripción, double duracion, double precioPorHora) {
        super(id, nombre, descripción, duracion, precioPorHora);
    }
}
