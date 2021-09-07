
package jdbc;
import jdbc.Conection.DBConection;
/**
 *
 * @author alejo
 */
public class Jdbc {

    public static void main(String[] args) {
        DBConection db = new DBConection();
        db.getConnection();
    }
    
}
