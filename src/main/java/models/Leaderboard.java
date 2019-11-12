package models;

import java.util.List;

public class Leaderboard {

    private Boolean allFinished;
    private List<Entry> entries;
    private List<Round> rounds;

    public Boolean getAllFinished() {
        return allFinished;
    }

    public void setAllFinished(Boolean allFinished) {
        this.allFinished = allFinished;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
