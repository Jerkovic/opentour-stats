package service.stats.models;

import models.Hole;

public class HoleStats {

    private Hole hole;
    private double average;
    // private int birdies
    // private int eagles
    // ... etc

    public HoleStats(Hole hole, double average) {
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
