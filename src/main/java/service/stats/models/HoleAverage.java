package service.stats.models;

import models.Hole;

public class HoleAverage {

    private int hole;
    private int par;
    private double average;

    public HoleAverage(int par, double average) {
        this.par = par;
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    public void setHole(int hole) {
        this.hole = hole;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }
}
