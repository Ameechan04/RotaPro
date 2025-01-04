import java.util.ArrayList;

public class Company extends User{
    final private String company_id;
    final private String company_name;
    private String email;
    private String phone_number;
    private ArrayList<Staff> staffList;
    private ArrayList<Shift> shiftList;
    private ArrayList<String> notices;
    private double breakDuration;
    private boolean clockInSystem;
    private String payPeriod;
    private double baseSalary;

    public Company(String company_id, String company_name, String email, String phone_number,
                   ArrayList<Staff> staffList, ArrayList<Shift> shiftList, ArrayList<String> notices,
                   double breakDuration, boolean clockInSystem, String payPeriod, double baseSalary) {
        super(company_id, email, company_name);
        this.company_id = company_id;
        this.company_name = company_name;
        this.email = email;
        this.phone_number = phone_number;
        this.staffList = staffList;
        this.shiftList = shiftList;
        this.notices = notices;
        this.breakDuration = breakDuration;
        this.clockInSystem = clockInSystem;
        this.payPeriod = payPeriod;
        this.baseSalary = baseSalary;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public ArrayList<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(ArrayList<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public ArrayList<String> getNotices() {
        return notices;
    }

    public void setNotices(ArrayList<String> notices) {
        this.notices = notices;
    }

    public double getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(double breakDuration) {
        this.breakDuration = breakDuration;
    }

    public boolean isClockInSystem() {
        return clockInSystem;
    }

    public void setClockInSystem(boolean clockInSystem) {
        this.clockInSystem = clockInSystem;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
