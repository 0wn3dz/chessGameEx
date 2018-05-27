package com.blaham15;

import com.blaham15.engine.board.Board;
import com.blaham15.gui.Table;

public class chessGame {

    public static void main(String[] args) {
        Board board = Board.createStandardBoard();
        System.out.println(board);

        Table table = new Table();

    }

}
