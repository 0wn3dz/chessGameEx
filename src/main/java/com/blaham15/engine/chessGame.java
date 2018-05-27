package com.blaham15.engine;

import com.blaham15.engine.board.Board;

public class chessGame {

    public static void main(String[] args) {
        Board board = Board.createStandardBoard();
        System.out.println(board);
    }

}
