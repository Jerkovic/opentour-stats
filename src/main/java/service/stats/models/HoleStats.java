package service.stats.models;

import models.Hole;

public class HoleStats {

    private Hole hole;
    private double average;
    private long birdies;
    private long pars;
    private long eagles;
    // ... etc

    public HoleStats(Hole hole, double average, long birdies, long pars, long eagles) {
        this.hole = hole;
        this.average = average;
        this.birdies = birdies;
        this.eagles = eagles;
        this.pars = pars;

    }

    public long getBirdies() {
        return birdies;
    }

    public long getPars() {
        return pars;
    }

    public long getEagles() {
        return eagles;
    }

    public double getAverage() {
        return average;
    }

    public int getHoleNumber() { return hole.getNumber(); }
    public int getPar() {
        return hole.getPar();
    }

}
