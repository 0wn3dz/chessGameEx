package com.blaham15.chessgame;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

import static com.blaham15.chessgame.MainApp.TILE_SIZE;

public class Piece extends StackPane{

    private PieceType type;
    public static final String pawn = "M 22,9 C 19.79,9 18,10.79 18,13 C 18,13.89 18.29,14.71 18.78,15.38 C 16.83,16.5 15.5,18.59 15.5,21 C 15.5,23.03 16.44,24.84 17.91,26.03 C 14.91,27.09 10.5,31.58 10.5,39.5 L 33.5,39.5 C 33.5,31.58 29.09,27.09 26.09,26.03 C 27.56,24.84 28.5,23.03 28.5,21 C 28.5,18.59 27.17,16.5 25.22,15.38 C 25.71,14.71 26,13.89 26,13 C 26,10.79 24.21,9 22,9 z ";

    public PieceType getType() {
        return type;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;

        SVGPath svg = new SVGPath();
        svg.setContent(pawn);
        svg.setFill(type == PieceType.BLACK
                ? Color.valueOf("#ffffff") : Color.valueOf("#000000"));

        svg.setStroke(Color.BLACK);
        svg.setStrokeWidth(TILE_SIZE * 0.03);

        svg.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        svg.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2 + TILE_SIZE * 0.07);

        getChildren().add(svg);

    }
}
