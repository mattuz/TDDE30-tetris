package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame = new JFrame();
    private TetrisComponent textarea;


    public TetrisViewer(final Board board) {
	this.textarea = new TetrisComponent(board); //Här tar den in boarden som i sin tur kommer hanteras av paintcomponent och dylikt.
							// Jag vill loopa igenom boarden så att jag får ut alla squares precis som i getSquareAt

	//String boardstring = BoardToTextConverter.convertToTextBoard(board);
	//textarea.setText(boardstring);
    }


    public void show() {
	frame.setLayout(new BorderLayout());
	frame.add(textarea, BorderLayout.CENTER);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.pack();
	frame.setVisible(true);
    }
}
