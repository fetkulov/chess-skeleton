package chess.behaviour;

import chess.Position;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestHelper {

    public static String getString(Set<Position> moves) {
        List<Position> positions = new ArrayList<Position>();
        positions.addAll(moves);


        Collector<Position, StringJoiner, String> positionsCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),
                        (j, p) -> j.add(p.getColumnRow()),
                        (j1, j2) -> j1.merge(j2),
                        StringJoiner::toString);

        return positions
                .stream()
                .collect(positionsCollector);
    }

    public static String getResultMoves(Set<Position> moves) {
        return getPositions(getPositionsFromMoves(moves));
    }

    private static List<String> getPositionsFromMoves(Set<Position> moves) {
        return
                moves.stream()
                        .map(Position::getColumnRow)
                        .sorted(String::compareTo)
                        .collect(Collectors.toList());
    }

    private static String getPositions(List<String> strings) {

        return strings.stream().map(x -> x).collect(Collectors.joining(" | "));
    }
}
