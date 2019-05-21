package model;

/**
 *
 * @author Laura Pein
 */
public enum ColumnNames {
    NAME("Name"),
    LOCATION("Location"),
    DATE("Date"),
    TIME("Time");
    
    private String name;

    private ColumnNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
