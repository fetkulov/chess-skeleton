package chess.behaviour;


import chess.Player;
import chess.Position;
import chess.behaviour.impl.BishopBehaviour;
import chess.behaviour.impl.RookBehaviour;
import chess.pieces.Bishop;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Rook;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class RookBehaviourTest {

    @Test
    public void testRookBehaviour1() {
        Set<Position> positions = getPositionList(Player.White, 2, 2);
        assertEquals(14, positions.size());

        String names = TestHelper.getString(positions);
        assertEquals("b6 | b7 | b1 | b8 | a2 | c2 | d2 | e2 | f2 | g2 | b3 | h2 | b4 | b5", names);
    }

    @Test
    public void testRookBehaviour2() {
        Set<Position> positions = getPositionList(Player.White, 2, 1);
        assertEquals(8, positions.size());

        String names = TestHelper.getString(positions);
        assertEquals("b6 | b3 | b7 | b4 | b1 | b8 | a2 | b5", names);
    }

    @Test
    public void testRookBehaviour3() {
        Set<Position> positions = getPositionList(Player.Black, 2, 1);
        assertEquals(9, positions.size());

        String names = TestHelper.getString(positions);
        assertEquals("c2 | b6 | b3 | b7 | b4 | b1 | b8 | a2 | b5", names);
    }


    private Set<Position> getPositionList(Player pawnPlayer, int pawnCol, int pawnRow) {
        Piece rook = new Rook(Player.White);
        Piece pawn = new Pawn(pawnPlayer);

        RookBehaviour bishopBehaviour = new RookBehaviour(rook);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[pawnCol][pawnRow] = pawn;
        chessBoard[1][1] = rook;
        return bishopBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));


    }
}
