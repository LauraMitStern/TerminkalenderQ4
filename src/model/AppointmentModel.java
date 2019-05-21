package model;

import data.Appointment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laura Pein
 */
public class AppointmentModel extends AbstractTableModel {

    /**
     *
     */
    public List<Appointment> list;

    /**
     *
     */
    public AppointmentModel() {
        this.list = new ArrayList();
    }

    /**
     *
     * @param a
     */
    public void add(Appointment a) {
        this.list.add(a);
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return ColumnNames.values().length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Appointment app = this.list.get(i);
        ColumnNames current = ColumnNames.values()[i1];
        switch (current) {
            case NAME:
                return app.getName();
            case LOCATION:
                return app.getLocation();
            case DATE:
                return app.getDateAsString();
            case TIME:
                return app.getTimeAsString();
            default:
                return "???";
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public String getColumnName(int i) {
        return ColumnNames.values()[i].getName();
    }
    
    /**
     *
     * @param i
     * @return
     */
    public Appointment getAppFromIndex(int i){
        return this.list.get(i);
    }
    
    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }
    
    /**
     *
     * @param list
     */
    public void setList(ArrayList<Appointment> list){
        this.list = list;
        this.fireTableDataChanged();
    }
    
    /**
     *
     * @param a
     */
    public void delete(Appointment a){
        this.list.remove(a);
        this.fireTableDataChanged();
    }
}
