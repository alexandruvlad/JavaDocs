package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Alexandru.Vlad on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void getConnectionTest() throws SQLException {

        Connection c = DBManager.getConnection();
        assertTrue(c!=null);

    }

    @Test
    public void checkConnectionTest() throws SQLException {
        Boolean b = DBManager.checkConnection(DBManager.getConnection());
        assertEquals(true,b);
    }


}
