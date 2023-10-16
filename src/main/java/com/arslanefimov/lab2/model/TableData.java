package com.arslanefimov.lab2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TableData implements Serializable {

    private double x;
    private double y;
    private double r;
    private boolean result;
    private long leadTime;
    private String dateTime;


    public TableData(){

    }

    public TableData(double x, double y, double r, boolean result, long leadTime, String dateTime){
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.leadTime = leadTime;
        this.dateTime = dateTime;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(long leadTime) {
        this.leadTime = leadTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableData tableData = (TableData) o;
        return Double.compare(x, tableData.x) == 0 && Double.compare(y, tableData.y) == 0 && Double.compare(r, tableData.r) == 0 && result == tableData.result && leadTime == tableData.leadTime && Objects.equals(dateTime, tableData.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, result, leadTime, dateTime);
    }

    @Override
    public String toString() {
        return "TableData{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + result +
                ", leadTime=" + leadTime +
                ", dateTime=" + dateTime +
                '}';
    }
}
