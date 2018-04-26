package com.blaham15.engine.pieces;

import com.blaham15.engine.PieceColor;
import com.blaham15.engine.board.Board;
import com.blaham15.engine.board.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    protected final PieceColor pieceColor;

    public Piece(final int piecePosition, final PieceColor pieceColor) {
        this.piecePosition = piecePosition;
        this.pieceColor = pieceColor;
    }


    public abstract List<Move> calculateLegalMoves(final Board board);


}
