package DAO;

import model.Paquete;
import model.Produccion;

import java.util.ArrayList;

public class PaqueteDAO {

    public static String getInfo(Paquete paquete){
        String inf = "" + paquete.getNombrePaquete() + "  $ " + calcularPrecio(paquete) + "\n";
        return inf;
    }

    // Suponemos que el descuento es un porcentaje del 1% al 100%
    public static double calcularPrecio(Paquete paquete) {
        ArrayList<Produccion> producciones = paquete.getProducciones();
        double valor = 0;
        for (Produccion produccion: producciones) {
            valor += ProduccionDAO.calcularPrecio(produccion);
        }
        double desc = valor * (paquete.getDescuento()/100);
        valor = valor - desc;
        return valor;
    }

    





}
