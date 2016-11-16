package chess.behaviour;


import chess.Player;
import chess.Position;
import chess.behaviour.impl.BishopBehaviour;
import chess.pieces.Bishop;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.*;

public class BishopBehaviourTest {

    @Test
    public void testRookBehaviour1() {
        Set<Position> positions = getPositionList(Player.White, 2, 1);
        assertEquals(9, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a3 | c1 | c3 | d4 | e5 | f6 | g7 | h8", names);
    }

    @Test
    public void testRookBehaviour2() {
        Set<Position> positions = getPositionList(Player.White, 0, 2);
        assertEquals(8, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | c1 | c3 | d4 | e5 | f6 | g7 | h8", names);
    }

    @Test
    public void testRookBehaviour3() {
        Set<Position> positions = getPositionList(Player.Black, 0, 2);
        assertEquals(9, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a3 | c1 | c3 | d4 | e5 | f6 | g7 | h8", names);
    }

    @Test
    public void testRookBehaviour4() {
        Set<Position> positions = getPositionList(Player.Black, 2, 2);
        assertEquals(4, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a3 | c1 | c3", names);
    }

    private Set<Position> getPositionList(Player pawnPlayer, int pawnCol, int pawnRow) {
        Piece bishop = new Bishop(Player.White);
        Piece pawn = new Pawn(pawnPlayer);

        BishopBehaviour bishopBehaviour = new BishopBehaviour(bishop);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[pawnCol][pawnRow] = pawn;
        chessBoard[1][1] = bishop;
        return bishopBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));


    }
}
