package chess.pieces;

import chess.Player;
import chess.behaviour.impl.PawnBehaviour;

/**
 * The Pawn
 */
public class Pawn extends Piece {
    public Pawn(Player owner) {
        super(owner);
        addBehaviour(new PawnBehaviour(this));
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }
}
