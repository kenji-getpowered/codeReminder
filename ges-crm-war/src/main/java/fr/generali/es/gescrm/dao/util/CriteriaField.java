package fr.generali.es.gescrm.dao.util;

/**
 * @author Mikael KROK (b002ksc)
 * @date 16/05/2016
 * This manager allows to generate the entire name of a field in a where criteria
 */
public class CriteriaField {

    private String fieldSchema;

    private String fieldTable;

    private String fieldName;

    private Object fieldValue;

    public CriteriaField(String fieldSchema, String fieldTable, String fieldName, Object value) {
        this(fieldTable, fieldName, value);
        this.fieldSchema = fieldSchema;
    }

    public CriteriaField(String fieldTable, String fieldName, Object value) {
        this(fieldName,value);
        this.fieldTable = fieldTable;
    }
    public CriteriaField(String fieldName, Object value) {
        this.fieldName = fieldName;
        this.fieldValue = value;
    }

    public String getSchema() {
        return fieldSchema;
    }

    public String getTable() {
        return fieldTable;
    }

    public String getName() {
        return fieldName;
    }

    public  Object getValue(){
        return fieldValue;
    }

    /**
     * @return the entire name f the field, composed with the schema, the table and the name
     */
    public String getFullName(){
        String result = "";
        if(fieldSchema != null && !"".equals(fieldSchema)){
            result += fieldSchema +".";
        }
        if(fieldTable != null && !"".equals(fieldTable)){
            result += fieldTable +".";
        }
        if(fieldName != null && !"".equals(fieldName)){
            result += fieldName;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaField that = (CriteriaField) o;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (fieldSchema != null ? !fieldSchema.equals(that.fieldSchema) : that.fieldSchema != null) return false;
        if (fieldTable != null ? !fieldTable.equals(that.fieldTable) : that.fieldTable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldSchema != null ? fieldSchema.hashCode() : 0;
        result = 31 * result + (fieldTable != null ? fieldTable.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }
}
