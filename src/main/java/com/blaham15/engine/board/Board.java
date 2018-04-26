package com.blaham15.engine.board;

//
public class Board {
//    Tile[][] board = new Tile[8][8];
//
//
//    public void startGame(){
//        board[0][0] = new Tile("Br");
//        board[0][1] = new Tile("Bh");
//        board[0][2] = new Tile("Bb");
//        board[0][3] = new Tile("BK");
//        board[0][4] = new Tile("Bq");
//        board[0][5] = new Tile("Bb");
//        board[0][6] = new Tile("Bh");
//        board[0][7] = new Tile("Br");
//        for (int i = 0; i < 8; i++) {
//            board[1][i] = new Tile("Bp");
//        }
//
//        for (int i = 2; i < 6; i++) {
//            for (int j = 0; j < 8; j++) {
//                board[i][j] = new Tile();
//            }
//        }
//
//        for (int i = 0; i < 8; i++) {
//            board[6][i] = new Tile("Wp");
//        }
//
//        board[7][0] = new Tile("Wr");
//        board[7][1] = new Tile("Wh");
//        board[7][2] = new Tile("Wb");
//        board[7][3] = new Tile("WK");
//        board[7][4] = new Tile("Wq");
//        board[7][5] = new Tile("Wb");
//        board[7][6] = new Tile("Wh");
//        board[7][7] = new Tile("Wr");
//
//
//    }
//
//    public void printBoard(){
//
//        System.out.println("    A     B    C    D    E    F    G    H\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "1 | "+board[0][0].getPiece()+" | "+board[0][1].getPiece()+" | "+board[0][2].getPiece()+" | "+board[0][3].getPiece()+" | "+board[0][4].getPiece()+" | "+board[0][5].getPiece()+" | "+board[0][6].getPiece()+" | "+board[0][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "2 | "+board[1][0].getPiece()+" | "+board[1][1].getPiece()+" | "+board[1][2].getPiece()+" | "+board[1][3].getPiece()+" | "+board[1][4].getPiece()+" | "+board[1][5].getPiece()+" | "+board[1][6].getPiece()+" | "+board[1][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "3 | "+board[2][0].getPiece()+" | "+board[2][1].getPiece()+" | "+board[2][2].getPiece()+" | "+board[2][3].getPiece()+" | "+board[2][4].getPiece()+" | "+board[2][5].getPiece()+" | "+board[2][6].getPiece()+" | "+board[2][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "4 | "+board[3][0].getPiece()+" | "+board[3][1].getPiece()+" | "+board[3][2].getPiece()+" | "+board[3][3].getPiece()+" | "+board[3][4].getPiece()+" | "+board[3][5].getPiece()+" | "+board[3][6].getPiece()+" | "+board[3][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "5 | "+board[4][0].getPiece()+" | "+board[4][1].getPiece()+" | "+board[4][2].getPiece()+" | "+board[4][3].getPiece()+" | "+board[4][4].getPiece()+" | "+board[4][5].getPiece()+" | "+board[4][6].getPiece()+" | "+board[4][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "6 | "+board[5][0].getPiece()+" | "+board[5][1].getPiece()+" | "+board[5][2].getPiece()+" | "+board[5][3].getPiece()+" | "+board[5][4].getPiece()+" | "+board[5][5].getPiece()+" | "+board[5][6].getPiece()+" | "+board[5][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "7 | "+board[6][0].getPiece()+" | "+board[6][1].getPiece()+" | "+board[6][2].getPiece()+" | "+board[6][3].getPiece()+" | "+board[6][4].getPiece()+" | "+board[6][5].getPiece()+" | "+board[6][6].getPiece()+" | "+board[6][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+\n" +
//                "8 | "+board[7][0].getPiece()+" | "+board[7][1].getPiece()+" | "+board[7][2].getPiece()+" | "+board[7][3].getPiece()+" | "+board[7][4].getPiece()+" | "+board[7][5].getPiece()+" | "+board[7][6].getPiece()+" | "+board[7][7].getPiece()+" |\n" +
//                "  +----+----+----+----+----+----+----+----+");
//
//    }
//
//    public String getSpot(int x, int y){
//        String name = board[x][y].getPiece();
//        return name;
//    }
//
//    public void movePiece(int odkudX, int odkudY, int kamX, int kamY){
//        //String odkud;
//        //String kam;
//        String odkudReal = getSpot(odkudX,odkudY);
//        String kamReal =  getSpot(kamX,kamY);
//        board[kamX][kamY] = board[odkudX][odkudY];
//        board[odkudX][odkudY] = new Tile();
//    }
//
//
//
//
//
//
}
//
//
