package jdbc.Conection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBConection {
    
    private static String DRIVER="com.mysql.jdbc.Driver";
    private static String USER="root";
    private static String PASS="root";
    private static String URL="jdbc:mysql://localhost:3306/tienda";
    
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR DRIVER");
        }
        
    }
    private Connection getConnection(){
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL,USER,PASS);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR conexion");
        }
        return con;
    }
    
    public Statement stmtt() throws SQLException{
        Connection con = getConnection();
        if (con!=null) return con.createStatement();
        else return null;
    }
    
}
