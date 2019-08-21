package com.example.chess;

public class Cell {
    enum Figure {
        NONE,
        WHITE_PAWN,
        BLACK_PAWN,
        WHITE_BISHOP,
        BLACK_BISHOP,
        WHITE_KING,
        BLACK_KING,
        WHITE_CASTLE,
        BLACK_CASTLE,
        WHITE_QUEEN,
        BLACK_QUEEN,
        WHITE_KNIGHT,
        BLACK_KNIGHT
    }

    enum TypeOfCell {
        WHITE,
        BLACK
    }
    TypeOfCell typeOfCell;
    Figure figure;
    int x;
    int y;
    int id;

}
