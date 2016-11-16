package chess.behaviour;


import chess.Player;
import chess.Position;
import chess.operations.Utils;
import chess.pieces.King;
import chess.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public abstract class PieceBehaviour {

    protected Piece piece;

    public PieceBehaviour(Piece piece) {
        this.piece = piece;
    }

    /*
    * Getting all possible moves for our Piece
    */

    public abstract Set<Position> getAvailableMoves(Piece[][] chessBoard, Position currentPosition);

    /*
    * Getting all acceptable moves for our Piece
    * and checking if our king in safe.
    */
 //TODO: should be tested and verified!
    public Set<Position> getAcceptableMoves(Piece[][] chessBoard, Position currentPosition) {

        Set<Position> acceptablePositions = new HashSet<>();
        King currentKing = (Player.White.equals(piece.getOwner()) ? Utils.findKing(Player.White, chessBoard) :
                Utils.findKing(Player.Black, chessBoard));
        for (Position position : getAvailableMoves(chessBoard, currentPosition)) {
            if (currentKing.isAlive(currentPosition, position, chessBoard.clone())) {
                acceptablePositions.add(position);
            }
        }
    // if acceptable positions are empty - seems to be checkmate
        return acceptablePositions;
    }


}
