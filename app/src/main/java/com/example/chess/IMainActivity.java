package com.example.chess;

import android.view.View;
import android.widget.ImageView;

interface IMainActivity {
    void changeImages (ImageView view1, ImageView view2, int indexOfFirstCell, int indexOfSecondCell);
    void onImage (int indexOfCell, ImageView chosenImageView);
    void log (String log);
}
