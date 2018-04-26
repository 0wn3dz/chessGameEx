package com.blaham15.engine.board;

import com.blaham15.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();


    /* Creates a map of all possible empty tiles (EMPTY_TILES_CACHE) upfront, so when we need one we don't have to
    create it again, we'll just take it out of this map.*/
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }


    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }


    private Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract Piece getPiece();

    public abstract boolean isTileOccupied();


    public static final class EmptyTile extends Tile {

        private EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }


    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OccupiedTile(final int coordinate, Piece pieceOnTile) {
            super(coordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return pieceOnTile;
        }
    }


}
