package models;

import java.util.ArrayList;
import java.util.List;

public class Division {

    private String id;
    private String name;
    private String activeRoundId;
    private Leaderboard leaderboard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiveRoundId() {
        return activeRoundId;
    }

    public void setActiveRoundId(String activeRoundId) {
        this.activeRoundId = activeRoundId;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    public List<HoleScore> getScores() {
        List<HoleScore> aggregate = new ArrayList<>();
        for (Entry entry : getLeaderboard().getEntries()) {
            for (Round round : leaderboard.getRounds()) {
                try {
                    RoundResult rr  = entry.getScorecards().get(round.getRoundId());

                    for (int i = 1; i <= round.getCourse().getNumHoles(); i++) {
                        Hole hole = round.getCourse().getHole(i);
                        if (rr.getScorecard().getScoreByHole(i) > 0 && hole.getPar() <= 5) {
                            HoleScore holeScore = new HoleScore(hole.getNumber(), hole.getPar(), rr.getScorecard().getScoreByHole(i), entry.getPlayer());
                            aggregate.add(holeScore);
                        }
                    }

                } catch (NullPointerException ignored) {

                }
            }
        }
        return aggregate;
    }
}
