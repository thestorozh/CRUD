import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionSQL {
    private final String url = "jdbc:postgresql://localhost/myDB";
    private final String user = "postgress";
    private final String password = "1";
    private static final Logger logger = Logger.getGlobal();

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
            	logger.log(Level.INFO, "Connected to the PostgreSQL server successfully.");
            } else {
            	logger.log(Level.WARNING,"Failed to make connection!");
            }

        } catch (SQLException e) {
        	logger.log(Level.WARNING,"Error:");
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionSQL app = new ConnectionSQL();
        app.connect();
    }
}