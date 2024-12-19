import java.time.Duration;
import java.time.LocalTime;

public class Shift {
    private final String shiftID;
    private String date;
    private LocalTime startTime, endTime;
    private double duration, overtime;

    public Shift(String shiftID, String date, LocalTime startTime, LocalTime endTime, double overtime) {
        this.shiftID = shiftID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.overtime = overtime;
        duration = calculateDuration();
    }

    private double calculateDuration() {
        Duration shiftDuration = Duration.between(startTime, endTime);
        return shiftDuration.toMinutes() / 60.0;
    }

    public String getShiftID() {
        return shiftID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }
}
