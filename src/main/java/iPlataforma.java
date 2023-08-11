public interface iPlataforma {
    String informe();
    void agregarSeries(Serie serie);
    void agregarPaquetes(Paquete paquete);
    void agregarPeliculas(Pelicula pelicula);
    void eliminarPelicula(Pelicula pelicula);
    void eliminarSerie(Serie serie);
    void eliminarPaquete(Paquete paquete);
    void alquilar(Produccion produccion);
    void alquilarPaquete(Paquete paquete);
}
