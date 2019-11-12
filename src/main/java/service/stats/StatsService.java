package service.stats;

import models.Division;
import models.HoleScore;
import models.Score;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class StatsService {

    public static void GetTest(Division division) {
        Map<Integer, Map<String, Double>> playerHoleAverages = division.getScores().stream()
                .collect(
                        Collectors.groupingBy(
                                HoleScore::getHole,
                                Collectors.groupingBy(
                                        HoleScore::getPlayerName,
                                        Collectors.averagingInt(HoleScore::getScore)
                                )
                        )
                );

        for (int hole = 1; hole <= 18; hole++) {
            LinkedHashMap<String, Double> temp = playerHoleAverages.get(hole).entrySet().
                    stream().sorted(comparingByValue()).collect(toMap(Map.Entry::getKey,
                    Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println("Hole winner: " + hole + " " + temp);

        }

        // most birdies
        Map<String, Long> mostbirds  = division.getScores().stream().
                filter(e -> e.getScoreTypeEnum().equals(Score.BIRDIE)).
                collect(Collectors.groupingBy(HoleScore::getPlayerName, Collectors.counting()));

        System.out.println(mostbirds);

        Map<String, Map<Score, Long>> playerScoresRaw = division.getScores().stream()
                .collect(
                        Collectors.groupingBy(
                                HoleScore::getPlayerName,
                                Collectors.groupingBy(
                                        HoleScore::getScoreTypeEnum,
                                        Collectors.counting()
                                )
                        )
                );

        System.out.println(playerScoresRaw);

        // and from raw we can display Most Birdies, HalfDan Roth 30

    }

    /**
     *
     * @param division
     * @return
     */
    public static Map<Integer, Double> GetHoleAverage(Division division) {

        return division.getScores().stream().collect(
                    Collectors.groupingBy(
                            HoleScore::getHole,
                            Collectors.averagingInt(HoleScore::getScore)));


    }


}
