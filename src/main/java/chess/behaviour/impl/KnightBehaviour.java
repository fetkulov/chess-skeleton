package chess.behaviour.impl;

import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class KnightBehaviour extends PieceBehaviour {

    private int[][] knightDirections = {
            {-2, +1}, //1
            {-1, +2}, //2
            {+1, +2}, //3
            {+2, +1}, //4
            {+2, -1}, //5
            {+1, -2}, //6
            {-1, -2}, //7
            {-2, -1}  //8
    };

    public KnightBehaviour(Piece piece) {
        super(piece);
    }

    @Override
    public Set<Position> getAvailableMoves(Piece[][] chessBoard, Position position) {
        Set<Position> knightPosition = new HashSet<Position>();
        for (int[] direction : knightDirections) {
            int column = position.getColumn() + direction[0];
            int row = position.getRow() + direction[1];
            if (!Position.isOutOfBoard(column, row)) {
                Position possiblePosition = new Position(column, row);
                Piece anotherPiece = chessBoard[column][row];
                if (anotherPiece == null) {
                    knightPosition.add(possiblePosition);
                } else if(!piece.getOwner().name().equals(anotherPiece.getOwner().name())){
                    knightPosition.add(possiblePosition);
                }
            }
        }
        return knightPosition;
    }
}
