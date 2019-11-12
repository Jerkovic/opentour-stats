package models;

import java.util.Map;

public class Entry {
    private String currentHole;
    private String currentRound;
    private String currentSeparator;
    private String  currentTotal;
    private int numericPosition;
    private String position;
    private Player player;
    private Map<String, RoundResult> scorecards;

    public Map<String, RoundResult> getScorecards() {
        return scorecards;
    }


    public void setScorecards(Map<String, RoundResult> scorecards) {
        this.scorecards = scorecards;
    }

    public String getCurrentHole() {
        return currentHole;
    }

    public void setCurrentHole(String currentHole) {
        this.currentHole = currentHole;
    }

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.currentRound = currentRound;
    }

    public String getCurrentSeparator() {
        return currentSeparator;
    }

    public void setCurrentSeparator(String currentSeparator) {
        this.currentSeparator = currentSeparator;
    }

    public String getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(String currentTotal) {
        this.currentTotal = currentTotal;
    }

    public int getNumericPosition() {
        return numericPosition;
    }

    public void setNumericPosition(int numericPosition) {
        this.numericPosition = numericPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return
                numericPosition + " " +
                player.toFormatted()
                ;
    }
}
