package service.stats;

import models.*;
import service.stats.models.CourseStats;
import service.stats.models.HoleStats;
import utils.MapUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class StatsService {

    public static Map<String, Long> getDivisionPlayerScoreWinners(Division division, Score score) {
        // most birdies
        Map<String, Long> result  = division.getScores().stream().
                filter(e -> e.getScoreTypeEnum().equals(Score.HOLE_IN_ONE)).
                collect(Collectors.groupingBy(HoleScore::getPlayerName, Collectors.counting()));

        return MapUtils.sortByValue(result);
    }

    public static void getHoleWinners(Division division) {
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
    }

    public static Map<String, Map<Score, Long>> getCountedPlayerScores(Division division)
    {
        return division.getScores().stream()
                .collect(
                        Collectors.groupingBy(
                                HoleScore::getPlayerName,
                                Collectors.groupingBy(
                                        HoleScore::getScoreTypeEnum,
                                        Collectors.counting()
                                )
                        )
                );
    }



    /***
     * @param division
     * @return
     */
    public static CourseStats GetHoleAverage(Division division) {

        // also by round? maybe
        Round round  = division.getLeaderboard().getRounds().get(0);

        CourseStats course = new CourseStats();
        course.setCourse(round.getCourse());

        Map<Integer, Double> temp = division.getScores().stream().collect(
                Collectors.groupingBy(
                        HoleScore::getHole,
                        Collectors.averagingInt(HoleScore::getScore)));


        // count score types / hole test
        Map<Integer, Map<Score, Long>> res = division.getScores().stream()
                .collect(
                        Collectors.groupingBy(
                                HoleScore::getHole,
                                Collectors.groupingBy(
                                        HoleScore::getScoreTypeEnum,
                                        Collectors.counting()
                                )
                        )
                );

        List<HoleStats> data = new ArrayList<>();

        for (int i = 1; i <= round.getCourse().getNumHoles(); i++) {
            Hole hole = round.getCourse().getHole(i);
            data.add(
                    new HoleStats(
                            hole,
                            temp.get(i),
                            res.get(i).getOrDefault(Score.BIRDIE, 0L),
                            res.get(i).getOrDefault(Score.PAR, 0L),
                            res.get(i).getOrDefault(Score.EAGLE, 0L))
            );
        }

        course.setHoleStats(data);
        return course;
    }
}
