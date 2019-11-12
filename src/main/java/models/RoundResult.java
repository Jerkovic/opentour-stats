package models;

public class RoundResult {

    private String displayScore;
    private Scorecard scorecard;
    private String stableford;
    private String strokeplay;

    public String getDisplayScore() {
        return displayScore;
    }

    public void setDisplayScore(String displayScore) {
        this.displayScore = displayScore;
    }


    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }

    public String getStableford() {
        return stableford;
    }

    public void setStableford(String stableford) {
        this.stableford = stableford;
    }

    public String getStrokeplay() {
        return strokeplay;
    }

    public void setStrokeplay(String strokeplay) {
        this.strokeplay = strokeplay;
    }

    public boolean isRoundComplete() {
        return getScorecard().getReportedScoresNumber() == 18; // hmm
    }

    public int getCompleteRoundScore() {
        return isRoundComplete() ? getScorecard().getTotal() : 0;
    }
}
