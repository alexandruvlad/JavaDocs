package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Employee;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ro.teamnet.zth.api.em.EntityUtils.castFromSqlType;
import static ro.teamnet.zth.api.em.EntityUtils.getColumns;
import static ro.teamnet.zth.api.em.EntityUtils.getTableName;

/**
 * Created by Alexandru.Vlad on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {


    @Override
    public <T> T findById(Class<T> entityClass, Long id) {

        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String tableName = getTableName(entityClass);
        List<ColumnInfo> columns = getColumns(entityClass);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, id.getClass());

        Condition cond = new Condition();
        cond.setValue(id);

        for (ColumnInfo col : columns) {
            if (col.isId()) {
                cond.setColumnName(col.getDbColumnName());
            }
        }


        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setQueryType(QueryType.SELECT);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setTableName(tableName);
        queryBuilder.addCondition(cond);

        String query = queryBuilder.createQuery();
//        System.out.println(query);


        try {
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);

            int i = 1;

            if (resultSet.next()) {

                try {
                    T instance = entityClass.newInstance();

                    for (ColumnInfo col : columns) {
                        Field field = instance.getClass().getDeclaredField(col.getColumnName());
                        field.setAccessible(true);
                        field.set(instance, castFromSqlType(resultSet.getObject(col.getDbColumnName()), field.getType()));
                    }
                    return instance;

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) {

        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT MAX(" + columnIdName + ") from " + tableName;
        long Id = -1;

        try {
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);

            if (resultSet.next()) {
                Id = resultSet.getLong(1);
            }

            return Id + 10;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public <T> Object insert(T entity) {

        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        Long Id = 0L;

        for (ColumnInfo col : columns) {

            if (col.isId()) {
                Id = getNextIdVal(tableName, col.getDbColumnName());
                col.setValue(Id);
            } else {
                try {
                    Field f = entity.getClass().getDeclaredField(col.getColumnName());

                    f.setAccessible(true);

                    col.setValue(f.get(entity));

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setQueryType(QueryType.INSERT);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setTableName(tableName);

        String query = queryBuilder.createQuery();

        System.out.println(query);

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return findById(entity.getClass(), Id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {

        try {
            Connection con = DBManager.getConnection();




            String table = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

            QueryBuilder queryBuilder = new QueryBuilder();

            queryBuilder.setQueryType(QueryType.SELECT);
            queryBuilder.setTableName(table);
            queryBuilder.addQueryColumns(columns);

            String query = queryBuilder.createQuery();

            Statement stm = con.createStatement();
            try {
                ResultSet resultSet = stm.executeQuery(query);

                List<T> all = new ArrayList<T>();

                while(resultSet.next()){
                    T instance = entityClass.newInstance();

                    for (ColumnInfo col : columns) {
                        Field field = instance.getClass().getDeclaredField(col.getColumnName());
                        field.setAccessible(true);
                        field.set(instance, castFromSqlType(resultSet.getObject(col.getDbColumnName()), field.getType()));
                    }
                    all.add(instance);
                }

                return all;

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T update(T entity) {

        try {
            Connection con = DBManager.getConnection();

            String table = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

            Long Id = 0L;
            String colName = "";

            for (ColumnInfo col : columns) {

                Field field = entity.getClass().getDeclaredField(col.getColumnName());

                field.setAccessible(true);

                col.setValue(field.get(entity));

            }
            Id = (Long)columns.get(0).getValue();
            colName = columns.get(0).getDbColumnName();

            Condition cond = new Condition();
            cond.setColumnName(colName);
            cond.setValue(Id);
;

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.UPDATE);
            queryBuilder.addQueryColumns(columns);
            queryBuilder.addCondition(cond);
            queryBuilder.setTableName(table);

            String query = queryBuilder.createQuery();

            System.out.println(query);

            try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(query);
                return (T) findById(entity.getClass(), Id);

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Object entity) {

        try {
            Connection con = DBManager.getConnection();


            String table = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

            for (ColumnInfo col : columns) {

                Field field = entity.getClass().getDeclaredField(col.getColumnName());

                field.setAccessible(true);

                col.setValue(field.get(entity));

            }

            Long Id = (Long)columns.get(0).getValue();
            String colName = columns.get(0).getDbColumnName();

            Condition cond = new Condition();
            cond.setColumnName(colName);
            cond.setValue(Id);

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.DELETE);
            queryBuilder.addQueryColumns(columns);
            queryBuilder.addCondition(cond);
            queryBuilder.setTableName(table);

            String query = queryBuilder.createQuery();

            System.out.println(query);

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {

        try {
            Connection con = DBManager.getConnection();

            String table = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);


            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT);
            queryBuilder.addQueryColumns(columns);
            queryBuilder.setTableName(table);


            for(Map.Entry<String, Object> s : params.entrySet()){
                Condition cond = new Condition();
                cond.setColumnName(s.getKey());
                cond.setValue(s.getValue());
                queryBuilder.addCondition(cond);
            }

            String query = queryBuilder.createQuery();

            System.out.println(query);

            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);

            List<T> all = new ArrayList<T>();

            while(resultSet.next()){
                T instance = entityClass.newInstance();

                for (ColumnInfo col : columns) {
                    Field field = instance.getClass().getDeclaredField(col.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, castFromSqlType(resultSet.getObject(col.getDbColumnName()), field.getType()));
                }
                all.add(instance);
            }

            return all;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Employee> findEmployees(String departmentName) {

        try {
            Connection con = DBManager.getConnection();

            String query = "SELECT department_id from departments where department_name= '"+departmentName + "'";

            List<ColumnInfo> columns = EntityUtils.getColumns(Employee.class);

            System.out.println(query);

            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);

            Long depId = -20L;
            if(resultSet.next()){
                depId = resultSet.getLong(1);
            };

            resultSet.close();

            query = "SELECT employee_id, first_name, last_name from employees where department_id="+depId;

            System.out.println(query);

            stm = con.createStatement();
            ResultSet resultSet2 = stm.executeQuery(query);

            List<Employee> all = new ArrayList<Employee>();

            while(resultSet2.next()){
                Employee e = new Employee();

                e.setId(resultSet.getLong("employee_id"));
                e.setFirstName(resultSet.getString("first_name"));
                e.setLastName(resultSet.getString("last_name"));

                all.add(e);

            }

            return all;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
