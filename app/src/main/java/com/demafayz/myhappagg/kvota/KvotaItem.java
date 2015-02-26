package com.demafayz.myhappagg.kvota;

/**
 * Created by DemaFayz on 17.02.2015.
 */
public class KvotaItem {
    String title;
    String description;
    double sum;
    int day;
    int month;
    int year;

    KvotaItem(String title, String description, double sum, int day, int month, int year) {
        this.title = title;
        this.description = description;
        this.sum = sum;
        this.month = month;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
