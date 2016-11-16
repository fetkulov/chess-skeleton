package chess.pieces;

import chess.Player;
import chess.behaviour.impl.KnightBehaviour;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
        addBehaviour(new KnightBehaviour(this));
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }
}
