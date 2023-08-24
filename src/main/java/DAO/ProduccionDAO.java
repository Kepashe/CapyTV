package DAO;

import model.Produccion;


public class ProduccionDAO {

    public static String getInfo(Produccion produccion){

        String inf = "" + produccion.getNombre() + "  $ " + calcularPrecio(produccion) + "\n";
        return inf;
    }

    public static double calcularPrecio(Produccion produccion){

        double precio = produccion.getDuracion() * produccion.getPrecioPorHora();
        return precio;
    }









}
