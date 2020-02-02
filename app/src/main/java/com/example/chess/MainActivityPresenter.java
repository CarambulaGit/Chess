//todo castling
//todo queue for turns
//todo check
//todo checkmate
//todo stalemate
//todo en passant capture
//todo promotion

package com.example.chess;


import com.example.chess.Cell.*;

public class MainActivityPresenter {
//    private IMainActivity activity;
    Cell[] cell = new Cell[65];
    int count = 1;
    int deltaX;
    int deltaY;

    MainActivityPresenter(IMainActivity activity) {
//        this.activity = activity;
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
        cell[1].figure = Figure.CASTLE;
        cell[2].figure = Figure.KNIGHT;
        cell[3].figure = Figure.BISHOP;
        cell[4].figure = Figure.QUEEN;
        cell[5].figure = Figure.KING;
        cell[6].figure = Figure.BISHOP;
        cell[7].figure = Figure.KNIGHT;
        cell[8].figure = Figure.CASTLE;
        cell[57].figure = Figure.CASTLE;
        cell[58].figure = Figure.KNIGHT;
        cell[59].figure = Figure.BISHOP;
        cell[60].figure = Figure.QUEEN;
        cell[61].figure = Figure.KING;
        cell[62].figure = Figure.BISHOP;
        cell[63].figure = Figure.KNIGHT;
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
        for (int i = 0; i < Math.max(Math.abs(deltaX), Math.abs(deltaY)) - 1; i++) {
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


