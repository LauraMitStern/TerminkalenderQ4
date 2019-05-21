package dbconfig;

/**
 *
 * @author Laura Pein
 */
public enum RequiredKeysEnum {
    DRIVER("db.driver"),
    URL("db.url"),
    USERNAME("db.username"),
    PASSWORD("db.password");

    private String key;

    private RequiredKeysEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
