
package servicio;
import java.sql.SQLException;
import persistencia.productoDao;
import entidades.Producto;
import java.util.List;
import java.util.Scanner;
public class productoService {
    Scanner input = new Scanner(System.in); 
    public productoService() {
    }
    public Producto creaProducto(){
        System.out.print("Ingrese el codigo: ");
        int codigo = input.nextInt();
        System.out.print("Ingrese el nombre: ");
        String nombre = input.next();
        System.out.print("Ingrese el precio: ");
        double precio = input.nextDouble();
        System.out.print("Ingrese el codigoFabicante: ");
        int codigoFabricante = input.nextInt();
        return new Producto(codigo,nombre,precio,codigoFabricante);
    }
    public void imprListProduc(int format,List<Producto> lista){
        for (Producto producto : lista) {
            switch (format) {
                case 0:
                    System.out.println(producto.getNombre());
                    break;
                case 1:
                    System.out.println(producto.getNombre() +  " y su precio es " +producto.getPrecio());
                    break;
                case 2:
                    System.out.println(producto);
                    break;
                default:
                    break;
            }
        }
    }
    public void consulMysql(String query,int format) throws SQLException, ClassNotFoundException{
        productoDao pd = new productoDao();
        List<Producto> lista = pd.ConsultaMySqlProduct(query);
        imprListProduc(2, lista);
        
    }
    public void Produc(int format) throws SQLException, ClassNotFoundException{
        consulMysql("SELECT codigo,nombre,precio,codigo_fabricante FROM producto",format); 
    }
    public void producosMayores() throws SQLException, ClassNotFoundException {
        consulMysql("SELECT codigo,nombre,precio,codigo_fabricante FROM producto where precio>=120 AND precio<=202",2);
    }
    public void portatiles() throws SQLException, ClassNotFoundException{
        consulMysql("SELECT * FROM producto where nombre like 'Portátil%' ",2);
    }
    public void minimo() throws SQLException, ClassNotFoundException{
        consulMysql("SELECT * FROM producto where precio= (select min(precio) from producto )",2);
    }
    public void ingreso() throws SQLException, ClassNotFoundException{
        productoDao pd = new productoDao();
        Producto agg = creaProducto();
        pd.insertarModificarEliminar("Insert into producto values ("+agg.getCodigo() +","+"'"+agg.getNombre()+"'"+","+agg.getPrecio()+","+agg.getCodigoFabricante()+")");
    }
   
}


