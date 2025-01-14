
package DAO;

import java.sql.*;

/**
 * @author Home
 */
public class Connect_SQL {

    public static Connection openConnection()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost;databaseName=QLDVat;"
                + "encrypt=true;trustservercertificate=true; sslProtocol=TLSv1.2"; // source connect db
        String userDB = "sa"; //username database
        String passwordDB = "Strongpass1@"; //pass
        Connection conn = DriverManager.getConnection(url, userDB, passwordDB);
        return conn;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
