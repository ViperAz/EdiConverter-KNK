package model;

import java.time.LocalDateTime;

public class Run {

    private String date ;
    private int run;
    public Run (){
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public void increaseRun(){
        this.run++;
    }
}
