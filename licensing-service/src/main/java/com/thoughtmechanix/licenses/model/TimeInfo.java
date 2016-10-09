package com.thoughtmechanix.licenses.model;


public class TimeInfo{

    private String time;
    private String label;

    public TimeInfo(String time, String label) {
        super();
        this.time = time;
        this.label = label;
    }

    public String getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

}