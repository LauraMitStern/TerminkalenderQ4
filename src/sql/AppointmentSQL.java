package sql;

/**
 *
 * @author Laura Pein
 */
public enum AppointmentSQL {
    STMT_FIND_ALL("SELECT * FROM Appointments"),
    PSTMT_FIND_BY_CITY("SELECT * FROM Appointments WHERE appLocation=?"),
    PSTMT_DELETE_BY_DATE_TIME("DELETE FROM Appointments WHERE appDate=? AND apptime=?"),
    PSTMT_INSERT_APPOINTMENT(" INSERT INTO Appointments ( "
            + " appName, appLocation, appDate, appTime ) "
            + " VALUES (?, ?, ?, ?)");

    private String sql;

    private AppointmentSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
