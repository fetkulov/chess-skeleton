package chess.operations;

import chess.Player;
import chess.Position;
import chess.pieces.King;
import chess.pieces.Piece;

public class Utils {

    public static King findKing(Player player, Piece[][] board) {
        for (int c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            for (int r = Position.MIN_ROW; r <= Position.MAX_ROW; r++) {
                if (board[c][r].getOwner().equals(player) &&
                        board[c][r] instanceof King) {
                    return (King) board[c][r];
                }
            }

        }
        return null;
    }

    public static Position findCurrentKingPosition(Player player, Piece[][] board) {
        for (int c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            for (int r = Position.MIN_ROW; r <= Position.MAX_ROW; r++) {
                if (board[c][r].getOwner().equals(player) &&
                        board[c][r] instanceof King) {
                    return new Position(c,r);
                }
            }

        }
        return null;
    }
}
