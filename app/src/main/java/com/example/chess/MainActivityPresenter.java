package com.example.chess;


public class MainActivityPresenter {
    private IMainActivity activity;
    Cell[] cell = new Cell[64];

    MainActivityPresenter(IMainActivity activity) {
        this.activity = activity;
        initializationCells();
        addingAttributes();
    }

    public void initializationCells() {
        for (int i = 0; i < 64; i++) {
            cell[i] = new Cell();
        }
    }

    public void addingAttributes() {
        for (int a = 1; a < 9; a++) {
            for (int b = 1; b < 9; b++) {
                cell[a * b].x = a;
                cell[a * b].y = b;
                if ((a + b) % 2 == 1) {
                    cell[a * b].type = Cell.Type.WHITE;
                } else {
                    cell[a * b].type = Cell.Type.BLACK;
                }
                if (b > 2 && b < 7) cell[a*b].figure = Cell.Figure.NONE;

            }
        }
    }

}
