package chess.behaviour.impl;

import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class KingBehaviour extends PieceBehaviour {

    private int[][] kingDirections = {
            {-1, -1}, //1
            {-1, 0}, //2
            {-1, +1}, //3
            {+1, +1}, //4
            {+1, -1}, //5
            {+1, 0}, //6
            {0, -1}, //7
            {0, +1}  //8
    };

    public KingBehaviour(Piece piece) {
        super(piece);
    }

    @Override
    public Set<Position> getAvailableMoves(Piece[][] chessBoard, Position position) {
        Set<Position> kingPosition = new HashSet<>();
        for (int[] direction : kingDirections) {
            int column = position.getColumn() + direction[0];
            int row = position.getRow() + direction[1];
            if (!Position.isOutOfBoard(column, row)) {
                Position possiblePosition = new Position(column, row);
                Piece anotherPiece = chessBoard[column][row];
                if (anotherPiece == null) {
                    kingPosition.add(possiblePosition);
                } else if (!piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    kingPosition.add(possiblePosition);
                }
            }
        }
        return kingPosition;
    }
}