package chess.behaviour.impl;


import chess.Player;
import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PawnBehaviour extends PieceBehaviour {

    public PawnBehaviour(Piece piece) {
        super(piece);
    }


    @Override
    public Set<Position> getAvailableMoves(Piece[][] chessBoard, Position position) {


        Set<Position> pawnPositions = new HashSet<Position>();
        pawnPositions.addAll(isHitting(position, piece.getOwner(), chessBoard));


        if (Player.White.equals(piece.getOwner())) {
            if (!Position.isOutOfBoard(position.getColumn(), position.getRow() + 1)) {
                if (isPositionEmpty(position.getColumn(), position.getRow() + 1, chessBoard)) {
                    pawnPositions.add(new Position(position.getColumn(), position.getRow() + 1));
                }
            }
            if (isPawnFirstStep(position, piece.getOwner())) {
                Position possiblePosition = new Position(position.getColumn(), position.getRow() + 2);
                if (isPositionEmpty(position.getColumn(), position.getRow() + 2, chessBoard)) {
                    pawnPositions.add(possiblePosition);
                }
            }
        } else {
            if (!Position.isOutOfBoard(position.getColumn(), position.getRow() - 1)) {
                if (isPositionEmpty(position.getColumn(), position.getRow() - 1, chessBoard)) {
                    pawnPositions.add(new Position(position.getColumn(), position.getRow() - 1));
                }
            }
            if (isPawnFirstStep(position, piece.getOwner())) {
                Position possiblePosition = new Position(position.getColumn(), position.getRow() - 2);
                if (isPositionEmpty(position.getColumn(), position.getRow() - 2, chessBoard)) {
                    pawnPositions.add(possiblePosition);
                }
            }
        }

        return pawnPositions;
    }

    private boolean isPositionEmpty(int col, int row, Piece[][] chessBoard) {
        if (!Position.isOutOfBoard(col, row)) {
            Piece anotherPiece = chessBoard[col][row];
            if (anotherPiece == null) {
                return true;
            }/*else if(!piece.getOwner().equals(anotherPiece.getOwner())){
                return true;
            }*/
            return false;
        }
        return false;
    }

    private boolean isPawnFirstStep(Position position, Player player) {
        if (Player.White.equals(player) && position.getRow() == 1) {
            return true;
        }

        if (Player.Black.equals(player) && position.getRow() == 6) {
            return true;
        }
        return false;
    }

    private List<Position> isHitting(Position position, Player player, Piece[][] chessBoard) {
        List<Position> resultPositions = new ArrayList<>();
        if (Player.White.equals(player)) {
            if (position.getRow() == 7) { //last line
                return new ArrayList<>();
            }
            if (!Position.isOutOfBoard(position.getColumn() + 1, position.getRow() + 1)) {
                Piece anotherPiece = chessBoard[position.getColumn() + 1][position.getRow() + 1];
                if (anotherPiece != null && !piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    resultPositions.add(new Position(position.getColumn() + 1, position.getRow() + 1));
                }
            }
            if (!Position.isOutOfBoard(position.getColumn() - 1, position.getRow() + 1)) {
                Piece anotherPiece = chessBoard[position.getColumn() - 1][position.getRow() + 1];
                if (anotherPiece != null && !piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    resultPositions.add(new Position(position.getColumn() - 1, position.getRow() + 1));
                }
            }
        } else {
            if (position.getRow() == 0) { //last line
                return new ArrayList<>();
            }
            if (!Position.isOutOfBoard(position.getColumn() + 1, position.getRow() - 1)) {
                Piece anotherPiece = chessBoard[position.getColumn() + 1][position.getRow() + 1];
                if (anotherPiece != null && !piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    resultPositions.add(new Position(position.getColumn() + 1, position.getRow() - 1));
                }
            }
            if (!Position.isOutOfBoard(position.getColumn() - 1, position.getRow() - 1)) {
                Piece anotherPiece = chessBoard[position.getColumn() - 1][position.getRow() + 1];
                if (anotherPiece != null && !piece.getOwner().name().equals(anotherPiece.getOwner().name())) {
                    resultPositions.add(new Position(position.getColumn() + 1, position.getRow() - 1));
                }
            }
        }
        return resultPositions;
    }


}
