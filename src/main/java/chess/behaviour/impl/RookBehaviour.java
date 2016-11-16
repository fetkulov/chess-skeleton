package chess.behaviour.impl;


import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class RookBehaviour extends PieceBehaviour {

    public RookBehaviour(Piece piece) {
        super(piece);
    }

    private int[][] rookDirections = {
            {-1, 0}, //1
            {0, -1}, //2
            {+1, 0}, //3
            {0, +1}  //4
    };

    @Override
    public Set<Position> getAvailableMoves(Piece[][] chessBoard, Position currentPosition) {

        Set<Position> rookPosition = new HashSet<Position>();
        for (int[] direction : rookDirections) {
            int column = currentPosition.getColumn() + direction[0];
            int row = currentPosition.getRow() + direction[1];
            boolean busyOrEnemy = false;
            while (!Position.isOutOfBoard(column, row) && !busyOrEnemy) {
                Position possiblePosition = new Position(column, row);
                Piece anotherPiece = chessBoard[column][row];
                if (anotherPiece == null) {
                    rookPosition.add(possiblePosition);
                } else if (!piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    rookPosition.add(possiblePosition);
                    busyOrEnemy = true;
                } else {
                    busyOrEnemy = true;
                }
                column = possiblePosition.getColumn() + direction[0];
                row = possiblePosition.getRow() + direction[1];
            }
        }
        return rookPosition;
    }

}
