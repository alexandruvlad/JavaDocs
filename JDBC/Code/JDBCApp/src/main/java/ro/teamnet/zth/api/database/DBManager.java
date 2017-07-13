package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alexandru.Vlad on 7/13/2017.
 */
public class DBManager {

    private DBManager() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    private static String CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }

    public static Connection getConnection() throws SQLException {

        String URL = CONNECTION_STRING;
        String USER = DBProperties.USER;
        String PASS = DBProperties.PASS;

        Connection con = DriverManager.getConnection(URL,USER,PASS);

        return con;
    }

    public static boolean checkConnection(Connection connection){

        String query = "SELECT 1 FROM DUAL";
        try{
            Statement stm = connection.createStatement();
            stm.execute(query);
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
