package chess;


import chess.behaviour.PieceBehaviour;
import chess.pieces.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {

    /**
     * The current player
     */
    private Player currentPlayer = Player.White;

    /**
     * A map of board positions to pieces at that position
     */
    private Piece[][] chessBoard;

    /**
     * Create the game state.
     */
    public GameState() {
        chessBoard = new Piece[8][8];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Piece[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(Piece[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    /**
     * Call to initialize the game state into the starting positions
     */
    public void reset() {
        // White Pieces
        placePiece(new Rook(Player.White), new Position("a1"));
        placePiece(new Knight(Player.White), new Position("b1"));
        placePiece(new Bishop(Player.White), new Position("c1"));
        placePiece(new Queen(Player.White), new Position("d1"));
        placePiece(new King(Player.White), new Position("e1"));
        placePiece(new Bishop(Player.White), new Position("f1"));
        placePiece(new Knight(Player.White), new Position("g1"));
        placePiece(new Rook(Player.White), new Position("h1"));
        placePiece(new Pawn(Player.White), new Position("a2"));
        placePiece(new Pawn(Player.White), new Position("b2"));
        placePiece(new Pawn(Player.White), new Position("c2"));
        placePiece(new Pawn(Player.White), new Position("d2"));
        placePiece(new Pawn(Player.White), new Position("e2"));
        placePiece(new Pawn(Player.White), new Position("f2"));
        placePiece(new Pawn(Player.White), new Position("g2"));
        placePiece(new Pawn(Player.White), new Position("h2"));

        // Black Pieces
        placePiece(new Rook(Player.Black), new Position("a8"));
        placePiece(new Knight(Player.Black), new Position("b8"));
        placePiece(new Bishop(Player.Black), new Position("c8"));
        placePiece(new Queen(Player.Black), new Position("d8"));
        placePiece(new King(Player.Black), new Position("e8"));
        placePiece(new Bishop(Player.Black), new Position("f8"));
        placePiece(new Knight(Player.Black), new Position("g8"));
        placePiece(new Rook(Player.Black), new Position("h8"));
        placePiece(new Pawn(Player.Black), new Position("a7"));
        placePiece(new Pawn(Player.Black), new Position("b7"));
        placePiece(new Pawn(Player.Black), new Position("c7"));
        placePiece(new Pawn(Player.Black), new Position("d7"));
        placePiece(new Pawn(Player.Black), new Position("e7"));
        placePiece(new Pawn(Player.Black), new Position("f7"));
        placePiece(new Pawn(Player.Black), new Position("g7"));
        placePiece(new Pawn(Player.Black), new Position("h7"));
    }

    public Set<Moves> getAllPossibleMoves() {
        Set<Moves> possibleMoves = new HashSet<>();
        for (int c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
            for (int r = Position.MIN_ROW; r <= Position.MAX_ROW; r++) {
                possibleMoves.addAll(possibleMovesFromCurrentPosition(c, r));
            }

        }
        return possibleMoves;
    }

    private Set<Moves> possibleMovesFromCurrentPosition(int c, int r) {
        Set<Moves> possibleMovesFromPosition = new HashSet<>();
        Position currentPosition = new Position(c, r);
        Piece piece = getPieceAtForCurrentPlayer(currentPosition);
        if (piece != null) {
            Moves movesForCurrentPiece = new Moves(currentPosition);
            movesForCurrentPiece.addPossibleMoves(getMovesFromBehaviours(piece.getBehaviors(), currentPosition));
            possibleMovesFromPosition.add(movesForCurrentPiece);
        }
        return possibleMovesFromPosition;
    }

    public void makeMove(String from, String to){

        Position fromPosition = new Position(from);
        Position toPosition = new Position(to);
        Set<Moves> possibleMovesFromPosition = possibleMovesFromCurrentPosition(fromPosition.getColumn(), fromPosition.getRow());
        Set<Position> positions = new HashSet<>();
        for (Moves moves : possibleMovesFromPosition) {
            positions.addAll(moves.getPossibleMoves());
        }
        if (!positions.isEmpty() && positions.contains(toPosition)) {
            Piece piece = getPieceAtForCurrentPlayer(fromPosition);
            chessBoard[fromPosition.getColumn()][fromPosition.getRow()] = null;
            chessBoard[toPosition.getColumn()][toPosition.getRow()] = piece;
            currentPlayer = Player.White.equals(currentPlayer) ? Player.Black : Player.White;
        } else {
            throw new IllegalArgumentException("incorrect 'from'/'to' position!");
        }

    }

    private Piece getPieceAtForCurrentPlayer(Position position) {
        Piece piece = getPieceAt(position);
        if (piece == null) {
            return null;
        }
        return currentPlayer.equals(piece.getOwner()) ? piece : null;
    }

    private Set<Position> getMovesFromBehaviours(Set<PieceBehaviour> pieceBehaviours, Position currentPosition) {
        Set<Position> possibleMoves = new HashSet<>();
        for (PieceBehaviour pieceBehaviour : pieceBehaviours) {
            possibleMoves.addAll(pieceBehaviour.getAvailableMoves(chessBoard, currentPosition));
        }
        return possibleMoves;
    }

    /**
     * Get the piece at the position specified by the String
     *
     * @param colrow The string indication of position; i.e. "d5"
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(String colrow) {
        Position position = new Position(colrow);
        return getPieceAt(position);
    }

    /**
     * Get the piece at a given position on the board
     *
     * @param position The position to inquire about.
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(Position position) {
        return chessBoard[position.getColumn()][position.getRow()];
    }

    /**
     * Method to place a piece at a given position
     *
     * @param piece    The piece to place
     * @param position The position
     */
    private void placePiece(Piece piece, Position position) {
        chessBoard[position.getColumn()][position.getRow()] = piece;
    }
}
