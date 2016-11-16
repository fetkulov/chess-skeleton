package chess.pieces;

import chess.Player;
import chess.behaviour.impl.BishopBehaviour;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
        addBehaviour(new BishopBehaviour(this));
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }
}
