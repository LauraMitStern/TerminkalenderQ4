package model;

import data.Appointment;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Laura Pein
 */
public class CustomRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        AppointmentModel model = (AppointmentModel) table.getModel();
        Appointment current = model.getAppFromIndex(row);
        //Wenn ein Eintrag in der DB ist wird er grün dargestellt, sonst rot.
        if (isSelected) {
            table.setSelectionBackground(Color.WHITE);
            table.setSelectionForeground(Color.BLACK);
        } else {
            if (current.isIsSavedToDB()) {
                c.setBackground(Color.GREEN);
            } else {
                c.setBackground(Color.RED);
            }
        }
        return c;
    }
}
