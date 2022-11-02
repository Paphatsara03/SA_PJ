package yote.workschedule.Model;

public class Select {
    private String name;
    private String date;
    private String time;

    public Select(String name, String date, String time) {
        this.name = name;
        this.date = String.valueOf(date);
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " , " + date + " , " + time;
    }

    public String toCSV() {
        return name + " , " + date + " , " + time;
    }
}
