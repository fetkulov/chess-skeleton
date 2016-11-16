package chess.pieces;

import chess.Player;
import chess.behaviour.impl.RookBehaviour;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
        addBehaviour(new RookBehaviour(this));
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }
}
