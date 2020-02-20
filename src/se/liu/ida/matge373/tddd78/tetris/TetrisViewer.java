package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame = new JFrame();
    private TetrisComponent boardgraphics;


    public TetrisViewer(final Board board) {

	this.boardgraphics = new TetrisComponent(board); //Här tar den in boarden som i sin tur kommer hanteras av paintcomponent och dylikt.
	//boardgraphics.getPreferredSize();						// Jag vill loopa igenom boarden så att jag får ut alla squares precis som i getSquareAt

	//String boardstring = BoardToTextConverter.convertToTextBoard(board);
	//textarea.setText(boardstring);
    }

    public void boardLoop(Board board) {
	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
		board.getSquareAt(i,j);

	    }
	}
    }

    public void refresh(final Board board) {
        this.boardgraphics = new TetrisComponent(board);
	show();
    }

    public void show() {
	frame.setLayout(new BorderLayout());
	frame.add(boardgraphics, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
    }
}
