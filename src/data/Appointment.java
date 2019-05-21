package data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a data class which is representing an appointment.
 *
 * @author Laura Pein
 */
public class Appointment {

    private String name, location;
    private LocalDate date;
    private LocalTime time;
    private boolean isSavedToDB;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("kk:mm");

    /**
     * Default constructor for Appointment
     *
     * @param name Name of the Appointment
     * @param location Location of the appointment
     * @param date Date when the appointment is happening
     * @param time Time when the appointment is starting
     * @param isSaved Tells if the Appointment is saved to the DB
     */
    public Appointment(String name, String location, LocalDate date, LocalTime time, boolean isSaved) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.isSavedToDB = isSaved;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDateAsString() {
        return DATE_FORMATTER.format(date);
    }

    public String getTimeAsString() {
        return TIME_FORMATTER.format(time);
    }

    public boolean isIsSavedToDB() {
        return isSavedToDB;
    }

    public void setIsSavedToDB(boolean isSaved) {
        this.isSavedToDB = isSaved;
    }

    @Override
    public String toString() {
        return "Appointment{" + "name=" + name + ", location=" + location + ", date=" + date + ", time=" + time + '}';
    }
}
