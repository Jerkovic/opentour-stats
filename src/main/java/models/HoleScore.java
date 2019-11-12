package models;

public class HoleScore {
    public int hole;
    public int par;
    public int score;
    public Score scoreType;
    public Player player;

    public HoleScore(int hole, int par, int score, Player player) {
        this.hole = hole; //nr
        this.par = par;
        this.score = score;
        this.player = player;

        if (score - par > 2) {
            scoreType = Score.TRIPLE_BOGEY_OR_WORSE;
        }
        if (score - par == 2) {
            scoreType = Score.DOUBLE_BOGEY;
        }
        if (score - par == 1) {
            scoreType = Score.BOGEY;
        }
        if (par == score) {
            scoreType = Score.PAR;
        }
        if (score - par == -1) {
            scoreType = Score.BIRDIE;
        }
        if (score - par == -2) {
            scoreType = Score.EAGLE;
        }
        if (score - par == -3) {
            scoreType = Score.ALBATROSS;
        }
        if (score == 1) {
            scoreType = Score.HOLE_IN_ONE;
        }

    }

    public boolean isParBreaker() {
        return (score - par < 0);
    }

    public String getScoreType() {
        return scoreType.toString().replace("_", " ");
    }

    public Score getScoreTypeEnum() {
        return scoreType;
    }

    /**
     * Returns the hole number
     * @return
     */
    public int getHole() {
        return hole;
    }

    public int getScore() {
        return score;
    }

    public int getPar() {
        return par;
    }

    public String getPlayerName() {
        return player.getName();
    }


    @Override
    public String toString() {
        return "HoleScore{" +
                "hole=" + hole +
                ", par=" + par +
                ", score=" + score +
                ", scoreType=" + scoreType +
                '}';
    }
}
