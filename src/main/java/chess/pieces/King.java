package chess.pieces;

import chess.Player;
import chess.Position;
import chess.behaviour.PieceBehaviour;
import chess.behaviour.impl.KingBehaviour;
import chess.behaviour.impl.PawnBehaviour;
import chess.operations.Utils;
import com.sun.javafx.scene.control.behavior.BehaviorBase;

import java.util.HashSet;
import java.util.Set;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
        addBehaviour(new KingBehaviour(this));
    }

    public boolean isAlive(Position currentPosition, Position futurePosition, Piece[][] chessBoard) {
        chessBoard[futurePosition.getColumn()][futurePosition.getRow()] =
                chessBoard[currentPosition.getColumn()][currentPosition.getRow()];
        chessBoard[currentPosition.getColumn()][currentPosition.getRow()] = null;
        Position currentKindPosition = Utils.findCurrentKingPosition(getOwner(), chessBoard);
        Set<Position> enemyPossiblePositions = new HashSet<>();
        //TODO: go through the chessboard and gather enemies possible positions and compare it with the current king position

        return enemyPossiblePositions.contains(currentKindPosition);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }
}
