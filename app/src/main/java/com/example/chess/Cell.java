package com.example.chess;

public class Cell {
    enum Figure {
        NONE,
        PAWN,
        BISHOP,
        KING,
        CASTLE,
        QUEEN,
        KNIGHT,
    }

    enum FigType {
        BLACK,
        WHITE,
        NONE
    }

    enum TypeOfCell {
        WHITE,
        BLACK
    }

    FigType figType;
    TypeOfCell typeOfCell;
    Figure figure;
    int x;
    int y;
    int id;

}
