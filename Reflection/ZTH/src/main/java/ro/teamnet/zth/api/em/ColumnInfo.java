package ro.teamnet.zth.api.em;

/**
 * Created by Alexandru.Vlad on 7/12/2017.
 */
public class ColumnInfo {

    private String columnName;
    private Class columnType;
    private String dbColumnName;
    private boolean isId;
    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public String getDbColumnName() {
        return dbColumnName;
    }

    public boolean isId() {
        return isId;
    }

    public Object getValue() {
        return value;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
