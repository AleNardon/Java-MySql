package Tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dao {
    
        
    //Connection es la clase que nos permite conectarnos a la base de datos
    protected Connection connection = null;
    //Statement es la clase que nos permite crear y ejecutar las querys
    protected Statement statement = null;
    //ResultSet es la clase que recibe el resultado de una consulta
    protected ResultSet resultSet = null;
    
    private String user = "root";
    private String password = "root";
    private String schema = "tienda";
    
    // En este método hacemos la conexion a la base de datos
    public void conectarse() throws SQLException, ClassNotFoundException {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");    
            String url = "jdbc:mysql://localhost:3306/"+schema+"?useSSL=false";    
            connection = DriverManager.getConnection(url, user, password);
        
        //cacth error de DriverManager.getConnection() al intentar conectarse al servidor
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Hubo un error al conectarse a la base de datos");
        
        //catch error de Class.forName("...") al intentar buscar la clase com.mysql.jdbc.Driver
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ClassNotFoundException("No se encontró la clase Driver");
        }
    }
    
    //-En este método vamos a desconectarnos de la base de datos para ahorrar recursos
    // porque cada vez que hacemos una conexión esta queda a la espera y continua
    //consumiendo recursos que luego afectan el rendimiento
    public void desconectarse() throws SQLException {
       try {
           // cerramos el resultSet si es existe
           if (resultSet != null) {
               resultSet.close();
           }
            // cerramos el statement si es existe
           if (statement != null) {
               statement.close();
           }
           // cerramos el connection si es existe
           if (connection != null) {
               connection.close();
           }
           
        // catch error .close -> SQLException 
       } catch (SQLException e) {
           e.printStackTrace();

           throw new SQLException("Ocurrio un error al intentar desconectarse");
       }
    }
    
    // ABM Alta Baja Modificación
    // CRUD Create Read Update Delete
    public void insertarModificarEliminar(String query) throws ClassNotFoundException, SQLException {
        // Nos conectamos a la base de datos
       conectarse();
       
       try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // IMPORTANTE: .rollback() es un método que retrocede la modificaciones realizadas
            // por la query al punto antes de su ejecución dejando la base de datos como estaba,
            // lo usamos en el caso que se produzca una excepcion para que no queden los cambios
            //que queriamos hacer a la mitad, solo es necesario usarlo en el catch de
            //insertarModificarEliminar porque las consultas con SELECT no modifican la base de
            //datos
            connection.rollback();
            
            throw new SQLException("Ocurrio un error al intentar hacer un CRUD");
        } finally {
            desconectarse();
        }
    }
    public void consultar(String query) throws SQLException, ClassNotFoundException {
       // Nos conectamos a la base de datos
        conectarse();
        try {
            //Inicializamos a statement para poder ejecutar la query
            statement = connection.createStatement();
            // utilizamos el método de statement .executeQuery para ejcutar la query,
            // el mismo se utiliza para las consultas SELECT en la base de datos
            // y devuelve un resultSet que es un objeto que contiene la respuesta de la
            // consulta realizada, el mismo será iterado en los respectivos DAO de cada
            // entidad para guardar los datos dentro de objetos que representan a las tablas
            // de las bases de datos
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            // Atrapamos el SQLException que puede lanzar .executeQuery
            //- indem(1)
            ex.printStackTrace();
            //- indem(2)
            throw new SQLException("Ocurrio un error al intentar hacer la consulta");
        } 
        // En este caso no realizamos un bloque finally porque no queremos cerrar el resulSet
        // porque necesitamos seguir usandolo para manipular sus datos, es por eso que la
        //desconexion en el caso de las consultas SELECT siempre las haremos en las clases DAO
        //de cada entidad
   }
}

