import java.time.LocalDate;
import java.util.ArrayList;

public class Staff extends User{
    private String firstname, surname, dob, role;
    private ArrayList<Shift> assignedShifts; // List of shifts assigned to this staff
    private Shift currentShift;
    private boolean clockedIn, notificationsEnabled; // Whether the staff member is clocked in
    private double clockInTime, clockOutTime; // Time when staff clocked in

    // Constructor
    public Staff(String staffID, String companyName, String firstname, String surname, String dob, String email, String role,
                 ArrayList<Shift> assignedShifts, Shift currentShift, boolean clockedIn,
                 double clockInTime, double clockOutTime, boolean notificationsEnabled) {
        super(staffID, email, companyName);
        this.firstname = firstname;
        this.surname = surname;
        this.dob = dob;
        this.role = role;
        this.assignedShifts = assignedShifts != null ? assignedShifts : new ArrayList<>(); // Ensure non-null list
        this.currentShift = currentShift;
        this.clockedIn = clockedIn;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.notificationsEnabled = notificationsEnabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Shift> getAssignedShifts() {
        return assignedShifts;
    }

    public void setAssignedShifts(ArrayList<Shift> assignedShifts) {
        this.assignedShifts = assignedShifts;
    }

    public Shift getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(Shift currentShift) {
        this.currentShift = currentShift;
    }

    public boolean isClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(boolean clockedIn) {
        this.clockedIn = clockedIn;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }


    public double getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(double clockInTime) {
        this.clockInTime = clockInTime;
    }

    public double getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(double clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    public Shift getNextShift(){
        LocalDate today = LocalDate.now();
        Shift closestShift = null;

        if (assignedShifts.isEmpty()) {
            System.out.println("NO SHIFTS ERROR");
        } else {
            for (Shift shift : assignedShifts) {
                LocalDate shiftDate = shift.getDate();

                if (shiftDate.isAfter(today)) {
                    if (closestShift == null || shiftDate.isBefore(closestShift.getDate())) {
                        closestShift = shift;
                    }
                }
            }
        }

        return closestShift;
    }
}
