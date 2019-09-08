package com.example.chess;


import com.example.chess.Cell.*;

public class MainActivityPresenter {
    private IMainActivity activity;
    Cell[] cell = new Cell[65];
    int count = 1;
    int deltaX;
    int deltaY;

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
                if (a <= 2) {
                    cell[count].figType = FigType.WHITE;
                    if (a == 2) {
                        cell[count].figure = Figure.PAWN;
                    }
                } else {
                    if (a < 7) {
                        cell[count].figure = Figure.NONE;
                        cell[count].figType = FigType.NONE;
                    } else {
                        cell[count].figure = Figure.PAWN;
                        cell[count].figType = FigType.BLACK;
                    }
                }
                count++;
            }
        }
        cell[1].id = R.id.a1;
        cell[1].figure = Figure.CASTLE;
        cell[2].id = R.id.b1;
        cell[2].figure = Figure.KNIGHT;
        cell[3].id = R.id.c1;
        cell[3].figure = Figure.BISHOP;
        cell[4].id = R.id.d1;
        cell[4].figure = Figure.QUEEN;
        cell[5].id = R.id.e1;
        cell[5].figure = Figure.KING;
        cell[6].id = R.id.f1;
        cell[6].figure = Figure.BISHOP;
        cell[7].id = R.id.g1;
        cell[7].figure = Figure.KNIGHT;
        cell[8].id = R.id.h1;
        cell[8].figure = Figure.CASTLE;
        cell[9].id = R.id.a2;
        cell[10].id = R.id.b2;
        cell[11].id = R.id.c2;
        cell[12].id = R.id.d2;
        cell[13].id = R.id.e2;
        cell[14].id = R.id.f2;
        cell[15].id = R.id.g2;
        cell[16].id = R.id.h2;
        cell[17].id = R.id.a3;
        cell[18].id = R.id.b3;
        cell[19].id = R.id.c3;
        cell[20].id = R.id.d3;
        cell[21].id = R.id.e3;
        cell[22].id = R.id.f3;
        cell[23].id = R.id.g3;
        cell[24].id = R.id.h3;
        cell[25].id = R.id.a4;
        cell[26].id = R.id.b4;
        cell[27].id = R.id.c4;
        cell[28].id = R.id.d4;
        cell[29].id = R.id.e4;
        cell[30].id = R.id.f4;
        cell[31].id = R.id.g4;
        cell[32].id = R.id.h4;
        cell[33].id = R.id.a5;
        cell[34].id = R.id.b5;
        cell[35].id = R.id.c5;
        cell[36].id = R.id.d5;
        cell[37].id = R.id.e5;
        cell[38].id = R.id.f5;
        cell[39].id = R.id.g5;
        cell[40].id = R.id.h5;
        cell[41].id = R.id.a6;
        cell[42].id = R.id.b6;
        cell[43].id = R.id.c6;
        cell[44].id = R.id.d6;
        cell[45].id = R.id.e6;
        cell[46].id = R.id.f6;
        cell[47].id = R.id.g6;
        cell[48].id = R.id.h6;
        cell[49].id = R.id.a7;
        cell[50].id = R.id.b7;
        cell[51].id = R.id.c7;
        cell[52].id = R.id.d7;
        cell[53].id = R.id.e7;
        cell[54].id = R.id.f7;
        cell[55].id = R.id.g7;
        cell[56].id = R.id.h7;
        cell[57].id = R.id.a8;
        cell[57].figure = Figure.CASTLE;
        cell[58].id = R.id.b8;
        cell[58].figure = Figure.KNIGHT;
        cell[59].id = R.id.c8;
        cell[59].figure = Figure.BISHOP;
        cell[60].id = R.id.d8;
        cell[60].figure = Figure.QUEEN;
        cell[61].id = R.id.e8;
        cell[61].figure = Figure.KING;
        cell[62].id = R.id.f8;
        cell[62].figure = Figure.BISHOP;
        cell[63].id = R.id.g8;
        cell[63].figure = Figure.KNIGHT;
        cell[64].id = R.id.h8;
        cell[64].figure = Figure.CASTLE;
    }

    boolean chosenCellTypeIsWhite(int i) {
        return cell[i].typeOfCell == TypeOfCell.WHITE;
    }

    public boolean thisIsFigure(int i) {
        return cell[i].figure != Figure.NONE;
    }

    public boolean thisMoveCorrect(int indexOfFigure, int indexOfCell) {
        if (!(cell[indexOfFigure].x == cell[indexOfCell].x && cell[indexOfFigure].y == cell[indexOfCell].y)) {
            switch (cell[indexOfFigure].figure) {
                case PAWN:
                    return pawnMove(indexOfFigure, indexOfCell);
                case BISHOP:
                    return bishopMove(indexOfFigure, indexOfCell);
                case KING:
                    return kingMove(indexOfFigure, indexOfCell);
                case QUEEN:
                    return queenMove(indexOfFigure, indexOfCell);
                case CASTLE:
                    return castleMove(indexOfFigure, indexOfCell);
                case KNIGHT:
                    return knightMove(indexOfFigure, indexOfCell);
            }
        }
        return false;
    }

    private boolean knightMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1
                || Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2)
            return !(cell[indCell].figType == cell[indFig].figType);
        return false;
    }

    private boolean castleMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (Math.abs(deltaX) == 0 || Math.abs(deltaY) == 0)
            return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
        return false;
    }

    private boolean queenMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (Math.abs(deltaX) == 0
                || Math.abs(deltaY) == 0
                || Math.abs(deltaX) == Math.abs(deltaY))
            return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
        return false;
    }

    private boolean kingMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (Math.abs(deltaX) <= 1
                && Math.abs(deltaY) <= 1)
            return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
        return false;
    }

    private boolean bishopMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (Math.abs(deltaX) == Math.abs(deltaY))
            return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
        return false;
    }

    public boolean pawnMove(int indFig, int indCell) {
        deltaX = cell[indCell].x - cell[indFig].x;
        deltaY = cell[indCell].y - cell[indFig].y;
        if (cell[indFig].figType == FigType.WHITE) {
            if (deltaX == 1 && Math.abs(deltaY) == 1
                    && cell[indCell].figType == FigType.BLACK)
                return true;
            if (cell[indFig].x == 2 && deltaX == 2
                    && deltaY == 0)
                return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
            if (deltaX == 1 && deltaY == 0)
                return cell[indCell].figType == FigType.NONE;
        } else {
            if (deltaX == -1 && Math.abs(deltaY) == 1
                    && cell[indCell].figType == FigType.WHITE)
                return true;
            if (cell[indFig].x == 7 && deltaX == -2
                    && deltaY == 0)
                return cleanWay(cell[indFig].x, cell[indFig].y, deltaX, deltaY, cell[indFig].figType);
            if (deltaX == -1 && deltaY == 0)
                return cell[indCell].figType == FigType.NONE;
        }
        return false;
    }

    public boolean cleanWay(int coordinateX, int coordinateY, int deltaX, int deltaY, FigType figType) {
        int x = coordinateX;
        int y = coordinateY;
        for (int i = 0; i < Math.abs(deltaX) - 1; i++) {
            if (deltaX > 0) {
                x++;
            } else {
                if(deltaX < 0) x--;
            }
            if (deltaY > 0) {
                y++;
            } else {
                if(deltaY < 0) y--;
            }
            if (thereIsFigure(indexOfCell(x, y))) {
                return false;
            }
        }
        if (cell[indexOfCell(coordinateX + deltaX, coordinateY + deltaY)].figType == figType)
            return false;
        return true;
    }

    public int indexOfCell(int coordinateX, int coordinateY) {
        return coordinateY + 8 * (coordinateX - 1);
    }

    public boolean thereIsFigure(int indexOfCell) {
        return cell[indexOfCell].figure != Figure.NONE;
    }
}


