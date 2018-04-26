package com.blaham15.engine;

public enum PieceColor {
        BLACK(1), WHITE(-1);

        final int moveDir;

    PieceColor(int moveDir) {
            this.moveDir = moveDir;

        }


}
