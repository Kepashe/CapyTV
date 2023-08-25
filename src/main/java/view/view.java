package view;

import view.jframe.Principal;

public class view {
//    public static void iniciar(){
//        //Creando Peliculas
//        Pelicula p1 = new Pelicula(1, "Pepe Grillo y la aventura de Pinocho", "A sí", 25, 50);
//        Pelicula p2 = new Pelicula(2, "La Gringa de los Ravioles", "A sí", 24, 50);
//        Pelicula p3 = new Pelicula(3, "Nodo de la cancha", "A sí", 12, 10);
//        Pelicula p4 = new Pelicula(4, "No tiene sentido el jg dif", "A sí", 2, 1.6);
//        Pelicula p5 = new Pelicula(5, "La historia de una Yumi salvaje", "A sí", 90, 30.5);
//        Pelicula p6 = new Pelicula(6, "PARAAA VIEJO", "A sí", 10, 34);
//        Pelicula p7 = new Pelicula(7, "No tengo plata :(", "A sí", 24, 20);
//
//        //Añadiendo las pelis a la lista
//        Plataforma.getInstancia().agregarPeliculas(p1);
//        Plataforma.getInstancia().agregarPeliculas(p2);
//        Plataforma.getInstancia().agregarPeliculas(p3);
//        Plataforma.getInstancia().agregarPeliculas(p4);
//        Plataforma.getInstancia().agregarPeliculas(p5);
//        Plataforma.getInstancia().agregarPeliculas(p6);
//        Plataforma.getInstancia().agregarPeliculas(p7);
//
//        //Creando Series
//        Serie s1 = new Serie(8, "Los Chicos", "A Nó", 200, 15.5);
//        Serie s2 = new Serie(9, "Las chicas", "A Nó", 15, 15);
//        Serie s3 = new Serie(10, "Pastel Americano", "A Nó", 769, 18);
//        Serie s4 = new Serie(11, "Dross", "A Nó", 100, 8);
//        Serie s5 = new Serie(12, "Planeta Vegetta Temporada 2!!! HOSTIA CHAVAL", "A Nó", 70, 60);
//        Serie s6 = new Serie(13, "A NÓ", "A Nó", 6, 99);
//        Serie s7 = new Serie(14, "Las Cronicas De Shako Suport", "A Nó", 55, 29.8);
//
//        //Añadiendo las series a la lista
//        Plataforma.getInstancia().agregarSeries(s1);
//        Plataforma.getInstancia().agregarSeries(s2);
//        Plataforma.getInstancia().agregarSeries(s3);
//        Plataforma.getInstancia().agregarSeries(s4);
//        Plataforma.getInstancia().agregarSeries(s5);
//        Plataforma.getInstancia().agregarSeries(s6);
//        Plataforma.getInstancia().agregarSeries(s7);
//
//        //Creando Paquetes
//        Paquete pa1 = new Paquete(1,"Random",10.0);
//        Paquete pa2 = new Paquete(2,"Aventuras de un lolero",5.0);
//        Paquete pa3 = new Paquete(3,"Series",15.0);
//
//        //Añadiendo producciones al paquete "Random"
//        pa1.setProducciones(p1);
//        pa1.setProducciones(p2);
//        pa1.setProducciones(p3);
//        pa1.setProducciones(p4);
//
//        //Añadiendo producciones al paquete "Aventuras de un lolero"
//        pa2.setProducciones(p4);
//        pa2.setProducciones(p5);
//        pa2.setProducciones(s6);
//
//        //Añadiendo producciones al paquete "Series"
//        pa3.setProducciones(s5);
//        pa3.setProducciones(p5);
//        pa3.setProducciones(s3);
//        pa3.setProducciones(p2);
//        pa3.setProducciones(p3);
//        pa3.setProducciones(s4);
//
//        //Añadiendo paquetes la lista
//        Plataforma.getInstancia().agregarPaquetes(pa2);
//        Plataforma.getInstancia().agregarPaquetes(pa3);
//
//
//        //Quitar Paquetes
//        Plataforma.getInstancia().eliminarPaquete(pa1);
//
//        //Quitar Series
//        Plataforma.getInstancia().eliminarSerie(s7);
//
//        //Quitar Pelis
//        Plataforma.getInstancia().eliminarPelicula(p7);
//
//
//
//        System.out.println(Plataforma.getInstancia().informe());
//
//
//        //Alquilar existente
//        Plataforma.getInstancia().alquilar(p2);
//        Plataforma.getInstancia().alquilar(s2);
//        Plataforma.getInstancia().alquilarPaquete(pa2);
//
//        //Alquilar inexistente
//        Plataforma.getInstancia().alquilar(p7);
//        Plataforma.getInstancia().alquilar(s7);
//
//
//    }

    public static void iniciarJframe() {
        Principal m = new Principal();
        m.setVisible(true);
    }

}
