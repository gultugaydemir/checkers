package com.example.checkersjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] buttons_id;
    ImageButton[][] buttons = new ImageButton[8][8];
    Button[][] buttonBoard;
    Player player1 = new Player(Piece.black);
    ArrayList<Cell> moves, highlightedCells;
    Player player2 = new Player(Piece.white);
    Player currentPlayer;
    Board board;
    Board cellBoard = new Board();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cellBoard.initialBoardSetup();
        setContentView(R.layout.activity_main);

        buttons_id = getButtonArray();
        buttonBoard = new Button[8][8];
        fillButtonBoard(listener);
        updateBoard(buttonBoard, cellBoard);
        this.moves = new ArrayList<>();
        player1 = new Player(Piece.black);
        player2 = new Player(Piece.white);
        currentPlayer = player1;

    }

    private final View.OnClickListener listener = (View.OnClickListener)(new View.OnClickListener() {
        public void onClick(View v) {
            int tag = (Integer) v.getTag();
            int x = tag / 10;
            int y = tag % 10;

        }
    });
    public void fillButtonBoard(View.OnClickListener listener) {
        int index = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    buttonBoard[i][j] = (Button) findViewById(buttons_id[index]);
                    index++;
                    buttonBoard[i][j].setTag(i * 10 + j);
                    buttonBoard[i][j].setOnClickListener(listener);
                }
            }
        }
    }
    public int[] getButtonArray(){
        return new int[]{R.id.button0, R.id.button2, R.id.button4, R.id.button6,
                R.id.button9, R.id.button11, R.id.button13, R.id.button15,
                R.id.button16, R.id.button18, R.id.button20, R.id.button22,
                R.id.button25, R.id.button27, R.id.button29, R.id.button31,
                R.id.button32, R.id.button34, R.id.button36, R.id.button38,
                R.id.button41, R.id.button43, R.id.button45, R.id.button47,
                R.id.button48, R.id.button50, R.id.button52, R.id.button54,
                R.id.button57, R.id.button59, R.id.button61, R.id.button63};
    }


    public void updateBoard(Button[][] buttonIndexes, Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (!board.getCell(i, j).containsPiece()) {
                        buttonIndexes[i][j].setBackgroundResource(android.R.color.transparent);
                    }
                    else if (board.getCell(i, j).getPiece().getColor().equals(Piece.white)) {
                        buttonIndexes[i][j].setBackgroundResource(R.drawable.white);
                    }
                    else if (board.getCell(i, j).getPiece().getColor().equals(Piece.black)) {
                        buttonIndexes[i][j].setBackgroundResource(R.drawable.black);
                    }
                }
            }
        }
    }

    public void showPossibleMoves(ArrayList<Cell> moves) {
        for (Cell cell : moves) {
            buttonBoard[cell.getX()][cell.getY()].setBackgroundResource(R.drawable.point);
        }
    }



}