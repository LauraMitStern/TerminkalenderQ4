package dbconfig;

/**
 *
 * @author Laura Pein
 */
public enum ConfigEnum {
    DERBY("dbconfig/derby.db.properties"),
    POSTGRES("dbconfig/postgres.db.properties");

    private String filename;

    private ConfigEnum(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

}
