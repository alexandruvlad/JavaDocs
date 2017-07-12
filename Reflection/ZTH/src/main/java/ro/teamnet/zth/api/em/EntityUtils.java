package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Alexandru.Vlad on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity){

        Annotation[] an = entity.getAnnotations();
        for(Annotation a:an){
            if(a.annotationType().equals(Table.class)){
                return ((Table)a).name();
            }
        }

        return entity.getName();

    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        ArrayList<ColumnInfo> col = new ArrayList<ColumnInfo>(10);

        Field[] f = entity.getDeclaredFields();

        for(Field i : f) {
            if (i.getAnnotations().getClass().getName().equals(Column.class.getName()) ||
                    i.getAnnotations().getClass().getName().equals(Id.class.getName())) {
                ColumnInfo c = new ColumnInfo();

                c.setColumnName("");
                c.setColumnType(null);
                c.setDbColumnName("");
                c.setId(false);
                c.setValue(null);
                col.add(c);
            }
        }
        return col;
    }

    public static Object castFromSqlType(Object value, Class wantedType){

        if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Integer")){
            return (Integer)value;
        }else

        if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Long")){
            return (Long)value;
        } else
        if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Float")){
            return (float)value;
        } else

        if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Double")){
            return (double)value;
        } else {
            return value;
        }
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){

        ArrayList<Field> field = new ArrayList<Field>(10);

        Field[] f = clazz.getDeclaredFields();

        for(Field i:f){
            if(i.getAnnotations().getClass().getName().equals(annotation.getClass().getName())){
                field.add(i);
            }
        }
        return field;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {

        if(object.getClass().isAnnotationPresent(Table.class)){
            Field[] field = object.getClass().getFields();
            for(Field i:field){
                if(i.isAnnotationPresent(Id.class)){
                    i.setAccessible(true);
                    return i.get(object);
                }
            }
        }

        return object;

    }

}
