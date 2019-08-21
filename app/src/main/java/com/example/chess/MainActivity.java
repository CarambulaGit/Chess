package com.example.chess;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements IMainActivity {
    private MainActivityPresenter presenter;
    private ImageView chosenImage;
    private ImageView a1;
    private ImageView a2;
    private ImageView a3;
    private ImageView a4;
    private ImageView a5;
    private ImageView a6;
    private ImageView a7;
    private ImageView a8;
    private ImageView b1;
    private ImageView b2;
    private ImageView b3;
    private ImageView b4;
    private ImageView b5;
    private ImageView b6;
    private ImageView b7;
    private ImageView b8;
    private ImageView c1;
    private ImageView c2;
    private ImageView c3;
    private ImageView c4;
    private ImageView c5;
    private ImageView c6;
    private ImageView c7;
    private ImageView c8;
    private ImageView d1;
    private ImageView d2;
    private ImageView d3;
    private ImageView d4;
    private ImageView d5;
    private ImageView d6;
    private ImageView d7;
    private ImageView d8;
    private ImageView e1;
    private ImageView e2;
    private ImageView e3;
    private ImageView e4;
    private ImageView e5;
    private ImageView e6;
    private ImageView e7;
    private ImageView e8;
    private ImageView f1;
    private ImageView f2;
    private ImageView f3;
    private ImageView f4;
    private ImageView f5;
    private ImageView f6;
    private ImageView f7;
    private ImageView f8;
    private ImageView g1;
    private ImageView g2;
    private ImageView g3;
    private ImageView g4;
    private ImageView g5;
    private ImageView g6;
    private ImageView g7;
    private ImageView g8;
    private ImageView h1;
    private ImageView h2;
    private ImageView h3;
    private ImageView h4;
    private ImageView h5;
    private ImageView h6;
    private ImageView h7;
    private ImageView h8;
    private TextView tv;
    private boolean thereIsChosenCell;
    private int indexOfFigure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initImageViews();
        presenter = new MainActivityPresenter(this);
        thereIsChosenCell = false;
    }

    public void initImageViews() {
        tv = findViewById(R.id.textView);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        g5 = findViewById(R.id.g5);
        g6 = findViewById(R.id.g6);
        g7 = findViewById(R.id.g7);
        g8 = findViewById(R.id.g8);
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onImage(int indexOfCell, ImageView chosenImageView) {
        log(presenter.cell[indexOfCell].figure.toString());
        if (!thereIsChosenCell) {
            if (presenter.thisIsFigure(indexOfCell)) {
                thereIsChosenCell = true;
                tv.setText("There is a chosen cell: True");
                tv.setTextColor(Color.GREEN);
                chosenImage = chosenImageView;
                indexOfFigure = indexOfCell;
            }
        } else {
            thereIsChosenCell = false;
            tv.setText("There is a chosen cell: False");
            tv.setTextColor(Color.RED);
            changeImages(chosenImage, chosenImageView, indexOfFigure, indexOfCell);
        }
    }

    public void onA1(View view) {
        onImage(1, a1);
    }

    public void onB1(View view) {
        onImage(2, b1);
    }

    public void onC1(View view) {
        onImage(3, c1);
    }

    public void onD1(View view) {
        onImage(4, d1);
    }

    public void onE1(View view) {
        onImage(5, e1);
    }

    public void onF1(View view) {
        onImage(6, f1);
    }

    public void onG1(View view) {
        onImage(7, g1);
    }

    public void onH1(View view) {
        onImage(8, h1);
    }

    public void onA2(View view) {
        onImage(9, a2);
    }

    public void onB2(View view) {
        onImage(10, b2);
    }

    public void onC2(View view) {
        onImage(11, c2);
    }

    public void onD2(View view) {
        onImage(12, d2);
    }

    public void onE2(View view) {
        onImage(13, e2);
    }

    public void onF2(View view) {
        onImage(14, f2);
    }

    public void onG2(View view) {
        onImage(15, g2);
    }

    public void onH2(View view) {
        onImage(16, h2);
    }

    public void onA3(View view) {
        onImage(17, a3);
    }

    public void onB3(View view) {
        onImage(18, b3);
    }

    public void onC3(View view) {
        onImage(19, c3);
    }

    public void onD3(View view) {
        onImage(20, d3);
    }

    public void onE3(View view) {
        onImage(21, e3);
    }

    public void onF3(View view) {
        onImage(22, f3);
    }

    public void onG3(View view) {
        onImage(23, g3);
    }

    public void onH3(View view) {
        onImage(24, h3);
    }

    public void onA4(View view) {
        onImage(25, a4);
    }

    public void onB4(View view) {
        onImage(26, b4);
    }

    public void onC4(View view) {
        onImage(27, c4);
    }

    public void onD4(View view) {
        onImage(28, d4);
    }

    public void onE4(View view) {
        onImage(29, e4);
    }

    public void onF4(View view) {
        onImage(30, f4);
    }

    public void onG4(View view) {
        onImage(31, g4);
    }

    public void onH4(View view) {
        onImage(32, h4);
    }

    public void onA5(View view) {
        onImage(33, a5);
    }

    public void onB5(View view) {
        onImage(34, b5);
    }

    public void onC5(View view) {
        onImage(35, c5);
    }

    public void onD5(View view) {
        onImage(36, d5);
    }

    public void onE5(View view) {
        onImage(37, e5);
    }

    public void onF5(View view) {
        onImage(38, f5);
    }

    public void onG5(View view) {
        onImage(39, g5);
    }

    public void onH5(View view) {
        onImage(40, h5);
    }

    public void onA6(View view) {
        onImage(41, a6);
    }

    public void onB6(View view) {
        onImage(42, b6);
    }

    public void onC6(View view) {
        onImage(43, c6);
    }

    public void onD6(View view) {
        onImage(44, d6);
    }

    public void onE6(View view) {
        onImage(45, e6);
    }

    public void onF6(View view) {
        onImage(46, f6);
    }

    public void onG6(View view) {
        onImage(47, g6);
    }

    public void onH6(View view) {
        onImage(48, h6);
    }

    public void onA7(View view) {
        onImage(49, a7);
    }

    public void onB7(View view) {
        onImage(50, b7);
    }

    public void onC7(View view) {
        onImage(51, c7);
    }

    public void onD7(View view) {
        onImage(52, d7);
    }

    public void onE7(View view) {
        onImage(53, e7);
    }

    public void onF7(View view) {
        onImage(54, f7);
    }

    public void onG7(View view) {
        onImage(55, g7);
    }

    public void onH7(View view) {
        onImage(56, h7);
    }

    public void onA8(View view) {
        onImage(57, a8);
    }

    public void onB8(View view) {
        onImage(58, b8);
    }

    public void onC8(View view) {
        onImage(59, c8);
    }

    public void onD8(View view) {
        onImage(60, d8);
    }

    public void onE8(View view) {
        onImage(61, e8);
    }

    public void onF8(View view) {
        onImage(62, f8);
    }

    public void onG8(View view) {
        onImage(63, g8);
    }

    public void onH8(View view) {
        onImage(64, h8);
    }


    @Override
    public void changeImages(ImageView img1, ImageView img2, int indexOfFirstCell, int indexOfSecondCell) {
        try {
            if (presenter.chosenCellTypeIsWhite(indexOfSecondCell)) {
                switch (presenter.cell[indexOfFirstCell].figure) {
                    case WHITE_BISHOP:
                        img2.setImageResource(R.drawable.white_bishop_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_BISHOP;
                        break;
                    case BLACK_BISHOP:
                        img2.setImageResource(R.drawable.black_bishop_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_BISHOP;
                        break;
                    case WHITE_CASTLE:
                        img2.setImageResource(R.drawable.white_castle_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_CASTLE;
                        break;
                    case BLACK_CASTLE:
                        img2.setImageResource(R.drawable.black_castle_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_CASTLE;
                        break;
                    case WHITE_KING:
                        img2.setImageResource(R.drawable.white_king_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_KING;
                        break;
                    case BLACK_KING:
                        img2.setImageResource(R.drawable.black_king_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_KING;
                        break;
                    case WHITE_QUEEN:
                        img2.setImageResource(R.drawable.white_queen_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_QUEEN;
                        break;
                    case BLACK_QUEEN:
                        img2.setImageResource(R.drawable.black_queen_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_QUEEN;
                        break;
                    case WHITE_KNIGHT:
                        img2.setImageResource(R.drawable.white_horse_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_KNIGHT;
                        break;
                    case BLACK_KNIGHT:
                        img2.setImageResource(R.drawable.black_horse_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_KNIGHT;
                        break;
                    case WHITE_PAWN:
                        img2.setImageResource(R.drawable.white_pawn_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_PAWN;
                        break;
                    case BLACK_PAWN:
                        img2.setImageResource(R.drawable.black_pawn_on_white);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_PAWN;
                        break;
                }
            } else {
                switch (presenter.cell[indexOfFirstCell].figure) {
                    case WHITE_BISHOP:
                        img2.setImageResource(R.drawable.white_bishop_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_BISHOP;
                        break;
                    case BLACK_BISHOP:
                        img2.setImageResource(R.drawable.black_bishop_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_BISHOP;
                        break;
                    case WHITE_CASTLE:
                        img2.setImageResource(R.drawable.white_castle_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_CASTLE;
                        break;
                    case BLACK_CASTLE:
                        img2.setImageResource(R.drawable.black_castle_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_CASTLE;
                        break;
                    case WHITE_KING:
                        img2.setImageResource(R.drawable.white_king_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_KING;
                        break;
                    case BLACK_KING:
                        img2.setImageResource(R.drawable.black_king_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_KING;
                        break;
                    case WHITE_QUEEN:
                        img2.setImageResource(R.drawable.white_queen_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_QUEEN;
                        break;
                    case BLACK_QUEEN:
                        img2.setImageResource(R.drawable.black_queen_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_QUEEN;
                        break;
                    case WHITE_KNIGHT:
                        img2.setImageResource(R.drawable.white_horse_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_KNIGHT;
                        break;
                    case BLACK_KNIGHT:
                        img2.setImageResource(R.drawable.black_horse_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_KNIGHT;
                        break;
                    case WHITE_PAWN:
                        img2.setImageResource(R.drawable.white_pawn_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.WHITE_PAWN;
                        break;
                    case BLACK_PAWN:
                        img2.setImageResource(R.drawable.black_pawn_on_black);
                        presenter.cell[indexOfSecondCell].figure = Cell.Figure.BLACK_PAWN;
                        break;
                }
            }
            if (presenter.chosenCellTypeIsWhite(indexOfFirstCell)) {
                img1.setImageResource(R.drawable.white_cell);
            } else {
                img1.setImageResource(R.drawable.black_cell);
            }
            presenter.cell[indexOfFirstCell].figure = Cell.Figure.NONE;
        } catch (Exception e) {
            log(e.toString());
        }
    }

    @Override
    public void log(String log) {
        Log.wtf("myTAG", log);
    }
}
