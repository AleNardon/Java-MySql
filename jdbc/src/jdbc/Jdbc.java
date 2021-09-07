
package jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.Conection.DBConection;
/**
 *
 * @author alejo
 */
public class Jdbc {

    public static void main(String[] args) throws SQLException {
        DBConection db = new DBConection();
        Statement stmt = db.stmtt();
        
        String sql= "SELECT * FROM TIENDA.FABRICANTE";
        ResultSet rs = stmt.executeQuery(sql);
        
        System.out.println(rs.getInt("codigo")+"   "+rs.getString("nombre"));
        
    }
    
}
