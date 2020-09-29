package com.example.checkersjava;

import java.util.ArrayList;

public class Board {
    Cell[][] board;
    ArrayList<Piece> whitePiece;
    ArrayList<Piece> blackPiece;
    static int BOARD_SIZE = 8;

    public Board(){
        this.whitePiece = new ArrayList<Piece>();
        this.blackPiece = new ArrayList<Piece>();
        board = new Cell[Board.BOARD_SIZE][Board.BOARD_SIZE];
    }
    public void initialBoardSetup(){
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                this.board[i][j] = new Cell(i, j);
            }
        }

        for (int column = 0; column < Board.BOARD_SIZE; column += 2) {
            this.board[0][column].setPiece(new Piece(Piece.white));
            this.board[2][column].setPiece(new Piece(Piece.white));
            this.board[6][column].setPiece(new Piece(Piece.black));

            whitePiece.add(this.board[0][column].getPiece());
            whitePiece.add(this.board[2][column].getPiece());
            blackPiece.add(this.board[6][column].getPiece());
        }

        for (int column = 1; column < Board.BOARD_SIZE; column += 2) {
            this.board[1][column].setPiece(new Piece(Piece.white));
            this.board[5][column].setPiece(new Piece(Piece.black));
            this.board[7][column].setPiece(new Piece(Piece.black));

            whitePiece.add(this.board[1][column].getPiece());
            blackPiece.add(this.board[5][column].getPiece());
            blackPiece.add(this.board[7][column].getPiece());
        }

  }

    public Cell getBoard(int x, int y) {
        if(x>0 && x<7 && y>0 && y<7) {
            return board[x][y];
        } else {
            return null;
        }
    }

    public Cell getCell(int x, int y) throws IllegalArgumentException{
        if((x<0 || x > 7) || (y<0 || y >7)){
            throw new IllegalArgumentException("The coordinates provided are outside of the board");
        }

        return this.board[x][y];
    }


    public ArrayList<Piece> getWhitePiece() {
        return whitePiece;
    }

    public ArrayList<Piece> getBlackPiece() {
        return blackPiece;
    }
}
