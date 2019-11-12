package models;

public class Round {

    private String divisionId;
    private int lastScoreAt;
    private String roundId;
    private int roundNumber;
    private Course course;

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public int getLastScoreAt() {
        return lastScoreAt;
    }

    public void setLastScoreAt(int lastScoreAt) {
        this.lastScoreAt = lastScoreAt;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Round{" +
                "divisionId='" + divisionId + '\'' +
                ", lastScoreAt=" + lastScoreAt +
                ", roundId='" + roundId + '\'' +
                ", roundNumber=" + roundNumber +
                ", course=" + course +
                '}';
    }
}
