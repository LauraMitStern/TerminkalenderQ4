package import_export.DatabaseAccess;

import data.Appointment;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import sql.AppointmentSQL;

/**
 *
 * @author Laura Pein
 */
public class AccessDB {

    private final DBManager dbm = DBManager.getInstance();

    public static AccessDB getInstance() {
        return AccessDBHolder.INSTANCE;
    }

    private static class AccessDBHolder {

        private static final AccessDB INSTANCE = new AccessDB();
    }

    /**
     * Uploads a new entry to the database.
     * @param a Appointment which will be uploaded.
     * @throws java.sql.SQLException
     */
    public void persistEntity(Appointment a) throws SQLException {
        PreparedStatement pstmt = dbm.createPreparedStatement(AppointmentSQL.PSTMT_INSERT_APPOINTMENT.getSql(), Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, a.getName());
        pstmt.setString(2, a.getLocation());
        pstmt.setDate(3, Date.valueOf(a.getDate()));
        pstmt.setTime(4, Time.valueOf(a.getTime()));

        int affectedRow = pstmt.executeUpdate();
        System.out.println("affected Row: " + affectedRow);
    }

    /**
     * Loads all entries from the database.
     * @return Returns a list which contains all entries.
     * @throws java.sql.SQLException
     */
    public ArrayList<Appointment> loadAllEntries() throws SQLException {
        ArrayList<Appointment> list = new ArrayList();
        Statement st = dbm.createStatement();
        ResultSet set = st.executeQuery(AppointmentSQL.STMT_FIND_ALL.getSql());
        while (set.next()) {
            list.add(new Appointment(
                    set.getString("appName"),
                    set.getString("appLocation"),
                    Instant.ofEpochMilli(set.getDate("appDate").getTime()).atZone(ZoneId.systemDefault()).toLocalDate(),
                    set.getTime("appTime").toLocalTime(),
                    true));
        }
        return list;
    }

    /**
     * Deletes an Appointment from the database.
     * @param a Appointment which will be deleted.
     * @throws java.sql.SQLException
     */
    public void deleteEntry(Appointment a) throws SQLException {
        PreparedStatement pstmt = dbm.createPreparedStatement(AppointmentSQL.PSTMT_DELETE_BY_DATE_TIME.getSql(), Statement.RETURN_GENERATED_KEYS);
        pstmt.setDate(1, Date.valueOf(a.getDate()));
        pstmt.setTime(2, Time.valueOf(a.getTime()));

        int affectedRow = pstmt.executeUpdate();
        System.out.println("affected Row: " + affectedRow);
    }
}
