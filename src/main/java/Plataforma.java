import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Plataforma implements iPlataforma{
    private static Plataforma instancia = new Plataforma();
    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
    private List<Paquete> paquetes = new ArrayList<>();

    private Plataforma(){}
    public static Plataforma getInstancia(){
        if (instancia == null) {
            instancia = new Plataforma();
        }
        return instancia;
    }

    //METODOS

    @Override
    public String informe() {

        String msgPeliculas = "";
        String msgSeries = "";
        String msgPaquetes = "";
        
        for (Pelicula peli: peliculas) {
            msgPeliculas += peli.getInfo();
        }
        for (Serie serie: series) {
            msgSeries += serie.getInfo();
        }
        for (Paquete paquete: paquetes) {
            msgPaquetes += paquete.getInfo();
        }
        
        String msg = "" +
                " " +
                "Catalogo: \n" +
                " Películas: \n" + msgPeliculas +
                "\n" +
                " Series \n" + msgSeries +
                " \n" +
                " Paquetes \n" + msgPaquetes;
        return msg;
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    @Override
    public void agregarSeries(Serie serie) {
        series.add(serie);
    }

    @Override
    public void agregarPaquetes(Paquete paquete) {
        paquetes.add(paquete);
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        for(Pelicula pelicula1: peliculas){
            peliculas.remove(pelicula1);
        }
    }

    @Override
    public void eliminarSerie(Serie serie) {
        Iterator<Serie> iterator = series.iterator();
        while (iterator.hasNext()) {
            Serie series = iterator.next();
            if(series == serie){
                iterator.remove();
            }
        }
    }

    @Override
    public void eliminarPaquete(Paquete paquete) {
        Iterator<Paquete> iterator = paquetes.iterator();
        while (iterator.hasNext()) {
            Paquete paquetes = iterator.next();
            if(paquetes == paquete){
                iterator.remove();
            }
        }
    }

    @Override
    public void alquilar(Produccion produccion) {
        if (produccion instanceof Serie) {
            for (Produccion produccion2: series) {
                if (series.contains(produccion2)) {
                    System.out.println("Alquilaste la serie: " + produccion2.getNombre());
                    break;
                }
            }
        } else if (produccion instanceof Pelicula) {
            for (Produccion produccion2: peliculas) {
                if (peliculas.contains(produccion2)) {
                    System.out.println("Alquilaste la película: " + produccion2.getNombre());
                    break;
                }
            }
        } else {
            System.out.println("Oops! No existe: " + produccion.getNombre() + " en nuestro catálogo.");
        }

    }

    public void alquilarPaquete(Paquete paquete){
        for (Paquete paquete1: paquetes) {
            if (paquetes.contains(paquete1)) {
                System.out.println("Alquilaste el paquete: " + paquete1.getNombrePaquete());
                break;
            } else {
                System.out.println("Oops! No existe: " + paquete1.getNombrePaquete() + " en nuestro catálogo.");
            }
        }
    }

    //GETTERS
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

}