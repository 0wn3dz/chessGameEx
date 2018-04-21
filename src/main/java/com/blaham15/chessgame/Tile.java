package com.blaham15.chessgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
    private Piece piece;

    public boolean hasPiece(){
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile() {
        this.piece = null;
    }

    public Tile(boolean light, int x, int y) {
        this.piece = piece;
        setWidth(MainApp.TILE_SIZE);
        setHeight(MainApp.TILE_SIZE);
        relocate(x * MainApp.TILE_SIZE, y * MainApp.TILE_SIZE);
        setFill(light ? Color.valueOf("#ffce9e") : Color.valueOf("#d18b47"));
    }


}
