package chess.behaviour;


import chess.Player;
import chess.Position;
import chess.behaviour.impl.PawnBehaviour;
import chess.behaviour.impl.RookBehaviour;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class QueenBehaviourTest {

    @Test
    public void testRookBehaviour1() {
        Set<Position> positions = getPositionList(Player.White, 2, 2);
        assertEquals(17, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a2 | a3 | b1 | b3 | b4 | b5 | b6 | b7 | b8 | c1 | c2 | d2 | e2 | f2 | g2 | h2", names);
    }

    @Test
    public void testRookBehaviour2() {
        Set<Position> positions = getPositionList(Player.White, 2, 1);
        assertEquals(17, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a2 | a3 | b1 | b3 | b4 | b5 | b6 | b7 | b8 | c1 | c3 | d4 | e5 | f6 | g7 | h8", names);
    }

    @Test
    public void testRookBehaviour3() {
        Set<Position> positions = getPositionList(Player.Black, 2, 1);
        assertEquals(18, positions.size());

        String names = TestHelper.getResultMoves(positions);
        assertEquals("a1 | a2 | a3 | b1 | b3 | b4 | b5 | b6 | b7 | b8 | c1 | c2 | c3 | d4 | e5 | f6 | g7 | h8", names);
    }


    private Set<Position> getPositionList(Player pawnPlayer, int pawnCol, int pawnRow) {
        Set<Position> result = new HashSet<>();
        Piece queen = new Queen(Player.White);
        Piece pawn = new Pawn(pawnPlayer);

        List<PieceBehaviour> queenBehaviours = new ArrayList<>();
        queenBehaviours.addAll(queen.getBehaviors());
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[pawnCol][pawnRow] = pawn;
        chessBoard[1][1] = queen;
        result.addAll(queenBehaviours.get(0).getAvailableMoves(chessBoard, new Position(1, 1)));
        result.addAll(queenBehaviours.get(1).getAvailableMoves(chessBoard, new Position(1, 1)));
        return result;

    }
}
