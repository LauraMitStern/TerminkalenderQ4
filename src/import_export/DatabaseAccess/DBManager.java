package import_export.DatabaseAccess;

import dbconfig.ConfigEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laura Pein
 */
public class DBManager {

    private DBPropertiesManager dbpm = DBPropertiesManager.getInstance();
    private Connection con;

    private DBManager() {
        try {
            dbpm.createProperties(ConfigEnum.DERBY);
            Class.forName(dbpm.getDriver());
            con = DriverManager.getConnection(dbpm.getUrl(), dbpm.getUsername(), dbpm.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBManager getInstance() {
        return DBManagerHolder.INSTANCE;
    }

    private static class DBManagerHolder {

        private static final DBManager INSTANCE = new DBManager();
    }

    public PreparedStatement createPreparedStatement(String sql, int... params) throws SQLException {
        switch (params.length) {
            case 0:
                return con.prepareStatement(sql);
            default:
                return con.prepareStatement(sql, params[0]);
        }
    }
    
    public Statement createStatement() throws SQLException{
        return con.createStatement();
    }

    public void close() throws Exception {
        con.close();
    }
}
