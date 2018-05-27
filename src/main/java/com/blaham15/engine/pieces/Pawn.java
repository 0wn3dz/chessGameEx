package com.blaham15.engine.pieces;

import com.blaham15.engine.Alliance;
import com.blaham15.engine.board.Board;
import com.blaham15.engine.board.BoardUtils;
import com.blaham15.engine.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.blaham15.engine.board.Move.MajorMove;

public class Pawn extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {7, 8, 9, 16};

    /**
     * A piece constructor, creates a piece belonging
     * to a certain alliance from parameters.
     *
     * @param piecePosition coordinate at which it shall be put.
     * @param pieceAlliance an alliance to which the piece will belong - black or white.
     */
    public Pawn(Alliance pieceAlliance, int piecePosition) {
        super(PieceType.PAWN, piecePosition, pieceAlliance);
    }

    @Override
    public String toString() {
        return PieceType.PAWN.toString();
    }

    @Override
    public Pawn movePiece(Move move) {
        return new Pawn(move.getMovedPiece().getPieceAlliance(), move.getDestinationCoordinate());
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE) {

            int candidateDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection() * currentCandidateOffset);
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }
            //normal move
            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                //TODO MORE WORK HERE majorMove to PawnMove
                legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                //pawn jump
            } else if (currentCandidateOffset == 16 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceAlliance.isBlack())
                    || (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.pieceAlliance.isWhite())) {
                final int behindCandidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * 8);
                if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                }
                //attack 1 - white pawn on 8th OR black pawn on 1st column can't attack to their right
            } else if (currentCandidateOffset == 7 &&
                    !((BoardUtils.EIGHTH_COLUMN[piecePosition] && this.pieceAlliance.isWhite())
                            || (BoardUtils.FIRST_COLUMN[piecePosition] && this.pieceAlliance.isBlack()))) {
                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
                        //todo this will be an attack move
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }
                //attack 2 - white pawn on 1st OR black pawn on 8th column can't attack to their left
            } else if (currentCandidateOffset == 9 &&
                    !((BoardUtils.EIGHTH_COLUMN[piecePosition] && this.pieceAlliance.isBlack())
                            || (BoardUtils.FIRST_COLUMN[piecePosition] && this.pieceAlliance.isWhite()))) {
                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
                        //todo this will be an attack move
                        legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }






}
