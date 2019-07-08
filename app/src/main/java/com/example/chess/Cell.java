package com.example.chess;

public class Cell {
    enum Figure {
        NONE,
        PAWN,
        BISHOP,
        KING,
        CASTLE,
        QUEEN,
        KNIGHT
    }

    enum Type {
        WHITE,
        BLACK
    }
    Type type;
    Figure figure;
    int x;
    int y;
    int id;

}
