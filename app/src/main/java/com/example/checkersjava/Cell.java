package com.example.checkersjava;

public class Cell {
    int x,y;
    Piece piece;

    public Cell(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean containsPiece(){
        return (this.piece != null);
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
