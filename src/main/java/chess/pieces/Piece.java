package chess.pieces;

import chess.Player;
import chess.Position;
import chess.behaviour.PieceBehaviour;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A base class for chess pieces
 */
public abstract class Piece {
    private final Player owner;
    protected Set<PieceBehaviour> behaviours = new HashSet<PieceBehaviour>();


    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public final void addBehaviour(PieceBehaviour behaviour) {
        this.behaviours.add(behaviour);
    }

    public final Set<PieceBehaviour> getBehaviors()
    {
        return Collections.unmodifiableSet(this.behaviours);
    }

    public Player getOwner() {
        return owner;
    }

    protected abstract char getIdentifyingCharacter();
}
