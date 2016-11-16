package chess.pieces;

import chess.Player;
import chess.behaviour.impl.BishopBehaviour;
import chess.behaviour.impl.RookBehaviour;

/**
 * The Queen
 */
public class Queen extends Piece{
    public Queen(Player owner) {
        super(owner);
        addBehaviour(new RookBehaviour(this));
        addBehaviour(new BishopBehaviour(this));
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }
}
