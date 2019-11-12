package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;


public class Scorecard {

    private String id;
    private int lastUpdate;
    private String roundId;
    private Map<String, String> holescore;

    private Map<Integer, Integer> scores;


    public Map<Integer, Integer > getIntMap() {
        return
                holescore.entrySet().stream().collect(Collectors.toMap(
                        entry -> Integer.parseInt(entry.getKey()),
                        entry -> Integer.parseInt(entry.getValue()))
                );
    }

    public static <T, U> List<U> convertList(List<String> from, Function<String, U> func) {
        from.removeAll(Arrays.asList("", null));
        return from.stream().map(func).collect(Collectors.toList());
    }

    //for arrays
    public static <T, U> U[] convertArray(T[] from,
                                          Function<T, U> func,
                                          IntFunction<U[]> generator) {
        return Arrays.stream(from).map(func).toArray(generator);
    }

    public int getTotal() {
        List<Integer> integerList = convertList(new ArrayList<>(holescore.values()), Integer::parseInt);
        return integerList.stream().mapToInt(Integer::intValue).sum();
    }

    public int getReportedScoresNumber() {
        return convertList(new ArrayList<>(holescore.values()), Integer::parseInt).size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public void setHolescore(Map<String, String> holescore) {
        this.holescore = holescore;
    }

    public int getScoreByHole(int hole) {
        try {
            return Integer.parseInt(holescore.get(String.valueOf(hole)));

        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Scorecard{" +
                "id='" + id + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", roundId='" + roundId + '\'' +
                ", totalScore='" + getTotal() + '\'' +
                '}';
    }
}
