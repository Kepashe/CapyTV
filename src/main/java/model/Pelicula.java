package model;

public class Pelicula extends Produccion {
    public Pelicula() {
    }

    public Pelicula(int id, String nombre, String descripción, double duracion, double precioPorHora, int tipo) {
        super(id, nombre, descripción, duracion, precioPorHora, tipo);
    }
}
