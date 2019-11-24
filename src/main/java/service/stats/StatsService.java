package service.stats;

import models.*;
import service.stats.models.HoleAverage;
import utils.MapUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

        System.out.println(MapUtils.sortByValue(mostbirds));

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
    public static List<HoleAverage> GetHoleAverage(Division division) {

        Round round  = division.getLeaderboard().getRounds().get(0);

        Map<Integer, Double> temp = division.getScores().stream().collect(
                Collectors.groupingBy(
                        HoleScore::getHole,
                        Collectors.averagingInt(HoleScore::getScore)));


        List<HoleAverage> data = new ArrayList<>();

        for (int i = 1; i <= round.getCourse().getNumHoles(); i++) {
            Hole hole = round.getCourse().getHole(i);
            data.add(new HoleAverage(hole, temp.get(i)));
        }

        return data;

    }


}
