package chess.behaviour;

import chess.Player;
import chess.Position;
import chess.behaviour.impl.KnightBehaviour;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collector;

import static junit.framework.Assert.*;

public class KnightBehaviourTest {
    @Test
    public void testRookBehaviour1() {
        Piece knight = new Knight(Player.White);
        Piece pawn = new Pawn(Player.Black);

        KnightBehaviour knightBehaviour = new KnightBehaviour(knight);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][1] = knight;
        chessBoard[3][2] = pawn;
        Set<Position> moves = knightBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));

        assertEquals(4, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("a4 | c4 | d1 | d3", names);
    }

    @Test
    public void testRookBehaviour2() {
        Piece knight = new Knight(Player.White);
        Piece pawn = new Pawn(Player.White);

        KnightBehaviour knightBehaviour = new KnightBehaviour(knight);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[5][2] = knight;
        chessBoard[3][1] = pawn;
        Set<Position> moves = knightBehaviour.getAvailableMoves(chessBoard, new Position(5, 2));

        assertEquals(7, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("d4 | e1 | e5 | g1 | g5 | h2 | h4", names);
    }


}
