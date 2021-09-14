package persistencia;
import entidades.Producto;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productoDao extends dao{

    public productoDao() {
    }
    
    public List<Producto> ConsultaMySqlProduct(String query) throws SQLException, ClassNotFoundException {
        try {
            consultar(query);
            Producto produc = null;
            List<Producto> productos = new ArrayList<>();
            while (resultSet.next()) {   
                
                
                int cod = Integer.parseInt(resultSet.getString(1));
                String nom = resultSet.getString(2);
                double prec = Double.parseDouble(resultSet.getString(3));;
                int codfab = Integer.parseInt(resultSet.getString(4));
                
                produc = new Producto(cod,nom,prec,codfab);
                productos.add(produc);
            }
            return productos;
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            desconectarse();
        } 
    }
    
}
