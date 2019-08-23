package com.example.chess;

import android.widget.ImageView;

interface IMainActivity {
    void changeImages (ImageView view1, ImageView view2, int indexOfFirstCell, int indexOfSecondCell);
    void changer (int index, int id, Cell.Figure figure, ImageView img);
    void onImage (int indexOfCell, ImageView chosenImageView);
    void log (String log);
}
