package com.example.watersystem.model;

public class Day {

    String day;
    String date;

    @Override
    public String toString() {
        return day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
