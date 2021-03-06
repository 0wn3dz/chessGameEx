package com.blaham15.engine.pieces;

import com.blaham15.engine.Alliance;
import com.blaham15.engine.board.Board;
import com.blaham15.engine.board.BoardUtils;
import com.blaham15.engine.board.Move;
import com.blaham15.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Queen extends Piece {

    private final static int[] CANDIDATE_MOVE_VECTOR_COORDS = {-9, -8, -7, -1, 1, 7, 8, 9};

    /**
     * A piece constructor, creates a piece belonging
     * to a certain alliance from parameters.
     *
     * @param piecePosition coordinate at which it shall be put.
     * @param pieceAlliance an alliance to which the piece will belong - black or white.
     */
    public Queen(Alliance pieceAlliance, int piecePosition) {
        super(PieceType.QUEEN, piecePosition, pieceAlliance);
    }

    @Override
    public String toString() {
        return PieceType.QUEEN.toString();
    }

    @Override
    public Queen movePiece(Move move) {
        return new Queen(move.getMovedPiece().getPieceAlliance(), move.getDestinationCoordinate());
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDS) {

            int candidateDestinationCoordinate = this.piecePosition;

            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset) ||
                        isEighthColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
                    break;
                }
                candidateDestinationCoordinate += candidateCoordinateOffset;
                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    if (!candidateDestinationTile.isTileOccupied()) {
                        legalMoves.add(new Move.PawnMove(board, this, candidateDestinationCoordinate));
                    } else {
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                        if (this.pieceAlliance != pieceAlliance) {
                            legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        // if it's occupied, no need to continue validating, break
                        break;
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }


    private static boolean isFirstColumnExclusion(final int currentPosition,
                                                  final int candidateOffset) {
        return (BoardUtils.FIRST_COLUMN[currentPosition] &&
                ((candidateOffset == -9) || (candidateOffset == 7) || (candidateOffset == -1)));
    }

    private static boolean isEighthColumnExclusion(final int currentPosition,
                                                   final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] &&
                ((candidateOffset == -7) || (candidateOffset == 9) || (candidateOffset == 1));
    }





}
