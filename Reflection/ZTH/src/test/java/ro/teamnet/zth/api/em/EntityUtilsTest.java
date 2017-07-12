package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Alexandru.Vlad on 7/12/2017.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    public void testGetTableNameMethod2() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }



}
