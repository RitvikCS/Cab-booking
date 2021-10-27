package bphc.taxidriver ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    Connection connection = null;
    
    
    // Private -> Prevent objects of this class from being created in other classes
    private DatabaseManager() {
    }
    
    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        
        return stmt.executeQuery(query);//to retrieve data from database
    }
    
    public void executeUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        
        stmt.executeUpdate(update);//to update existing rows
    }
    
    public static DatabaseManager createConnection(String filePath) throws Exception {
        DatabaseManager manager = new DatabaseManager();//creating a database manager
        
         Class.forName("org.sqlite.JDBC");
         manager.connection = DriverManager.getConnection("jdbc:sqlite:" + filePath);//using filepath to connect database to manager
         
         return manager;
    }
    
    
}
