package chess.behaviour.impl;

import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class BishopBehaviour extends PieceBehaviour {

    public BishopBehaviour(Piece piece) {
        super(piece);
    }
    private int[][] bishoptDirections = {
            {-1, -1}, //1
            {-1, +1}, //2
            {+1, +1}, //3
            {+1, -1}  //4
    };

    @Override
    public Set<Position> getAvailableMoves(Piece[][] chessBoard, Position currentPosition) {

        Set<Position> bishopPosition = new HashSet<Position>();
        for (int[] direction : bishoptDirections) {
            int column = currentPosition.getColumn() + direction[0];
            int row = currentPosition.getRow() + direction[1];
            boolean busyOrEnemy = false;
            while(!Position.isOutOfBoard(column, row) && !busyOrEnemy ) {
                Position possiblePosition = new Position(column, row);
                Piece anotherPiece = chessBoard[column][row];
                if (anotherPiece == null) {
                    bishopPosition.add(possiblePosition);
                } else if(!piece.getOwner().name().equals(anotherPiece.getOwner().name())){
                    bishopPosition.add(possiblePosition);
                    busyOrEnemy = true;
                } else{
                    busyOrEnemy = true;
                }
                 column = possiblePosition.getColumn() + direction[0];
                 row = possiblePosition.getRow() + direction[1];
            }
        }
        return bishopPosition;
    }
}
