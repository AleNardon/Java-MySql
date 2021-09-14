package Tienda;


import servicio.fabricanteService;
import java.sql.SQLException;
import servicio.productoService;
//package Tienda;

public class tienda {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        productoService servP =new productoService();
        fabricanteService servF = new fabricanteService();
        System.out.println("\n\n\nEjercicio1");
        servP.Produc(2);
        System.out.println("\n\n\nEjercicio2");
        servP.Produc(1);
        System.out.println("\n\n\nEjercicio3");
        servP.producosMayores();
        System.out.println("\n\n\nEjercicio4");
        servP.portatiles();
        System.out.println("\n\n\nEjercicio5");
        servP.minimo();
//        System.out.println("\n\n\nEjercicio6");
//        servP.ingreso();
//        servP.Produc(1);

        System.out.println("\n\n\nEjercicio7");
        servF.imprFabric();
        servF.ingreso();
        servF.imprFabric();
    }
    
}
