package chess.behaviour;

import chess.Player;
import chess.Position;
import chess.behaviour.impl.KingBehaviour;
import chess.behaviour.impl.PawnBehaviour;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class PawntBehaviourTest {
    @Test
    public void testPawnBehaviour1() {
        Piece pawn = new Pawn(Player.White);
        Piece pawnAnother = new Pawn(Player.Black);

        PawnBehaviour pawnBehaviour = new PawnBehaviour(pawn);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][1] = pawn;
        chessBoard[2][2] = pawnAnother;
        Set<Position> moves = pawnBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));

        assertEquals(3, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("b3 | b4 | c3", names);
    }
    @Test
    public void testPawnBehaviour2() {
        Piece pawn = new Pawn(Player.White);
        Piece pawnAnother = new Pawn(Player.White);

        PawnBehaviour pawnBehaviour = new PawnBehaviour(pawn);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][1] = pawn;
        chessBoard[2][2] = pawnAnother;
        Set<Position> moves = pawnBehaviour.getAvailableMoves(chessBoard, new Position(1, 1));

        assertEquals(2, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("b3 | b4", names);
    }
    @Test
    public void testPawnBehaviour3() {
        Piece pawn = new Pawn(Player.White);
        Piece pawnAnother = new Pawn(Player.Black);

        PawnBehaviour pawnBehaviour = new PawnBehaviour(pawn);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][2] = pawn;
        chessBoard[2][3] = pawnAnother;
        Set<Position> moves = pawnBehaviour.getAvailableMoves(chessBoard, new Position(1, 2));

        assertEquals(2, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("b4 | c4", names);
    }
    @Test
    public void testPawnBehaviour4() {
        Piece pawn = new Pawn(Player.Black);

        PawnBehaviour pawnBehaviour = new PawnBehaviour(pawn);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][6] = pawn;
        Set<Position> moves = pawnBehaviour.getAvailableMoves(chessBoard, new Position(1, 6));

        assertEquals(2, moves.size());

        String names = TestHelper.getResultMoves(moves);
        assertEquals("b5 | b6", names);
    }

    @Test
    public void testPawnBehaviour5() {
        Piece pawn = new Pawn(Player.Black);

        PawnBehaviour pawnBehaviour = new PawnBehaviour(pawn);
        Piece[][] chessBoard = new Piece[8][8];
        chessBoard[1][0] = pawn;
        Set<Position> moves = pawnBehaviour.getAvailableMoves(chessBoard, new Position(1, 0));

        assertEquals(0, moves.size());

    }

}
