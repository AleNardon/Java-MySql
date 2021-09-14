package servicio;

import java.util.Scanner;
import entidades.Fabricante;
import java.sql.SQLException;
import java.util.List;
import persistencia.fabricanteDao;
public class fabricanteService {
    Scanner input = new Scanner(System.in); 
    public Fabricante creaFabricante(){
        System.out.print("Ingrese el codigo del fabricante: ");
        int codigo = input.nextInt();
        System.out.print("Ingrese el nombre del fabricante: ");
        String nom = input.next();
        return new Fabricante(codigo, nom);
    }
    
    public void imprListProduc(List<Fabricante> lista){
        for (Fabricante fabricante : lista) {       
            System.out.println(fabricante.toString());
        }
    }
    public void ingreso() throws SQLException, ClassNotFoundException{
        fabricanteDao pd = new fabricanteDao();
        Fabricante agg = creaFabricante();
        pd.insertarModificarEliminar("Insert into fabricante values ("+agg.getCodigoFabricante()+","+"'"+agg.getNombreFabricante()+"'"+")");
    }
    public void imprFabric() throws SQLException, ClassNotFoundException{
        fabricanteDao pd = new fabricanteDao();
        List<Fabricante> lista = pd.ConsultaMySqlFabricant("SELECT * FROM tienda.fabricante");
        imprListProduc (lista);
        
    }
    
}
