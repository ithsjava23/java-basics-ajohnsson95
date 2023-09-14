package org.example;

public class TimeIntervals {
    String[] time = new String[25];

    public TimeIntervals() {
        for (int i = 0; i < time.length; i++) {
            int endHour = (i + 1) % time.length;
            String timeInterval = String.format("%02d-%02d", i, endHour);
            time[i] = timeInterval;
        }
    }
    public String[] getTime() {
        return time;
    }
}