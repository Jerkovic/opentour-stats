package service.stats.models;

import models.Hole;

public class HoleAverage {

    private Hole hole;
    private double average;

    public HoleAverage(Hole hole, double average) {
        this.hole = hole;
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public int getHoleNumber() { return hole.getNumber(); }
    public int getPar() {
        return hole.getPar();
    }

}
