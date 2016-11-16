package chess;
/*
*
*/

import java.util.HashSet;
import java.util.Set;

public class Moves {

    private final Position piecePosition;
    private Set<Position> possibleMoves = new HashSet<Position>();

    public Moves(Position piecePosition) {
        this.piecePosition = piecePosition;
    }

    public Set<Position> getPossibleMoves() {
        return possibleMoves;
    }

    public void addPossibleMoves(Set<Position> possibleMoves) {
        this.possibleMoves.addAll(possibleMoves);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.NEWLINE);
        for (Position position : possibleMoves) {
            builder.append(piecePosition.getColumnName()).append(piecePosition.getRow() + 1);
            builder.append(position.getColumnName()).append(position.getRow() + 1).append(Constants.NEWLINE);
        }
        return builder.toString();
    }
}
