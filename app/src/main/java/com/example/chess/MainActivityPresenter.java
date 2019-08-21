package com.example.chess;


import com.example.chess.Cell.*;

public class MainActivityPresenter {
    private IMainActivity activity;
    Cell[] cell = new Cell[65];
    int count = 1;

    MainActivityPresenter(IMainActivity activity) {
        this.activity = activity;
        initializationCells();
        addingAttributes();
    }

    private void initializationCells() {
        for (int i = 1; i < 65; i++) {
            cell[i] = new Cell();
        }
    }

    private void addingAttributes() {
        for (int a = 1; a < 9; a++) {
            for (int b = 1; b < 9; b++) {
                cell[count].x = a;
                cell[count].y = b;
                if ((a + b) % 2 == 1) {
                    cell[count].typeOfCell = TypeOfCell.WHITE;
                } else {
                    cell[count].typeOfCell = TypeOfCell.BLACK;
                }
                if (b > 2 && b < 7) cell[count].figure = Figure.NONE;
                count++;
            }
        }
        cell[1].id = R.id.a1;
        cell[1].figure = Figure.WHITE_CASTLE;
        cell[2].id = R.id.b1;
        cell[2].figure = Figure.WHITE_KNIGHT;
        cell[3].id = R.id.c1;
        cell[3].figure = Figure.WHITE_BISHOP;
        cell[4].id = R.id.d1;
        cell[4].figure = Figure.WHITE_QUEEN;
        cell[5].id = R.id.e1;
        cell[5].figure = Figure.WHITE_KING;
        cell[6].id = R.id.f1;
        cell[6].figure = Figure.WHITE_BISHOP;
        cell[7].id = R.id.g1;
        cell[7].figure = Figure.WHITE_KNIGHT;
        cell[8].id = R.id.h1;
        cell[8].figure = Figure.WHITE_CASTLE;
        cell[9].id = R.id.a2;
        cell[9].figure = Figure.WHITE_PAWN;
        cell[10].id = R.id.b2;
        cell[10].figure = Figure.WHITE_PAWN;
        cell[11].id = R.id.c2;
        cell[11].figure = Figure.WHITE_PAWN;
        cell[12].id = R.id.d2;
        cell[12].figure = Figure.WHITE_PAWN;
        cell[13].id = R.id.e2;
        cell[13].figure = Figure.WHITE_PAWN;
        cell[14].id = R.id.f2;
        cell[14].figure = Figure.WHITE_PAWN;
        cell[15].id = R.id.g2;
        cell[15].figure = Figure.WHITE_PAWN;
        cell[16].id = R.id.h2;
        cell[16].figure = Figure.WHITE_PAWN;
        cell[17].id = R.id.a3;
        cell[17].figure = Figure.NONE;
        cell[18].id = R.id.b3;
        cell[18].figure = Figure.NONE;
        cell[19].id = R.id.c3;
        cell[19].figure = Figure.NONE;
        cell[20].id = R.id.d3;
        cell[20].figure = Figure.NONE;
        cell[21].id = R.id.e3;
        cell[21].figure = Figure.NONE;
        cell[22].id = R.id.f3;
        cell[22].figure = Figure.NONE;
        cell[23].id = R.id.g3;
        cell[23].figure = Figure.NONE;
        cell[24].id = R.id.h3;
        cell[24].figure = Figure.NONE;
        cell[25].id = R.id.a4;
        cell[25].figure = Figure.NONE;
        cell[26].id = R.id.b4;
        cell[26].figure = Figure.NONE;
        cell[27].id = R.id.c4;
        cell[27].figure = Figure.NONE;
        cell[28].id = R.id.d4;
        cell[28].figure = Figure.NONE;
        cell[29].id = R.id.e4;
        cell[29].figure = Figure.NONE;
        cell[30].id = R.id.f4;
        cell[30].figure = Figure.NONE;
        cell[31].id = R.id.g4;
        cell[31].figure = Figure.NONE;
        cell[32].id = R.id.h4;
        cell[32].figure = Figure.NONE;
        cell[33].id = R.id.a5;
        cell[33].figure = Figure.NONE;
        cell[34].id = R.id.b5;
        cell[34].figure = Figure.NONE;
        cell[35].id = R.id.c5;
        cell[35].figure = Figure.NONE;
        cell[36].id = R.id.d5;
        cell[36].figure = Figure.NONE;
        cell[37].id = R.id.e5;
        cell[37].figure = Figure.NONE;
        cell[38].id = R.id.f5;
        cell[38].figure = Figure.NONE;
        cell[39].id = R.id.g5;
        cell[39].figure = Figure.NONE;
        cell[40].id = R.id.h5;
        cell[40].figure = Figure.NONE;
        cell[41].id = R.id.a6;
        cell[41].figure = Figure.NONE;
        cell[42].id = R.id.b6;
        cell[42].figure = Figure.NONE;
        cell[43].id = R.id.c6;
        cell[43].figure = Figure.NONE;
        cell[44].id = R.id.d6;
        cell[44].figure = Figure.NONE;
        cell[45].id = R.id.e6;
        cell[45].figure = Figure.NONE;
        cell[46].id = R.id.f6;
        cell[46].figure = Figure.NONE;
        cell[47].id = R.id.g6;
        cell[47].figure = Figure.NONE;
        cell[48].id = R.id.h6;
        cell[48].figure = Figure.NONE;
        cell[49].id = R.id.a7;
        cell[49].figure = Figure.BLACK_PAWN;
        cell[50].id = R.id.b7;
        cell[50].figure = Figure.BLACK_PAWN;
        cell[51].id = R.id.c7;
        cell[51].figure = Figure.BLACK_PAWN;
        cell[52].id = R.id.d7;
        cell[52].figure = Figure.BLACK_PAWN;
        cell[53].id = R.id.e7;
        cell[53].figure = Figure.BLACK_PAWN;
        cell[54].id = R.id.f7;
        cell[54].figure = Figure.BLACK_PAWN;
        cell[55].id = R.id.g7;
        cell[55].figure = Figure.BLACK_PAWN;
        cell[56].id = R.id.h7;
        cell[56].figure = Figure.BLACK_PAWN;
        cell[57].id = R.id.a8;
        cell[57].figure = Figure.BLACK_CASTLE;
        cell[58].id = R.id.b8;
        cell[58].figure = Figure.BLACK_KNIGHT;
        cell[59].id = R.id.c8;
        cell[59].figure = Figure.BLACK_BISHOP;
        cell[60].id = R.id.d8;
        cell[60].figure = Figure.BLACK_QUEEN;
        cell[61].id = R.id.e8;
        cell[61].figure = Figure.BLACK_KING;
        cell[62].id = R.id.f8;
        cell[62].figure = Figure.BLACK_BISHOP;
        cell[63].id = R.id.g8;
        cell[63].figure = Figure.BLACK_KNIGHT;
        cell[64].id = R.id.h8;
        cell[64].figure = Figure.BLACK_CASTLE;
    }

    boolean chosenCellTypeIsWhite(int i) {
         return cell[i].typeOfCell == TypeOfCell.WHITE;
    }

    public boolean thisIsFigure(int i) {
        return cell[i].figure !=  Figure.NONE;
    }
}


