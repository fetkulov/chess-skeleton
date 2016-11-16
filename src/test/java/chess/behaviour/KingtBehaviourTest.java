package chess.behaviour;

import chess.Player;
import chess.Position;
import chess.behaviour.impl.KingBehaviour;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class KingtBehaviourTest {
    @Test
    public void testKingBehaviour1() {
        Piece king = new King(Player.White);
        Piece pawn = new Pawn(Player.Black);

        KingBehaviour knightBehaviour = new KingBehaviour(king);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][1] = king;
        chessBoard[2][1] = pawn;
        Set<Position> moves = knightBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));

        assertEquals(8, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("a1 | a2 | a3 | b1 | b3 | c1 | c2 | c3", names);
    }

    @Test
    public void testKingBehaviour2() {
        Piece king = new King(Player.White);
        Piece pawn = new Pawn(Player.White);

        KingBehaviour knightBehaviour = new KingBehaviour(king);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][1] = king;
        chessBoard[2][1] = pawn;
        Set<Position> moves = knightBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));

        assertEquals(7, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("a1 | a2 | a3 | b1 | b3 | c1 | c3", names);
    }

    @Test
    public void testKingBehaviour3() {
        Piece king = new King(Player.White);
        Piece pawn = new Pawn(Player.White);

        KingBehaviour knightBehaviour = new KingBehaviour(king);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][0] = king;
        chessBoard[2][1] = pawn;
        Set<Position> moves = knightBehaviour.getAvailableMoves(chessBoard, new Position(1, 0));

        assertEquals(4, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("a1 | a2 | b2 | c1", names);
    }


}
