package com.example.checkersjava;

public class Piece {
    String color;
    Cell position;
    public static String white="white";
    public static String black="black";

    public Piece(String color){
        this.color=color;
        this.position=null;
    }

    public String getColor() {
        return color;
    }

    public Cell getPosition() {
        return this.position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }
}
