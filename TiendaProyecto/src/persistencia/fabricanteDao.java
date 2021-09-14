package persistencia;

import entidades.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fabricanteDao extends dao{
    public fabricanteDao() {
    }
    
    public List<Fabricante> ConsultaMySqlFabricant(String query) throws SQLException, ClassNotFoundException {
        try {
            consultar(query);
            Fabricante fabri = null;
            List<Fabricante> fabricantes = new ArrayList<>();
            while (resultSet.next()) {   
                
                
                int codFab = Integer.parseInt(resultSet.getString(1));
                String nom = resultSet.getString(2);
                
                fabri = new Fabricante(codFab,nom);
                fabricantes.add(fabri);
            }
            return fabricantes;
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            desconectarse();
        } 
    }
    
}
