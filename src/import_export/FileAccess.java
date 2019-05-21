package import_export;

import data.Appointment;
import gui.AppointmentGUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Laura Pein
 */
public class FileAccess {

    public static final String LINE_SEPARATOR = "\n";
    public static final String COLUMN_SEPARATOR = ";";
    public static final String HEADER = "Name;Location;Date;Time";

     /**
     * Exports all Appointments in the JTable into a CSV file.
     * @param f File which contains to path for writing.
     * @param tGUI Reference to the JTable GUI. Is used for accessing the List.
    */
    public void exportToCSV(File f, AppointmentGUI tGUI) {
        ArrayList<Appointment> list = tGUI.getList();
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(HEADER);
            for (int i = 0; i < list.size(); i++) {
                bw.write(LINE_SEPARATOR);
                bw.write(list.get(i).getName());
                bw.write(COLUMN_SEPARATOR);
                bw.write(list.get(i).getLocation());
                bw.write(COLUMN_SEPARATOR);
                bw.write(list.get(i).getDateAsString());
                bw.write(COLUMN_SEPARATOR);
                bw.write(list.get(i).getTimeAsString());
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
